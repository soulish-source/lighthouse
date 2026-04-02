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

import java.util.Arrays;
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
                        Arrays.asList("稳定主线推进", "让伏笔回收可追踪", "确保人物弧线持续可见"),
                        Arrays.asList("长篇", "多卷", "高记忆密度")
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
        return Arrays.asList(
                new OutlineNodeDto("arc-1", "VOLUME", "第一卷：灯塔醒者", "主角确认灯塔职责与初始同盟。", "建立世界危机与核心任务", "多 POV", "ACTIVE", Arrays.asList("灯塔权限争夺", "失忆身份疑云"), Arrays.asList("灯塔记录并非绝对真实"), Arrays.asList()),
                new OutlineNodeDto("ch-12", "CHAPTER", "第 12 章：潮汐回廊", "主角第一次主动改写碎片时间。", "验证能力边界并付出代价", "林渊", "DRAFTING", Arrays.asList("是否救下旧友", "改写后记忆污染"), Arrays.asList("旧友其实来自敌对阵营"), Arrays.asList("ch-11", "foreshadow-black-seal")),
                new OutlineNodeDto("ch-13", "CHAPTER", "第 13 章：无名观测者", "引出第二位灯塔持钥人。", "将支线人物接入主线", "沈照", "PLANNED", Arrays.asList("联盟的信任边界"), Arrays.asList("观测者知晓主角前世职责"), Arrays.asList("ch-12"))
        );
    }

    public List<ChapterCardDto> sampleChapters() {
        return Arrays.asList(
                new ChapterCardDto("ch-12", "潮汐回廊", "第一卷：灯塔醒者", "DRAFTING", "林渊", 4000, 2680, "2026-03-19T20:45:00+08:00", Arrays.asList("林渊", "顾停舟"), Arrays.asList("黑印未灭")),
                new ChapterCardDto("ch-13", "无名观测者", "第一卷：灯塔醒者", "PLANNED", "沈照", 4200, 0, "2026-03-18T23:10:00+08:00", Arrays.asList("沈照", "谢白"), Arrays.asList("塔顶第七层禁门")),
                new ChapterCardDto("ch-14", "潮后余响", "第一卷：灯塔醒者", "REVIEW", "林渊", 3800, 3920, "2026-03-17T22:00:00+08:00", Arrays.asList("林渊", "阿雪"), Arrays.asList("灯油来源异常"))
        );
    }

    public List<CharacterCardDto> sampleCharacters() {
        return Arrays.asList(
                new CharacterCardDto("char-linyuan", "林渊", "主角 / 失忆灯塔守望者", "灯塔", "从被动求生转向主动调查", "记忆残缺、可短暂触碰时间裂缝", Arrays.asList("冷静", "防备心强", "对旧友有迟滞信任"), Arrays.asList("真实身份", "灯塔契约来源")),
                new CharacterCardDto("char-shenzhao", "沈照", "副主角 / 外部视角观察者", "夜航司", "从试探合作走向共同调查", "掌握不完整未来片段", Arrays.asList("克制", "怀疑主义", "善于谈判"), Arrays.asList("为何提前认识林渊", "夜航司真正任务")),
                new CharacterCardDto("char-gutingzhou", "顾停舟", "旧友 / 高风险伏笔人物", "不明", "生死状态未定", "被时间潮汐卷走", Arrays.asList("温和", "执拗", "关键时刻会越界"), Arrays.asList("是否真的死亡", "敌对阵营潜伏史"))
        );
    }

    public List<ForeshadowCardDto> sampleForeshadows() {
        return Arrays.asList(
                new ForeshadowCardDto("foreshadow-black-seal", "黑印未灭", "TRACKING", "第 4 章", "第一卷尾声", "HIGH", Arrays.asList("林渊", "顾停舟"), Arrays.asList("黑印会在时间改写后短暂显现", "已在第 11 章再次被提及")),
                new ForeshadowCardDto("foreshadow-oil", "灯油来源异常", "OPEN", "第 6 章", "第二卷中段", "MEDIUM", Arrays.asList("阿雪", "守塔人组织"), Arrays.asList("与旧日灾变档案相关")),
                new ForeshadowCardDto("foreshadow-gate7", "塔顶第七层禁门", "OPEN", "第 9 章", "第一卷尾声", "HIGH", Arrays.asList("沈照", "林渊"), Arrays.asList("禁门后疑似存放前任守望者记录"))
        );
    }

    public List<TimelineEventDto> sampleTimeline() {
        return Arrays.asList(
                new TimelineEventDto("day-12-event-1", "故事第 12 天 / 子时", "灯塔外环出现逆潮", "ch-12", "北岸观测台", Arrays.asList("林渊", "顾停舟"), "强制触发时间裂缝，主角暴露能力"),
                new TimelineEventDto("day-12-event-2", "故事第 12 天 / 丑时", "顾停舟被卷入回廊", "ch-12", "潮汐回廊", Arrays.asList("林渊", "顾停舟"), "推动主角第一次主动改写"),
                new TimelineEventDto("day-13-event-1", "故事第 13 天 / 辰时", "沈照抵达灯塔", "ch-13", "主塔议事厅", Arrays.asList("沈照", "林渊", "阿雪"), "多方联盟进入试探阶段")
        );
    }

    public List<GenerationTaskDto> sampleTasks() {
        return Arrays.asList(
                new GenerationTaskDto("task-ch12-draft", "CHAPTER_DRAFT", "ch-12", "RUNNING", "builder-agent", "longform-draft", 65, Arrays.asList("需要补齐顾停舟在前章的情绪衔接"), Arrays.asList("提纲约束已加载", "人物状态已加载", "一致性预检查已通过")),
                new GenerationTaskDto("task-memory-ch11", "MEMORY_WRITEBACK", "ch-11", "DONE", "review-agent", "memory-extract", 100, Arrays.asList(), Arrays.asList("抽取人物状态变化", "更新黑印伏笔状态")),
                new GenerationTaskDto("task-consistency-ch14", "CONSISTENCY_REVIEW", "ch-14", "QUEUED", "review-agent", "consistency-audit", 0, Arrays.asList("等待章节 13 草稿完成后执行跨章检查"), Arrays.asList("时间线数据准备完成"))
        );
    }

    public List<ModelConfigDto> sampleModelConfigs() {
        ModelConfigDto d1 = new ModelConfigDto();
        d1.setId("profile-draft");
        d1.setProfileName("longform-draft");
        d1.setProvider("OpenAI-compatible");
        d1.setPrimaryModel("writer-primary");
        d1.setFallbackModel("writer-fallback");
        d1.setTemperature(0.82);
        d1.setMaxContextTokens(128000);
        d1.setCapabilities(Arrays.asList("chapter-draft", "scene-expand", "emotion-flow"));
        d1.setPromptPreset("chapter-draft-v1");
        d1.setMemoryPolicy("chapter-window + entity recall");

        ModelConfigDto d2 = new ModelConfigDto();
        d2.setId("profile-memory");
        d2.setProfileName("memory-extract");
        d2.setProvider("OpenAI-compatible");
        d2.setPrimaryModel("extract-primary");
        d2.setFallbackModel("extract-fallback");
        d2.setTemperature(0.2);
        d2.setMaxContextTokens(64000);
        d2.setCapabilities(Arrays.asList("fact-extract", "state-change", "foreshadow-update"));
        d2.setPromptPreset("memory-writeback-v1");
        d2.setMemoryPolicy("strict structured extraction");

        ModelConfigDto d3 = new ModelConfigDto();
        d3.setId("profile-review");
        d3.setProfileName("consistency-audit");
        d3.setProvider("OpenAI-compatible");
        d3.setPrimaryModel("review-primary");
        d3.setFallbackModel("review-fallback");
        d3.setTemperature(0.35);
        d3.setMaxContextTokens(96000);
        d3.setCapabilities(Arrays.asList("consistency-check", "timeline-verify", "character-ooc"));
        d3.setPromptPreset("consistency-review-v1");
        d3.setMemoryPolicy("timeline + lore + history grounding");

        return Arrays.asList(d1, d2, d3);
    }
}
