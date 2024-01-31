import sys
input = sys.stdin.readline

answer = 0
def dfs(x,y,routes,visited,n,arr,cnt):
    global answer
    if routes[cnt][0] == x and routes[cnt][1] == y:
        if cnt == len(routes) -1:
            answer += 1
            return
        else:
            cnt += 1
    visited[x][y] = True
    for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
        nx, ny = x+dx, y+dy
        if 0<=nx<n and 0<=ny<n and not visited[nx][ny] and arr[nx][ny] != 1:
            dfs(nx,ny,routes,visited,n,arr, cnt)
    visited[x][y] = False

def solution(n,arr,routes):
    visited = [[False]*n for _ in range(n)]
    dfs(routes[0][0], routes[0][1], routes, visited, n, arr, 1)


n, m = map(int, input().split())
arr = [list(map(int,input().split())) for _ in range(n)]
routes = []
for _ in range(m):
    a, b = map(int, input().split())
    routes.append((a-1,b-1))
solution(n,arr,routes)
print(answer)
