import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

def solution():
    left, right = 0, (n-1)*(1+max(arr)-min(arr))
    dp = [[0] * n for _ in range(n)]
    answer = 0
    for i in range(n):
        for j in range(i+1, n):
            dp[i][j] = (j-i)*(1+abs(arr[i]-arr[j]))
    while left <= right:
        mid = (left + right)//2
        stack = [0]
        visited = [False] * (n)
        visited[0]=True
        flag = False
        while stack:
            now = stack.pop()
            if now == n-1:
                flag = True
            for idx in range(now+1, n):
                if dp[now][idx] <= mid and not visited[idx]:
                    stack.append(idx)
                    visited[idx] = True
        if flag:
            answer = mid
            right = mid -1
        else:
            left = mid + 1

    return answer

print(solution())
