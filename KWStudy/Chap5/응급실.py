"""
import sys
sys.stdin=open("input.txt",'rt')
"""
from collections import deque
N,M=map(int,input().split())
arr=deque([(x,y)for x,y in enumerate(map(int,input().split()))])
cnt=0

num=M



while True:
    x=arr.popleft()
    maxnum=max(arr,key=lambda x:x[1])
    if x[1]>=maxnum[1]:
        cnt+=1
        if x[0]==num:
           break
    else:
        arr.append(x)

print(cnt)


