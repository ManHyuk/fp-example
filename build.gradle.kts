import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "me.manhyuk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.arrow-kt:arrow-core:1.0.1")
    implementation("io.arrow-kt:arrow-fx-coroutines:1.0.1")
    implementation("io.arrow-kt:arrow-optics:1.0.1")
//    implementation("io.arrow-kt:arrow-syntax:0.13.2")
//    implementation("o.arrow-kt:arrow-core-data:0.13.2")

    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

application {
    mainClassName = "MainKt"
}