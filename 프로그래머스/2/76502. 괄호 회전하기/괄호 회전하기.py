def is_valid(s):
    stack = []
    bracket_map = {')': '(', ']': '[', '}': '{'}

    for char in s:
        if char in bracket_map.values():
            stack.append(char)
        elif char in bracket_map.keys():
            if not stack or stack.pop() != bracket_map[char]:
                return False
        else:
            return False

    return not stack

def solution(s):
    answer = 0

    for i in range(len(s)):
        rotated_str = s[i:] + s[:i]
        if is_valid(rotated_str):
            answer += 1

    return answer
