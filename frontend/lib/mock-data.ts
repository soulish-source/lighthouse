export const projectSummary = {
  name: '天渊灯塔',
  genre: '仙侠 / 群像 / 悬疑',
  stage: '第一阶段工程演示',
  premise:
    '围绕长篇网文创作的项目中台：项目、提纲、章节、人物、伏笔、时间线、模型配置统一进入一个长期可维护的工作流。'
};

export const kpis = [
  { label: '目标总字数', value: '220 万', detail: '支持多卷长期规划' },
  { label: '已完成章节', value: '48', detail: '提纲/草稿/审查分层管理' },
  { label: '活跃伏笔', value: '17', detail: '按回收风险持续追踪' },
  { label: '模型配置', value: '3', detail: '创作/抽取/审查职责拆分' }
];

export const workspaceModules = [
  {
    title: '项目概览',
    description: '掌握作品定位、进度、活跃风险与当前生产链路。'
  },
  {
    title: '提纲中心',
    description: '从全书到分卷再到章节，把主线、副线和揭示节点拆清楚。'
  },
  {
    title: '章节工作台',
    description: '围绕章节目标聚合人物状态、时间线约束和相关伏笔。'
  },
  {
    title: '角色设定',
    description: '管理人物静态设定、动态状态和未解决的人物弧线。'
  },
  {
    title: '伏笔时间线',
    description: '把埋点与故事日历绑定，减少遗忘和时间错位。'
  },
  {
    title: '模型配置',
    description: '按任务类型切换模型策略，而不是让一个模型包打天下。'
  }
];

export const outlineNodes = [
  {
    title: '第一卷：灯塔醒者',
    type: 'VOLUME',
    status: '进行中',
    goal: '建立世界危机与主角职责',
    reveals: ['灯塔记录并非绝对真实', '主角与前代守望者有继承关系']
  },
  {
    title: '第 12 章：潮汐回廊',
    type: 'CHAPTER',
    status: '草稿中',
    goal: '让主角第一次主动改写时间碎片',
    reveals: ['顾停舟身份存在反转', '时间改写会造成记忆污染']
  },
  {
    title: '第 13 章：无名观测者',
    type: 'CHAPTER',
    status: '待规划',
    goal: '接入沈照视角，扩大外部世界信息',
    reveals: ['夜航司对灯塔另有所图']
  }
];

export const chapters = [
  {
    title: '潮汐回廊',
    status: 'DRAFTING',
    pov: '林渊',
    progress: '2680 / 4000 字',
    note: '一致性预检查已通过，待补情绪衔接。'
  },
  {
    title: '无名观测者',
    status: 'PLANNED',
    pov: '沈照',
    progress: '0 / 4200 字',
    note: '等待第 12 章定稿后的时间线结果。'
  },
  {
    title: '潮后余响',
    status: 'REVIEW',
    pov: '林渊',
    progress: '3920 / 3800 字',
    note: '需检查灯油设定与前章是否冲突。'
  }
];

export const characters = [
  {
    name: '林渊',
    role: '主角 / 失忆守望者',
    status: '可短暂触碰时间裂缝，记忆残缺',
    traits: ['冷静', '防备心强', '延迟信任旧友'],
    arc: '从被动求生转向主动调查'
  },
  {
    name: '沈照',
    role: '副主角 / 观察者',
    status: '掌握不完整未来片段',
    traits: ['克制', '怀疑主义', '善于谈判'],
    arc: '从试探合作走向共同调查'
  },
  {
    name: '顾停舟',
    role: '旧友 / 高风险伏笔人物',
    status: '生死未定，被潮汐卷走',
    traits: ['温和', '执拗', '必要时会越界'],
    arc: '真实阵营与立场仍待揭示'
  }
];

export const foreshadows = [
  {
    title: '黑印未灭',
    status: 'TRACKING',
    target: '第一卷尾声',
    risk: '高',
    note: '已在第 11 章再次被提及，必须在卷末给出阶段性回应。'
  },
  {
    title: '灯油来源异常',
    status: 'OPEN',
    target: '第二卷中段',
    risk: '中',
    note: '和旧日灾变档案关联，适合并入记忆检索。'
  },
  {
    title: '塔顶第七层禁门',
    status: 'OPEN',
    target: '第一卷尾声',
    risk: '高',
    note: '适合作为沈照正式进入主线的连接点。'
  }
];

export const timelineEvents = [
  {
    time: '故事第 12 天 / 子时',
    title: '灯塔外环出现逆潮',
    chapter: '第 12 章',
    result: '主角能力暴露，触发后续改写。'
  },
  {
    time: '故事第 12 天 / 丑时',
    title: '顾停舟被卷入回廊',
    chapter: '第 12 章',
    result: '迫使主角承担改写代价。'
  },
  {
    time: '故事第 13 天 / 辰时',
    title: '沈照抵达灯塔',
    chapter: '第 13 章',
    result: '联盟与猜疑同步升高。'
  }
];

export const modelProfiles = [
  {
    name: 'longform-draft',
    purpose: '章节创作',
    provider: 'OpenAI-compatible',
    model: 'writer-primary',
    strategy: '高上下文 + 实体召回'
  },
  {
    name: 'memory-extract',
    purpose: '记忆回写',
    provider: 'OpenAI-compatible',
    model: 'extract-primary',
    strategy: '低温抽取 + 严格结构化输出'
  },
  {
    name: 'consistency-audit',
    purpose: '一致性审查',
    provider: 'OpenAI-compatible',
    model: 'review-primary',
    strategy: '时间线 + 设定 + 历史章节交叉校验'
  }
];

export const activePipeline = [
  '提纲约束已加载到章节草稿任务',
  '角色动态状态已和章节工作台关联',
  '伏笔/时间线可以单页展示产品方向',
  '模型配置页区分创作、抽取、审查三类职责'
];
