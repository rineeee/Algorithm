import sys
from collections import deque
input = sys.stdin.readline


n, k = map(int, input().split())
arr = list(map(int, input().split()))

def bfs():
    visited = set()
    q = deque()

    for i in arr:
        q.append((i, 1))
        visited.add(i)

    result = 0
    now_build = 0
    while q:
        now, cnt = q.popleft()
        for d in [1,-1]:
            nx = now+d
            if nx in visited:
                continue
            visited.add(nx)
            result += cnt
            now_build += 1
            q.append((nx, cnt+1))
            if now_build == k:
                q = deque()
                break
    return result

print(bfs())
