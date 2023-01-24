"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N=int(input())
cnt=N
arr=[[0]*2 for i in range(N)]
for i in range(N):
    arr[i][0],arr[i][1]=map(int,input().split())

arr=sorted(arr,key=lambda x:x[0])


for i in range(0,len(arr)-1):
    for j in range(i+1, len(arr)):
        if arr[i][1]< arr[j][1]:
            cnt-=1
            break

print(cnt)
