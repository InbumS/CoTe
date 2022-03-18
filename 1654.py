K,N=map(int,input().split())
arr=[]

for _ in range(K):
    arr.append(int(input()))    

lower_bound,upper_bound=1,max(arr)

while lower_bound<=upper_bound:
    
    mid=(lower_bound+upper_bound)//2
    
    allsum= sum([(i//mid) for i in arr])
    
    if allsum>=N:
        result=mid
        lower_bound=mid+1
    else:
        upper_bound=mid-1
        
        
print(result)