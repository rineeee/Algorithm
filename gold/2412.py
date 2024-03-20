import sys
from collections import deque
input = sys.stdin.readline


n, t = map(int, input().split())
set_ = set()
for _ in range(n):
    a, b = map(int, input().split())
    set_.add((a,b))

def solution():
    q = deque()
    q.append((0,0,0))

    while q:
        x, y, cnt = q.popleft()
        if y == t:
            return cnt
        for dx in range(-2,3):
            for dy in range(-2,3):
                if (x+dx, y+dy) in set_:
                    q.append((x+dx, y+dy, cnt+1))
                    set_.remove((x+dx, y+dy))
    return -1

print(solution())
