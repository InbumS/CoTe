"""
import sys
sys.stdin=open("input.txt","r")
"""

N,M=map(int,input().split())
arr=[ 0 for i in range(1000)]
max_num=0

for i in range(1,N+1):
    for j in range(1,M+1):
        arr[i+j]+=1

for i in range(1000):
    if max_num < arr[i]:
        max_num = arr[i]

for i in range(1000):
    if max_num == arr[i]:
        print(i,end=" ")
