plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.bentleyboovr.goopbot"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.bentleyboovr.goopbot"
        minSdk = 29
        targetSdk = 32
        versionCode = 1
        versionName = "0.1.0"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}
