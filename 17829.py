n=int(input())

def search(arr,n):
    if n==1:
        return arr[0][0]
    
    arr2=[[]for i in range(n//2)]
    #두 개씩 추가되는 거 생각
    for i in range(0,n,2):
        for j in range(0,n,2):
            arr2[i//2].append(sorted([arr[i][j],arr[i+1][j],arr[i][j+1],arr[i+1,j+1]])[2])
    return search(arr2,n//2)        
    
        

arr=[]
for i in range(n):
    arr.append(list(map(int,input().split())))
print(search(arr,n))