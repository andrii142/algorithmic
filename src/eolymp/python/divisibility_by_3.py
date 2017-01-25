n = int(input())

res = n // 3 * 2
if n % 3 == 2:
    res += 1

print (res)