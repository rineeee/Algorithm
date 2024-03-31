import sys
from collections import deque
input = sys.stdin.readline

arr = [input().rstrip() for i in range(8)]
n = 8
def solution():
    wall = set()
    for i in range(8):
        for j in range(8):
            if arr[i][j] == "#":
                wall.add((i,j))

    q = deque()
    q.append((7,0))
    while q:
        for _ in range(len(q)):
            x, y = q.popleft()
            if (x,y) in wall:
                continue
            if x == 0:
                return 1
            for dx, dy in [[0, 0], [1, 0], [-1, 0], [0, -1], [0, 1], [-1, -1], [-1, 1], [1, -1], [1, 1]]:
                nx, ny = x+dx, y+dy
                if 0<=nx<8 and 0<=ny<8 and (nx,ny) not in wall:
                    q.append((nx,ny))
        next_wall = set()
        for x,y in wall:
            if x<7:
                next_wall.add((x+1,y))
        wall = next_wall
    return 0

print(solution())
