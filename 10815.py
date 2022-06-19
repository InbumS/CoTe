n=int(input())
arr1 = list(map(int,input().split()))
arr1.sort()
m=int(input())
arr2=list(map(int,input().split()))

for i in arr2:
    start=0
    end=len(arr1)-1
    while 1:
        mid=(start+end)//2
        if arr1[mid]==i:
            print(1,end=' ')
            break
        
        if arr1[mid]<i:
            start=mid+1
        if arr1[mid]>i:
            end=mid-1
            
        if start>end:
            print(0,end=' ')
            break