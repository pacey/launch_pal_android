plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    sourceSets["main"].java.srcDir("src/main/kotlin")
    compileSdkVersion(Versions.compile_sdk)
    defaultConfig {
        applicationId = "com.github.pacey.launchpal"
        minSdkVersion(Versions.min_sdk)
        targetSdkVersion(Versions.target_sdk)
        versionCode = Versions.version_code
        versionName = Versions.version_name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro", "okhttp.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.kotlin_stdlib)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.core_ktx)
    implementation(Dependencies.constraintlayout)
    implementation(Dependencies.dagger)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_jackson)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.stetho)
    implementation(Dependencies.stetho_okhttp)
    implementation(Dependencies.jackson_module_kotlin)

    kapt(Dependencies.dagger_compiler)

    testImplementation(Dependencies.junit)

    androidTestImplementation(Dependencies.androidx_test_runner)
    androidTestImplementation(Dependencies.androidx_test_junit)
    androidTestImplementation(Dependencies.androidx_test_espresso_core)
}
