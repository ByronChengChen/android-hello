# Spec — Android Hello World

> 本文档由 **Kiro CLI `kiro_planner` agent** 生成（Spec 驱动开发流程的规划阶段产物）。
> 规划 agent 只有只读权限（fs_read / glob / grep），产出计划后交由执行 agent 落地实现。

---

## 1. 问题陈述

创建一个完整的 Android Hello World 项目，包含所有必要的配置文件和源码，实现一个简单的计数器应用。

## 2. 需求

1. 使用 AGP 8.5.2 和 Gradle 8.7
2. compileSdk 34, minSdk 24, targetSdk 34, Java 17
3. 应用 ID / namespace: `com.byron.hello`
4. 基本 Material Design UI，标题「安卓 Hello」，带计数器按钮
5. 包含所有必要的 Android 项目结构文件
6. 包含 GitHub Actions 配置用于构建 debug APK
7. 包含项目文档和配置

## 3. 背景

- 这是一个全新的 Android 项目，目录为空
- 需要遵循标准的 Android 项目结构
- 使用现代 Android 开发实践

## 4. 设计方案

1. 标准 Android 项目结构
2. 使用 Material Design 3 主题
3. 简单的计数器逻辑，点击按钮递增并显示
4. 适配自适应启动图标

## 5. 任务分解

每项任务遵循「目标 / 实现 / 测试 / 演示」四维度描述。

### Task 1: 创建项目根目录配置
- **目标**: 设置项目级 Gradle 配置
- **实现**: 创建根目录的 `build.gradle`, `settings.gradle`
- **测试**: Gradle sync 应成功
- **演示**: 项目可以被 Android Studio 识别为 Android 项目

### Task 2: 配置 Gradle Wrapper
- **目标**: 设置指定的 Gradle 版本
- **实现**: 创建 `gradle/wrapper/gradle-wrapper.properties`
- **测试**: 可以执行 `./gradlew tasks`
- **演示**: Gradle wrapper 正常工作

### Task 3: 创建应用模块配置
- **目标**: 设置应用级别的 build.gradle
- **实现**: 创建 `app/build.gradle` 包含指定配置
- **测试**: Gradle build 应成功
- **演示**: 应用模块配置完成

### Task 4: 创建 Android Manifest 和主 Activity
- **目标**: 设置应用入口点和权限
- **实现**: 创建 `AndroidManifest.xml` 和 `MainActivity.java`
- **测试**: 应用应能编译
- **演示**: 基本的 Android 应用结构就绪

### Task 5: 创建布局文件
- **目标**: 实现「安卓 Hello」标题和计数器按钮的 UI
- **实现**: 创建 `activity_main.xml` 布局文件
- **测试**: 布局应能正确渲染
- **演示**: UI 设计完成

### Task 6: 创建资源文件
- **目标**: 设置字符串、颜色、主题等资源
- **实现**: 创建 `values/` 目录下的 `strings.xml`, `colors.xml`, `themes.xml`
- **测试**: 资源应能被正确引用
- **演示**: 应用具备完整的资源系统

### Task 7: 创建启动图标文件
- **目标**: 实现自适应启动图标
- **实现**: 创建各种 mipmap 和 drawable 图标文件
- **测试**: 应用图标应显示正常
- **演示**: 应用具备完整的图标系统

### Task 8: 创建 CI/CD 配置
- **目标**: 设置 GitHub Actions 构建工作流
- **实现**: 创建 `.github/workflows/build.yml`
- **测试**: GitHub Actions 应能触发构建
- **演示**: 云端构建配置完成

### Task 9: 创建项目文档和配置
- **目标**: 设置项目文档和 Git 配置
- **实现**: 创建 `README.md` 和 `.gitignore`
- **测试**: 文件应包含必要信息
- **演示**: 项目文档和配置就绪

### Task 10: 集成测试
- **目标**: 验证所有组件协同工作
- **实现**: 运行完整构建并测试基本功能
- **测试**: 应用应能构建并运行
- **演示**: 完整的 Android Hello World 项目

---

## 6. 实际执行记录

| 阶段 | 命令 | 结果 |
|------|------|------|
| 规划 | `kiro-cli chat --agent kiro_planner --trust-all-tools` | 产出本文档（Task 1-10），消耗 0.12 credits |
| 执行 | `kiro-cli chat --trust-all-tools` | 落地 17 个文件，消耗 1.73 credits |

### 计划外修复（3 项）

Kiro 生成的产物在真实构建时暴露了 3 个问题，均已修复：

1. **AGP 8 废弃 `package` 属性** — `AndroidManifest.xml` 中同时存在 `package` 与 `namespace` 会报错，已移除 `package`。
2. **缺少 `gradle.properties`** — AGP 8.x 要求显式声明 `android.useAndroidX=true`，Kiro 遗漏此文件，导致首次 GitHub Actions 构建失败（`checkDebugAarMetadata FAILED`）。
3. **缺少 Gradle Wrapper 脚本** — 只生成了 `gradle-wrapper.properties`，未生成 `gradlew` / `gradlew.bat` / `gradle-wrapper.jar`，已从 Gradle v8.7.0 官方仓库补全。

### 关于 V3 引擎

`kiro-cli chat --v3 --mode spec` 在当前环境**不可用**：
```
HTTP 400 ValidationException  reason: INVALID_MODEL_ID
```
V3 引擎需要付费模型（Claude 系），Free 账号仅有开源模型（deepseek-3.2 / qwen3-coder-next / minimax / glm-5），因此 V3 报 `Invalid model ID`。

**可用替代方案**：V2 引擎 + `kiro_planner` agent，同样实现规划/执行分离的 Spec 驱动开发。
