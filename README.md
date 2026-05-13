# MusicStreamApp 🎵

A modern Android Music Streaming Application built using Java and Android Studio.

The application provides a Spotify-inspired UI with online music streaming, album artwork, playlist navigation, and playback controls.

---

# Features

- 🎶 Online Music Streaming
- 🖼 Album Artwork Display
- ⏯ Play / Pause Controls
- ⏭ Next Song
- ⏮ Previous Song
- 📃 Playlist Navigation
- 🎧 ExoPlayer Integration
- ⚡ RecyclerView-based Song List
- 🌙 Modern Dark UI
- 📱 Responsive Android Layouts

---

# Tech Stack

| Technology | Purpose |
|---|---|
| Java | Core Android Development |
| Android Studio | IDE |
| XML | UI Design |
| RecyclerView | Song List Display |
| Glide | Image Loading |
| ExoPlayer | Audio Streaming |
| Retrofit | API Integration |
| Gradle | Dependency Management |

---

# Project Structure

```plaintext
MusicStreamApp/
│
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml
│   │
│   ├── java/com/example/musicstreamiapp/
│   │   ├── MainActivity.java
│   │   ├── PlayerActivity.java
│   │   ├── OnlineSong.java
│   │   ├── OnlineSongAdapter.java
│   │   └── api/
│   │       ├── ApiService.java
│   │       ├── RetrofitClient.java
│   │       └── JamendoResponse.java
│   │
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── activity_player.xml
│   │   │   └── song_item.xml
│   │   │
│   │   └── drawable/
│   │       ├── song_card.xml
│   │       ├── player_background.xml
│   │       └── round_button.xml
│
└── build.gradle.kts
```

---

# Screens

## Home Screen
- Displays playlist using RecyclerView
- Shows song title, artist name, and album image

## Player Screen
- Displays current song information
- Supports play/pause
- Supports next/previous song navigation
- Streams audio using ExoPlayer

---

# Dependencies

Add these dependencies inside:

```gradle
build.gradle.kts (Module :app)
```

```gradle
implementation("androidx.recyclerview:recyclerview:1.3.2")

implementation("com.github.bumptech.glide:glide:4.16.0")

implementation("com.google.android.exoplayer:exoplayer:2.19.1")

implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
```

---

# Permissions

Inside:

```xml
AndroidManifest.xml
```

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

---

# How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/MusicStreamApp.git
```

2. Open the project in Android Studio

3. Sync Gradle

4. Connect Android device or emulator

5. Run the application

---

# Learning Outcomes

This project helped in understanding:

- Android Activity Lifecycle
- RecyclerView & Adapters
- ExoPlayer Media Streaming
- Intent Communication
- Serializable Objects
- Modern Android UI Design
- API Integration
- Image Loading Libraries
- Playlist Handling

---

# Future Improvements

- 🔍 Song Search
- ❤️ Favorites Playlist
- 🔔 Notification Controls
- ☁ Firebase Backend
- 📥 Offline Downloads
- 🎼 Lyrics Support
- 🔀 Shuffle & Repeat
- 👤 User Authentication
- 🎧 Background Playback Service

---

# Author

Parth Singh

---

# License

This project is developed for educational and learning purposes.
