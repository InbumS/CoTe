
import sys

# sys.stdin=open("input.txt",'rt')

Num = list(map(int,input()))
n=len(Num)
Num.insert(n,-1)
res=[0]*(n+3)
cnt= 0


def DFS(L,P):
    global cnt
    if Num == 0:
       sys.exit(0)

    if L==n:
        cnt+=1
        for j in range(P):
            print(chr(res[j]+64), end=' ')
        print()

    else:
        for i in range(1 ,27):
            if Num[L]==i:
                res[P]=i
                DFS(L+1, P+1)

            elif i>=10 and Num[L]==i//10 and Num[L+1]== i%10:
                res[P]=i
                DFS(L+2, P+1)
                 
DFS(0,0)
print(cnt)        