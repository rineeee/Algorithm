import sys
from collections import defaultdict
from heapq import heappop, heappush
input = sys.stdin.readline

n, m = map(int, input().split())
graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def solution(start):
    h = []
    dist = [float('inf')] * (n+1)
    dist[start] = 0
    chart = [0] * (n+1)
    heappush(h,(0,start))

    while h:
        cnt, curr = heappop(h)
        if dist[curr] < cnt:
            continue
        for next_b, next_c in graph[curr]:
            next_cnt = cnt+next_c
            if next_cnt < dist[next_b]:
                dist[next_b] = next_cnt
                chart[next_b] = curr
                heappush(h,(next_cnt, next_b))
    return chart[1:]


result = []
for i in range(1, n+1):
    result.append(solution(i))

for i in range(n):
    for j in range(n):
        if i==j:
            print('-', end=' ')
        else:
            print(result[j][i],end=' ')
    print()
