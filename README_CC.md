# JKook

選擇他言之讀我: [English](README.md)

Java 平臺之 [Kook](https://kookapp.cn) 機器人插件框架。

JKook 之官方 Kook 伺服器: [點我加入](https://kook.top/aecCr6)

## 特點

* Kook 中幾乎所有內容之完整描述
* 良好之設計
* 基礎之插件類
* 非常詳細之文檔

## 安裝

汝宜依照以下步驟準備工作:

---

### 在 JitPack 上使用預編譯之庫（推薦）

汝只需將 JitPack 儲庫添加為專案之儲庫之一。

### 自行編譯

#### 使用 Maven 3

JKook 是一 Java“程序”, 它使用 [Maven 3](https://maven.apache.org) 進行編譯.

要編譯和安裝之, 汝宜執行以下步驟:
* 安裝 Maven 和 Git
* 克隆此儲庫 (`git clone https://github.com/SNWCreations/JKook.git`)
* `mvn clean install`

#### 使用 Gradle

創造一 Gradle 專案,在 `build.gradle` 內引入依賴

```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.SNWCreations:JKook:{version}'
}
```

* `{version}` 宜替換為汝需要使用之 JKook API 之版本

---

最後，將組件作為依賴項添加到汝之專案中。

_提示:_

若汝使用之為 JitPack 之庫, 則 `groupId` 為 `com.github.SNWCreations`, `artifactId` 為 `JKook`.

若汝選擇自行編譯, 則 `groupId` 為 `snw`, `artifactId` 為 `jkook`.

萬事具備! 現今汝可始撰汝之代碼矣!

## JKook 之目標

吾輩開發此框架者，為供 Kook 開發者社區一統之標準。

雖然其為“for Java”，然我等更喜跨語言之標準。

我等之終極目標，乃使開發者能於多種編程語言之下，用 JKook 為 Kook 之機器人開發框架也。

## 作者之語

老實說，吾初時僅出於興趣而設計此。

吾花二十餘日完成基礎之設計。

大小修改及錯誤修復亦花吾數日時。

此段時光幸而識得一些朋友，彼等亦為此項目之開發提供一些助，謹此表示感謝。

終而，吾將此框架介紹與汝，望對汝之開發自汝所喜之機器人有所助。

吾等望汝能創造自汝之 Kook Bot，而後以 Bot 為他人帶來歡樂。

> 空談無用，應付出實踐。

## 特別感謝

Bukkit 項目：框架之設計深受此項目之影響。

Jetbrains：彼等提供如此卓越之 [IntelliJ IDEA](https://www.jetbrains.com/idea)!
