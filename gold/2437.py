import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
def solution(n, arr):
    arr.sort()
    target = 1
    for a in arr:
        if target < a:
            break
        target += a
    return target


print(solution(n, arr))
