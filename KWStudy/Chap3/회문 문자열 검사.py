"""
import sys
sys.stdin=open("input.txt","r")
"""
N=int(input())
for i in range(N):
    chk=0
    word=input()
    word=word.lower()
    for j in range(len(word)//2):
        if word[j]!=word[-1-j]:
           chk=1
           break

    if chk==0:
        print("#%d YES" %(i+1))
    else:
        print("#%d NO" %(i+1))

