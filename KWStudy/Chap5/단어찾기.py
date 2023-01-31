"""
import sys
sys.stdin=open("input.txt",'rt')
"""

# example of hash thing?
N=int(input())
dic=dict()
for i in range(N):
    dic[input()]=i

for i in range(N-1):
    a=input()
    del dic[a]

print(*dic.keys())       