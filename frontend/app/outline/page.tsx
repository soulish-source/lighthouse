import { BulletList, Card, Grid, Pill, SectionHeader } from '@/components/ui';
import { outlineNodes } from '@/lib/mock-data';

export default function OutlinePage() {
  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="提纲中心"
        title="从全书到章节，先把结构站稳。"
        description="提纲页不是一份静态文档，而是驱动章节生成、伏笔跟踪和时间线校验的上游约束层。"
      />
      <Grid>
        {outlineNodes.map((node) => (
          <Card key={node.title} title={node.title} subtitle={node.goal}>
            <div style={{ display: 'flex', gap: 8, flexWrap: 'wrap', marginBottom: 14 }}>
              <Pill tone="accent">{node.type}</Pill>
              <Pill>{node.status}</Pill>
            </div>
            <div style={{ color: '#94a3b8', marginBottom: 8 }}>关键信息揭示</div>
            <BulletList items={node.reveals} />
          </Card>
        ))}
      </Grid>
    </div>
  );
}
