
import sys
"""
sys.stdin=open("input.txt",'rt')
"""
def DFS(L,sum):
    if L==N and sum==F:
        print(*p)
        sys.exit(0)
        
    else:
        for i in range(1,N+1):
            if check[i]==0:
                check[i]=1
                p[L]=i
                DFS(L+1, sum+(p[L]*b[L]))
                check[i]=0

N,F=map(int,input().split())
b=[1]*N # first and last is 1
p=[0]*N
check=[0]*(N+1)

# this is spot
for i in range(1,N):
    b[i]=b[i-1]*(N-i)//i #use permutation formulas
    

DFS(0,0)