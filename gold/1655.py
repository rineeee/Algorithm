import sys
import heapq
input = sys.stdin.readline

n = int(input())
lq, rq = [], []
answer = []

for _ in range(n):
    curr = int(input())
    if len(lq) == len(rq):
        heapq.heappush(lq, (-curr, curr))
    else:
        heapq.heappush(rq, (curr, curr))

    if rq and rq[0][1] < lq[0][1]:
        left = heapq.heappop(lq)[1]
        right = heapq.heappop(rq)[1]
        heapq.heappush(rq, (left, left))
        heapq.heappush(lq, (-right, right))

    print(lq[0][1])
