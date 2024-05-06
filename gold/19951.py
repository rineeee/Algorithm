import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
prefix_sum = [0] *(n+1)

for _ in range(m):
    a, b, k = map(int, input().split())
    prefix_sum[a-1] += k
    prefix_sum[b] -= k
for i in range(1,n):
    prefix_sum[i] += prefix_sum[i-1]

for i in range(n):
    arr[i] += prefix_sum[i]

print(*arr)
