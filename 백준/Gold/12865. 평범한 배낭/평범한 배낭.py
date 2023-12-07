arr = []
N,K = map(int,input().split())
DP =[[0] * (K+1) for _ in range(N+1)]
for i in range(N):
    w,v = map(int,input().split())
    arr.append([w,v])

for i in range(1,N+1):
    for j in range(1,K+1):
        if arr[i-1][0] <= j:
            DP[i][j] = max(DP[i-1][j], DP[i-1][j-arr[i-1][0]]+arr[i-1][1])
        else:
            DP[i][j] = DP[i-1][j]

print(DP[N][K])