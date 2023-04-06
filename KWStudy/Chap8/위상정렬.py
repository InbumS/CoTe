import sys
from collections import deque
#sys.stdin=open("input.txt", "r")


N,M=map(int,input().split())
deq=deque()

degree=[0]*(N+1)
graph=[[0]*(N+1) for i in range(N+1)]

for i in range(M):
    x,y=map(int,input().split())
    graph[x][y]=1
    degree[y]+=1

for i in range(1,N+1):
    if degree[i]==0:
        deq.append(i)
 
while deq:
    x=deq.popleft()
    print(x,end=' ')
    for i in range(1,N+1):
        if graph[x][i]==1:
            degree[i]-=1
            if degree[i]==0:
                deq.append(i)