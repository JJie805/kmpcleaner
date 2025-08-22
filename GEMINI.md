# GEMINI Project Analysis: KMPCleaner

## Project Overview

This is a Kotlin Multiplatform (KMP) project built with Gradle. It aims to create a cross-platform application targeting Android, iOS, Desktop (JVM), and Web (WasmJS) from a single codebase.

The project utilizes Jetpack Compose for Multiplatform to build the user interface, ensuring a consistent look and feel across all target platforms.

Key technologies employed include:
- **UI:** Jetpack Compose for Multiplatform
- **Dependency Injection:** Koin
- **Networking:** Ktor for HTTP requests
- **Asynchronous Programming:** Kotlin Coroutines
- **Database:** Room for local data persistence
- **Data Storage:** Jetpack DataStore for simple key-value storage
- **Image Loading:** Coil3 for loading images from various sources

## Building and Running

### Android

To run the application on an Android emulator or a connected device, use the following Gradle command:
```bash
./gradlew :composeApp:installDebug
```
Alternatively, you can open the project in Android Studio and run the `composeApp` configuration.

### iOS

To run on an iOS simulator or device, open the `iosApp/iosApp.xcodeproj` file in Xcode and build/run the project from there.

### Desktop (JVM)

To run the application on your local desktop environment, execute:
```bash
./gradlew :composeApp:run
```

### Web (WasmJS)

To run the web application in a browser with development mode:
```bash
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

## Development Conventions

- **Shared Logic:** All business logic, data handling, and UI components shared across platforms are located in `composeApp/src/commonMain`.
- **Platform-Specific Code:** Any code that requires native platform APIs should be placed in the corresponding source set (e.g., `composeApp/src/androidMain`, `composeApp/src/iosMain`).
- **Dependency Management:** Dependencies are centralized and managed through version catalogs in `gradle/libs.versions.toml`.
- **Dependency Injection:** Koin is used for managing dependencies. Modules are defined in the `di` package within `commonMain`.
- **Architecture:** The project follows a clean architecture pattern, separating concerns into different layers (UI, domain, data). This is evident from the package structure and the use of dependency injection.
