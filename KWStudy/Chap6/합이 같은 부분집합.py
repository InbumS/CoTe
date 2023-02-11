
import sys
"""
sys.stdin=open("input.txt","rt")
"""
def dfs(val,s):
    # you can save speed
    if s>sums//2:
        return 

    if val==N:
        # you may see even number
        if s == (sums-s):
            print("YES")
            # program end
            sys.exit(0)

    else:
        dfs(val+1, s+arr[val])
        # just go having value
        dfs(val+1, s)


chk=0
N=int(input())
arr=list(map(int,input().split()))
sums=sum(arr)
dfs(0,0) 
print("NO")

