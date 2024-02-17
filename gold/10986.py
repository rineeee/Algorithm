import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

def solution(n, m, arr):
    answer = 0
    prefix_sum = [0] * (n + 1)

    for i in range(1, n + 1):
        prefix_sum[i] = prefix_sum[i - 1] + arr[i - 1]

    count_remainders = [0] * m
    for i in range(n + 1):
        remainder = prefix_sum[i] % m
        count_remainders[remainder] += 1

    for count in count_remainders:
        answer += count * (count - 1) // 2

    return answer

print(solution(n, m, arr))
