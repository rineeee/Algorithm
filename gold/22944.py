from collections import deque
n, h, d = map(int, input().split())
grid = [list(str(input())) for _ in range(n)]
sy, sx = 0, 0
for i in range(n):
    for j in range(n):
        if grid[i][j] == 'S':
            sy, sx = i, j
dy, dx = [0, 1, 0, -1], [1, 0, -1, 0]
visited = [[0 for _ in range(n)] for _ in range(n)]
def to_safety_zone():
    q = deque()
    q.append((sy, sx, h, 0, 0))
    visited[sy][sx] = h
    while q:
        y, x, cur_h, cur_d, cnt = q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < n and 0 <= nx < n:
                if grid[ny][nx] == 'E':
                    return cnt+1
                nxt_h, nxt_d = cur_h, cur_d
                if grid[ny][nx] == 'U':
                    nxt_d = d
                if nxt_d:
                    nxt_d -= 1
                else:
                    nxt_h -= 1
                if not nxt_h:
                    continue
                if visited[ny][nx] < nxt_h:
                    visited[ny][nx] = nxt_h
                    q.append((ny, nx, nxt_h, nxt_d, cnt+1))
    return -1
print(to_safety_zone())
