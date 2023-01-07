"""
import sys
sys.stdin=open("input.txt","r")
"""


def reverse(x):
    for i in range(len(x)):
        num=str(x[i])
        if '0' in num:
            num.replace('0','')
        x[i]= num[::-1]
        ls2.append(int(x[i]))

def isPrime(x):
    for i in range(len(x)):
      cnt=0
      for j in range(2,x[i]+1):
          if x[i]%j==0:
              cnt+=1
      if cnt==1:
       print(x[i],end=" ")

   
N=int(input())
ls=list(map(int,input().split()))
ls2=[]
reverse(ls)
isPrime(ls2)



