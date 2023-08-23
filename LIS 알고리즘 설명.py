#import sys
import sys
sys.stdin=open("input.txt", "r")

### 이분탐색을 통한 LIS(최장 증가 부분 수열) 알고리즘 구현
### 1) LIS를 풀기 위한 일반적인 방법 : DP O(N^2)
### 2) 시간 복잡도 개선 방법 : 이분탐색 O(NlogN)

inputs = [*map(int,input().split())]
memorization = [0]

for i in inputs:
    if memorization[-1]< i:
        memorization.append(i)
    else:
        # 이분탐색 시작
        left=0
        right=len(memorization)

        while left < right:
            mid=(left+right)//2

            if memorization[mid]<i:
                left= mid+1

            else:
                right=mid
                memorization[right] = i

print(memorization)