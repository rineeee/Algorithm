import sys
input = sys.stdin.readline


def solution(n,arr):
    dp = [[float('inf')]*n for _ in range(n)]
    sum_ = [0]
    for i in range(n):
        dp[i][i] = 0
        sum_.append(sum_[-1]+arr[i])

    for d in range(1, n):
        for i in range(n-d):
            for j in range(i,i+d):
                dp[i][i+d] = min(dp[i][i+d], dp[i][j]+dp[j+1][i+d]+sum_[i+d+1]-sum_[i])

    return dp[0][n-1]


for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    print(solution(n,arr))
