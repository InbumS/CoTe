"""
import sys
sys.stdin=open("input.txt",'rt')
"""

arr=input()
sums=0
left=0

for i in range(len(arr)):
    if arr[i]=='(':
        left+=1
    elif arr[i]==')':
        left-=1
        if arr[i-1]=='(':
            sums=sums+left
        else:
            sums+=1

print(sums)