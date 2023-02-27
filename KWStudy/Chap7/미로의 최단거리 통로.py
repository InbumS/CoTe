
import sys
#sys.stdin=open("input.txt",'rt')

from collections import deque

arr=[list(map(int,input().split()))for i in range(7)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]


def BFS(x,y):

    Q=deque()   
    Q.append((x,y))

    while Q:
       x,y=Q.popleft()
       for i in range(4):
               ax=x+dx[i]
               ay=y+dy[i]

               if ax>=0 and ay>=0 and ax<7 and ay<7:
                   if arr[ax][ay]==1:
                       continue
               
                   if arr[ax][ay]==0:
                       Q.append((ax,ay))
                       arr[ax][ay]=arr[x][y]+1
            
    return arr[6][6]
        
Val=BFS(0,0)

if Val==0:
    print(-1)
else:
    print(Val)