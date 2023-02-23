
import sys
# sys.stdin=open("input.txt",'rt')

N=int(input())
arr=[int(input())for i in range(N)]
res=[0]*3
Diff=9999999


def DFS(L):
    global Diff
    if L==N:
        Loss=max(res)-min(res) 
        if Loss<Diff:
             if len(set(res))==len(res):
                 Diff=Loss
   
    # Impressive backTracking
    else:
        for i in range(3):
            res[i]+= arr[L]
            DFS(L+1)
            res[i]-= arr[L]

DFS(0)
print(Diff)