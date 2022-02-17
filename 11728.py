#two-pointer 문제
n,m=map(int,input().split())

first=list(map(int,input().split()))
second=list(map(int,input().split()))

ans=first+second
ans.sort()
print(*ans)