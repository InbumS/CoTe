# 해시 [검색과 저장 시간 복잡도 O(1)]
# key값이 배열의 index로 변경

def solution(phone_book):
    phone_arr = {}
    for i in phone_book:
        phone_arr[i] = True
        
    for phone_number in phone_book:
        prefix = ""
        for i in phone_number:
            prefix += i
            if prefix in phone_arr and prefix != phone_number:
                return False
            
    return True
        
        
    