plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2-native-mt"){
        version {
            strictly("1.4.2-native-mt")
        }
    }

    implementation(platform("com.google.firebase:firebase-bom:28.1.0"))
    implementation("com.google.firebase:firebase-analytics")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.github.kmachida12345.otenki_kmm.android"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}