import sys
from collections import defaultdict
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

def solution(arr):
    board = [[0] * 101 for _ in range(101)]
    for a in arr:
        x, y, d, g = a
        board[x][y] = 1
        curve = [d]
        for _ in range(g):
            for i in range(len(curve) - 1, -1, -1):
                curve.append((curve[i] + 1) % 4)

        for i in range(len(curve)):
            x, y = x + dx[curve[i]], y + dy[curve[i]]
            board[x][y] = 1

    result = 0
    for i in range(100):
        for j in range(100):
            if board[i][j] and board[i + 1][j] and board[i][j + 1] and board[i + 1][j + 1]:
                result += 1
    print(result)

solution(arr)
