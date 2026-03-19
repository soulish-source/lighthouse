import { BulletList, Card, Grid, Pill, SectionHeader } from '@/components/ui';
import { activePipeline, kpis, projectSummary, workspaceModules } from '@/lib/mock-data';

export default function HomePage() {
  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="项目概览"
        title="不是聊天框，而是面向长篇创作资产的工作台。"
        description={`${projectSummary.name} 把作品定位、提纲、章节、人物、伏笔、时间线与模型策略放进一个可持续维护的系统里，优先展示产品方向而不是单点生成能力。`}
      />

      <Grid>
        {kpis.map((item) => (
          <Card key={item.label} title={item.value} subtitle={item.label}>
            <div style={{ color: '#94a3b8' }}>{item.detail}</div>
          </Card>
        ))}
      </Grid>

      <Grid columns="1.2fr 0.8fr">
        <Card title={projectSummary.name} subtitle={`${projectSummary.genre} · ${projectSummary.stage}`}>
          <p style={{ marginTop: 0, color: '#cbd5e1', lineHeight: 1.8 }}>{projectSummary.premise}</p>
          <div style={{ display: 'flex', gap: 10, flexWrap: 'wrap' }}>
            <Pill tone="accent">项目</Pill>
            <Pill tone="accent">提纲</Pill>
            <Pill tone="accent">章节</Pill>
            <Pill tone="accent">记忆回写</Pill>
            <Pill tone="accent">一致性审查</Pill>
          </div>
        </Card>

        <Card title="当前可展示链路" subtitle="第一阶段工程关注表达清晰度与可扩展结构。">
          <BulletList items={activePipeline} />
        </Card>
      </Grid>

      <Grid>
        {workspaceModules.map((module) => (
          <Card key={module.title} title={module.title}>
            <p style={{ margin: 0, color: '#cbd5e1', lineHeight: 1.7 }}>{module.description}</p>
          </Card>
        ))}
      </Grid>
    </div>
  );
}
