import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(1, n+1):
    graph[i].sort()
s, e = map(int, input().split())

def bfs(s, e,visited, start_cnt):
    q = deque()
    q.append((s, start_cnt))
    visited[s] = 0

    while q:
        curr, cnt = q.popleft()
        if curr == e:
            if start_cnt == 0:
                break
            return cnt
        for nxt in graph[curr]:
            if visited[nxt] == -1:
                q.append((nxt, cnt+1))
                visited[nxt] = curr
    path = [e]
    nxt = visited[e]
    while nxt != 0:
        path.append(nxt)
        nxt = visited[nxt]
    return path[:-1]


visited = [-1]*(n+1)
path1 = bfs(s, e, visited,0)
visited = [-1]*(n+1)
for idx in path1:
    visited[idx] = 1
cnt = bfs(e,s,visited,len(path1))
print(cnt)
