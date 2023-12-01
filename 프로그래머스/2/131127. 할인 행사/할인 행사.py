from collections import Counter
def solution(want, number, discount):
    answer = 0
    item = {}
    for i,j in zip(want, number):
        item[i] = j
        
    # 마지막 요소를 제외한 9개
    for i in range(len(discount)-9):
        # 컨테이너의 자료가 몇개인지 파악하는 함수 
        check = Counter(discount[i:i+10])
        if check == item:
            answer +=1
            
    return answer