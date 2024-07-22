buildscript {

    repositories{

        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.com.android.tools.build.gradle)
        classpath (libs.kotlin.gradle.plugin)
        classpath(libs.hilt.android.gradle.plugin)

    }

}


