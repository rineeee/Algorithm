import sys
input = sys.stdin.readline


def print_arr(arr, n):
    for i in range(n):
        print(*arr[i])


for _ in range(int(input())):
    n, d = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    result = [[0] * n for _ in range(n)]
    if d < 0:
        d = 360+d
    if d ==360 or d==0:
        print_arr(arr, n)
    else:
        for _ in range(d//45):
            for i in range(n):
                for j in range(n):
                    if i == j:
                        result[i][j] = arr[(n+1)//2-1][j]
                    elif i == (n+1)//2-1:
                        result[i][j] = arr[n-j-1][j]
                    elif i + j == n-1:
                        result[i][j] = arr[i][(n+1)//2-1]
                    elif j == (n+1)//2-1:
                        result[i][j] = arr[i][i]
                    else:
                        result[i][j] = arr[i][j]
            arr = [r[:] for r in result]
        print_arr(result, n)
