"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N=int(input())
arr=[list(map(int,input().split()))for i in range(N)]

arr2=[[0]*(N+2) for i in range(N+2)]

for i in range(N):
    for j in range(N):
          arr2[i+1][j+1]=arr[i][j]

res=0
# explore four range 
ax=[-1,0,1,0]
ay=[0,1,0,-1]
for i in range(1,N+1):
    for j in range(1,N+1):
        if all(arr2[i][j] >arr2[i+ax[k]][j+ay[k]] for k in range(4)):
            res+=1
print(res)
        