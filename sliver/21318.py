import sys
input = sys.stdin.readline

n = int(input())

data = list(map(int, input().split()))
q = int(input())

sum_ = [0 for _ in range(n+1)]
sum_temp = 0
for i in range(n-1):
    if data[i] > data[i+1]:
        sum_temp += 1
    sum_[i+1] = sum_temp

sum_[-1] = sum_temp
for _ in range(q):
    x, y = map(int, input().split())
    print(sum_[y-1] - sum_[x-1])
