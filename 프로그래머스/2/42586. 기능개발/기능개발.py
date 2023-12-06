def solution(progresses, speeds):
    answer = [1]
    check = []
    for i in range(len(progresses)):
        cnt = 0
        while progresses[i] < 100:
            cnt +=1
            progresses[i] += speeds[i]  
        check.append(cnt)
    print(check)
    x = check.pop(0)
    print(check)
    while check:
        if check[0] <= x:
            answer[-1] +=1
            check.pop(0)
            
        else:
            x = check.pop(0)
            answer.append(1)
        
        
    return answer