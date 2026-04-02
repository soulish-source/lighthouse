'use client';
import { useEffect, useState } from 'react';
import { Card, Grid, Pill, SectionHeader } from '@/components/ui';
import { api } from '@/lib/api-client';

interface ChapterData {
  id: string;
  title: string;
  volumeTitle: string;
  status: string;
  pov: string;
  targetWords: number;
  currentWords: number;
  updatedAt: string;
  focusCharacters: string[];
  relatedForeshadows: string[];
}

const STATUS_LABELS: Record<string, string> = {
  PLANNED: '待规划',
  DRAFTING: '草稿中',
  REVIEW: '审查中',
  PUBLISHED: '已发布',
};

export default function ChaptersPage() {
  const [chapters, setChapters] = useState<ChapterData[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    (api.listChapters('demo-project') as Promise<ChapterData[]>)
      .then(setChapters)
      .catch(() => setChapters([]))
      .finally(() => setLoading(false));
  }, []);

  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="章节工作台"
        title="章节不是孤立文本，而是一个受约束的生产任务。"
        description="从真实 API 加载章节数据。"
      />
      {loading ? (
        <div style={{ color: '#94a3b8' }}>加载中...</div>
      ) : chapters.length === 0 ? (
        <div style={{ color: '#94a3b8' }}>暂无章节，请先在后端创建。</div>
      ) : (
        <Grid>
          {chapters.map((chapter) => (
            <Card key={chapter.id} title={chapter.title} subtitle={`POV：${chapter.pov}`}>
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 14 }}>
                <Pill tone="accent">{STATUS_LABELS[chapter.status] || chapter.status}</Pill>
                <span style={{ color: '#94a3b8', fontSize: 14 }}>
                  {chapter.currentWords} / {chapter.targetWords} 字
                </span>
              </div>
              <div style={{ color: '#94a3b8', fontSize: 13 }}>
                关联人物：{chapter.focusCharacters.join('、')}
              </div>
            </Card>
          ))}
        </Grid>
      )}
    </div>
  );
}
