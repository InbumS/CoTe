
import sys
#sys.stdin=open("input.txt",'rt')
arr=[]
N=int(input())
revenue=0
for i in range(N):
    arr.append(tuple(map(int,input().split())))


def dfs(L, P):
    global revenue
    if L>N:
        return

    # because of +1 that make index error
    elif L==N:
        if P>revenue:
            revenue=P

    else:    
        dfs(L+arr[L][0],P+arr[L][1])
        dfs(L+1,P)

dfs(0,0)
print(revenue)