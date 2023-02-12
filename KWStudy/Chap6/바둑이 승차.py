"""
import sys
sys.stdin=open("input.txt", "rt")
"""
def dfs(lst,addnum,tsum):
    global maxnum,C
    
    if addnum+(total-tsum)<maxnum:
        return

    if addnum>C:
        return 

    if lst==N:
         if addnum>maxnum:
             maxnum=addnum
                
    else:
        dfs(lst+1,addnum+arr[lst],tsum+arr[lst])
        dfs(lst+1,addnum,tsum+arr[lst])
        
    
arr=[]
C,N=map(int,input().split())
addnum=0
maxnum=0
for i in range(N):
    arr.append(int(input()))
total=sum(arr)
dfs(0,0,0)
print(maxnum)