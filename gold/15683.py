import sys
from collections import defaultdict
input = sys.stdin.readline

mode = [
    [],
    [[0], [1], [2], [3]],
    [[0, 2], [1, 3]],
    [[0, 1], [1, 2], [2, 3], [0, 3]],
    [[0, 1, 2], [0, 1, 3], [1, 2, 3], [0, 2, 3]],
    [[0, 1, 2, 3]],
]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
cctv = []
for i in range(n):
    for j in range(m):
        if board[i][j] in [1,2,3,4,5]:
            cctv.append((board[i][j],i,j))

def fill(board, mm, x, y):
    for i in mm:
        nx = x
        ny = y
        while True:
            nx += dx[i]
            ny += dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                break
            if board[nx][ny] == 6:
                break
            elif board[nx][ny] == 0:
                board[nx][ny] = 7
def dfs(depth, arr):
    global result
    if depth == len(cctv):
        tmp = 0
        for i in range(n):
            tmp += arr[i].count(0)
        result = min(tmp, result)
        return
    copy_arr = [a[:] for a in arr]
    cctv_number, x, y = cctv[depth]
    for i in mode[cctv_number]:
        fill(copy_arr, i, x, y)
        dfs(depth+1, copy_arr)
        copy_arr = [a[:] for a in arr]


result = float('inf')
dfs(0, board)
print(result)
