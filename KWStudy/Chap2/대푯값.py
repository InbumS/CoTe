"""
import sys
sys.stdin=open("input.txt","rt")
"""

from sys import implementation, intern


N=int(input())
ls=list(map(int,input().split()))
avg=0
ans=1000000
for i in range(N):
    avg+=ls[i]

avg=int(avg/N)   

for idx, i in enumerate(ls):
    tmp=abs(i-avg)
    if tmp<ans:
        ans=i
        res=idx+1

    elif tmp==ans:
        if i>avg:
            ans=i 
            res=idx+1
print(avg,res)


