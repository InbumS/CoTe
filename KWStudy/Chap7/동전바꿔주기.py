
import sys
#sys.stdin=open("input.txt",'rt')

T=int(input())
k=int(input())
arr=[]
check=[]
cnt=0
for i in range(k):
    x,y=map(int,input().split())
    check.append(x)
    arr.append(y)

def DFS(L,value):
    global cnt

    if value>T:
        return

    # think about 0 
    if L==k:
        if value==T:
            cnt+=1
    else:
        for i in range(arr[L]+1):   
            DFS(L+1, value+check[L]*i)
       
DFS(0,0)
print(cnt)