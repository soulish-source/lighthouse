import { ReactNode } from 'react';

export function SectionHeader({ eyebrow, title, description }: { eyebrow: string; title: string; description: string }) {
  return (
    <section style={{ marginBottom: 24 }}>
      <div style={{ color: '#67e8f9', fontSize: 13, marginBottom: 8 }}>{eyebrow}</div>
      <h1 style={{ fontSize: 40, lineHeight: 1.1, margin: '0 0 12px' }}>{title}</h1>
      <p style={{ margin: 0, color: '#94a3b8', lineHeight: 1.7, maxWidth: 860 }}>{description}</p>
    </section>
  );
}

export function Grid({ children, columns = 'repeat(auto-fit, minmax(240px, 1fr))' }: { children: ReactNode; columns?: string }) {
  return <section style={{ display: 'grid', gridTemplateColumns: columns, gap: 16 }}>{children}</section>;
}

export function Card({ title, subtitle, children }: { title: string; subtitle?: string; children: ReactNode }) {
  return (
    <article
      style={{
        padding: 20,
        borderRadius: 22,
        background: 'linear-gradient(180deg, rgba(15, 23, 42, 0.96), rgba(15, 23, 42, 0.72))',
        border: '1px solid rgba(71, 85, 105, 0.5)',
        boxShadow: '0 18px 40px rgba(2, 6, 23, 0.28)'
      }}
    >
      <h2 style={{ fontSize: 22, margin: '0 0 8px' }}>{title}</h2>
      {subtitle ? <p style={{ margin: '0 0 14px', color: '#94a3b8', lineHeight: 1.6 }}>{subtitle}</p> : null}
      {children}
    </article>
  );
}

export function Pill({ children, tone = 'default' }: { children: ReactNode; tone?: 'default' | 'accent' | 'warning' }) {
  const styles = {
    default: { background: 'rgba(30, 41, 59, 0.9)', color: '#cbd5e1' },
    accent: { background: 'rgba(8, 145, 178, 0.18)', color: '#67e8f9' },
    warning: { background: 'rgba(245, 158, 11, 0.16)', color: '#fbbf24' }
  } as const;

  return (
    <span
      style={{
        display: 'inline-block',
        padding: '6px 10px',
        borderRadius: 999,
        fontSize: 12,
        ...styles[tone]
      }}
    >
      {children}
    </span>
  );
}

export function BulletList({ items }: { items: string[] }) {
  return (
    <ul style={{ margin: 0, paddingLeft: 18, color: '#cbd5e1', lineHeight: 1.8 }}>
      {items.map((item) => (
        <li key={item}>{item}</li>
      ))}
    </ul>
  );
}
