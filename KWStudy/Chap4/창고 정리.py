"""
import sys
sys.stdin=open("input.txt",'rt')
"""
L=int(input())
arr=list(map(int,input().split()))
M=int(input())

for i in range(M):
    arr.sort()
    arr[0]+=1
    arr[-1]-=1

arr.sort()
print(arr[-1]-arr[0])