
import sys
#sys.stdin=open("input.txt",'rt')
K=int(input())
arr=list(map(int,input().split()))
res=set()


S=sum(arr)
def dfs(L,sum):
    global res
    if L==K:
        if 0<sum<=S:
            res.add(sum)
        return

    else:
        dfs(L+1,sum+arr[L])
        dfs(L+1,sum-arr[L])
        dfs(L+1,sum)
    
dfs(0,0)
print(S-len(res))