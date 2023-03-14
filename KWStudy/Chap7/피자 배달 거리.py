import sys
#sys.stdin=open("input.txt", "r")
N,M=map(int,input().split())
arr=[list(map(int,input().split())) for i in range(N)]
house=[]
pizza=[]

# store count of combinations
combination=[0]*M
result=21470000

def DFS(L,S):
    global result
    if L==M:
        sum=0
        for j in range(len(house)):
            x1=house[j][0]
            y1=house[j][1]
            dis=214700000

            for x in combination:
                x2=pizza[x][0]
                y2=pizza[x][1]
                dis=min(dis,abs(x1-x2)+abs(y1-y2))

            sum+=dis
        if sum<result:
           result=sum   

    else:
        for i in range(S,len(pizza)):
            combination[L]=i
            DFS(L+1,i+1)


for i in range(N):
    for j in range(N):
        if arr[i][j]==1:
            house.append((i,j))
        elif arr[i][j]==2:
            pizza.append((i,j))
       
DFS(0,0)
print(result)