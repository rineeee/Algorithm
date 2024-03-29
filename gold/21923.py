import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for i in range(n)]

def solution():
    dp_up = [[-float('inf')] * m for _ in range(n)]
    dp_down = [[-float('inf')] * m for _ in range(n)]
    dp_up[n - 1][0] = arr[n - 1][0]
    dp_down[n - 1][m - 1] = arr[n - 1][m - 1]

    for i in range(n-1, -1, -1):
        for j in range(m):
            if i == n-1 and j == 0: continue
            if i < n-1: dp_up[i][j] = max(dp_up[i][j], dp_up[i+1][j])
            if j > 0: dp_up[i][j] = max(dp_up[i][j], dp_up[i][j-1])
            dp_up[i][j] += arr[i][j]

    for i in range(n-1, -1, -1):
        for j in range(m-1, -1, -1):
            if i == n-1 and j == m-1: continue
            if i < n-1: dp_down[i][j] = max(dp_down[i][j], dp_down[i+1][j])
            if j < m-1: dp_down[i][j] = max(dp_down[i][j], dp_down[i][j+1])
            dp_down[i][j] += arr[i][j]

    answer = -float('inf')
    for i in range(n):
        for j in range(m):
            answer = max(answer, dp_up[i][j]+dp_down[i][j])
    return answer

print(solution())
