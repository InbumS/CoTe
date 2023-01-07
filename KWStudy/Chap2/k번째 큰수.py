import sys
sys.stdin=open("input.txt","rt")
ans=set()

N,K=map(int,input().split())
ls=[*map(int, input().split())]
for i in range(N):
    for j in range(i+1,N):
        for k in range(j+1, N):
            ans.add(ls[i]+ls[j]+ls[k])

ans=list(ans)
ans.sort(reverse=True)
print(ans[K-1])
