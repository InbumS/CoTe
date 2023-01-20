"""
import sys
sys.stdin=open("input.txt",'rt')
"""
num=0
N,M=map(int,input().split())
arr=list(map(int,input().split()))

for i in range(len(arr)):
    if M>arr[i]:
        num+=1

print(num+1)