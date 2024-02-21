import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def solution(v, graph):
    result = [0 for _ in range(v+1)]
    dfs(1, 1, graph, result)
    idx = result.index(max(result))
    result2 = [0 for _ in range(v + 1)]
    dfs(idx, idx, graph, result2)
    print(max(result2))


def dfs(start, now, graph, result):
    for a, b in graph[now]:
        if result[a] == 0 and a != start:
            result[a] = result[now] + b
            dfs(start, a, graph, result)


v = int(input())
graph = [[] for _ in range(v+1)]
for i in range(1, v+1):
    curr = list(map(int, input().split()))
    for j in range(1, len(curr)-1, 2):
        graph[curr[0]].append((curr[j], curr[j+1]))

solution(v, graph)
