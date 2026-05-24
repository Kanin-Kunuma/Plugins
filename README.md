# Custom Doc

<div align="center">

![Plugin Icon](src/main/resources/META-INF/pluginIcon.svg)

**A lightweight IntelliJ IDEA plugin for customized JavaDoc comments**

[![JetBrains Plugins](https://img.shields.io/badge/JetBrains-Marketplace-blue)](https://plugins.jetbrains.com/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](LICENSE)
[![Version](https://img.shields.io/badge/version-1.0.0-orange.svg)](https://github.com/Kanin-Kunuma/Plugins/releases)

[English](#english) | [中文](#中文)

</div>

---

## English

### ✨ Features

- 🎯 **Smart Detection** - Only triggers on class-level declarations
- 📝 **Multiple Types** - Supports classes, interfaces, enums, and annotations
- ⚡ **Auto Positioning** - Cursor automatically positioned for quick input
- 🔧 **Non-intrusive** - Methods still use IDEA's default JavaDoc

### 🚀 Installation

**From JetBrains Marketplace:**
1. Open IntelliJ IDEA
2. Go to `Settings` → `Plugins` → `Marketplace`
3. Search for "Custom Doc"
4. Click `Install` and restart IDEA

**From Disk:**
1. Download the latest release from [Releases](https://github.com/Kanin-Kunuma/Plugins/releases)
2. Go to `Settings` → `Plugins` → ⚙️ → `Install Plugin from Disk...`
3. Select the downloaded zip file
4. Restart IDEA

### 📖 Usage

1. Place your cursor above a class, interface, enum, or annotation
2. Type `/**` and press `Enter`
3. The plugin generates:
   ```java
   /**
    * @description [cursor here]
    */
   ```
4. Start typing your description immediately

### 🎬 Demo

```java
// Before
|  // cursor here
public class MyClass {
}

// Type /** and press Enter

// After
/**
 * @description |  // cursor here
 */
public class MyClass {
}
```

### 🛠️ Build from Source

```bash
git clone https://github.com/Kanin-Kunuma/Plugins.git
cd Plugins/CustomDocPlugin
./gradlew buildPlugin
```

The plugin will be in `build/distributions/CustomDocPlugin-1.0.0.zip`

### 📋 Requirements

- IntelliJ IDEA 2023.1 or later
- Java 17 or later

### 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

### 📄 License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

---

## 中文

### ✨ 功能特性

- 🎯 **智能检测** - 仅在类级别声明时触发
- 📝 **多种类型** - 支持类、接口、枚举和注解
- ⚡ **自动定位** - 光标自动定位，方便快速输入
- 🔧 **不干扰** - 方法仍使用 IDEA 默认的 JavaDoc

### 🚀 安装

**从 JetBrains 插件市场：**
1. 打开 IntelliJ IDEA
2. 进入 `Settings` → `Plugins` → `Marketplace`
3. 搜索 "Custom Doc"
4. 点击 `Install` 并重启 IDEA

**从本地安装：**
1. 从 [Releases](https://github.com/Kanin-Kunuma/Plugins/releases) 下载最新版本
2. 进入 `Settings` → `Plugins` → ⚙️ → `Install Plugin from Disk...`
3. 选择下载的 zip 文件
4. 重启 IDEA

### 📖 使用方法

1. 将光标放在类、接口、枚举或注解的上方
2. 输入 `/**` 并按回车
3. 插件会生成：
   ```java
   /**
    * @description [光标在这里]
    */
   ```
4. 直接开始输入描述内容

### 🎬 演示

```java
// 之前
|  // 光标在这里
public class MyClass {
}

// 输入 /** 并按回车

// 之后
/**
 * @description |  // 光标在这里
 */
public class MyClass {
}
```

### 🛠️ 从源码构建

```bash
git clone https://github.com/Kanin-Kunuma/Plugins.git
cd Plugins/CustomDocPlugin
./gradlew buildPlugin
```

插件文件位于 `build/distributions/CustomDocPlugin-1.0.0.zip`

### 📋 系统要求

- IntelliJ IDEA 2023.1 或更高版本
- Java 17 或更高版本

### 🤝 贡献

欢迎贡献！请随时提交 Pull Request。

### 📄 许可证

本项目采用 Apache License 2.0 许可证 - 详见 [LICENSE](LICENSE) 文件。

---

<div align="center">

**Made with ❤️ by Z-COM**

⭐ If you find this plugin helpful, please star this repository!

</div>
