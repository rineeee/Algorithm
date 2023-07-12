def ubak(k):
    result = []
    while k != 1:
        result.append(k)
        k = k / 2 if k % 2 == 0 else k * 3 + 1
    result.append(k)
    return result

def solution(k, ranges):
    answer = []
    arr = ubak(k)
    for r in ranges:
        total = 0
        tmp_arr = arr[r[0]:len(arr)+r[1]]
        if r[0] >= r[1]+len(arr):
            answer.append(-1)
            continue
        for i in range(len(tmp_arr)-1):
            total += ((tmp_arr[i] + tmp_arr[i+1])/2)
        answer.append(total)
    return answer
