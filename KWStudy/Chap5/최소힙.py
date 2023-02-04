"""
import sys
sys.stdin=open("input.txt", "rt")
"""
import heapq

heap=[]
while True:
    n=int(input())
    if n==-1:
        break
    elif n==0:
        print(heapq.heappop(heap))
    else:
        heapq.heappush(heap,n)

