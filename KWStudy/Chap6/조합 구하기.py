"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N,M=map(int,input().split())

def DFS(n,m):
    global cnt
    if len(arr)==m:
        print(*arr)
        cnt+=1
    
    else:
        for i in range(1,n+1):
            if i not in arr:
                arr.append(i)
                if i==max(arr):
                    DFS(n,m)
                arr.pop()

cnt=0
arr=[]
DFS(N,M)
print(cnt)