import sys
input = sys.stdin.readline

arr = [-1]*26
s = input().rstrip().upper()
for idx, ch in enumerate(s):
    if arr[ord(ch)-65] == -1:
        arr[ord(ch)-65] = idx
print(*arr)

