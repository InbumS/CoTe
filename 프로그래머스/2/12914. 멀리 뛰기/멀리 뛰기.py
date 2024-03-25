# Using DP

def solution(n):
    answer = 0
    DP = [0 for i in range(n+2)]
    # 1
    DP[1] = 1
    # 1,1 and 2 두가지 방법
    DP[2] = 2
    for i in range(3, n+1):
        DP[i] = DP[i-2]+DP[i-1]
        
    answer = DP[n]
    return answer%1234567