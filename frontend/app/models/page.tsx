import { Card, Grid, SectionHeader } from '@/components/ui';
import { modelProfiles } from '@/lib/mock-data';

export default function ModelsPage() {
  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="模型配置"
        title="把模型当系统组件，而不是黑盒按钮。"
        description="不同阶段的长篇创作任务需要不同模型策略：创作用高上下文和召回，抽取要更稳定，审查则强调跨资产比对。"
      />
      <Grid>
        {modelProfiles.map((profile) => (
          <Card key={profile.name} title={profile.name} subtitle={`${profile.purpose} · ${profile.provider}`}>
            <div style={{ color: '#94a3b8', marginBottom: 10 }}>模型：{profile.model}</div>
            <div style={{ color: '#cbd5e1', lineHeight: 1.7 }}>{profile.strategy}</div>
          </Card>
        ))}
      </Grid>
    </div>
  );
}
