
import sys
#sys.stdin=open("input.txt",'rt')

from collections import deque
N=int(input())
arr=[list(map(int,input().split()))for i in range(N)]
# range select
sum=0
dx=[-1,0,1,0]
dy=[0,1,0,-1]
check=[[0]*N for i in range(N)]
Q=deque()
check[N//2][N//2]=1
sum+=arr[N//2][N//2]
Q.append((N//2,N//2))
L=0

while True:
    if L==N//2:
        break
    
    size=len(Q)
    for i in range(size):
        tmp=Q.popleft()
        for j in range(4):
             x=tmp[0]+dx[j]
             y=tmp[1]+dy[j]
             if check[x][y]==0:
                 check[x][y]=1
                 sum+=arr[x][y]
                 Q.append((x,y))

    L+=1

print(sum)
