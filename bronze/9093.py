import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    arr = input().rstrip().split()
    reverse = []
    for a in arr:
        reverse.append(a[::-1])
    print(*reverse)
