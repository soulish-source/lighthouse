# Backend

Spring Boot 后端骨架，承担 Lighthouse 的 API、领域模型与 agent 工作流编排能力。

> 运行要求：JDK 17+

## 计划职责

- 作品 / 提纲 / 章节管理 API
- 人物 / 设定 / 伏笔 / 时间线管理
- 记忆抽取与回写
- 一致性检查
- agent orchestration

## 本地启动

```bash
mvn spring-boot:run
```

说明：当前仓库先提供 Spring Boot 基础骨架，尚未附带 Maven Wrapper。

## 当前状态

- 已提供 Spring Boot 启动类
- 已提供 `/api/health` 健康检查接口
- 尚未接入数据库、任务编排与真实业务模块
