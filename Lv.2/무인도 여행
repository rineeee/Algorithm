dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def solution(maps):
    col, row = len(maps), len(maps[0])
    visited = [[False]*row for _ in range(col)]
    
    answer = []
    
    for i in range(col) :
        for j in range(row) :
            if maps[i][j] != "X" and not visited[i][j] :
                period = 0
                q = [(j, i)]
                
                while q :
                    x, y = q.pop()
                    if visited[y][x] :
                        continue
                    visited[y][x] = True
                    period += int(maps[y][x])
                    
                    for k in range(4) :
                        ax, ay = x + dx[k], y + dy[k]
                        if -1 < ax < row and -1 < ay < col and maps[ay][ax] != "X" and not visited[ay][ax] :
                            q.append((ax, ay))
                    
                answer.append(period)
    
    return sorted(answer) if answer else [-1]
