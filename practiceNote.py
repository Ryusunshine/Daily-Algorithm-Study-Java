m = int(input())
n = int(input())
def solution(num_list):
    cnt = 0
    start, end = 0, 0
    num_sum = num_list[0]
    while True:
        if num_sum < m: #합이 작으면 end 포인터를 1증가
            end += 1
            if end >= n: #end포인터가 마지막 인덱스와 같거나 넘어가면 break
                break
            num_sum += num_list[end] #end포인터 값 합에 더해주기
        elif num_sum == m: # 합이 같으면 cnt 증가
            cnt += 1
            num_sum -= num_list[start] #합에서 빼고 start 값 증가시키기
            start += 1
        else:
            num_sum -= num_list[start] #합보다 크면 start += 1
            start += 1

    return cnt

def solution2(num_list):
    cnt = 0
    start, end = 0, 0
    num_sum = num_list[0]
    while True:
        if num_sum < m: # 작으면 end +1
            end += 1
            if end >= n: # 인덱스 범위 주의
                break
            num_sum += num_list[end]
        elif num_sum == m: # 같으면 cnt +1
            cnt += 1
            num_sum -= num_list[start] # 합에서 빼기
            start += 1
        else: # 크면 start +1
            num_sum -= num_list[start]
            start += 1

    return cnt

print(solution2(num_list))