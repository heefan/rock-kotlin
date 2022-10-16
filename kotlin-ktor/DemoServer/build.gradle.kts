import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// ktor
// https://ktor.io/docs/server-dependencies.html#add-ktor-dependencies
plugins {
    kotlin("jvm") version "1.7.20"
    application
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

// https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
dependencies {
    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-server-core:2.1.2")
    implementation("io.ktor:ktor-server-netty:2.1.2")
    implementation("ch.qos.logback:logback-classic:1.4.3")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("ios.ktor.server.netty.EnginMain")
}