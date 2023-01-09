"""
import sys
sys.stdin=open("input.txt","r")
"""
N=int(input())
arr=[*map(int,input().split())]
sum=0
num=1

for i in range(N):
    if arr[i]==1:
        sum+=num
        num+=1

    else:
        num=1

print(sum)