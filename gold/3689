import sys
from collections import deque

T = int(sys.stdin.readline().rstrip())

INT_MAX = int(sys.maxsize)

dp_max = [0] * 101
dp_min = [INT_MAX] * 101

count = [6, 2, 5, 5, 4, 5, 6, 3, 7, 6]
initial = [[value, idx] for idx, value in enumerate(count)][1:]

queue = deque(initial)

while queue:
    cnt, make = queue.popleft()
    dp_min[cnt] = min(dp_min[cnt], make)
    if dp_min[cnt] != make:
        continue
    for i in range(10):
        if cnt + count[i] <= 100:
            queue.append([cnt + count[i], int(str(make)+str(i))])

for _ in range(T):
    p = int(sys.stdin.readline().rstrip())
    max_string = ''
    if p % 2 == 1:
        max_string = '7' + '1' * ((p-3) // 2)
    else:
        max_string = '1' * (p // 2)
    print(dp_min[p], max_string)
