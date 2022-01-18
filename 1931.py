num=int(input())

last=0
cnt=0

arr=[[0]*2 for i in range(num)]


for i in range(num):
    n,m=map(int,input().split())
    arr[i][0]=n
    arr[i][1]=m    



arr=sorted(arr,key=lambda x:x[0])
arr=sorted(arr,key=lambda x:x[1])

for i, j in arr:  
    if i >= last:
        last = j
        cnt+=1
        
print(cnt)
