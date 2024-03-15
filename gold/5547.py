import sys
from collections import deque
input = sys.stdin.readline

w, h = map(int, input().split())
arr = [[0 for _ in range(w+2)] for _ in range(h+2)]
for i in range(1, h+1):
    arr[i][1:w+1] = map(int, input().split())

dx = [0, 1, 1, 0, -1, -1]
dy = [[1, 0, -1, -1, -1, 0], [1, 1, 0, -1, 0, 1]]

def bfs(i, j):
    q = deque()
    q.append((i, j))
    visited = [[False for _ in range(w + 2)] for _ in range(h + 2)]
    visited[i][j] = True
    cnt = 0
    while q:
        x, y = q.popleft()
        for i in range(6):
            nx = x+dx[i]
            ny = y+dy[x % 2][i]
            if 0 <= nx < h+2 and 0 <= ny < w+2:
                if arr[nx][ny] == 0 and not visited[nx][ny]:
                    q.append((nx,ny))
                    visited[nx][ny] = True
                elif arr[nx][ny] == 1:
                    cnt += 1
    return cnt

print(bfs(0,0))
