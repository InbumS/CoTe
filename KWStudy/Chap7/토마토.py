import sys
from collections import deque
#sys.stdin=open("input.txt", "r")

M,N=map(int,input().split())
arr=[list(map(int,input().split())) for i in range(N)]
cnt=0
dx=[1,-1,0,0]
dy=[0,0,1,-1]
deq=deque()

   

for i in range(N):
    for j in range(M):
        if arr[i][j]==1:
            deq.append((i,j))

while deq:
        x,y=deq.popleft()
        for i in range(4):
            ax=x+dx[i]
            ay=y+dy[i]
            if 0<= ax <N and 0<=ay <M:
                if arr[ax][ay]==0:
                    arr[ax][ay]=arr[x][y]+1
                    deq.append((ax,ay))

       
for x in arr:
    for y in x:
        if y==0:
            print(-1)   
            sys.exit(0)
    cnt=max(cnt,max(x))

print(cnt-1)