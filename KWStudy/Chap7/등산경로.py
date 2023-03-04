
import sys
from types import LambdaType
#sys.stdin=open("input.txt",'rt') 

N=int(input())
arr=[list(map(int,input().split())) for i in range(N)]

# using map function to find extremum point
MinNum=min(map(min,arr))
MaxNum=max(map(max,arr))
cnt=0
x=y=0
x2=y2=0
dx=[1,-1,0,0]
dy=[0,0,1,-1]
check=[[0]*N for i in range(N)]


# List indexing for min max number
for i in range(N):
    for j in range(N):
        if arr[i][j]== MinNum:
            x,y=i,j
            
        elif arr[i][j]==MaxNum:
            x2,y2=i,j


def DFS(x,y):
    global cnt
    if x==x2 and y==y2:
        cnt+=1

    else:
        for i in range(4):
            ax=x+dx[i]
            ay=y+dy[i]
            if ax>=0 and ay>=0 and ax<N and ay<N and check[ax][ay]==0:
                if arr[ax][ay]>arr[x][y]:
                    check[ax][ay]=1
                    DFS(ax,ay)
                    check[ax][ay]=0

check[x][y]=1
DFS(x,y)
print(cnt)