'use client';
import { useEffect, useState } from 'react';
import { BulletList, Card, Grid, Pill, SectionHeader } from '@/components/ui';
import { api } from '@/lib/api-client';

interface OutlineNode {
  id: string;
  type: string;
  title: string;
  summary: string;
  goal: string;
  pov: string;
  status: string;
  keyConflicts: string[];
  reveals: string[];
  dependencies: string[];
}

export default function OutlinePage() {
  const [nodes, setNodes] = useState<OutlineNode[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    (api.listOutlines('demo-project') as Promise<OutlineNode[]>)
      .then(setNodes)
      .catch(() => setNodes([]))
      .finally(() => setLoading(false));
  }, []);

  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="提纲中心"
        title="从全书到章节，先把结构站稳。"
        description="从真实 API 加载提纲数据。"
      />
      {loading ? (
        <div style={{ color: '#94a3b8' }}>加载中...</div>
      ) : nodes.length === 0 ? (
        <div style={{ color: '#94a3b8' }}>暂无提纲节点，请先在后端创建。</div>
      ) : (
        <Grid>
          {nodes.map((node) => (
            <Card key={node.id} title={node.title} subtitle={node.goal}>
              <div style={{ display: 'flex', gap: 8, flexWrap: 'wrap', marginBottom: 14 }}>
                <Pill tone="accent">{node.type === 'VOLUME' ? '卷' : '章'}</Pill>
                <Pill>{node.status}</Pill>
              </div>
              <div style={{ color: '#94a3b8', marginBottom: 8 }}>关键信息揭示</div>
              <BulletList items={node.reveals} />
            </Card>
          ))}
        </Grid>
      )}
    </div>
  );
}
