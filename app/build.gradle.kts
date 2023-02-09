import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp") version "1.7.21-1.0.8"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("com.diffplug.spotless")
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
    }

    /* Kotlin Block - makes sure that the KSP Plugin looks at
     the right paths when it comes to generated classes*/
    kotlin {
        sourceSets {
            debug {
                kotlin.srcDir("build/generated/ksp/debug/kotlin")
            }
            release {
                kotlin.srcDir("build/generated/ksp/release/kotlin")
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
// ktlintFormat task will need to run before preBuild
tasks.getByPath("preBuild")
    .dependsOn("ktlintFormat")

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {

    android.set(false)
    ignoreFailures.set(false)
    disabledRules.set(setOf("final-newline", "no-wildcard-imports"))
    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
        reporter(ReporterType.SARIF)
    }
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        // version, setUseExperimental, userData and editorConfigOverride are all optional
        ktlint("0.45.2")
            .setUseExperimental(true)
            .userData(mapOf("android" to "true"))
            .editorConfigOverride(mapOf("indent_size" to 2))
    }
    kotlinGradle {
        target("*.gradle.kts") // default target for kotlinGradle
        ktlint() // or ktfmt() or prettier()
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:1.3.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.3")

    implementation("androidx.multidex:multidex:2.0.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.3")



    // Material 3 Lib - this version is causing the problem

    implementation("androidx.compose.material3:material3:1.1.0-alpha04")

    // Coil
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("io.coil-kt:coil-svg:2.2.2")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")
    implementation("com.squareup.okhttp3:okhttp:4.7.2")

    // Retrofit Converters
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")

    // Moshi Library Dependencies - Core Moshi JSON Library and Moshi"s Kotlin support and converter factory
    implementation("com.squareup.moshi:moshi:1.12.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")

    // Room KTX with Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")

    // Paging 3.0
    implementation("androidx.paging:paging-compose:1.0.0-alpha17")

    // Lottie Animation
    implementation("com.airbnb.android:lottie-compose:5.2.0")

    // Compose Nav Destinations
    implementation("io.github.raamcosta.compose-destinations:core:1.6.23-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.6.23-beta")

    // Pager - Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.28.0") // Pager
    implementation("com.google.accompanist:accompanist-pager-indicators:0.28.0") // Pager Indicators

    // Swipe to Refresh - Accompanist
    implementation("com.google.accompanist:accompanist-swiperefresh:0.28.0")

    // System UI Controller - Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

    // Timber Logging
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Date Picker Library
    implementation("io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc")

    // DesugaringLib
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.6")

    // testing
    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
    androidTestImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")
    testImplementation("org.mockito:mockito-android:3.10.0")
    testImplementation("org.mockito:mockito-inline:3.11.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    testImplementation("io.mockk:mockk:1.12.7")
    testImplementation("org.mockito:mockito-core:3.11.2")
    androidTestImplementation("org.mockito:mockito-android:3.10.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.42")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.38.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test:runner:1.4.0")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("androidx.test:core-ktx:1.4.0")
    testImplementation("org.robolectric:robolectric:4.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
}
