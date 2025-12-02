plugins {
    kotlin("jvm") version "2.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")

    implementation(kotlin("test"))
    implementation(kotlin("test-junit"))
    implementation(kotlin("reflect"))
}

java.sourceSets["test"].java {
    srcDir("src/main/kotlin")
}

//tasks.test {
//    useJUnitPlatform()
//}

kotlin {
    jvmToolchain(17)
}