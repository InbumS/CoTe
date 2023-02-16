
import sys
"""
sys.stdin=open("input.txt",'rt')
"""
N,K=map(int,input().split())
arr=[*map(int,input().split())]
M=int(input())
cnt=0

def DFS(left,s,sum):
    global cnt
    if left==K:
        if sum%M==0:
            cnt+=1

    else:
        for i in range(s,N):
                DFS(left+1,i+1,sum+arr[i])
                
    

check=[0]*(N+1)
DFS(0,0,0)
print(cnt)