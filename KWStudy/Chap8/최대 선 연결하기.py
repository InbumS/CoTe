import sys
#sys.stdin=open("input.txt", "r")
N=int(input())
arr=list(map(int,input().split()))
dp=[0]*101

for i in range(N):
    dp[i]=1
    for j in range(i-1,0,-1):
        if arr[i]>arr[j]:
            dp[i]=max(dp[i],dp[j]+1)

print(max(dp))
