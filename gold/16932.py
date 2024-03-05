import sys
from collections import deque
input = sys.stdin.readline

def bfs(i,j,n,m,arr, count):
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    q = deque()
    q.append((i,j))
    arr[i][j] = count
    cnt = 1

    while q:
        x, y = q.popleft()
        for dx, dy in directions:
            nx, ny = x+dx, y+dy
            if 0<=nx<n and 0<=ny<m and arr[nx][ny] == 1:
                arr[nx][ny] = count
                cnt += 1
                q.append((nx,ny))
    return cnt

def solution(n, m, arr):
    dic = {}
    count =2
    for i in range(n):
        for j in range(m):
            if arr[i][j] == 1:
                dic[count] = bfs(i,j,n,m,arr,count)
                count += 1
    answer = 0
    directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    for x in range(n):
        for y in range(m):
            if arr[x][y] == 0:
                tmp = set()
                cnt = 1
                for dx, dy in directions:
                    nx, ny = x + dx, y + dy
                    if 0<=nx<n and 0<=ny<m and arr[nx][ny] not in tmp and arr[nx][ny] > 1:
                        cnt += dic[arr[nx][ny]]
                        tmp.add(arr[nx][ny])
                answer = max(answer, cnt)
    return answer

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
print(solution(n,m,arr))
