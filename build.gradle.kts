plugins {
    `java-library`
    `maven-publish`
    id("publish-conventions")
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api("org.slf4j:slf4j-api:1.7.36")
    api("org.yaml:snakeyaml:2.0")
    compileOnly("org.jetbrains:annotations:23.0.0")
}

group = "io.github.snwcreations"
version = "0.54.1"
description = "JKook"

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.javadoc {
    options.encoding = "UTF-8"
}
