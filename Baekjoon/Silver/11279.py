import heapq
import sys

input=sys.stdin.readline

n=int(input())

number=[]
for i in range(n):
    x=int(input())
    if(x !=0):
        heapq.heappush(number, (-n,n))
    if (x==0):
        if (not number):
            print(0)
            
        else:
            maxnum=heapq.heappop(number)[1]
            print(maxnum)