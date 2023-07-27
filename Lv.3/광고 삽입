def strtoint(time):
    answer = int(time[0:2])*60*60
    answer += int(time[3:5])*60
    answer += int(time[6:])
    return answer
def inttostr(time):
    hour = time//3600
    minute = (time%3600)//60
    second = (time-hour*3600-minute*60)
    answer = str(hour).zfill(2) + ':'
    answer += str(minute).zfill(2) + ':'
    answer += str(second).zfill(2)
    return answer

def solution(play_time, adv_time, logs):
    play_time = strtoint(play_time)
    adv_time = strtoint(adv_time)
    dp = [0]*(play_time+1)
    for x in logs:
        start = strtoint(x[:8])
        end = strtoint(x[9:])
        dp[start] += 1
        dp[end] -= 1
    for i in range(1, play_time+1):
        dp[i] = dp[i]+dp[i-1]
    for i in range(1, play_time+1):
        dp[i] = dp[i]+dp[i-1]
    answer = 0
    max_cnt = dp[adv_time]
    for start in range(1, play_time):
        if start+adv_time >= play_time:
            end = play_time
        else:
            end = start+adv_time
        if max_cnt < dp[end]-dp[start]:
            max_cnt = dp[end]-dp[start]
            answer = start+1
    return inttostr(answer)
