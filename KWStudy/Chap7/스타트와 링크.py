import sys
from itertools import combinations
#sys.stdin=open("input.txt",'rt')
n=int(input())
arr=[]
lst_num=list(range(n))
answer=[]

for i in range(n):
    arr.append(list(map(int,input().split())))


for i in list(combinations(lst_num,n//2)):
    start=link=0
    j=list(set(lst_num)-set(i))

    for k,h in list(combinations(i,2)):
        start+= arr[k][h]
        start+= arr[h][k]
    for k,h in list(combinations(j,2)):
        link+= arr[k][h]
        link+= arr[h][k]

    answer.append(abs(start-link))

print(min(answer))