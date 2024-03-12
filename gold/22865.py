import sys
from collections import defaultdict
import heapq
input = sys.stdin.readline


n = int(input())
friends_location = list(map(int, input().split()))
m = int(input())
graph = defaultdict(list)
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def find(now):
    h = []
    heapq.heappush(h, (0,now))
    location = [float('inf')] * (n+1)
    location[now] = 0
    while h:
        cnt, curr = heapq.heappop(h)
        if location[curr] < cnt:
            continue
        for next_, next_cnt in graph[curr]:
            next_cost = cnt + next_cnt
            if next_cost < location[next_]:
                location[next_] = next_cost
                heapq.heappush(h,(next_cost, next_))
    return location


def solution():
    arr = []
    for friend_location in friends_location:
        arr.append(find(friend_location))

    result = 0
    answer = 0
    for i in range(1, n+1):
        curr_min = min(arr[0][i], arr[1][i], arr[2][i])
        if curr_min and curr_min > result:
            result = curr_min
            answer = i
    return answer


print(solution())
