import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        KoinAppKt.doInitKoin(config: { koinApp in
            koinApp.provideSwiftLibDependencyFactory(
                factory: SwiftLibDependencyFactoryImpl.shared
            )
        })
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
