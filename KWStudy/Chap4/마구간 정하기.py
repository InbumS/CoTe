"""
import sys
sys.stdin=open("input.txt",'rt')
"""
def count(len):
    cnt=1
    #end point
    ep=arr[0]
    for i in range(1,N):
        if arr[i]-ep>=len:
            cnt+=1
            ep=arr[i]
    return cnt
N,C=map(int,input().split())
res=0
arr=[]
for i in range(N):
   arr.append(int(input()))
 
arr.sort()
lt=1
rt=arr[N-1]

while lt<=rt:
    mid=(lt+rt)//2
    if count(mid)>=C:
       res=mid 
       lt = mid + 1
    else:
        rt = mid -1

print(res)