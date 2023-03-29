import sys
#sys.stdin=open("input.txt", "r")
N=int(input())

arr=[list(map(int,input().split()))for i in range(N)]
dp=[[0]*N for i in range(N)]

dp[0][0]=arr[0][0]

# Setting or Initialize Value
for i in range(1,N):
    dp[0][i]=dp[0][i-1]+arr[0][i]
    dp[i][0]=dp[i-1][0]+arr[i][0]

# Find Small Cost Value
for i in range(1,N):
    for j in range(1,N):
        dp[i][j]=min(dp[i-1][j],dp[i][j-1])+arr[i][j]
  
print(dp[N-1][N-1])