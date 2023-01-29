"""
import sys
sys.stdin=open("input.txt",'rt')
"""
arr=input()
stack=[]

for i in arr:
    if i.isnumeric():
        stack.append(int(i))
       
    else:
        x1=stack.pop()
        x2=stack.pop()
        if i=='+':
             stack.append(x1+x2)
        elif i == '-' :
            stack.append(x2-x1)
        elif i == '*' :
            stack.append(x1*x2)
        elif i == '/' :     
            stack.append(x2/x1)

        

print(abs(*stack))