from collections import deque

deq=deque()
n=int(input())


for i in range(1,n+1):
    deq.append(i)
    
if n==1:
    y=1

else:
    for i in range(n-1):
        x=deq.popleft()
        y=deq.popleft()
        deq.append(y)
  
    
    
print(y)