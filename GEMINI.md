
# Gemini 项目背景：kmpcleaner

## 1. 项目概述

`kmpcleaner` 是一个使用 Kotlin Multiplatform (KMP) 构建的、功能全面的设备清理及管理工具。它旨在帮助用户通过清理相似照片、大文件、联系人、日历事件等来优化设备存储空间和性能。

应用采用 Compose Multiplatform 构建UI，实现了在 **Android, iOS, 桌面 (JVM), 和 Web (Wasm)** 四大平台上的代码共享和一致的用户体验。

### 1.1. 关键技术栈

*   **语言/框架**: Kotlin, Kotlin Multiplatform, Compose Multiplatform
*   **架构模式**: MVVM (ViewModel), MVI-like (State/Action), Repository, Use-Case
*   **依赖注入**: Koin
*   **网络**: Ktor
*   **数据库**: Room (用于存储用户信息等)
*   **键值存储**: AndroidX DataStore
*   **图片加载**: Coil
*   **异步处理**: Kotlin Coroutines
*   **构建工具**: Gradle

## 2. 核心功能

应用主要包含三大功能模块：清理器、工具箱和个人中心。

### 2.1. 清理器 (Cleaner)

这是应用的核心功能，提供了多种清理选项，帮助用户释放存储空间。

*   **相似图片/相似截图清理**: 使用 **dHash (差异哈希)** 算法识别并分组相似的图片和屏幕截图，让用户可以方便地删除多余的副本。
*   **大视频清理**: 扫描并列出设备上占用空间较大的视频文件。
*   **相似视频清理**: 扫描并列出设备上相似的视频文件。
*   **截图清理**: 提供单独清理所有屏幕截图的选项。
*   **通讯录清理**: （占位功能）旨在帮助用户管理和清理联系人。
*   **日历清理**: （占位功能）用于清理过期的日历事件和提醒。

### 2.2. 工具箱 (Toolbox)

提供一系列实用的系统工具和信息展示。

*   **手机状态**: 以仪表盘的形式实时显示 CPU 占用率、内存使用率和存储空间余量。
*   **附加工具**: 包含“密码保险箱”和“订阅管理器”等占位功能。

### 2.3. 个人中心 (Profile & Auth)

管理用户账户和应用设置。

*   **PRO 订阅**: 应用内包含一个PRO会员订阅的推广入口，暗示了其商业模式。
*   **用户认证**: 实现了完整的认证模块 (`feature_auth`)，支持**访客登录**，并为其他登录方式（如手机、微信等）预留了接口。
*   **应用设置**: 提供用户协议、隐私政策、意见反馈和版本信息等标准功能。

## 3. 技术架构

项目采用了现代化的、模块化的架构，以实现高度的代码复用和可维护性。

### 3.1. 模块化

*   **功能模块 (`feature_*`)**: 代码按功能（如 `feature_auth`, `feature_cleaner`）进行组织，每个模块都包含了其独立的UI、ViewModel和业务逻辑，实现了高度的内聚。
*   **核心模块 (`core`)**: 包含整个应用共享的组件，如设计系统 (`designsystem`)、网络层 (`network`)、领域模型 (`domain`) 和工具类 (`util`)。

### 3.2. UI 层

*   **Compose Multiplatform**: UI完全由Compose构建，确保了跨平台的一致性。
*   **MVI-like 模式**: UI状态管理遵循类似 MVI (Model-View-Intent) 的模式。每个屏幕或功能都由一个 `ViewModel` 管理，该 `ViewModel` 暴露一个 `State` (UI状态) Flow，并接收 `Action` (用户操作) 来更新状态。

### 3.3. 数据与业务逻辑

*   **Repository 模式**: 通过 `MediaRespository` 等仓库接口来抽象数据来源，将数据获取逻辑（无论是来自本地数据库还是网络）与业务逻辑分离。
*   **UseCase 模式**: 复杂的业务逻辑被封装在独立的 `UseCase` 类中（例如 `GetSimilarPhotoGroupsUseCase`），使得业务逻辑清晰、可复用且易于测试。

### 3.4. 平台特定实现

*   **`expect`/`actual` 机制**: KMP的核心机制，用于声明通用API（在 `commonMain` 中 `expect`）并在各平台提供具体实现（在 `androidMain`, `iosMain` 等中 `actual`）。这在项目中被广泛用于数据库构建、数据存储和平台信息获取等。
*   **iOS 原生能力集成**: 通过定义 `SwiftLibDependencyFactory` 接口，项目巧妙地允许将原生 Swift 代码（如 `FirebaseAnalyticsImpl.swift`, `MediaScannerImpl.swift`）的实现通过 Koin 注入到共享的 Kotlin 代码中，这是与iOS生态系统深度集成的一个关键模式。

## 4. 构建和运行

项目使用 Gradle 进行构建。

*   **构建项目**: `./gradlew build`
*   **运行 Android 版**: 在 Android Studio 中运行 `composeApp` 配置，或执行 `./gradlew :composeApp:installDebug`。
*   **运行桌面版**: `./gradlew :composeApp:run`
*   **运行 Web (Wasm) 版**: `./gradlew :composeApp:wasmJsBrowserDevelopmentRun`
*   **运行 iOS 版**: 在 Xcode 中打开 `iosApp/iosApp.xcworkspace` 并运行。
*   **运行测试**: `./gradlew test`

## 5. 开发约定

*   **代码组织**: 遵循按功能模块化的结构。新功能应创建新的 `feature_*` 包。
*   **UI 开发**: 遵循 MVI-like 模式，为每个屏幕创建 `ViewModel`、`State` 和 `Action`。
*   **平台代码**: 优先使用 `expect`/`actual`。对于复杂的原生交互，尤其是在iOS端，应扩展 `SwiftLibDependencyFactory` 来注入原生实现。
