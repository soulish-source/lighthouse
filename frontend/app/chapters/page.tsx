import { Card, Grid, Pill, SectionHeader } from '@/components/ui';
import { chapters } from '@/lib/mock-data';

export default function ChaptersPage() {
  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="章节工作台"
        title="章节不是孤立文本，而是一个受约束的生产任务。"
        description="这里应该把提纲目标、人物动态状态、上下文章节、伏笔和时间线一起装配给创作 Agent。当前先用 mock 数据表达工作台结构。"
      />
      <Grid>
        {chapters.map((chapter) => (
          <Card key={chapter.title} title={chapter.title} subtitle={`POV：${chapter.pov}`}>
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 14 }}>
              <Pill tone="accent">{chapter.status}</Pill>
              <span style={{ color: '#94a3b8', fontSize: 14 }}>{chapter.progress}</span>
            </div>
            <p style={{ margin: 0, color: '#cbd5e1', lineHeight: 1.7 }}>{chapter.note}</p>
          </Card>
        ))}
      </Grid>
    </div>
  );
}
