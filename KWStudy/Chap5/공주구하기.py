"""
import sys
sys.stdin=open("input.txt",'rt')
"""

from collections import deque
# Using deque
deq=deque()

N,K=map(int,input().split())
for i in range(1,N+1):
   deq.append(i)

for i in range(N-1):
    deq.rotate(-K+1)
    deq.popleft()
    
print(*deq)


