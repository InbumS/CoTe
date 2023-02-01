"""
import sys
sys.stdin=open("input.txt",'rt')
"""
arr=input()
compare=input()

answer=dict()
for i in arr:
    if answer.get(i):
        answer[i]+=1
    else:
        answer[i]=1

for i in compare:
    if answer.get(i):
        answer[i]-=1

aws=list(answer.values())

if(all(x==0 for x in aws)):
    print("YES")
else:
    print("NO")