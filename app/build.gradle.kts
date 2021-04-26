plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdkVersion (Versions.minSdkVersion)
        targetSdkVersion  (Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled =  false
            proguardFiles  (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        exclude ("META-INF/DEPENDENCIES")
    }
}

dependencies {

    implementation (Deps.kotlin_stdlib)
    implementation (Deps.ktx_core)
    implementation (Deps.appcompat_v7)
    implementation (Deps.design)
    implementation (Deps.constraint_layout)

    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    kapt ("com.github.bumptech.glide:compiler:4.12.0")

    implementation ("androidx.palette:palette-ktx:1.0.0")

    testImplementation (Deps.junit)
    androidTestImplementation ("androidx.test.ext:junit:1.1.1")
    androidTestImplementation (Deps.espresso_core, {
        exclude (group = "com.android.support", module = "support-annotations")
    })
}