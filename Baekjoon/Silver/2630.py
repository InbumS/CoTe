def divide(x,y,n):

    global zero_cnt
    global one_cnt

    check=arr[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if check!=arr[i][j]:
                divide(x,y,n//2)
                divide(x,y+n//2,n//2)
                divide(x+n//2,y,n//2)
                divide(x+n//2,y+n//2,n//2)
                return


    if check==0:
        zero_cnt+=1

    else:
        one_cnt+=1
    


 
n=int(input())
arr=[]

zero_cnt=0
one_cnt=0

for i in range(n):
    arr.append(list(map(int,input().split())))


divide(0,0,n)
print(zero_cnt)
print(one_cnt)
