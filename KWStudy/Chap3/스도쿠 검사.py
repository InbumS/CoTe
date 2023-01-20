"""
import sys
sys.stdin=open("input.txt",'rt')
"""
arr=[list(map(int,input().split()))for i in range(9)]
flag=True
for i in range(9):
    row=col=set()
    for j in range(9):
          row.add(arr[i][j])
          col.add(arr[i][j])
    if len(row)!=9 and len(col)!=9:
        flag=False
        break

if flag:
    for i in range(0,9,3):
        for j in range(0,9,3):
            nemo=set()
            for k in range(3):
              for m in range(3):
                nemo.add(arr[i+k][j+m])
            if len(nemo)!=9:
                flag=False
                break

print('YES' if flag is True else 'NO')

