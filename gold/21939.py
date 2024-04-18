import sys
from heapq import heappop, heappush
input = sys.stdin.readline
from collections import defaultdict


n = int(input())
min_heap = []
max_heap = []
in_list = defaultdict(bool)
for _ in range(n):
    p, l = map(int, input().split())
    heappush(min_heap, [l, p])
    heappush(max_heap, [-l, -p])
    in_list[p] = True

m = int(input())
for _ in range(m):
    command = input().split()
    if command[0] == "add":
        p, l = int(command[1]), int(command[2])
        while not in_list[-max_heap[0][1]]:
            heappop(max_heap)
        while not in_list[min_heap[0][1]]:
            heappop(min_heap)
        in_list[p] = True
        heappush(max_heap, [-l, -p])
        heappush(min_heap, [l, p])
    elif command[0] == "recommend":
        if command[1] == '1':
            while not in_list[-max_heap[0][1]]:
                heappop(max_heap)
            print(-max_heap[0][1])
        else:
            while not in_list[min_heap[0][1]]:
                heappop(min_heap)
            print(min_heap[0][1])
    else:
        in_list[int(command[1])] = False

