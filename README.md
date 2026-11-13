# BentleyBooVR Goop Bot

A small private-lobby code companion for the BentleyBooVR project.

## Current version

- Enter a private lobby code.
- Copy it to the clipboard.
- Clear it from the page.
- The code is held only in the current page session; it is not sent to a server or saved.

## Run locally

Open `index.html` in a modern browser. Clipboard access works best on localhost or HTTPS.

Alternatively, run:

```bash
python -m http.server 8000
```

Then open http://localhost:8000.

## Important scope

This starter does **not** log into Animal Company, connect to its matchmaking services, impersonate a player, automate lobby entry, or modify the game. Use the game's normal private-room join flow. Any future game integration must use an official, authorized API or test environment.

## Project files

- `index.html` — standalone code companion.
