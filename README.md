# Android Hello

这是一个使用 Kiro 生成的 Android Hello World 项目。

## 项目特性

- 简单的 Hello World Android 应用
- 点击按钮增加计数功能
- 中文界面显示
- 自适应图标
- Material Design 主题

## 技术栈

- Android SDK 34
- Java 17
- Gradle 8.7
- 支持 Android 24 及以上版本

## 运行项目

1. 使用 Android Studio 打开项目
2. 同步 Gradle 依赖
3. 连接 Android 设备或启动模拟器
4. 点击运行按钮

## GitHub Actions

项目配置了 GitHub Actions，在推送到 main 分支时会自动构建 APK 文件。

## 项目结构

```
android-hello/
├── app/
│   ├── build.gradle          # 应用构建配置
│   └── src/main/
│       ├── java/com/byron/hello/
│       │   └── MainActivity.java  # 主活动逻辑
│       └── res/
│           ├── layout/       # 布局文件
│           ├── values/       # 资源文件
│           ├── drawable/     # 矢量图标
│           └── mipmap/       # 应用图标
├── build.gradle              # 根构建配置
├── settings.gradle           # 项目设置
└── gradle/wrapper/           # Gradle 包装器
```

## 许可证

MIT License
