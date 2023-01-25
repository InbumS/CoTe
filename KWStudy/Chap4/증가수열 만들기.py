"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N=int(input())
a=list(map(int,input().split()))
last=0
res=""
tmp=[]
lt=0
rt=N-1

while lt<=rt:
    if a[lt]>last:
        tmp.append((a[lt],'L'))
    if a[rt]>last:
        tmp.append((a[rt],'R'))
    tmp.sort()
   
    if len(tmp)==0:
        break
    else:
        res=res+tmp[0][1]
        last=tmp[0][0]
        if tmp[0][1]=='L':
            lt+=1
        else:
            rt-=1
    tmp.clear()
print(len(res))
print(res)