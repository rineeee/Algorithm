def solution(elements):
    result = set()
    n = 0
    while n != len(elements):
        n += 1
        for i in range(len(elements)):
            if i+n > len(elements):
                result.add(sum(elements[i:]+elements[:i+n-len(elements)]))
            else:
                result.add(sum(elements[i:i+n]))
    
    return len(result)
