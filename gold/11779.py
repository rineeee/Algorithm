import sys
import heapq
from collections import defaultdict
input = sys.stdin.readline

def solution(n,m,graph,start,end):
    h = []
    distance = [float('inf')]*n
    heapq.heappush(h,(0,start))
    path = defaultdict(list)
    distance[start] = 0
    while h:
        cnt, curr = heapq.heappop(h)
        if distance[curr] < cnt:
            continue

        for next_, cost in graph[curr]:
            new_cost = cost + cnt
            if new_cost < distance[next_]:
                distance[next_] = new_cost
                path[next_] = path[curr] + [next_]
                heapq.heappush(h,(new_cost, next_))
    print(distance[end])
    print(len(path[end])+1)
    print(*[city + 1 for city in [start]+path[end]])



n = int(input())
m = int(input())
graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int,input().split())
    graph[a-1].append((b-1,c))
start, end = map(int,input().split())

solution(n,m,graph,start-1,end-1)
