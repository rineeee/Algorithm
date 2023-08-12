import heapq as h
def solution(n, start, end, roads, traps):
    start -=1; end -=1;
    INF = float("inf");
    graph = [[] for _ in range(n)]
    trap_dict = {trap-1:idx for idx, trap in enumerate(traps)};
    nodes = [];
    isVisit = [[False]*n for _ in range(1<<len(traps))]
    
    for road in roads:
        start_i, end_i, cost = road
        graph[start_i-1].append([end_i-1,cost,0])
        graph[end_i-1].append([start_i-1,cost,1])
    
    h.heappush(nodes,(0,start,0))
    while nodes:
        cur_time, cur_node, state = h.heappop(nodes);
        if cur_node == end : return cur_time;      
        if isVisit[state][cur_node] == True: continue;
        else: isVisit[state][cur_node] = True;
            
        for next_node, next_cost, road_type in graph[cur_node]:
            next_state = state
            cur_isTrap = 1 if cur_node in trap_dict else 0;
            next_isTrap = 1 if next_node in trap_dict else 0;

            if cur_isTrap == 0 and next_isTrap == 0:
                if road_type == 1: continue
            elif (cur_isTrap + next_isTrap) == 1:
                node_i = cur_node if cur_isTrap == 1 else next_node
                isTrapOn = (state & (1<<trap_dict[node_i]))>>trap_dict[node_i]
                if isTrapOn != road_type: continue
            else:
                isTrapOn = (state & (1<<trap_dict[cur_node]))>>trap_dict[cur_node]
                n_isTrapOn = (state & (1<<trap_dict[next_node]))>>trap_dict[next_node]
                if (isTrapOn ^ n_isTrapOn) != road_type: continue
            
            if next_isTrap == 1:
                next_state = state ^ (1<<trap_dict[next_node])

            h.heappush(nodes,(cur_time+next_cost, next_node, next_state))
