"""
import sys 
sys.stdin=open("input.txt", "rt")
"""
T=int(input())
answer=[]

for i in range(T):
    N,s,e,k=map(int,input().split())
    x=[*map(int,input().split())]
    x=x[s-1:e]
    x.sort()
    answer.append(x[k-1])
    
    

for i in range(len(answer)):
    print("#%d %d" %(i+1,answer[i]))
 
    
