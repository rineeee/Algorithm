import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
arr = []
for _ in range(m):
    a, b, c = map(int, input().split())
    arr.append((a,b,c))
arr.sort(key= lambda x: x[2])
parent = {i:i for i in range(1, n+1)}

def find(a):
    if parent[a] == a:
        return parent[a]
    parent[a] = find(parent[a])
    return parent[a]

def union(a,b):
    ap = find(a)
    bp = find(b)
    parent[ap] = bp

result = 0
for a, b, value in arr:
    if find(a) != find(b):
        union(a,b)
        result += value
print(result)
