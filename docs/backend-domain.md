# Backend Domain Design

## 目标

第一阶段后端不追求把数据库、鉴权、工作流引擎一次做完，而是先把 **领域边界、API 形状、后续持久化方向** 立住，让前端和后续 agent 能围绕稳定对象继续扩展。

当前策略：

- 用 Spring Boot 3 + Java 17 建立清晰 package 结构
- 先提供只读查询接口和内存示例数据
- DTO 与 controller 直接表达核心产品对象
- 后续再逐步接入 PostgreSQL / ORM / 向量检索 / 异步任务

---

## 领域对象

### 1. Project（项目）

顶层容器，描述一部作品的总体信息。

关键字段：

- `id`
- `name`
- `genre`
- `premise`
- `stage`
- `targetWords`
- `completedWords`
- `narrativeGoals`
- `labels`

职责：

- 汇总创作目标和当前阶段
- 承载 dashboard 入口
- 作为 outline / chapter / character / foreshadow / timeline 的归属根节点

### 2. OutlineNode（提纲节点）

统一表示全书、卷、章节等结构层级。

关键字段：

- `id`
- `type`：`BOOK` / `VOLUME` / `CHAPTER`
- `title`
- `summary`
- `goal`
- `pov`
- `status`
- `keyConflicts`
- `reveals`
- `dependencies`

职责：

- 为章节生成提供上游结构约束
- 作为伏笔回收和时间线事件的锚点
- 后续适合扩展 parent/children 关系或 tree path

### 3. Chapter（章节）

章节是生产核心对象，既是文本容器，也是工作流任务中心。

关键字段：

- `id`
- `title`
- `volumeTitle`
- `status`
- `pov`
- `targetWords`
- `currentWords`
- `updatedAt`
- `focusCharacters`
- `relatedForeshadows`

后续应拆分：

- `ChapterDraft`
- `ChapterVersion`
- `ChapterReview`
- `ChapterContextSnapshot`

### 4. Character（人物）

人物对象应明确区分静态设定与动态状态。

当前示例字段：

- `name`
- `role`
- `faction`
- `currentArc`
- `status`
- `traits`
- `unresolvedThreads`

后续建议：

- `character_profile`：静态设定
- `character_state`：动态状态（可事件溯源）
- `character_relationship`：关系图

### 5. Foreshadow（伏笔）

伏笔是可追踪的叙事承诺。

关键字段：

- `title`
- `status`
- `plantedAt`
- `targetPayoff`
- `riskLevel`
- `relatedCharacters`
- `notes`

后续建议增加：

- `payoffChapterId`
- `evidenceRefs`
- `reminderWindow`
- `overdueScore`

### 6. TimelineEvent（时间线事件）

用于维持事件顺序、人物状态和因果一致性。

关键字段：

- `dayLabel`
- `eventTitle`
- `chapterRef`
- `location`
- `participants`
- `consequence`

后续建议：

- 存绝对时间与相对时间双表示
- 支持地点迁移和耗时计算
- 支持人物状态快照绑定

### 7. GenerationTask（生成任务）

统一表达创作、抽取、审查等异步任务。

关键字段：

- `taskType`
- `targetRef`
- `status`
- `owner`
- `modelProfile`
- `progress`
- `blockers`
- `checklist`

后续适合进入真正任务系统：

- 队列
- 重试
- 审计日志
- 任务输入输出快照

### 8. ModelConfig（模型配置）

让模型变成可配置基础设施，而不是散落在代码里的参数。

关键字段：

- `profileName`
- `provider`
- `primaryModel`
- `fallbackModel`
- `temperature`
- `maxContextTokens`
- `capabilities`
- `promptPreset`
- `memoryPolicy`

后续可扩展：

- 限流策略
- 成本预算
- provider 级 failover
- prompt / tool policy 版本化

---

## API 结构

当前已提供的基础读取接口：

- `GET /api/health`
- `GET /api/projects/{projectId}`
- `GET /api/outlines?projectId=...`
- `GET /api/chapters?projectId=...`
- `GET /api/characters?projectId=...`
- `GET /api/foreshadows?projectId=...`
- `GET /api/timeline-events?projectId=...`
- `GET /api/generation-tasks?projectId=...`
- `GET /api/model-configs?projectId=...`

特点：

- 全部返回统一 `ApiResponse<T>`
- 用单独模块 package 隔离 controller / dto / service
- 当前 service 内存 mock，可直接被真实 repository 替换

---

## 包结构

```text
backend/src/main/java/com/soulish/lighthouse
├── common
├── project
├── outline
├── chapter
├── character
├── foreshadow
├── timeline
├── task
└── model
```

每个模块至少包含：

- `controller`
- `dto`
- `service`

这样做的目的不是追求“分层教科书感”，而是给后续以下演进留出空间：

- DTO / entity 解耦
- repository 接入
- validation 和 command/query 分离
- 模块级测试

---

## 持久化策略（下一阶段）

### Phase 2：结构化数据落库

优先接入 PostgreSQL，建议表：

- `projects`
- `outline_nodes`
- `chapters`
- `chapter_versions`
- `characters`
- `character_states`
- `foreshadows`
- `timeline_events`
- `generation_tasks`
- `model_configs`

### Phase 3：记忆与检索

在关系型数据库之外增加：

- `memory_facts`
- `memory_summaries`
- `consistency_findings`
- 向量库索引章节摘要 / 设定片段 / 角色状态片段

### Phase 4：事件化与审计

当长篇创作流程复杂度上来后，建议给以下对象增加事件流：

- 章节定稿
- 记忆回写
- 伏笔状态变更
- 时间线冲突修复
- 模型配置版本切换

---

## 当前限制

- 仍然是 mock/in-memory 查询，并未接数据库
- 尚无写接口、校验器、鉴权、任务执行器
- 因本机仅有 Java 8，暂未实际编译验证 Java 17 代码
- 现在更像“可展示产品方向的稳定 API 骨架”，不是可上线后端

## 明确的下一步

1. 接入 JDK 17 后跑通 `mvn test` / `mvn spring-boot:run`
2. 引入 JPA 或 MyBatis + PostgreSQL
3. 为项目/提纲/章节至少补一条创建写接口
4. 把记忆回写和一致性审查抽象成真正 task pipeline
