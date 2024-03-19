import sys
import heapq
input = sys.stdin.readline


n = int(input())
h=[]
for _ in range(n):
    heapq.heappush(h, int(input()))

answer = 0
while len(h)>1:
    f = heapq.heappop(h)
    s = heapq.heappop(h)
    answer += f+s
    heapq.heappush(h, f+s)
print(answer)

