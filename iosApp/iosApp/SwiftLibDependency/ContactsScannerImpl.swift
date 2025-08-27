import Foundation
import Photos
import Contacts
import ComposeApp
import UIKit

class ContactsScannerImpl: ComposeApp.ContactsScanner {

    func getContacts(completion: @escaping ([ComposeApp.Contact]) -> Void) {
        let store = CNContactStore()
        store.requestAccess(for: .contacts) { (granted, error) in
            if granted {
                var contacts = [ComposeApp.Contact]()
                let keys = [CNContactGivenNameKey, CNContactFamilyNameKey, CNContactPhoneNumbersKey, CNContactEmailAddressesKey]
                let request = CNContactFetchRequest(keysToFetch: keys as [CNKeyDescriptor])
                try? store.enumerateContacts(with: request) { (contact, _) in
                    let newContact = ComposeApp.Contact(
                        id: contact.identifier,
                        name: "\(contact.givenName) \(contact.familyName)",
                        phoneNumbers: contact.phoneNumbers.map { $0.value.stringValue },
                        emails: contact.emailAddresses.map { $0.value as String }
                    )
                    contacts.append(newContact)
                }
                completion(contacts)
            } else {
                completion([])
            }
        }
    }
}
