import sys
#sys.stdin=open("input.txt", "r")

N=int(input())

graph=[[1e+4]*(N+1) for i in range(N+1)]

while True:
    x,y=map(int,input().split())
    if x==-1 and y==-1:
        break
    
    else:
        graph[x][y]=1
        graph[y][x]=1

for i in range(1,N+1):
    graph[i][i]=0
    
for i in range(1, N+1):
    for x in range(1, N+1):
        for y in range(1, N+1):
            graph[x][y]= min(graph[x][y], graph[x][i]+graph[i][y])

M_value = 1e+4

for i in range(1, N+1):
    M_value = min(M_value, max(graph[i][1:]))

result=[]

for i in range(1,N+1):
    if max(graph[i][1:])==M_value:
        result.append(i)

print(M_value, len(result))
for i in range(len(result)):
    print(result[i],end=' ')


