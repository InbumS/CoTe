"""
import sys
sys.stdin=open("input.txt", "rt")
"""
N=int(input())
arr=[]
while True:
    arr.append(N%2)
    if N==1:
       break
    N=N//2

for i in range(len(arr)):
    print(arr.pop(),end='')


