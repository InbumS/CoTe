"""
import sys
sys.stdin=open("input.txt",'rt')
"""
from collections import deque


N,M=map(int,input().split())

arr=list(map(int,input().split()))
arr.sort(reverse=True)

deq=deque()
cnt=0
for i in range(N):
    deq.append(arr[i])

while deq:
    if len(deq)==1:
        cnt+=1
        break

    if deq[0]+deq[-1]>M:
        deq.popleft()
        cnt+=1
    else:
        deq.popleft()
        deq.pop()
        cnt+=1
print(cnt)