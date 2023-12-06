def solution(priorities, location):
    queue = [(i,p) for i,p in enumerate(priorities)]
    print(queue)
    answer = 0
    # 시간 초과
    # 해결 방법: any 함수를 쓴다
    # any function : O(n)의 시간복잡도
    while True:
        x = queue.pop(0)
        if any(x[1] < q[1] for q in queue):
            queue.append(x)
        else:
            answer+=1
            if x[0] == location:
                return answer