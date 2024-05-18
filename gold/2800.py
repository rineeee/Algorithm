import sys
from itertools import combinations
input = sys.stdin.readline

string = list(input().rstrip())
stack = []
lists = []
answer = set()

for idx in range(len(string)):
    if string[idx] == "(":
        stack.append(idx)
    if string[idx] == ")":
        lists.append((stack.pop(), idx))

for i in range(1, len(lists)+1):
    for combs in combinations(lists, i):
        str_copy = string[:]
        for c in combs:
            str_copy[c[0]] = str_copy[c[1]] = ""
        answer.add("".join(str_copy))

for a in sorted(list(answer)):
    print(a)
