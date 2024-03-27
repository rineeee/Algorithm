import sys
input = sys.stdin.readline

n, k = map(int, input().split())

def solution():
    left, right = 0, n//2+1

    while left<=right:
        mid = (left+right)//2 # 가로로 자른 횟수
        result = (mid+1) * (n-mid+1)
        if result == k:
            return "YES"
        if result > k:
            right = mid -1
        else:
            left = mid + 1

    return "NO"


print(solution())
