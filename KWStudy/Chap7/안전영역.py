import sys
from collections import deque
#sys.stdin=open("input.txt", "r")

N=int(input())
arr=[list(map(int,input().split())) for i in range(N)]
maxnum=0
result=0
maxnum=max(map(max,arr))
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def BFS(x,y,V,visited):
   deq=deque()
   deq.append((x,y))
   visited[x][y]=1

   while deq:
       a,b=deq.popleft()
       
       for i in range(4):
           ax=a+dx[i]
           ay=b+dy[i]
           if ax>=0 and ay>=0 and ax <N and ay <N:
               if arr[ax][ay]>V and visited[ax][ay]==0:
                   visited[ax][ay]+=1
                   deq.append((ax,ay))




result=0
for i in range(maxnum):
    visited=[[0]*N for i in range(N)]
    cnt=0

    for j in range(N):
        for k in range(N):
            if arr[j][k]>i and visited[j][k]==0:
                BFS(j,k,i,visited)
                cnt+=1

    if result < cnt:
        result=cnt

print(result)