"""
import sys
sys.stdin=open("input.txt",'rt')
"""

arr=[i for i in range(1,21)]


for i in range(10):
  x,y=map(int,input().split())
  for j in range((y-x+1)//2):
      # when you change index, you must think index place, not exceed the list size
      arr[x-1+j],arr[y-1-j]=arr[y-1-j],arr[x-1+j]

for i in range(20):
    print(arr[i],end=" ")