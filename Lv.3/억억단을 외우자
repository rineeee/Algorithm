def solution(e, starts):
    divisor_list = [0]*(e+1)
    min_s = min(starts)
    for i in range(1, e + 1):
        if i * i <= e:
            divisor_list[i*i] += 1
        for j in range(i+1, e + 1):
            n = i * j
            if n > e:
                break
            divisor_list[n] += 2
            
    max_div_list = [0]*(e+1)
    max_div_list[-1] = e
    for i in range(e-1, min_s-1, -1) :
        if divisor_list[max_div_list[i+1]] <= divisor_list[i] :
            max_div_list[i] = i
        else :
            max_div_list[i] = max_div_list[i+1]
    answer = [ max_div_list[s] for s in starts ]
    
    return answer
