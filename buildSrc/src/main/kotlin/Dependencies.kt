object Versions {
    const val kotlin = "1.3.40"
    const val android_gradle_plugin = "3.4.1"
    const val compile_sdk = 28
    const val min_sdk = 21
    const val target_sdk = 28
    const val version_code = 1
    const val version_name = "1.0.0"
    const val androidx = "1.0.2"
    const val constraintlayout = "1.1.3"
    const val junit = "4.12"
    const val androidx_test_runner = "1.2.0"
    const val androidx_test_junit = "1.1.1"
    const val androidx_test_espresso_core = "3.2.0"
    const val dagger = "2.23.2"
    const val retrofit = "2.6.0"
    const val okhttp = "4.0.0"
    const val stetho = "1.5.1"
    const val jackson = "2.9.9"
}

object Dependencies {
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
    const val core_ktx = "androidx.core:core-ktx:${Versions.androidx}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val androidx_test_runner = "androidx.test:runner:${Versions.androidx_test_runner}"
    const val androidx_test_junit = "androidx.test.ext:junit:${Versions.androidx_test_junit}"
    const val androidx_test_espresso_core =
        "androidx.test.espresso:espresso-core:${Versions.androidx_test_espresso_core}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_jackson = "com.squareup.retrofit2:converter-jackson:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
    const val stetho_okhttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
    const val jackson_module_kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}"
}
