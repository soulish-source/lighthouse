'use client';
import { useEffect, useState } from 'react';
import { Card, Grid, Pill, SectionHeader } from '@/components/ui';
import { api } from '@/lib/api-client';

interface Foreshadow {
  id: string;
  title: string;
  status: string;
  plantedAt: string;
  targetPayoff: string;
  riskLevel: string;
  relatedCharacters: string[];
  notes: string[];
}

interface TimelineEvent {
  id: string;
  dayLabel: string;
  eventTitle: string;
  chapterRef: string;
  location: string;
  participants: string[];
  consequence: string;
}

const RISK_TONE: Record<string, 'warning' | 'accent'> = {
  HIGH: 'warning',
  MEDIUM: 'accent',
  LOW: 'accent',
};

export default function ForeshadowsPage() {
  const [foreshadows, setForeshadows] = useState<Foreshadow[]>([]);
  const [timeline, setTimeline] = useState<TimelineEvent[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    Promise.all([
      (api.listForeshadows('demo-project') as Promise<Foreshadow[]>).catch(() => [] as Foreshadow[]),
      (api.listTimelineEvents('demo-project') as Promise<TimelineEvent[]>).catch(() => [] as TimelineEvent[]),
    ]).then(([f, t]) => {
      setForeshadows(f);
      setTimeline(t);
    }).finally(() => setLoading(false));
  }, []);

  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="伏笔 / 时间线"
        title="叙事承诺和故事日历必须绑在一起。"
        description="从真实 API 加载伏笔和时间线数据。"
      />
      <Grid columns="1fr 1fr">
        <Card title="活跃伏笔" subtitle="按风险和预期回收节点管理">
          {loading ? (
            <div style={{ color: '#94a3b8' }}>加载中...</div>
          ) : foreshadows.length === 0 ? (
            <div style={{ color: '#94a3b8' }}>暂无伏笔数据。</div>
          ) : (
            <div style={{ display: 'grid', gap: 12 }}>
              {foreshadows.map((item) => (
                <div key={item.id} style={{ paddingBottom: 12, borderBottom: '1px solid rgba(71, 85, 105, 0.4)' }}>
                  <div style={{ display: 'flex', justifyContent: 'space-between', gap: 10, marginBottom: 8 }}>
                    <strong>{item.title}</strong>
                    <Pill tone={RISK_TONE[item.riskLevel] || 'accent'}>{item.riskLevel}风险</Pill>
                  </div>
                  <div style={{ color: '#94a3b8', marginBottom: 6 }}>{item.status} · 目标：{item.targetPayoff}</div>
                  <div style={{ color: '#cbd5e1', lineHeight: 1.7 }}>{item.notes?.join(' ')}</div>
                </div>
              ))}
            </div>
          )}
        </Card>

        <Card title="故事时间线" subtitle="用于检查人物状态和事件顺序">
          {loading ? (
            <div style={{ color: '#94a3b8' }}>加载中...</div>
          ) : timeline.length === 0 ? (
            <div style={{ color: '#94a3b8' }}>暂无时间线数据。</div>
          ) : (
            <div style={{ display: 'grid', gap: 12 }}>
              {timeline.map((event) => (
                <div key={event.id} style={{ paddingBottom: 12, borderBottom: '1px solid rgba(71, 85, 105, 0.4)' }}>
                  <div style={{ color: '#67e8f9', marginBottom: 6 }}>{event.dayLabel}</div>
                  <strong>{event.eventTitle}</strong>
                  <div style={{ color: '#94a3b8', margin: '6px 0' }}>{event.chapterRef} · {event.location}</div>
                  <div style={{ color: '#cbd5e1', lineHeight: 1.7 }}>{event.consequence}</div>
                </div>
              ))}
            </div>
          )}
        </Card>
      </Grid>
    </div>
  );
}
