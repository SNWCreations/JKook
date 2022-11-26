# JKook

选择其他语言的README: [English](README.md)

Java 平台的 [Kook](https://kookapp.cn) 机器人插件框架。

JKook 的官方 Kook 服务器: [点我加入](https://kook.top/aecCr6)

## 特点

* Kook 中几乎所有内容的完整描述
* 良好的设计
* 基础的插件类
* 非常详细的文档

## 安装

您应该按照以下步骤准备工作:

---

### 在 JitPack 上使用预编译的库（推荐）

您只需将 JitPack 存储库添加为项目中的存储库之一。

### 自行编译

#### 使用 Maven 3

JKook 是一个 Java“程序”, 它使用 [Maven 3](https://maven.apache.org) 进行编译.

要编译和安装它，您应该执行以下步骤:
* 安装 Maven 和 Git
* 克隆此存储库 (`git clone https://github.com/SNWCreations/JKook.git`)
* `mvn clean install`

#### 使用 Gradle

创建一个 Gradle 项目,在 `build.gradle` 内引入依赖

```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.SNWCreations:JKook:{version}'
}
```

* `{version}` 应替换为您需要使用的 JKook API 的版本

---

最后，将组件作为依赖项添加到您的项目中。

_提示:_

如果你使用的是来自 JitPack 的库, 则 `groupId` 为 `com.github.SNWCreations`, `artifactId` 为 `JKook`.

如果你选择自己编译, 则 `groupId` 为 `snw`, `artifactId` 为 `jkook`.

万事俱备! 现在你可以开始编写你的代码!

## JKook 的目标

我们开发出这个框架是为了给 Kook 开发者社区提供一个统一的标准。

虽然它是“for Java”的，但我们更喜欢跨语言的标准。

我们的最终目标是让开发者能够使用 JKook 作为多种编程语言下的 Kook 机器人的开发框架。

## 作者的话

老实说，我一开始只是出于兴趣才设计这个的。

我花了 20 多天完成了基础的设计。

大大小小的修改和错误修复花了我几天时间。

这段时间有幸认识了一些朋友，他们也为这个项目的开发提供了一些帮助，在此表示感谢。

最后，我把这个框架给大家介绍给大家，希望对大家开发自己喜欢的机器人有所帮助。

我们希望您可以创建自己的 Kook Bot，然后用 Bot 为他人带来快乐。

> 空谈无用，应该付出实践。

## 特别感谢

Bukkit 项目：框架的设计深受这个项目的影响。

Jetbrains：他们提供了如此出色的 [IntelliJ IDEA](https://www.jetbrains.com/idea)!
