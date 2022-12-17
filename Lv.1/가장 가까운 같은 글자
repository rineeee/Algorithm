def solution(s):
    answer = []
    
    word_dict = {}
    
    for idx, word in enumerate(list(s)):
        if word not in word_dict:
            answer.append(-1)
            word_dict[word] = idx
        else:
            answer.append(idx - word_dict[word])
            word_dict[word] = idx
            
    return answer
