"""
import sys
sys.stdin=open("input.txt","r")
"""
arr=' '
word=input()
num=0
for i in range(len(word)):
      if word[i].isdigit():
        arr+=word[i]

arr=int(arr)
print(arr)
for i in range(1,arr+1):
    if arr%i==0:
       num+=1

print(num)