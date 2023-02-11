"""
import sys
sys.stdin=open("input.txt","rt")
"""
def dfs(K):
    if K==N+1:
        for i in range(1,N+1):
            if check[i]==1:
                print(i,end=' ')
        print()
        
    else:
       check[K]=1
       dfs(K+1)
       check[K]=0
       dfs(K+1)

N=int(input())
check=[0]*(N+1)
dfs(1)