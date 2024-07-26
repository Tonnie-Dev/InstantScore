plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.ksp.plugin)
    alias(libs.plugins.parcelize.plugin)
}

android {
    namespace = "com.uxstate.instantscore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.uxstate.instantscore"
        minSdk = 21
        targetSdk = 34
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
            //multiDexEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        //isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //implementation(libs.multidex)


    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)

    // Dagger Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // hilt work
    implementation(libs.work.runtime.ktx)

    // WorkManager with Coroutines
    implementation(libs.work.runtime.ktx)

    // App Startup
    implementation(libs.startup.runtime)

    // Retrofit
    implementation(Square.retrofit2)
    implementation(Square.okHttp3)
    implementation(Square.okHttp3.loggingInterceptor)

    // Retrofit Converters
    implementation(Square.retrofit2.converter.moshi)
    implementation(libs.converter.scalars)

    // Moshi Library Dependencies - Core Moshi JSON Library and Moshi"s Kotlin support and converter factory
    implementation(Square.moshi)
    implementation(Square.moshi.kotlinReflect)

    // Room components
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    // Lottie Animation
    implementation(libs.lottie.compose)

    // Compose Nav Destinations
    //implementation(libs.compose.destinations.core)
    //ksp(libs.compose.destinations.ksp)

    implementation(libs.ksp)
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
    //coreLibraryDesugaring(libs.desugar.jdk.libs)


}
