"""
import sys
sys.stdin=open("input.txt",'rt')
"""
from itertools import combinations, permutations
num,N=map(int,input().split())


arr=list(map(int,str(num)))
"""
while num:
    x=num%10
    arr.append(x)
    num=num//10

# reverse the number and add array
arr2=[0]*len(arr)
for i in range(len(arr)):
    arr2[-1-i]=arr[i]


maxnum=arr2[0]
for i in range(1,N+1):
    if arr2[i]>maxnum:
        arr2=arr2[i:]
"""

# combi=list(combinations(arr2,len(arr)-N))
stack=[]
for x in arr:
    while stack and N>0 and stack[-1]<x:
        stack.pop()
        N-=1
    stack.append(x)

if N!=0:
    stack=stack[:-N]

res=''.join(map(str,stack))
print(res)