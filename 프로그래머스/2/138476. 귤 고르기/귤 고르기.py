from collections import Counter

def solution(k, tangerine):
    answer = 0
    counts = Counter(tangerine)
    # Dict values sort
    counts = sorted(counts.values(), reverse=True)
    cnt = 0
    for i in counts:
        cnt += i
        answer +=1
        if cnt >= k:
            break
    
    return answer