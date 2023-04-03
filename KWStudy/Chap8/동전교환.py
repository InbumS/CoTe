import sys
#sys.stdin=open("input.txt", "r")

N=int(input())
Coin=list(map(int,input().split()))
M=int(input())

dp=[501]*(M+1)
dp[0]=0

for i in range(N):
   for j in range(Coin[i],M+1):
        if dp[j-Coin[i]] != 501:
            dp[j]=min(dp[j],dp[j-Coin[i]]+1)


print(dp[M])