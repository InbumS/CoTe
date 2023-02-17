
import sys
# sys.stdin=open("input.txt",'rt')

N,M=map(int,input().split())
arr=[[0]*(N+1) for i in range(N+1)]
cnt=0
visited=[False]*(N+1)

for i in range(M):
    x,y=map(int,input().split())
    arr[x][y]=1

def DFS(n):
    global cnt
    if n==N:
        cnt+=1

    else:
        for i in range(1,N+1):
           visited[n]=True   
           if not visited[i] and arr[n][i]==1:
               DFS(i)
           visited[n]=False


DFS(1)
print(cnt)