n = int(input())
a, b = 0, 1
n = n % (15 * (10**5))
for i in range(n):
    a, b = b % (10**6), (a+b) % (10**6)
print(a)
