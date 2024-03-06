import sys
input = sys.stdin.readline

n = int(input())
nArr = list(map(int, input().split()))
m = int(input())
mArr = list(map(int, input().split()))
dp = [[0]*(30*500+1) for _ in range(n+1)]
result = set()
def dfs(nArr, n, idx, left, right):
    new = abs(left-right)
    if new not in result:
        result.add(new)

    if idx == n:
        return

    if dp[idx][new] == 0:
        dfs(nArr,n,idx+1,left+nArr[idx],right)
        dfs(nArr,n,idx+1,left,right+nArr[idx])
        dfs(nArr,n,idx+1,left,right)
        dp[idx][new] = 1


dfs(nArr, n, 0, 0, 0)
answer = []

for ma in mArr:
    if ma in result:
        answer.append("Y")
    else:
        answer.append("N")

print(*answer)
