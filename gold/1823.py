import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

n = int(input())
arr = [int(input()) for _ in range(n)]
dp =[[0] *n for _ in range(n)]
def solution(k, left, right):
    if left == right:
        return k*arr[left]
    if dp[left][right]:
        return dp[left][right]
    dp[left][right] = max(solution(k+1, left+1, right)+k*arr[left], solution(k+1,left,right-1)+k*arr[right])
    return dp[left][right]


print(solution(1, 0, n-1))
