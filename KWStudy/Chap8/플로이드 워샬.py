import sys
#sys.stdin=open("input.txt", "r")

N,M=map(int,input().split())

graph=[[1e9]*(N+1) for i in range(N+1)]

for i in range(1,N+1):
    for j in range(1,N+1):
        if i==j:
            graph[i][j]=0

for i in range(M):
    x,y,v=map(int,input().split())
    graph[x][y]=v

for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            graph[i][j]=min(graph[i][j],graph[i][k]+graph[k][j])

for i in range(1,N+1):
    for j in range(1,N+1):
        if graph[i][j]==1e9:
            print("M",end=" ")
        else:
            print(graph[i][j],end=" ")

    print()