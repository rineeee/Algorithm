import sys
from collections import Counter
input = sys.stdin.readline

#상 우 하 좌
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def solution(r,c,t,arr):
    up, down = 0, 0
    for i in range(r):
        if arr[i][0] == -1:
            up = i
            down = i+1
            break

    for _ in range(t):
        # 1
        new_arr = [a[:] for a in arr]
        for i in range(r):
            for j in range(c):
                if arr[i][j] > 0:
                    spread = arr[i][j]//5
                    for k in range(4):
                        nx, ny = i+dx[k], j+dy[k]
                        if 0<=nx<r and 0<=ny<c and arr[nx][ny] != -1:
                            new_arr[nx][ny] += spread
                            new_arr[i][j] -= spread
        arr = [a[:] for a in new_arr]

        #2
        for i in range(up - 2, -1, -1):
            arr[i + 1][0] = arr[i][0]
        for i in range(c - 1):
            arr[0][i] = arr[0][i + 1]
        for i in range(up):
            arr[i][c - 1] = arr[i + 1][c - 1]
        for i in range(c - 2, 0, -1):
            arr[up][i + 1] = arr[up][i]
        arr[up][1] = 0

        for i in range(down + 1, r - 1):
            arr[i][0] = arr[i + 1][0]
        for i in range(c - 1):
            arr[r - 1][i] = arr[r - 1][i + 1]
        for i in range(r - 1, down, -1):
            arr[i][c - 1] = arr[i - 1][c - 1]
        for i in range(c - 2, 0, -1):
            arr[down][i + 1] = arr[down][i]
        arr[down][1] = 0

    answer = 0
    for i in range(r):
        answer += sum(arr[i])
    return answer + 2

r, c, t = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(r)]
print(solution(r,c,t,arr))
