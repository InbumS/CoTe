"""
import sys
sys.stdin=open("input.txt","r")
"""
arr=[]
num=int(input())

def calculate(x):
    if x[0]==x[1] and x[1]==x[2]:
        money=10000+x[0]*1000
        arr.append(money)

    elif (x[0]!=x[1] and x[1]!=x[2]) and (x[1]!=x[2] and x[0]!=x[2]):
        max_num=max(x)
        arr.append(max_num*100)

    else:
        max_num=0
        for i in range(3):
            for j in range(i+1,3):
                if x[i]==x[j]:
                    max_num=x[i]

        money=1000+max_num*100
        arr.append(money)


for i in range(num):
    list_Num=list(map(int,input().split())) 
    calculate(list_Num)

print(max(arr))
