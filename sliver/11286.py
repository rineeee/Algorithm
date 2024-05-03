import sys
from heapq import heappop, heappush
input = sys.stdin.readline

n = int(input())
h = []

for _ in range(n):
    curr = int(input())
    if curr == 0:
        if not h:
            print(0)
        else:
            a, b = heappop(h)
            print(b)
    else:
        heappush(h, (abs(curr), curr))
