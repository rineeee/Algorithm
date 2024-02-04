from collections import deque

def solution(coin, cards):
    N = len(cards)
    initial = set(cards[:N//3])
    not_yet = deque(cards[N//3:])
    possible = set()

    def update_possible():
        if not_yet:
            possible.add(not_yet.popleft())
            possible.add(not_yet.popleft())

    def remove_pair(source: set, target: set):
        for x in source.copy():
            if N+1-x in target:
                source.remove(x)
                target.remove(N+1-x)
                return True
        return False

    round = 1
    while not_yet:
        update_possible()
        if remove_pair(initial, initial):
            round += 1
        elif coin >= 1 and remove_pair(initial, possible):
            coin -= 1
            round += 1
        elif coin >= 2 and remove_pair(possible, possible):
            coin -= 2
            round += 1
        else:
            break

    return round
