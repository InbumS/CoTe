

import sys

# sys.stdin=open("input.txt",'rt')

N,M= map(int,input().split())
arr=[[0]*N for i in range(N)]

for i in range(M):
    x,y,w=map(int,input().split())
    arr[x-1][y-1]=w

for i in range(N):
    print(*arr[i])
    print()

