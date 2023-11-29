def solution(elements):
    length = len(elements)
    elements = elements*2
    answer = set()
    for i in range(length):
        for j in range(length):
            answer.add(sum(elements[i:i+j+1]))
            
    return len(answer)