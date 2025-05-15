# JKook

[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/SNWCreations/JKook)

Select Other Language README: [简体中文](README_CN.md)

The [Kook](https://kookapp.cn) Bot's Plugin framework for Java.

JKook Official Kook Server: [Link](https://kook.top/aecCr6)

## Features

* A complete representation of almost everything in Kook
* Powerful design
* Basic Plugin representation
* Very detailed documentation

## Installation

You should do following steps to prepare the artifacts:

---

### Use pre-compiled artifacts on JitPack (Recommended)

You just need to add the JitPack repository as the one of the repositories in your project.

### Compile by yourself

#### Uses Maven 3

JKook is a Java "program" and it uses [Gradle](https://gradle.org) for compilation.

To compile and install it, you should perform the following steps:
* Install Gradle and Git
* Clone this repository (`git clone https://github.com/SNWCreations/JKook.git`)
* `gradlew build publishToMavenLocal`

#### Uses Gradle

Create a Gradle project and import dependencies in `build.gradle`

```
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.snwcreations:jkook:{version}")
}
```

* `{version}` should be replaced with the version of the JKook API you need to use

---

In the end, add the artifact as the dependency in your project.

All done! You can create your things right now!

## The JKook's Goal

We propose this framework to provide a unified standard for the Kook developer community.

Although it is “for Java”, we prefer that the standard be cross-language.

Our Ultimate Goal is to enable developers to use JKook as a development framework for Kook robots in many languages.

## Author's words

To be honest, I designed this just because of interest at the beginning.

I took 20+ days completed the basic design.

The large and small modification and bug fixes took me a few days.

During this time, I have the honor to know some friends, they also provided some help to the development of this project, thanks here.

In the end, I present you with this framework, hoping that it will help you develop your favorite robots.

We hope you can create your own Kook Bot, and then use the Bot to bring happiness to others.

> Talk is cheap, make it happen.

## Special Thanks

The Bukkit Project: The design of the framework is greatly influenced by this project.

Jetbrains: They provide such a great [IntelliJ IDEA](https://www.jetbrains.com/idea)!
