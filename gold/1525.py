import sys
from collections import deque
input = sys.stdin.readline

def solution(start):
    target = '123456780'
    q = deque()
    visited = dict()
    visited[start] = 0
    q.append((start))

    while q:
        curr= q.popleft()
        if curr == target:
            return visited[curr]
        zero = curr.index('0')
        x, y = divmod(zero, 3)
        for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
            nx, ny = x+dx, y+dy
            if 0<=nx<3 and 0<=ny<3:
                new_zero = nx*3+ny
                new_arr = list(curr)
                new_arr[zero], new_arr[new_zero] = new_arr[new_zero], new_arr[zero]
                new_arr = ''.join(new_arr)
                if not visited.get(new_arr):
                    visited[new_arr] = visited[curr] + 1
                    q.append((new_arr))
    return -1


initial_state = ''
for _ in range(3):
    initial_state += ''.join(input().split())

print(solution(initial_state))
