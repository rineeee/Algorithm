import sys
from collections import deque
input = sys.stdin.readline

n, m, t = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

def solution():
    visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
    visited[0][0][0] = 1
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    q = deque()
    q.append((0,0,0))

    while q:
        x, y, z = q.popleft()
        if x == n-1 and y == m -1 and visited[x][y][z]-1 <= t:
            return visited[x][y][z] -1
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0<=nx<n and 0<=ny<m and not visited[nx][ny][z]:
                if z == 0 and arr[nx][ny] == 0:
                    visited[nx][ny][z] = visited[x][y][z] + 1
                    q.append((nx,ny,z))
                elif z == 0 and arr[nx][ny] == 2:
                    visited[nx][ny][1] = visited[x][y][z] + 1
                    q.append((nx,ny,1))
                elif z == 1:
                    visited[nx][ny][z] = visited[x][y][z] + 1
                    q.append((nx,ny,z))

    return "Fail"

print(solution())
