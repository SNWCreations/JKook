# JKook

The [KOOK](https://kookapp.cn) API standard & Bot framework for Java.

**End Of Life!**

This branch of JKook API (0.37.x) was End-Of-Life since 2023-1-31.

Please migrate to newer API version for bugfixes and new features!
See this [tutorial](https://github.com/SNWCreations/JKookTutorial/blob/master/Migrate_To_0.48.md) for more information.

## Features

* A complete representation of almost everything in Kook
* Powerful design
* Basic Bot representation
* Very detailed documentation

## Installation

You should do following steps to prepare the artifacts:

---

### Use pre-compiled artifacts on JitPack (Recommended)

You just need to add the JitPack repository as the one of the repositories in your project.

### Compile by yourself

JKook is a Java "program" and it uses [Maven 3](https://maven.apache.org) for compilation.

To compile and install it, you should perform the following steps:
* Install Maven and Git
* Clone this repository (`git clone https://github.com/SNWCreations/JKook.git`)
* `mvn clean install`

---

In the end, add the artifact as the dependency in your project.

_Tips:_

If you use the artifacts from JitPack, then `groupId` is `com.github.SNWCreations`, `artifactId` is `JKook`.

If you use the artifacts that compiled by yourself, then `groupId` is `snw`, `artifactId` is `jkook`.

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
