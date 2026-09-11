# Android Hello

一个最小的 Android Hello World 应用，使用 **Kiro CLI 生成** + **GitHub Actions 云端构建**，无需本地 Android SDK。

## 功能

- 显示「安卓 Hello」标题
- 一个按钮，点击后显示点击次数
- ConstraintLayout + Material Components

## 生成过程

本项目由 **Kiro CLI** 完成（Spec 驱动开发工作流）：

1. **计划阶段** — `kiro-cli chat --agent kiro_planner`
   使用 `kiro_planner` 规划 agent，将需求拆解为 10 项任务，每项包含「目标 / 实现 / 测试 / 演示」四个维度。
2. **执行阶段** — 按批准的计划，用默认 agent 通过 `fs_write` 落地全部文件。
3. **修复** — 补 `gradle.properties`（AGP 8 需要 `android.useAndroidX=true`）、移除 manifest 中已废弃的 `package` 属性。

## 技术栈

| 项目 | 版本 |
|------|------|
| compileSdk / targetSdk | 34 |
| minSdk | 24 (Android 7.0+) |
| Gradle | 8.7 |
| Android Gradle Plugin | 8.5.2 |
| Java | 17 |

## 如何构建

推送到 `main` 分支后，GitHub Actions 自动：
1. 配置 JDK 17（temurin）
2. 安装 Android SDK
3. 用 Gradle 编译 debug APK
4. 上传 APK 为 artifact

## 下载 APK

1. 打开仓库的 **Actions** 标签页
2. 点击最新的 workflow run
3. 在页面底部的 **Artifacts** 区域下载 `android-hello-debug-apk`

## 本地构建（可选）

```bash
./gradlew assembleDebug
# APK 输出: app/build/outputs/apk/debug/app-debug.apk
```
