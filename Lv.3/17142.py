import sys
from itertools import combinations
from collections import deque


def bfs(arr, q, n, empty_count):
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    time = 0
    infected_count = 0

    while q:
        if infected_count == empty_count:
            return time

        q_len = len(q)
        for _ in range(q_len):
            x, y = q.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < n and arr[nx][ny] != -1:
                    if arr[nx][ny] == 0:
                        infected_count += 1
                    arr[nx][ny] = -1
                    q.append((nx, ny))
        time += 1

    return float('inf')


def solution(n, m, arr):
    virus = []
    empty_count = 0
    for i in range(n):
        for j in range(n):
            if arr[i][j] == 1:
                arr[i][j] = -1
            elif arr[i][j] == 2:
                virus.append((i, j))
                arr[i][j] = -2
            elif arr[i][j] == 0:
                empty_count += 1

    answer = float('inf')
    for selected_virus in combinations(virus, m):
        q = deque(selected_virus)
        copy_arr = [row[:] for row in arr]
        time = bfs(copy_arr, q, n, empty_count)
        answer = min(answer, time)

    if answer == float('inf'):
        return -1
    return answer


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

print(solution(n, m, arr))
