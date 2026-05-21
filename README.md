# Custom Doc Plugin

自定义类注释模板插件

## 功能

在类声明上方输入 `/**` 并按回车键，自动生成：

```java
/**
 * @description 
 */
```

## 构建插件

```bash
./gradlew buildPlugin
```

构建完成后，插件文件位于：`build/distributions/CustomDocPlugin-1.0.0.zip`

## 安装插件

1. 打开 IDEA
2. 进入 `Settings` -> `Plugins`
3. 点击齿轮图标 -> `Install Plugin from Disk...`
4. 选择生成的 zip 文件
5. 重启 IDEA

## 使用方法

1. 在 Java 类声明上方输入 `/**`
2. 按回车键
3. 自动生成注释模板
