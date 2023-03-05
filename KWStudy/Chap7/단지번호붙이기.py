
import sys
#sys.stdin=open("input.txt",'rt') 
from collections import deque
N=int(input())
arr=[list(map(int,input()))for i in range(N)]
dy=[0,0,1,-1]
dx=[1,-1,0,0]
answer=[]

def BFS(x,y):
    arr[x][y]=0
    deq=deque()
    deq.append((x,y))
    cnt=1
    while deq:
        x,y=deq.popleft()
        for i in range(4):
            ax=x+dx[i]
            ay=y+dy[i]
            if ax<0 or ax>=N or ay>=N or ay<0:
                continue
            else:
                if arr[ax][ay]==1:
                    arr[ax][ay]=0
                    deq.append((ax,ay))
                    cnt+=1

    return cnt

for i in range(N):
    for j in range(N):
        if arr[i][j]==1:
            answer.append(BFS(i,j))

answer.sort()
print(len(answer))

for num in answer:
    print(num)