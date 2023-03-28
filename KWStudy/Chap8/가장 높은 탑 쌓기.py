import sys
#sys.stdin=open("input.txt", "r")
N=int(input())

dp=[0]*N

arr=[]
for i in range(N):
    arr.append(tuple(map(int,input().split())))

arr.sort(reverse=True)
dp[0]=arr[0][1]
res=arr[0][1]

for i in range(1,N):
    max_h=0
    for j in range(i-1,-1,-1):
        if arr[j][2] > arr[i][2] and dp[j]>max_h:
            max_h=dp[j]
            
    dp[i]=max_h+arr[i][1]
    res=max(res,dp[i])

print(res)

