import sys
#sys.stdin=open("input.txt", "r")

N,M=map(int,input().split())
dp=[0]*(M+1)

for i in range(N):
    w,v=map(int,input().split())
    for j in range(M,v-1,-1):   
        dp[j]=max(dp[j],dp[j-v]+w)

print(dp[M])