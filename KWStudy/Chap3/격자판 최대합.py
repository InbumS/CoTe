"""
import sys
sys.stdin=open("input.txt",'rt')
"""
N=int(input())
arr=[list(map(int,input().split()))for i in range(N)]
nums=[]

for i in range(N):
    sum=0
    for j in range(N):
        sum+=arr[i][j]

    nums.append(sum)



for i in range(N):
    sum=0
    for j in range(N):
        sum+=arr[j][i]
    nums.append(sum)


sum=0
rev_sum=0
for i in range(N):
    for j in range(N):
        if i==j:
           sum+=arr[i][j]
        if i+j==N-1:
            rev_sum+=arr[i][j]
    nums.append(sum)
    nums.append(rev_sum)


print(max(nums))
