'use client';
import { useEffect, useState } from 'react';
import { BulletList, Card, Grid, SectionHeader } from '@/components/ui';
import { api } from '@/lib/api-client';

interface CharacterData {
  id: string;
  name: string;
  role: string;
  faction: string;
  currentArc: string;
  status: string;
  traits: string[];
  unresolvedThreads: string[];
}

export default function CharactersPage() {
  const [characters, setCharacters] = useState<CharacterData[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    (api.listCharacters('demo-project') as Promise<CharacterData[]>)
      .then(setCharacters)
      .catch(() => setCharacters([]))
      .finally(() => setLoading(false));
  }, []);

  return (
    <div style={{ display: 'grid', gap: 18 }}>
      <SectionHeader
        eyebrow="角色设定"
        title="静态设定和动态状态分开，人物才不容易写崩。"
        description="从真实 API 加载角色数据。"
      />
      {loading ? (
        <div style={{ color: '#94a3b8' }}>加载中...</div>
      ) : characters.length === 0 ? (
        <div style={{ color: '#94a3b8' }}>暂无角色，请先在后端创建。</div>
      ) : (
        <Grid>
          {characters.map((character) => (
            <Card key={character.id} title={character.name} subtitle={character.role}>
              <p style={{ marginTop: 0, color: '#94a3b8' }}>{character.status}</p>
              <div style={{ color: '#67e8f9', marginBottom: 8 }}>人物弧线</div>
              <p style={{ marginTop: 0, color: '#cbd5e1', lineHeight: 1.7 }}>{character.currentArc}</p>
              <div style={{ color: '#67e8f9', marginBottom: 8 }}>行为特征</div>
              <BulletList items={character.traits} />
            </Card>
          ))}
        </Grid>
      )}
    </div>
  );
}
