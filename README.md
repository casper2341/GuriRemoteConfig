# Firebase Remote Config POC

This project demonstrates how to use **Firebase Remote Config** in an Android application built with **Jetpack Compose**. It features a screen with buttons (numbered 1 to 9) that fetch and display different types of values (e.g., strings, integers) associated with unique keys from Firebase Remote Config.

## Features

- **Jetpack Compose UI**: Modern UI toolkit for building native Android interfaces.
- **Firebase Remote Config Integration**: Dynamically fetch and apply key-value pairs from Firebase.
- Fetch and display different data types (string, integer) from Firebase Remote Config.
- A clean and simple POC showcasing practical usage of Firebase Remote Config.

## Project Structure

- **UI Layer**: A single screen with buttons from 1 to 9. Each button fetches and displays a specific key-value pair from Firebase Remote Config.
- **Firebase Setup**: Integration with Firebase services to utilize Remote Config functionality.

## How to Use This Project

### Prerequisites

1. Android Studio (latest stable version recommended)
2. Firebase Project setup in the [Firebase Console](https://console.firebase.google.com)
3. Add your `google-services.json` file to the `app` directory.

### Setting Up Firebase Remote Config

1. Go to the **Firebase Console**.
2. Navigate to the **Remote Config** section.
3. Create key-value pairs, e.g.:
    - `key1` = "Hello World!"
    - `key2` = 12345
    - `key3` = "Welcome to Firebase Remote Config"
4. Publish your changes in the Firebase Console.

---

### Running the App

1. Clone the repository.
2. Open the project in **Android Studio**.
3. Sync the project with Gradle.
4. Build and run the app on an emulator or a physical device.

---

## UI Built with Jetpack Compose

- Buttons numbered from 1 to 9.
- A **Text** view displays the fetched key-value result.

---

## Future Enhancements

- Add more data types and keys to demonstrate Firebase Remote Config's versatility.
- Enhance UI/UX for a production-ready feel.
- Integrate caching and fallback mechanisms.
- Setting initialization in App Startup.

---

## Screenshots

> Coming Soon.

---

## Contributing and Issues

Feel free to fork the project and contribute. PRs are welcome!. If you find any issue you can create an issue.

---
