
import sys
from collections import deque
#sys.stdin=open("input.txt",'rt')
MAX=100000
S,E=map(int,input().split())

ch=[0]*(MAX+1)
dis=[0]*(MAX+1)
ch[S]=1
dis[E]=0
cnt=0
dq=deque()
dq.append(S)


while dq:
       now=dq.popleft()
       if now==E:
           break
       for next in (now-1,now+1,now+5):
           if 0<next< MAX:
               if ch[next]==0:
                    dq.append(next)
                    ch[next]=1
                    dis[next]=dis[now]+1

print(dis[E])
