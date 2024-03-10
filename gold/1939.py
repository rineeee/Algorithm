import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

for i in range(1, n + 1):
    graph[i].sort(reverse=True)
s, e = map(int, input().split())

def check(curr):
    q = deque()
    visited = [False]*(n+1)
    q.append(s)
    visited[s] = True
    while q:
        now = q.popleft()
        if now == e:
            return True
        for next_, cnt in graph[now]:
            if not visited[next_] and curr <= cnt:
                q.append(next_)
                visited[next_] = True
    return False

def solution():
    left, right = 1, 1000000000
    while left <= right:
        mid = (left+right)//2
        if check(mid):
            left = mid + 1
        else:
            right = mid - 1
    return right

print(solution())
