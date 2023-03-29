import sys
#sys.stdin=open("input.txt", "r")
N=int(input())

arr=[list(map(int,input().split()))for i in range(N)]
dp=[[0]*N for i in range(N)]


def DFS(x, y):
    if dp[x][y]>0:
        return dp[x][y]
    
    elif x==0 and y==0:
        return arr[0][0]

    else:
        if y==0:
            dp[x][y]=DFS(x-1,y)+arr[x][y]

        elif x==0:
            dp[x][y]=DFS(x,y-1)+arr[x][y]
            
        else:
            dp[x][y]=min(DFS(x-1,y),DFS(x,y-1))+arr[x][y]
        
    return dp[x][y]

print(DFS(N-1,N-1))