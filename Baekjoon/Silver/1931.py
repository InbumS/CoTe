num=int(input())

last=0
cnt=0

#숫자 만큼의 2차원 배열
arr=[[0]*2 for i in range(num)]

#각각을 정렬해야한다 --> 출발과 끝시간이 같은 1시간이 안되거나 시간이 0인 회의 존재가능성
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
