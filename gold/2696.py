import sys
import heapq
input = sys.stdin.readline


def solution(m, arr):
    lh = []
    rh = []
    mid = arr[0]
    result = [arr[0]]

    for i in range(1, len(arr)):
        if arr[i] < mid:
            heapq.heappush(lh, -arr[i])
        else:
            heapq.heappush(rh, arr[i])

        if i % 2 == 0:
            if len(lh) > len(rh):
                heapq.heappush(rh, mid)
                mid = -heapq.heappop(lh)
            elif len(lh) < len(rh):
                heapq.heappush(lh, -mid)
                mid = heapq.heappop(rh)
            result.append(mid)
    print(len(result))
    for i, num in enumerate(result):
        if i != 0 and i % 10 == 0:
            print()
        print(num, end=' ')

for _ in range(int(input())):
    m = int(input())
    arr = []
    for _ in range(m // 10 + 1):
        arr += list(map(int, input().split()))
    solution(m, arr)
