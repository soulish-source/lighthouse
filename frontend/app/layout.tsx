import { AppShell } from '@/components/app-shell';
import { ReactNode } from 'react';

export const metadata = {
  title: 'Lighthouse',
  description: 'Long-form web novel creation workspace'
};

export default function RootLayout({ children }: { children: ReactNode }) {
  return (
    <html lang="zh-CN">
      <body style={{ margin: 0, fontFamily: 'Inter, system-ui, sans-serif' }}>
        <AppShell>{children}</AppShell>
      </body>
    </html>
  );
}
