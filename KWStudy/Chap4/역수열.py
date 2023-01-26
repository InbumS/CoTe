"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N=int(input())
arr=[*map(int,input().split())]
arr2=[100]*N

for i in range(N):
    num=arr[i]
    for j in range(N):
       if num==0 and arr2[j]==100:
           arr2[j]=i+1
           break
       if i+1<arr2[j]:
           num-=1
    
      
      

print(*arr2)
