"""
import sys
sys.stdin=open("input.txt",'rt')
"""

def dfs(N,M):
    global cnt
    if len(check)==M:
        cnt+=1
        print(*check)
    else:
        for i in range(1,N+1):
            check.append(i)
            dfs(N,M)
            check.pop()


N,M=map(int,input().split())
cnt=0
check=[]
dfs(N,M)
print(cnt)