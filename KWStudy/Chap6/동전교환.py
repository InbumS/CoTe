"""
import sys
sys.stdin=open("input.txt",'rt')
"""
def dfs(L,M):
    global Count
    # you can find time exceed type 1
    if L>Count:
        return
    if M<0: 
       return
    if M==0:
        if Count > L:
            Count=L

    else:
        for i in range(N):
            dfs(L+1, M-S[i])
           

N=int(input())
S=list(map(int,input().split()))
S.sort(reverse=True)
M=int(input())
Count=100000
dfs(0,M)
print(Count)