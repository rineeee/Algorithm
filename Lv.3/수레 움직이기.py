from collections import deque

def solution(maze):
    answer = int(1e9)
    n, m = len(maze), len(maze[0])
    visitedR = [[False]*m for _ in range(n)]
    visitedB = [[False]*m for _ in range(n)]
    q = deque()
    a, b, c, d = 0, 0, 0, 0
    for i in range(n):
        for j in range(m):
            if maze[i][j] == 1:
                a, b = i, j
                visitedR[i][j] = True
            elif maze[i][j] == 2:
                c, d = i, j
                visitedB[i][j] = True
    q.append((a,b,c,d,visitedR,visitedB,0))
    
    while q:
        rx, ry, bx, by, vR, vB, cnt = q.popleft()
        if maze[rx][ry] == 3 and maze[bx][by] == 4:
            answer = min(answer,cnt)
            continue
        if maze[rx][ry] == 3:
            for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                nx, ny = bx+dx, by+dy
                if 0<=nx<n and 0<=ny<m and not vB[nx][ny] and maze[nx][ny] != 5 and (rx,ry) != (nx,ny):
                    nvR = [r[:] for r in vR]
                    nvB = [b[:] for b in vB]
                    nvB[nx][ny] = True
                    q.append((rx,ry,nx,ny,nvR,nvB,cnt+1))
        elif maze[bx][by] == 4:
             for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                nx, ny = rx+dx, ry+dy
                if 0<=nx<n and 0<=ny<m and not vR[nx][ny] and maze[nx][ny] != 5 and (bx,by) != (nx,ny):
                    nvR = [r[:] for r in vR]
                    nvB = [b[:] for b in vB]
                    nvR[nx][ny] = True
                    q.append((nx,ny,bx,by,nvR,nvB,cnt+1))
        else:
            for drx, dry in [(0,1),(0,-1),(1,0),(-1,0)]:
                nrx, nry = rx+drx, ry+dry
                if 0<=nrx<n and 0<=nry<m and not vR[nrx][nry] and maze[nrx][nry] != 5:
                    for dbx, dby in [(0,1),(0,-1),(1,0),(-1,0)]:
                        nbx, nby = bx+dbx, by+dby
                        if 0<=nbx<n and 0<=nby<m and not vB[nbx][nby] and maze[nbx][nby] != 5:
                            if (nrx,nry) == (nbx,nby): continue
                            if (rx,ry) == (nbx,nby) and (bx,by) == (nrx,nry): continue
                            nvR = [r[:] for r in vR]
                            nvB = [b[:] for b in vB]
                            nvR[nrx][nry] = True
                            nvB[nbx][nby] = True
                            q.append((nrx,nry,nbx,nby,nvR,nvB,cnt+1))
            
    if answer == int(1e9):
        return 0    
    return answer
