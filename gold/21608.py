import sys
from collections import defaultdict
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def solution(n, arr):
    board = [[0]*n for _ in range(n)]
    for curr, a, b, c, d in arr:
        # 1
        tmp = []
        for i in range(n):
            for j in range(n):
                if board[i][j] == 0:
                    like, blank = 0, 0
                    for k in range(4):
                        nx, ny = i+dx[k], j+dy[k]
                        if 0<=nx<n and 0<=ny<n:
                            if board[nx][ny] in [a,b,c,d]:
                                like += 1
                            if board[nx][ny] == 0:
                                blank += 1
                    tmp.append([like, blank, i, j])
        tmp.sort(key=lambda x:(-x[0],-x[1],x[2],x[3]))
        board[tmp[0][2]][tmp[0][3]] = curr
    result = 0
    arr.sort()
    for i in range(n):
        for j in range(n):
            ans = 0
            for k in range(4):
                nx, ny = i+dx[k], j+dy[k]
                if 0 <= nx < n and 0 <= ny < n:
                    if board[nx][ny] in arr[board[i][j]-1]:
                        ans += 1
            if ans != 0:
                result += 10 ** (ans-1)
    print(result)

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n*n)]
solution(n, arr)
