"""
import sys
sys.stdin=open("input.txt",'rt')
"""
def DFS(N,M):   
    global cnt
    if len(check)==M:
            print(*check)
            cnt+=1
    else:
        for i in range(1,N+1):
           if i in check:
               continue
           check.append(i)
           DFS(N,M)
           check.pop()


cnt=0
N,M=map(int,input().split())
check=[]
DFS(N,M)
print(cnt)
