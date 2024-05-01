import sys
from bisect import bisect_left
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr.sort()
answer= 0
for i in range(n-2):
    l, r = i+1, n-1
    while l<r:
        ans = arr[i]+arr[l]+arr[r]
        if ans > 0:
            r -= 1
        else:
            if ans == 0:
                if arr[l] == arr[r]:
                    answer += r-l
                else:
                    k = bisect_left(arr, arr[r])
                    answer += r-k+1
            l += 1
print(answer)
