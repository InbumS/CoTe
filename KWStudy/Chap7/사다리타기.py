import sys
#sys.stdin=open("input.txt", "r")

arr=[list(map(int,input().split())) for i in range(10)]
check=[[0]*10 for i in range(10)]

def DFS(x, y):
    check[x][y] = 1
    if x == 0:                                        
        print(y)
    else:
        if y - 1 >= 0 and arr[x][y-1] == 1 and check[x][y-1] == 0:
            DFS(x, y-1)                        
        elif y + 1 < 10 and arr[x][y+1] == 1 and check[x][y+1] == 0:
            DFS(x, y+1)                        
        else:
            DFS(x-1, y)     

   

for i in range(10):
    if arr[9][i]==2:
        DFS(9,i)




