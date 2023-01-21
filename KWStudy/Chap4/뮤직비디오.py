"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N,M=map(int,input().split())
arr=list(map(int,input().split()))
res=0
lt=min(arr)
rt=sum(arr)

while lt <= rt:
    mid=(lt+rt)//2
    cnt=1
    sums=0
    # you check center num and compare num
    for x in arr:
        if sums+x >mid:
            cnt+=1
            sums=x
        else:
            sums+=x
    if cnt<=M:
        res=mid
        rt=mid-1
    else:
        lt=mid+1

print(res)

