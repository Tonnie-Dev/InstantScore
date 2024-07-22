

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version "1.7.21-1.0.8"

}

android {
    namespace = "com.uxstate.instantscore"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.uxstate.instantscore"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] =
                    "$projectDir/schemas"
            }
        }
    }



    buildTypes {

        getByName("release") {
            isMinifyEnabled = false
            multiDexEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}



dependencies {

    implementation(libs.androidx.core.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)

    implementation(libs.multidex)

    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)

    // Chucker
    debugImplementation(libs.library)
    releaseImplementation(libs.library.no.op)

    // Material 3 Lib - this version is causing the problem

    implementation(libs.material3)

    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)

    // Dagger - Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation.compose)
    // when using Kotlin
    kapt(libs.hilt.compiler)
    // hilt work
    implementation(libs.hilt.work)

    // WorkManager with Coroutines
    implementation(libs.work.runtime.ktx)

    // App Startup
    implementation(libs.startup.runtime)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)

    // Retrofit Converters
    implementation(libs.converter.moshi)
    implementation(libs.converter.scalars)

    // Moshi Library Dependencies - Core Moshi JSON Library and Moshi"s Kotlin support and converter factory
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)

    // Room KTX with Kotlin Extensions and Coroutines support for Room
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)

    // Lottie Animation
    implementation(libs.lottie.compose)

    // Compose Nav Destinations
    implementation(libs.io.github.raamcosta.compose.destinations.core)
    ksp(libs.ksp)

    // Pager - Accompanist
    implementation(libs.accompanist.pager) // Pager
    implementation(libs.accompanist.pager.indicators) // Pager Indicators

    // Swipe to Refresh - Accompanist
    // implementation("com.google.accompanist:accompanist-swiperefresh:_")

    // System UI Controller - Accompanist
    implementation(libs.accompanist.systemuicontroller)

    // Timber Logging
    implementation(libs.timber)

    // Date Picker Library
    implementation(libs.datetime)

    // DesugaringLib
    coreLibraryDesugaring(libs.desugar.jdk.libs)

    // testing
    androidTestImplementation(libs.truth)
    androidTestImplementation(libs.androidx.test.core.ktx)
    androidTestImplementation(libs.mockwebserver)
    testImplementation(libs.mockito.android)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockk)
    testImplementation(libs.mockito.core)
    androidTestImplementation(libs.mockito.android)
    androidTestImplementation(libs.hilt.android.testing)
    kaptAndroidTest(libs.hilt.android.compiler)
    testImplementation(libs.junit.junit)
    testImplementation(libs.androidx.test.runner)
    testImplementation(libs.truth)
    testImplementation(libs.androidx.test.core.ktx)
    testImplementation(libs.robolectric)
    implementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.core.testing)
}
