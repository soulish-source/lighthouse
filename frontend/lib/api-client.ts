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

  // Character
  listCharacters: (projectId: string) => request(`/characters?projectId=${projectId}`),
  createCharacter: (dto: unknown) => request('/characters', { method: 'POST', body: JSON.stringify(dto) }),
  updateCharacter: (id: string, dto: unknown) => request(`/characters/${id}`, { method: 'PUT', body: JSON.stringify(dto) }),
  deleteCharacter: (id: string) => request(`/characters/${id}`, { method: 'DELETE' }),

  // Foreshadow
  listForeshadows: (projectId: string) => request(`/foreshadows?projectId=${projectId}`),
  createForeshadow: (dto: unknown) => request('/foreshadows', { method: 'POST', body: JSON.stringify(dto) }),
  updateForeshadow: (id: string, dto: unknown) => request(`/foreshadows/${id}`, { method: 'PUT', body: JSON.stringify(dto) }),
  deleteForeshadow: (id: string) => request(`/foreshadows/${id}`, { method: 'DELETE' }),

  // Timeline
  listTimelineEvents: (projectId: string) => request(`/timeline-events?projectId=${projectId}`),
  createTimelineEvent: (dto: unknown) => request('/timeline-events', { method: 'POST', body: JSON.stringify(dto) }),
  updateTimelineEvent: (id: string, dto: unknown) => request(`/timeline-events/${id}`, { method: 'PUT', body: JSON.stringify(dto) }),
  deleteTimelineEvent: (id: string) => request(`/timeline-events/${id}`, { method: 'DELETE' }),
};
