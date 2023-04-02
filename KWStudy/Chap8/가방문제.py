import sys
#sys.stdin=open("input.txt", "r")

N,L=map(int,input().split())
dp = [0]*(L+1)

for i in range(N):
    w,v=map(int,input().split())
    for j in range(w,L+1):
        dp[j]=max(dp[j],dp[j-w]+v)

print(dp[L])