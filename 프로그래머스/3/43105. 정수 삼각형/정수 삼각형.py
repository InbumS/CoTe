def solution(triangle):
    N = len(triangle)
    DP = [[0]*N for i in range(N)]
    DP[0][0] = triangle[0][0]
    
    for i in range(1, N):
        for j in range(i+1):
            # 맨 왼쪽 자리
            if j == 0:
                DP[i][j] = DP[i-1][j] + triangle[i][j]
            # 맨 오른쪽 자리
            elif j == i:
                DP[i][j] = DP[i-1][j-1] + triangle[i][j]
                
            else:
                DP[i][j] = max(DP[i-1][j], DP[i-1][j-1])+triangle[i][j]
                
    answer = max(DP[N-1])
    
    return answer
            