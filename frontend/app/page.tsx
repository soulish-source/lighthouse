const sections = [
  {
    title: '提纲中心',
    description: '管理全书、分卷与章节提纲，维护主线与副线推进。'
  },
  {
    title: '章节工作台',
    description: '围绕当前章节装配相关人物状态、伏笔与时间线约束。'
  },
  {
    title: '设定与记忆',
    description: '沉淀人物、世界规则、动态状态，并将章节事实回写为长期记忆。'
  },
  {
    title: '一致性检查',
    description: '发现人物 OOC、时间错位、伏笔遗忘与设定冲突。'
  }
];

export default function HomePage() {
  return (
    <main style={{ maxWidth: 1100, margin: '0 auto', padding: '64px 24px 96px' }}>
      <section style={{ marginBottom: 48 }}>
        <div style={{ display: 'inline-block', padding: '6px 12px', borderRadius: 999, background: '#172554', color: '#bfdbfe', fontSize: 14 }}>
          Lighthouse / Novel Creation Agent
        </div>
        <h1 style={{ fontSize: 52, lineHeight: 1.1, margin: '20px 0 16px' }}>
          为长篇网文创作而设计的前后端分离 Agent 系统
        </h1>
        <p style={{ fontSize: 18, lineHeight: 1.7, color: '#cbd5e1', maxWidth: 780 }}>
          面向提纲、章节、人物设定、伏笔、时间线与记忆回写的一体化创作工作台。
          当前为初始化骨架，重点表达核心能力边界与未来扩展方向。
        </p>
      </section>

      <section style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(220px, 1fr))', gap: 20 }}>
        {sections.map((section) => (
          <article key={section.title} style={{ padding: 24, border: '1px solid #1e293b', borderRadius: 18, background: 'linear-gradient(180deg, #111827 0%, #0f172a 100%)' }}>
            <h2 style={{ marginTop: 0, fontSize: 22 }}>{section.title}</h2>
            <p style={{ marginBottom: 0, color: '#94a3b8', lineHeight: 1.7 }}>{section.description}</p>
          </article>
        ))}
      </section>
    </main>
  );
}
