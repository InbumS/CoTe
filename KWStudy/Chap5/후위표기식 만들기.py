"""
import sys
sys.stdin=open("input.txt",'rt')
"""
# you know that (+,-) is same level and (*,/) is same level too!
# you should deal with '(' to operator
# https://dttmmit.tistory.com/137

arr=input()
lst=[]
result=''

for i in arr:
    if i.isdigit():
       result+=i
    # this ( have priority attribute
    elif i=='(':
        lst.append(i)

    elif i=='*' or i=='/':
       while len(lst)>0 and (lst[-1]=='*' or lst[-1]=='/'):
           # if you have already one?
           result+=lst.pop()
       lst.append(i)

    elif i== '-' or i== '+':
      # because of priority   
      # +,- < x, /  
      while len(lst)>0 and (lst[-1]!='('):
           result+=lst.pop()
      lst.append(i)
    else:
         while lst and lst[-1]!='(':
             result+=lst.pop()
         # remove (
         lst.pop()

while lst:
    result+=lst.pop()
    
print(result)
