"""
import sys
sys.stdin=open("input.txt","r")
"""
import math

N=int(input())
arr=[True for i in range(N+1)]

primeNum=0

for i in range(2,int(math.sqrt(N+1))):
    if arr[i]:
        for j in range(i+i, N+1, i):
            arr[j]=False
      
for i in range(2,N+1):
    if arr[i]:
        primeNum+=1

print(primeNum)
