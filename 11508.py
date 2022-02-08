from collections import deque

d=deque()
arr=[]
n=int(input())
sum=0
for i in range(n):
    arr.append(int(input()))
    
arr.sort(reverse=True)

for i in range(len(arr)):
    d.append(arr[i])
    
while d:
    if len(d)>=3:
        sum+=(d[0]+d[1])
        for i in range(3):
            d.popleft()
            
    else:
        sum+=d[0]
        d.popleft()
        
        
print(sum)