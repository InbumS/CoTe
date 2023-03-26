import sys
#sys.stdin=open("input.txt", "r")
N=int(input())
arr=list(map(int,input().split()))

dp=[0]*1001

for i in range(N):
   dp[i]=1
   for j in range(i):   
       if arr[i]>arr[j]:
           dp[i]=max(dp[i],dp[j]+1)
    

print(max(dp))