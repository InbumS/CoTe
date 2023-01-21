"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N,cutn=(map(int,input().split()))
arr=[]
for i in range(N):
    x=int(input())
    arr.append(x)
res=0
rt=max(arr)
lt=1

while lt<=rt:
     mid=(lt+rt)//2
     cnt=0
     for i in range(N):
         cnt+=(arr[i]//mid)
     
     if cnt>=cutn:
         res=mid
         lt=mid+1


     else:
         rt=mid-1

print(res)