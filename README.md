# Lighthouse

Lighthouse 是一个面向长篇网文创作场景的前后端分离 agent 系统骨架，用来支持从世界观搭建、提纲生成、章节创作，到人物/伏笔/时间线管理与一致性校验的完整创作流程。

## 产品目标

- 服务长篇网络小说、系列文、世界观复杂作品的创作过程
- 用 agent 能力辅助作者进行提纲拆解、章节生成、记忆沉淀与回写
- 让人物设定、剧情伏笔、时间线和章节内容保持长期一致
- 为后续多人协作、工作流编排、模型切换与质量评估预留扩展空间

## 技术栈

- Frontend: Next.js 14 + React 18 + TypeScript
- Backend: Spring Boot 3 + Java 17（运行需要 JDK 17+）
- Docs: Markdown

## 目录结构

```text
.
├── frontend/         # Next.js 前端骨架
├── backend/          # Spring Boot 后端骨架
├── docs/             # 架构与设计文档
└── README.md         # 项目总览
```

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

说明：当前仓库先提供 Spring Boot 基础骨架，尚未附带 Maven Wrapper。

默认服务地址：`http://localhost:8080`

## 当前状态

当前仓库为初始化骨架，重点完成：

- 前后端目录与基础入口
- 创作系统架构文档
- 最小可运行的示例页面与健康检查接口

## 后续 TODO

- 接入真实 LLM / agent orchestration
- 建立提纲、章节、人物、伏笔、时间线的数据模型
- 增加记忆回写、冲突检测、一致性审查工作流
- 补充数据库、缓存、向量检索与权限体系
- 增加测试、CI/CD 与部署方案
