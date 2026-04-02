const API_BASE = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080/api';

async function request<T>(path: string, options?: RequestInit): Promise<T> {
  const res = await fetch(`${API_BASE}${path}`, {
    headers: { 'Content-Type': 'application/json' },
    ...options,
  });
  if (!res.ok) throw new Error(`API ${res.status}: ${path}`);
  const json = await res.json();
  return json.data as T;
}

export const api = {
  // Project
  getDashboard: (projectId: string) => request(`/projects/${projectId}`),
  createProject: (dto: unknown) => request('/projects', { method: 'POST', body: JSON.stringify(dto) }),
  updateProject: (id: string, dto: unknown) => request(`/projects/${id}`, { method: 'PUT', body: JSON.stringify(dto) }),
  deleteProject: (id: string) => request(`/projects/${id}`, { method: 'DELETE' }),

  // Chapter
  listChapters: (projectId: string) => request(`/chapters?projectId=${projectId}`),
  createChapter: (dto: unknown) => request('/chapters', { method: 'POST', body: JSON.stringify(dto) }),
  updateChapter: (id: string, dto: unknown) => request(`/chapters/${id}`, { method: 'PUT', body: JSON.stringify(dto) }),
  deleteChapter: (id: string) => request(`/chapters/${id}`, { method: 'DELETE' }),

  // Outline
  listOutlines: (projectId: string) => request(`/outlines?projectId=${projectId}`),
  createOutline: (dto: unknown) => request('/outlines', { method: 'POST', body: JSON.stringify(dto) }),
  updateOutline: (id: string, dto: unknown) => request(`/outlines/${id}`, { method: 'PUT', body: JSON.stringify(dto) }),
  deleteOutline: (id: string) => request(`/outlines/${id}`, { method: 'DELETE' }),
};
