import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

def solution():
    answer = float('inf')
    l, r = 0, 0
    left, right = 0, n-1
    while left < right:
        curr = arr[left] + arr[right]
        curr_abs = abs(curr)
        if curr == 0:
            return arr[left], arr[right]
        if answer > curr_abs:
            answer = curr_abs
            l, r = arr[left], arr[right]
        if curr < 0:
            left += 1
        else:
            right -= 1
    return l, r

print(*solution())
