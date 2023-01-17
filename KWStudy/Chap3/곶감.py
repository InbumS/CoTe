"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N=int(input())
arr=[list(map(int,input().split()))for i in range(N)]
M=int(input())
for i in range(M):
    C,W,Num=map(int,input().split())
    if W==0:
        for j in range(Num):
            tmp=arr[C-1][0]
            arr[C-1][:-1]=arr[C-1][1:]
            arr[C-1][-1]=tmp

    else:
        for j in range(Num):
            tmp=arr[C-1][-1]
            arr[C-1][1:]=arr[C-1][:-1]
            arr[C-1][0]=tmp

sumall=0
l=0
r=N-1
for i in range(N):
    for j in range(l,r+1):
        sumall+=arr[i][j]
    if i<N//2:
        l+=1
        r-=1
    else:
        l-=1
        r+=1
print(sumall)