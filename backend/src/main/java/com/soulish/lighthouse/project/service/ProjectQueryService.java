package com.soulish.lighthouse.project.service;

import com.soulish.lighthouse.chapter.dto.ChapterCardDto;
import com.soulish.lighthouse.character.dto.CharacterCardDto;
import com.soulish.lighthouse.foreshadow.dto.ForeshadowCardDto;
import com.soulish.lighthouse.model.dto.ModelConfigDto;
import com.soulish.lighthouse.outline.dto.OutlineNodeDto;
import com.soulish.lighthouse.project.dto.ProjectDashboardDto;
import com.soulish.lighthouse.project.dto.ProjectSummaryDto;
import com.soulish.lighthouse.task.dto.GenerationTaskDto;
import com.soulish.lighthouse.timeline.dto.TimelineEventDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectQueryService {

    public ProjectDashboardDto getDashboard(String projectId) {
        return new ProjectDashboardDto(
                new ProjectSummaryDto(
                        projectId,
                        "天渊灯塔",
                        "仙侠 / 群像 / 悬疑",
                        "主角在一座记录诸界灾变的灯塔中醒来，必须以修补时间裂缝为代价拼接自己失落的记忆。",
                        "结构搭建中",
                        2200000,
                        186000,
                        List.of("稳定主线推进", "让伏笔回收可追踪", "确保人物弧线持续可见"),
                        List.of("长篇", "多卷", "高记忆密度")
                ),
                sampleOutline(),
                sampleChapters(),
                sampleCharacters(),
                sampleForeshadows(),
                sampleTimeline(),
                sampleTasks(),
                sampleModelConfigs()
        );
    }

    public List<OutlineNodeDto> sampleOutline() {
        return List.of(
                new OutlineNodeDto("arc-1", "VOLUME", "第一卷：灯塔醒者", "主角确认灯塔职责与初始同盟。", "建立世界危机与核心任务", "多 POV", "ACTIVE", List.of("灯塔权限争夺", "失忆身份疑云"), List.of("灯塔记录并非绝对真实"), List.of()),
                new OutlineNodeDto("ch-12", "CHAPTER", "第 12 章：潮汐回廊", "主角第一次主动改写碎片时间。", "验证能力边界并付出代价", "林渊", "DRAFTING", List.of("是否救下旧友", "改写后记忆污染"), List.of("旧友其实来自敌对阵营"), List.of("ch-11", "foreshadow-black-seal")),
                new OutlineNodeDto("ch-13", "CHAPTER", "第 13 章：无名观测者", "引出第二位灯塔持钥人。", "将支线人物接入主线", "沈照", "PLANNED", List.of("联盟的信任边界"), List.of("观测者知晓主角前世职责"), List.of("ch-12"))
        );
    }

    public List<ChapterCardDto> sampleChapters() {
        return List.of(
                new ChapterCardDto("ch-12", "潮汐回廊", "第一卷：灯塔醒者", "DRAFTING", "林渊", 4000, 2680, "2026-03-19T20:45:00+08:00", List.of("林渊", "顾停舟"), List.of("黑印未灭")),
                new ChapterCardDto("ch-13", "无名观测者", "第一卷：灯塔醒者", "PLANNED", "沈照", 4200, 0, "2026-03-18T23:10:00+08:00", List.of("沈照", "谢白"), List.of("塔顶第七层禁门")),
                new ChapterCardDto("ch-14", "潮后余响", "第一卷：灯塔醒者", "REVIEW", "林渊", 3800, 3920, "2026-03-17T22:00:00+08:00", List.of("林渊", "阿雪"), List.of("灯油来源异常"))
        );
    }

    public List<CharacterCardDto> sampleCharacters() {
        return List.of(
                new CharacterCardDto("char-linyuan", "林渊", "主角 / 失忆灯塔守望者", "灯塔", "从被动求生转向主动调查", "记忆残缺、可短暂触碰时间裂缝", List.of("冷静", "防备心强", "对旧友有迟滞信任"), List.of("真实身份", "灯塔契约来源")),
                new CharacterCardDto("char-shenzhao", "沈照", "副主角 / 外部视角观察者", "夜航司", "从试探合作走向共同调查", "掌握不完整未来片段", List.of("克制", "怀疑主义", "善于谈判"), List.of("为何提前认识林渊", "夜航司真正任务")),
                new CharacterCardDto("char-gutingzhou", "顾停舟", "旧友 / 高风险伏笔人物", "不明", "生死状态未定", "被时间潮汐卷走", List.of("温和", "执拗", "关键时刻会越界"), List.of("是否真的死亡", "敌对阵营潜伏史"))
        );
    }

    public List<ForeshadowCardDto> sampleForeshadows() {
        return List.of(
                new ForeshadowCardDto("foreshadow-black-seal", "黑印未灭", "TRACKING", "第 4 章", "第一卷尾声", "HIGH", List.of("林渊", "顾停舟"), List.of("黑印会在时间改写后短暂显现", "已在第 11 章再次被提及")),
                new ForeshadowCardDto("foreshadow-oil", "灯油来源异常", "OPEN", "第 6 章", "第二卷中段", "MEDIUM", List.of("阿雪", "守塔人组织"), List.of("与旧日灾变档案相关")),
                new ForeshadowCardDto("foreshadow-gate7", "塔顶第七层禁门", "OPEN", "第 9 章", "第一卷尾声", "HIGH", List.of("沈照", "林渊"), List.of("禁门后疑似存放前任守望者记录"))
        );
    }

    public List<TimelineEventDto> sampleTimeline() {
        return List.of(
                new TimelineEventDto("day-12-event-1", "故事第 12 天 / 子时", "灯塔外环出现逆潮", "ch-12", "北岸观测台", List.of("林渊", "顾停舟"), "强制触发时间裂缝，主角暴露能力"),
                new TimelineEventDto("day-12-event-2", "故事第 12 天 / 丑时", "顾停舟被卷入回廊", "ch-12", "潮汐回廊", List.of("林渊", "顾停舟"), "推动主角第一次主动改写"),
                new TimelineEventDto("day-13-event-1", "故事第 13 天 / 辰时", "沈照抵达灯塔", "ch-13", "主塔议事厅", List.of("沈照", "林渊", "阿雪"), "多方联盟进入试探阶段")
        );
    }

    public List<GenerationTaskDto> sampleTasks() {
        return List.of(
                new GenerationTaskDto("task-ch12-draft", "CHAPTER_DRAFT", "ch-12", "RUNNING", "builder-agent", "longform-draft", 65, List.of("需要补齐顾停舟在前章的情绪衔接"), List.of("提纲约束已加载", "人物状态已加载", "一致性预检查已通过")),
                new GenerationTaskDto("task-memory-ch11", "MEMORY_WRITEBACK", "ch-11", "DONE", "review-agent", "memory-extract", 100, List.of(), List.of("抽取人物状态变化", "更新黑印伏笔状态")),
                new GenerationTaskDto("task-consistency-ch14", "CONSISTENCY_REVIEW", "ch-14", "QUEUED", "review-agent", "consistency-audit", 0, List.of("等待章节 13 草稿完成后执行跨章检查"), List.of("时间线数据准备完成"))
        );
    }

    public List<ModelConfigDto> sampleModelConfigs() {
        return List.of(
                new ModelConfigDto("profile-draft", "longform-draft", "OpenAI-compatible", "writer-primary", "writer-fallback", 0.82, 128000, List.of("章节草稿", "场景扩写", "情绪连续性"), "chapter-draft-v1", "chapter-window + entity recall"),
                new ModelConfigDto("profile-memory", "memory-extract", "OpenAI-compatible", "extract-primary", "extract-fallback", 0.2, 64000, List.of("事实抽取", "状态变化", "伏笔更新"), "memory-writeback-v1", "strict structured extraction"),
                new ModelConfigDto("profile-review", "consistency-audit", "OpenAI-compatible", "review-primary", "review-fallback", 0.35, 96000, List.of("一致性检查", "时间线校验", "人物 OOC 检测"), "consistency-review-v1", "timeline + lore + history grounding"))
        );
    }
}
