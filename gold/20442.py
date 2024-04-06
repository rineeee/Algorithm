import sys
input = sys.stdin.readline

str = input().rstrip()

left_c, right_c = [], []

c = 0
for s in str:
    if s == "K":
        c += 1
    else:
        left_c.append(c)

c= 0
for s in str[::-1]:
    if s == "K":
        c+= 1
    else:
        right_c.append(c)
right_c.reverse()

def solution():
    if len(right_c) == 0:
        return 0

    left, right = 0, len(right_c) - 1
    result = 0
    while left <= right:
        result = max(result, (right-left+1) +min(left_c[left], right_c[right])*2)

        if left_c[left] < right_c[right]:
            left += 1
        elif left_c[left] > right_c[right]:
            right -= 1
        else:
            left += 1
            right -= 1
    return result

print(solution())
