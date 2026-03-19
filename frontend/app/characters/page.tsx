import { BulletList, Card, Grid, SectionHeader } from '@/components/ui';
import { characters } from '@/lib/mock-data';

export default function CharactersPage() {
  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="角色设定"
        title="静态设定和动态状态分开，人物才不容易写崩。"
        description="角色页要承载基础设定、当前状态、关系变化与未解决的人物弧线，方便章节生成前做召回与审查。"
      />
      <Grid>
        {characters.map((character) => (
          <Card key={character.name} title={character.name} subtitle={character.role}>
            <p style={{ marginTop: 0, color: '#94a3b8' }}>{character.status}</p>
            <div style={{ color: '#67e8f9', marginBottom: 8 }}>人物弧线</div>
            <p style={{ marginTop: 0, color: '#cbd5e1', lineHeight: 1.7 }}>{character.arc}</p>
            <div style={{ color: '#67e8f9', marginBottom: 8 }}>行为特征</div>
            <BulletList items={character.traits} />
          </Card>
        ))}
      </Grid>
    </div>
  );
}
