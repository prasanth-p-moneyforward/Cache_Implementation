import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    kotlin("plugin.spring") version "1.7.20"
    id("org.springframework.boot") version "2.6.12"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

}

group = "com.mfx.invoice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // Spring Boot
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("javax.persistence:javax.persistence-api:2.2")

    implementation("com.github.ben-manes.caffeine:caffeine:3.1.5")
    implementation("org.springframework.boot:spring-boot-starter-cache")

    implementation("mysql:mysql-connector-java:8.0.27")


}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}