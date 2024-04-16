import sys
input = sys.stdin.readline

n, m = map(int, input().split())
map_ = []
for _ in range(m):
    a, b, c = map(int, input().split())
    map_.append((a,b,c))

map_.sort(key = lambda x: x[2])
parent = {i: i for i in range(1, n+1)}

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    ap = find(a)
    bp = find(b)
    if ap < bp:
        parent[bp] = ap
    else:
        parent[ap] = bp

ans = 0
last = 0
for a, b, c in map_:
    if find(a) != find(b):
        union(a,b)
        ans += c
        last = c

print(ans-last)
