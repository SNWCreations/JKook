plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("net.kyori:indra-common:3.1.3")
    implementation("cl.franciscosolis.sonatype-central-upload:cl.franciscosolis.sonatype-central-upload.gradle.plugin:1.0.3")
}