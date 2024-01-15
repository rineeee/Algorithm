import sys
input = sys.stdin.readline

import heapq

def topological_sort(N, indegree, time, edges, W):
    heap = []

    for i in range(1, N + 1):
        if indegree[i] == 0:
            heapq.heappush(heap, (time[i], i))

    while heap:
        current_time, current_node = heapq.heappop(heap)
        if current_node == W:
            return current_time
        for next_node in edges[current_node]:
            indegree[next_node] -= 1

            if indegree[next_node] == 0:
                heapq.heappush(heap, (current_time+time[next_node], next_node))


def solution():
    T = int(input())

    for _ in range(T):
        N, K = map(int, input().split())
        time = [0] + list(map(int, input().split()))
        indegree = [0] * (N + 1)
        edges = {i: [] for i in range(1, N + 1)}

        for _ in range(K):
            X, Y = map(int, input().split())
            edges[X].append(Y)
            indegree[Y] += 1

        W = int(input())
        result = topological_sort(N, indegree, time, edges, W)
        print(result)

solution()

