"""
import sys
sys.stdin=open("input.txt","r")
"""
def digit_sum(x):
    sum_all=0
    while x!=0:
        sum_all+=(x%10)
        x=x//10
    return sum_all
        

N=int(input())
max_arr=[0 for i in range(100000)]
arr=list(map(int, input().split()))

for i in range(len(arr)):
   max_arr[i]= digit_sum(arr[i])

max_num = max(max_arr)
index = max_arr.index(max_num)
print(arr[index])