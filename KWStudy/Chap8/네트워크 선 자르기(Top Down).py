import sys
#sys.stdin=open("input.txt", "r")
N=int(input())

dp=[0]*1000

def Network(x):

    if x==1:
        return 1

    if x==2:
        return 2

    if dp[x]!=0:
        return dp[x]

    dp[x]=Network(x-1)+Network(x-2)

    return dp[x]


print(Network(N))