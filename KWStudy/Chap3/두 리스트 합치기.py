"""
import sys
sys.stdin=open("input.txt",'rt')
"""
x=int(input())
arr1=list(map(int,input().split()))
y=int(input())
arr2=list(map(int,input().split()))

arr3=arr1+arr2
arr3.sort()

for i in range(len(arr3)):
    print(arr3[i],end=" ")