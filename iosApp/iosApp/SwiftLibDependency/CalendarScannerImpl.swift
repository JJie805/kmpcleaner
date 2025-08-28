import Foundation
import EventKit
import ComposeApp

class CalendarScannerImpl: NSObject, ComposeApp.CalendarScanner {
    func getPastEvents(completion: @escaping ([ComposeApp.CalendarEvent]) -> Void) {
        let eventStore = EKEventStore()
        
        eventStore.requestAccess(to: .event) { (granted, error) in
            if (granted) && (error == nil) {
                let endDate = Date()
                let startDate = Calendar.current.date(byAdding: .year, value: -2, to: endDate)! // Look back 2 years for past events
                
                // Filter for calendars that can be modified and are not subscription-based.
                let calendars = eventStore.calendars(for: .event).filter {
                    $0.allowsContentModifications && $0.type != .subscription
                }

                guard !calendars.isEmpty else {
                    completion([])
                    return
                }

                let predicate = eventStore.predicateForEvents(withStart: startDate, end: endDate, calendars: calendars)
                
                let events = eventStore.events(matching: predicate).map { event -> ComposeApp.CalendarEvent in
                    return ComposeApp.CalendarEvent(
                        id: event.eventIdentifier,
                        title: event.title,
                        startDate: Int64(event.startDate.timeIntervalSince1970 * 1000),
                        endDate: Int64(event.endDate.timeIntervalSince1970 * 1000)
                    )
                }
                completion(events)
            } else {
                completion([])
            }
        }
    }
}