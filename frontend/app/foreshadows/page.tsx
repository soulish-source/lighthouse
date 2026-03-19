import { Card, Grid, Pill, SectionHeader } from '@/components/ui';
import { foreshadows, timelineEvents } from '@/lib/mock-data';

export default function ForeshadowsPage() {
  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="伏笔 / 时间线"
        title="叙事承诺和故事日历必须绑在一起。"
        description="这一页把伏笔追踪和时间线展示放在同一视图里，方便发现该回收未回收、回收过早、事件先后矛盾等问题。"
      />
      <Grid columns="1fr 1fr">
        <Card title="活跃伏笔" subtitle="按风险和预期回收节点管理">
          <div style={{ display: 'grid', gap: 12 }}>
            {foreshadows.map((item) => (
              <div key={item.title} style={{ paddingBottom: 12, borderBottom: '1px solid rgba(71, 85, 105, 0.4)' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', gap: 10, marginBottom: 8 }}>
                  <strong>{item.title}</strong>
                  <Pill tone={item.risk === '高' ? 'warning' : 'accent'}>{item.risk}风险</Pill>
                </div>
                <div style={{ color: '#94a3b8', marginBottom: 6 }}>{item.status} · 目标回收：{item.target}</div>
                <div style={{ color: '#cbd5e1', lineHeight: 1.7 }}>{item.note}</div>
              </div>
            ))}
          </div>
        </Card>

        <Card title="故事时间线" subtitle="用于检查人物状态和事件顺序">
          <div style={{ display: 'grid', gap: 12 }}>
            {timelineEvents.map((event) => (
              <div key={event.title} style={{ paddingBottom: 12, borderBottom: '1px solid rgba(71, 85, 105, 0.4)' }}>
                <div style={{ color: '#67e8f9', marginBottom: 6 }}>{event.time}</div>
                <strong>{event.title}</strong>
                <div style={{ color: '#94a3b8', margin: '6px 0' }}>{event.chapter}</div>
                <div style={{ color: '#cbd5e1', lineHeight: 1.7 }}>{event.result}</div>
              </div>
            ))}
          </div>
        </Card>
      </Grid>
    </div>
  );
}
