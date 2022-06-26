# 잘 몰라서 인터넷을 참고하였음. combinations의 활용법은 알고 있었으나
# 시간 복잡도 문제로 인해 continue를 활용한 배열 접근법 풀이로 해결? 

from collections import deque
from itertools import combinations
import sys
input=sys.stdin.readline
ans=0
N,M=map(int,input().split())
comb=[]
accept=[[False]*N for i in range(N)]

if N<3:
    print(0)
else:
    for i in range(M):
        a,b=map(int,input().split())
        accept[a-1][b-1]=True
        accept[b-1][a-1]=True
    
    for j in combinations(range(N),3):
        if accept[j[0]][j[1]] or accept[j[1]][j[2]] or accept[j[0]][j[2]]:
            continue
        ans+=1
    print(ans)