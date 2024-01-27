import sys
from collections import Counter
input = sys.stdin.readline

def doR(arr, dir):
    new_arr = []
    max_ = 0
    for r in range(len(arr)):
        c = Counter(arr[r])
        del c[0]
        tmp = list(c.items())
        tmp.sort(key = lambda x: (x[1],x[0]))
        if len(tmp) > 50:
            tmp = tmp[:50]
        new_row = []
        for a, b in tmp:
            new_row.extend([a, b])
        new_arr.append(new_row)
        max_ = max(max_, len(new_row))

    for i in range(len(new_arr)):
        if len(new_arr[i]) < max_:
            new_arr[i].extend([0]*(max_ - len(new_arr[i])))

    return list(zip(*new_arr)) if dir == 'C' else new_arr

def solution(r,c,k,arr):
    time = 0
    if r < len(arr) and c < len(arr[0]):
        if arr[r][c] == k: return time

    while True:
        if len(arr) >= len(arr[0]):
            arr = doR(arr, "R")
        else:
            arr = doR(list(zip(*arr)), "C")
        time += 1
        if time > 100: return -1
        if r < len(arr) and c < len(arr[0]):
            if arr[r][c] ==k: return time


r, c, k = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(3)]
print(solution(r-1,c-1,k,arr))
