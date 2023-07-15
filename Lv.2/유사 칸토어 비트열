def solution(n, l, r):
    answer = r-l+1
    for num in range(l-1,r):
        while num>=1:
            a,b=divmod(num,5)
            if b==2 or a==2:
                answer-=1
                break
            num=a


    return answer
