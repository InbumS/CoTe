
def solution(s):
    s = s[2:-2]
    tuples = s.split("},{")
    tuples.sort(key=len)
    answer = []
    for t in tuples:
        numbers = list(map(int, t.split(',')))
        for num in numbers:
            if num not in answer:
                answer.append(num)

    return answer
  