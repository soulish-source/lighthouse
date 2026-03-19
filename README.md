# Lighthouse

Lighthouse 是一个面向长篇网文创作场景的前后端分离系统原型。它的目标不是做一个“会续写”的聊天页，而是把 **项目、提纲、章节、人物、伏笔、时间线、记忆回写与一致性审查** 组织成长期可维护的创作操作系统。

## 当前阶段

这轮推进的目标是把仓库从“初始化骨架”推进到 **能展示清晰产品方向的第一阶段工程**：

- 后端：建立领域模块、DTO、controller、service 与基础 API
- 前端：建立长篇创作工作台导航与多页面壳子
- 文档：补齐后端领域模型、路线图、记忆系统设计
- 验证：尽量执行前端构建；后端明确运行前置条件与限制

## 技术栈

- Frontend: Next.js 14 + React 18 + TypeScript
- Backend: Spring Boot 3 + Java 17
- Docs: Markdown

## 目录结构

```text
.
├── frontend/         # Next.js 前端工作台
├── backend/          # Spring Boot 后端 API 骨架
├── docs/             # 架构、路线图、领域与记忆设计文档
└── README.md
```

## 可展示内容

### 前端页面

- 项目概览 `/`
- 提纲 `/outline`
- 章节 `/chapters`
- 角色设定 `/characters`
- 伏笔时间线 `/foreshadows`
- 模型配置 `/models`

### 后端接口

- `GET /api/health`
- `GET /api/projects/{projectId}`
- `GET /api/outlines?projectId=demo-project`
- `GET /api/chapters?projectId=demo-project`
- `GET /api/characters?projectId=demo-project`
- `GET /api/foreshadows?projectId=demo-project`
- `GET /api/timeline-events?projectId=demo-project`
- `GET /api/generation-tasks?projectId=demo-project`
- `GET /api/model-configs?projectId=demo-project`

当前接口仍使用内存 mock 数据，但结构已经对齐长篇创作系统的核心对象。

## 快速启动

### Frontend

```bash
cd frontend
npm install
npm run dev
```

默认开发地址：`http://localhost:3000`

### Backend

```bash
cd backend
mvn spring-boot:run
```

默认服务地址：`http://localhost:8080`

注意：后端运行和编译需要 **JDK 17+**。当前机器若只有 Java 8，将无法直接执行 Spring Boot 3 项目。

## 核心文档

- `docs/architecture.md`：总体产品与系统架构
- `docs/backend-domain.md`：后端领域模型与持久化策略
- `docs/memory-system.md`：长篇记忆回写 / 检索方案
- `docs/roadmap.md`：分阶段路线图

## 当前已知限制

- 后端还是查询型骨架，未接数据库
- 前端目前使用 mock 数据，尚未连真实 API
- 未接入真实 LLM / workflow orchestration
- 本地若没有 JDK 17，后端只能先保证代码结构与文档完整

## 下一步建议

1. 给项目 / 提纲 / 章节补最小写接口与真实存储
2. 把前端页面切到真实 API
3. 引入章节版本、记忆回写和一致性审查数据结构
4. 增加测试、CI 与运行脚本
