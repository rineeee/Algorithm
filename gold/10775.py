import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x :
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    xp, yp = find(x), find(y)
    parent[xp] = yp

def solution(g, p ,arr):
    cnt = 0
    for a in arr:
        target = find(a)
        curr = find(target)
        if curr != 0:
            union(curr, curr-1)
        else:
            break

        cnt+=1
    return cnt


g = int(input())
p = int(input())
arr = [int(input()) for _ in range(p)]
parent = [i for i in range(g + 1)]
print(solution(g,p,arr))
