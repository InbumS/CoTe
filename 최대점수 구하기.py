
import sys
#sys.stdin=open("input.txt",'rt')
N,M=map(int,input().split())
arr=[]
maxnum=0
for i in range(N):
    arr.append(tuple(map(int,input().split())))
 
    
def dfs(L,time,score):
    global maxnum
    if time>M:
        return

    else:
        if score>maxnum:
            maxnum=score
        for i in range(L,N):
            dfs(i+1, time+arr[i][1],score+arr[i][0])

dfs(0,0,0)
print(maxnum)