export const metadata = {
  title: 'Lighthouse',
  description: 'Long-form web novel creation agent workspace'
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="zh-CN">
      <body style={{ margin: 0, fontFamily: 'Inter, system-ui, sans-serif', background: '#0b1120', color: '#e5e7eb' }}>
        {children}
      </body>
    </html>
  );
}
