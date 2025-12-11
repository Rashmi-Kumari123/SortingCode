# *
# **
# ***
def print_row_wise_stars(n):
    for i in range(1, n+1):
        print(i * '*')
        print()
print_row_wise_stars(3)


def pattern_print(n):
    if n == 0:
        return
    pattern_print(n-1)
    for i  in range(1, n+1):
        print(i, end = ' ')
    print()
pattern_print(6)
# output:
# 1 
# 1 2 
# 1 2 3 
# 1 2 3 4 
# 1 2 3 4 5 
# 1 2 3 4 5 6 

## Fibonacci Sequence   (0,1,1,2,3,5..)  
def fib(n):
    if n == 1: # First fibonacci 
        return 0
    if n == 2:
        return 1
    return fib(n-1) + fib(n-2)
print(fib(6))

## using recursion finding  sum of digits of a number
def sum_digits(n):
    if n == 0:
        return 0
    last_digit = n % 10
    remaining = n // 10
    return sum_digits(remaining) + last_digit
print(sum_digits(236))

