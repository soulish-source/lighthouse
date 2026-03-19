import Link from 'next/link';
import { ReactNode } from 'react';

const navItems = [
  { href: '/', label: '项目概览' },
  { href: '/outline', label: '提纲' },
  { href: '/chapters', label: '章节' },
  { href: '/characters', label: '角色设定' },
  { href: '/foreshadows', label: '伏笔时间线' },
  { href: '/models', label: '模型配置' }
];

export function AppShell({ children }: { children: ReactNode }) {
  return (
    <div
      style={{
        minHeight: '100vh',
        background:
          'radial-gradient(circle at top, rgba(56, 189, 248, 0.16), transparent 30%), #020617',
        color: '#e2e8f0'
      }}
    >
      <div style={{ maxWidth: 1400, margin: '0 auto', padding: '28px 20px 40px' }}>
        <header
          style={{
            display: 'flex',
            justifyContent: 'space-between',
            alignItems: 'center',
            gap: 20,
            marginBottom: 20,
            padding: '18px 20px',
            border: '1px solid rgba(148, 163, 184, 0.2)',
            borderRadius: 24,
            background: 'rgba(15, 23, 42, 0.72)',
            backdropFilter: 'blur(14px)'
          }}
        >
          <div>
            <div style={{ color: '#7dd3fc', fontSize: 13, marginBottom: 6 }}>Lighthouse / Long-form Creation OS</div>
            <strong style={{ fontSize: 22 }}>长篇创作系统第一阶段演示</strong>
          </div>
          <div style={{ textAlign: 'right', color: '#94a3b8', fontSize: 14 }}>
            <div>Project focus</div>
            <div>项目 → 提纲 → 章节 → 记忆 → 审查</div>
          </div>
        </header>

        <div style={{ display: 'grid', gridTemplateColumns: '240px minmax(0, 1fr)', gap: 20 }}>
          <aside
            style={{
              alignSelf: 'start',
              position: 'sticky',
              top: 20,
              padding: 16,
              borderRadius: 24,
              border: '1px solid rgba(148, 163, 184, 0.16)',
              background: 'rgba(15, 23, 42, 0.88)'
            }}
          >
            <div style={{ color: '#94a3b8', fontSize: 13, marginBottom: 12 }}>工作区导航</div>
            <nav style={{ display: 'grid', gap: 10 }}>
              {navItems.map((item) => (
                <Link
                  key={item.href}
                  href={item.href}
                  style={{
                    padding: '12px 14px',
                    borderRadius: 16,
                    textDecoration: 'none',
                    color: '#e2e8f0',
                    background: 'rgba(30, 41, 59, 0.7)',
                    border: '1px solid rgba(71, 85, 105, 0.6)'
                  }}
                >
                  {item.label}
                </Link>
              ))}
            </nav>
          </aside>

          <main>{children}</main>
        </div>
      </div>
    </div>
  );
}
