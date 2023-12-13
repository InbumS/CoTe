from collections import Counter

def solution(str1, str2):
    str1 = str1.lower()
    str2 = str2.lower()
    set1 = []   
    set2 = []
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            set1.append(str1[i:i+2])
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            set2.append(str2[i:i+2])
    
    c1 = Counter(set1)
    c2 = Counter(set2)
    
    # 교집합 및 합집합 구현
    lengthc1 = len(list((c1&c2).elements()))
    lengthc2 = len(list((c1|c2).elements()))
    if lengthc1 == 0 and lengthc2 == 0:
        return 65536
    else:
        answer = int(lengthc1/lengthc2*65536)
        return answer