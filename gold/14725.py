import sys
input = sys.stdin.readline

def add(dic, arr):
    if len(arr) == 0:
        return

    if arr[0] not in dic:
        dic[arr[0]] = {}
    add(dic[arr[0]], arr[1:])


def printTree(dic, leng):
    for i in sorted(dic.keys()):
        print("--"*leng+i)
        printTree(dic[i],leng+1)

n = int(input())
a = [list(map(str, input().split())) for _ in range(n)]
dic = {}

for i in a:
    i = i[1:]
    add(dic, i)

print(dic)
printTree(dic, 0)
