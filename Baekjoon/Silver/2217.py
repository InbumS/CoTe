n=int(input())

maxdiv=0
arr=[]

for i in range(n):
    arr.append(int(input()))
    
 
arr.sort()

# 정렬 후 선택된수에 맞는 로프의 개수를 곱하여 최대 무게 계산
# 그 후 n의 갯수는 하나씩 줄여야한다. sort 함수때문에 쉽게 구한다.
for i in arr:
    maxdiv=max(maxdiv,i*n)
    n-=1
    
print(maxdiv)