
import sys
#sys.stdin=open("input.txt",'rt') 

arr=[list(map(int,input().split()))for i in range(7)]

dx=[-1,1,0,0]
dy=[0,0,-1,1]
cnt=0

def DFS(x,y):
    global cnt
    if x==6 and y==6:
        cnt+=1

   
    else:
       for i in range(4):
            ax=x+dx[i]
            ay=y+dy[i]
            if ax>=0 and ay>=0 and ax<7 and ay<7 and arr[ax][ay]==0 :
                    arr[ax][ay]=1
                    DFS(ax,ay)
                    arr[ax][ay]=0

arr[0][0]=1             
DFS(0,0)
print(cnt)