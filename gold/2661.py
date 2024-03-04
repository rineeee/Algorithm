import sys
from collections import deque
input = sys.stdin.readline

def solution(cnt):
    if not check(result, cnt):
        return False

    if cnt == n:
        for i in range(n): print(result[i], end='')
        return True

    for i in range(1,4):
        result.append(i)
        if solution(cnt+1):
            return True
        result.pop()

def check(result, cnt):
    for i in range(1, cnt//2+1):
        if result[-i:] == result[-2*i:-i]:
            return False
    return True


n = int(input())
result=[]
solution(0)
