# BentleyBooVR Goop Bot

A standalone Meta Quest companion starter for managing a private-room code while you join Animal Company through its normal in-game flow.

## Current game version noted

- Animal Company version reported for testing: `1.99.4.4071`
- This is a user-provided version note, not a verified compatibility claim.

## Project contents

- `index.html` — browser-based lobby-code helper.
- `app/` — native Android companion app starter. It provides a simple screen to enter and copy a private-room code.
- `settings.gradle.kts`, `build.gradle.kts`, `gradle.properties` — Gradle project configuration.

## Native Android / Quest app

The native starter is a basic Android activity intended for testing as a 2D companion app on a compatible Quest headset.

To build it, use Android Studio with JDK 17 and Android SDK Platform 35 installed:

1. Open this repository as a project in Android Studio.
2. Let Android Studio sync the Gradle project.
3. Build the `app` configuration to create a debug APK.
4. Install and test the APK only on a device you own or are authorized to use, following Meta's current developer and app-installation requirements.

This repository does not currently include a Gradle wrapper or a prebuilt APK.

## Scope and privacy

- The code is held only in the app screen's memory and is not saved or uploaded.
- The app copies the code to the Android clipboard when you tap **Copy lobby code**.
- Use Animal Company's normal in-game private-room flow to join.
- The app does not log into Animal Company, connect to matchmaking/game servers, automate lobby entry, impersonate a player, modify the game client, or bypass game protections.
- Any future integration must use a documented, officially supported API or an authorized test environment.

## Web helper

Open `index.html` in a modern browser. Clipboard access works best on localhost or HTTPS.

For local preview:

```bash
python -m http.server 8000
```

Then open `http://localhost:8000`.
