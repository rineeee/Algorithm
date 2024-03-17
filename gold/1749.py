import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]


def solution():
    prefix_sum = [[0] * (m+1) for _ in range(n+1)]
    for i in range(1,n+1):
        for j in range(1,m+1):
            prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j-1] + arr[i-1][j-1] -prefix_sum[i-1][j-1]

    answer = -float('inf')
    for a in range(1, n+1):
        for b in range(a, n+1):
            for c in range(1, m+1):
                for d in range(c, m+1):
                    answer = max(answer, prefix_sum[b][d] - prefix_sum[b][c-1] - prefix_sum[a-1][d] + prefix_sum[a-1][c-1])
    return answer

print(solution())
