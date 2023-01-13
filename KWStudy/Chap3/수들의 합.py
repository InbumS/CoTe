
import sys
sys.stdin=open("input.txt",'rt')

N,M=map(int,input().split())
arr=[*map(int,input().split())]
cnt=0
lt=0
rt=1
sums=arr[0]

while True:
    if sums<M:
        if rt<N:
            sums+=arr[rt]
            rt+=1
        else:
            break

    elif sums==M:
        cnt+=1
        sums-=arr[lt]
        lt+=1

    else:
        sums-=arr[lt]
        lt+=1

print(cnt)

