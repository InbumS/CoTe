"""
import sys
sys.stdin=open("input.txt",'rt')
"""
from collections import deque


essential=input()
N=int(input())
check=[0]*N


for i in range(N):
    arr=input()
    deq=deque(essential)
    for j in arr:
        if j in deq and j!=deq.popleft():
            break
    if len(deq)==0:
        check[i]+=1
        

for i in range(len(check)):
    if check[i]==1:
        print("#%d YES" %(i+1))
    else:
        print("#%d NO" %(i+1))
           
       