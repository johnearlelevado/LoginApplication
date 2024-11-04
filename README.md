# Modern Android Login App

A modern Android application demonstrating MVVM pattern, and Jetpack Compose implementation of a login system. This project serves as a template and learning resource for building modern Android applications.

<p float="left">
  <img src="Screenshot_1.png" width="250" hspace="10"/>
  <img src="Screenshot_2.png" width="250" hspace="10"/>
</p>

## Features

- 🎨 Modern UI with Jetpack Compose
- 📐 MVVM Architecture
- 🌗 Dark/Light theme support
- 🔄 State management with Kotlin Flow
- 🧪 Comprehensive test coverage
- 🎯 Material Design 3
- 📱 Responsive design
- 🔒 Simulated authentication flow

## Tech Stack

- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **State Management**: Kotlin Flow
- **Dependency Injection**: Manual DI (can be extended to Hilt)
- **Testing**: JUnit, Turbine, MockK
- **Build System**: Gradle with Kotlin DSL
- **CI/CD**: GitHub Actions

## Prerequisites

- Android Studio Hedgehog | 2023.1.1 or newer
- Minimum SDK: 24
- Target SDK: 34
- Kotlin version: 1.9.20
- Gradle version: 8.1.2

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/johnearlelevado/login-app.git
```

2. Open the project in Android Studio

3. Build and run the application

4. Use these credentials to test the login:
- Username: `test`
- Password: `password`

## Architecture

The application follows the MVVM (Model-View-ViewModel) architecture pattern and clean architecture principles:

- **UI Layer**: Compose UI components
- **ViewModel Layer**: Manages UI state and business logic
- **Data Layer**: Repository pattern for data operations

## Testing

The project includes comprehensive test coverage:

- **Unit Tests**: ViewModels, Repository, and business logic
- **Integration Tests**: End-to-end flow testing

Run tests using:
```bash
# Unit tests
./gradlew test
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
