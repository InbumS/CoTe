"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N=int(input())
arr=[list(map(int,input().split()))for i in range(N)]
sumall=0
s=e=N//2

for i in range(N):
    for j in range(s,e+1):
        sumall+=arr[i][j]
    if i<N//2:
         s-=1
         e+=1
    else:
         s+=1
         e-=1
                
print(sumall)