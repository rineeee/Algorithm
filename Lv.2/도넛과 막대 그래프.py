def solution(edges):
    answer = [0, 0, 0, 0]

    exchangeCnts = dict()
    for a, b in edges:
        if a not in exchangeCnts:
            exchangeCnts[a] = [0, 0]
        if b not in exchangeCnts:
            exchangeCnts[b] = [0, 0]
        
        exchangeCnts[a][0] += 1
        exchangeCnts[b][1] += 1
    
    for key, exchangeCnt in exchangeCnts.items():
        if exchangeCnt[0] >= 2 and exchangeCnt[1] == 0:
            answer[0] = key
        elif exchangeCnt[0] == 0 and exchangeCnt[1] > 0:
            answer[2] += 1
        elif exchangeCnt[0] >= 2 and exchangeCnt[1] >= 2:
            answer[3] += 1
    
    answer[1] = (exchangeCnts[answer[0]][0] - answer[2] - answer[3])

    return answer
