# 백준 1260

from collections import deque
n, m, v = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start_node):
    queue = deque()
    queue.append(start_node)
    visited[start_node] = True
    while queue:
        now = queue.popleft()
        print(now, end=" ")
        for next_node in graph[now]:
            if not visited[next_node]:
                queue.append(next_node)
                visited[next_node] = True

def dfs(node):
    visited[node] = True
    print(node, end=" ")
    for next in graph[node]:
        if not visited[next]:
            dfs(next)

for i in graph: # 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
    i.sort()

visited = [False] * (n + 1)
dfs(v)
print()
visited = [False] * (n + 1)
bfs(v)

# 백준 11724

from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
queue = deque()
for _ in range(m):
    a, b= map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(i):
    queue.append(i)
    visited[i] = True
    while queue:
        now = queue.popleft()
        for next in graph[now]:
            if not visited[next]:
                queue.append(next)
                visited[next] = True

cnt = 0
for i in range(1, n + 1):
    if not visited[i]:
        bfs(i)
        cnt += 1
print(cnt)

# 10451

from collections import deque
def bfs(start_node):
    queue = deque()
    queue.append(start_node)
    visited[start_node] = True
    while queue:
        now = queue.popleft()
        for next in graph[now]:
            if not visited[next]:
                queue.append(next)
                visited[next] = True

n = int(input())
for _ in range(n):
    m = int(input())
    num_list = list(map(int, input().split()))
    graph = [[] for _ in range(m+1)]
    visited = [False] * (m+1)
    for i in range(m):
        graph[i+1].append(num_list[i])
        graph[num_list[i]].append(i+1)
    cnt = 0
    for i in range(1, m+1):
        if not visited[i]:
            bfs(i)
            cnt += 1
    print(cnt)

#백준 2331

A, P = map(int, input().split())
num_list = [A]
while True:
    a = 0
    for i in str(num_list[-1]):
        a += int(i) ** P
    if a in num_list:
        break
    num_list.append(a)

print(num_list.index(a))

# 백준 4963

from collections import deque
import sys
input = sys.stdin.readline
queue = deque()

dx = [1, -1, 0, 0, 1, -1, 1, -1]
dy = [0, 0, -1, 1, -1, 1, 1, -1]
def bfs(i, j):
    queue.append([i, j])
    graph[i][j] = 0
    while queue:
        x, y = queue.popleft()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<= nx < n and 0<= ny < m and graph[nx][ny] == 1:
                queue.append([nx, ny])
                graph[nx][ny] = 0

while True:
    m,n = map(int, input().split())
    if m == 0 & n == 0:
        break
    graph = [list(map(int, input().split())) for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                bfs(i, j)
                cnt += 1
    print(cnt)

# 1697
from collections import deque
n, k = map(int, input().split())
visited = [0] * 100001
queue = deque()
def bfs():
    queue.append(n)
    while queue:
        now = queue.popleft()
        if now == k:
            print(visited[now])
            break
        for next in (now-1, now+1, now*2):
            if 0 <= next <= 100000 and visited[next] == False:
                visited[next] = visited[now] + 1 # 노드 방문 표시를 cnt 로 한다.
                queue.append(next)
bfs()

# 1726

import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
sx, sy, sd = map(int, input().split())
ex, ey, ed = map(int, input().split())
visited = [[[False for _ in range(5)] for _ in range(m)] for _ in range(n)]

def change_dir(before, after):
    if before == after:
        return 0
    # (동쪽, 서쪽) 또는 (남쪽, 북쪽) 이면 방향값 2
    elif (before, after) == (1, 2) or (before, after) == (2, 1) or (before, after) == (3, 4) or (before, after) == (4, 3):
        return 2
    else:
        return 1

def bfs(i, j, dir, visited):
    dx = [0, 0, 0, 1, -1]
    dy = [0, 1, -1, 0, 0]

    q = deque()
    q.append((i, j, dir, 0))
    visited[i][j][dir] = True

    while q:
        x, y, dir, cnt = q.popleft()

        if x == ex - 1 and y == ey - 1:
            return cnt + change_dir(dir, ed)

        for i in range(1, 4):  # 1 ~3 칸 전진
            nx = x + dx[dir] * i
            ny = y + dy[dir] * i
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny][dir]:  # 해당 코드 추가안하면 메모리초과
                continue
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] != 1:
                visited[nx][ny][dir] = True
                q.append((nx, ny, dir, cnt + 1))
            else:  # 벽을 만나면 전진 멈춤
                break

        for i in range(1, 5):  # 방향 바꾸기
            if not visited[x][y][i]:
                visited[x][y][i] = True
                q.append((x, y, i, cnt + change_dir(dir, i)))

print(bfs(sx - 1, sy - 1, sd, visited))

# 1753

import heapq
import sys
input = sys.stdin.readline
INF = 1e9
x, y= map(int, input().split(' '))
graph = [[] for _ in range(x+1)]
min_distance = [None]
min_distance += [INF] * x

start_node = int(input())
for _ in range(y):
     u, v, w = map(int, input().split(' '))
     graph[u].append([v, w])

def dijkstra(graph, start_node, min_distance):
     queue = []
     heapq.heappush(queue, [0, start_node])
     min_distance[start_node] = 0
     while queue:
          current_dist, current_node = heapq.heappop(queue)
          if min_distance[current_node] < current_dist: # 전체 다 확인하니깐. 이 문장 꼭 써주기, 안쓰면 다른 정답나와
               continue
          min_distance[current_node] = current_dist
          for next_node, weight in graph[current_node]:
               cost = min_distance[current_node] + weight
               if cost < min_distance[next_node]:
                    min_distance[next_node] = cost
                    heapq.heappush(queue, [cost, next_node])

     return min_distance #전체 다 돌고 min_dist 반환

dijkstra(graph, start_node, min_distance)
for i in range(1, len(min_distance)):
     if min_distance[i] == INF:
          print("INF")
     else:
          print(min_distance[i])

#######################################################################################################################
# 1956 운동 공부
# 10217 KCM Travel - dp 공부
########################################################################################################################

# 1504 특정한 최단경로

import heapq
import sys
input = sys.stdin.readline

def dijkstra(start, end):
    queue = []
    min_dist = [1e9] * (n + 1)
    heapq.heappush(queue, [0, start])
    min_dist[start] = 0
    while queue:
        current_dist, current_node = heapq.heappop(queue)
        for next_node, weight in graph[current_node]:
            cost = min_dist[current_node] + weight
            if cost < min_dist[next_node]:
                min_dist[next_node] = cost
                heapq.heappush(queue, [cost, next_node])

    return min_dist[end]

n,e = map(int, input().split())
graph = [[] for _ in range(n+1)]
for i in range(e):
    a, b, c= map(int, input().split())
    graph[a].append([b,c])
    graph[b].append([a, c])
v1, v2 = map(int, input().split())


def solve():
    path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n)
    path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n)

    result = min(path1, path2)

    if result < 1e9:
        return result
    else:
        return -1

print(solve())

# 2309 일곱 난쟁이
small_people = []
for _ in range(9):
    small_people.append(int(input()))

temp = []
def dfs(depth, temp):
    if depth == 7:
        if sum(temp) == 100:
            for i in sorted(temp):
                print(i)
            exit()
        else:
            return
    for j in range(depth, 9):
        temp.append(small_people[j])
        dfs(depth+1, temp)
        temp.pop()

print(dfs(0, temp))

# 3085 사탕게임
def check(a):
    n = len(a)
    ans = 1
    for i in range(n):
        cnt = 1
        for j in range(1, n): # 열을 돌면서 중복 알파벳 개수 더하기
            if a[i][j] == a[i][j-1]:
                cnt += 1
            else:
                cnt = 1
            if ans < cnt:
                ans = cnt
        cnt = 1
        for j in range(1, n): # 행을 돌면서 중복 알파벳 개수 더하기
            if a[j][i] == a[j-1][i]:
                cnt += 1
            else:
                cnt = 1
            if ans < cnt:
                ans = cnt
    return ans

n = int(input())
a = [list(input()) for _ in range(n)]
ans = 0
for i in range(n):
    for j in range(n):
        if j+1 < n: # 오른쪽 칸
            a[i][j],a[i][j+1] = a[i][j+1],a[i][j]
            temp = check(a)
            if ans < temp:
                ans = temp
            a[i][j],a[i][j+1] = a[i][j+1],a[i][j] #원상 복귀
        if i+1 < n: # 아래 칸
            a[i][j],a[i+1][j] = a[i+1][j],a[i][j]
            temp = check(a)
            if ans < temp:
                ans = temp
            a[i][j],a[i+1][j] = a[i+1][j],a[i][j]
print(ans)

# 1107 리모콘

import sys

input = sys.stdin.readline
target = int(input())
n = int(input())
broken = list(map(int, input().split()))

# 현재 채널에서 + 혹은 -만 사용하여 이동하는 경우
min_count = abs(100 - target) # 현재 채널 = 100번

for nums in range(1000001):
    # 여기서 range를 N의 최대 범위인 500,000이 아닌 그 두 배 1,000,000로 해준 것은, 수빈이가 이동하려는 채널의 범위는 500,000 이하이지만 채널 자체는 무한대라는 점 때문이다.
    nums = str(nums)

    for j in range(len(nums)): # 갈려는 숫자 하나하나씩 돌면서 고장났는지 확인
        # 그 숫자가 고장난 숫자이면 break
        if int(nums[j]) in broken:
            break

        # 고장난 숫자 없이 마지막 인덱스까지 왔다면 min_count 비교 후 업데이트
        elif j == len(nums) - 1:
            min_count = min(min_count, abs(int(nums) - target) + len(nums))

print(min_count)

# 모음사전
def find(data, p, step):
    if step == 6:
        return
    if p != '':
        data.append(p) #사전에 추가
    for c in ['A','E','I','O','U']:
        find(data, "".join([p,c]), step+1)

def solution(word):
    answer = 0
    data = []
    find(data, "", 0)
    for i in range(len(data)):
        if data[i] == word:
            answer = i+1
            break
    return answer


##############조금 다르게
def find(data, word, step):
    if step == 6:
        return
    if word != '':
        data.append(word)
    for i in 'AEIOU':
        find(data, word+i, step+1)

def solution():
    data= []
    find(data, '', 0)
    for i in range(len(data)):
        if data[i] == target:
            print(i+1)
            return
target = str(input())
solution()


# 9095 1,2,3 더하기
def add_num(now, goal):
    if now > goal:
        return 0
    if now == goal:
        return 1
    cnt = 0
    for i in range(1, 4):
        cnt += add_num(now+i, goal)

    return cnt

t = int(input())
for _ in range(t):
    goal = int(input())
    print(add_num(0, goal))

#백준 13023 ABCDE

import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

n, m = map(int, input().split())
visited = [False] * n
graph = [[] for _ in range(n)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

flag = False

def dfs(depth, now):
    global flag
    visited[now] = True
    if depth == 4:
        print(1)
        exit()

    for next in graph[now]:
        if not visited[next]:
            dfs(depth + 1, next)
            visited[next] = False #return 되면 다시 방문 표시 해제

for i in range(n):
    dfs(0, i)
    visited[i] = False # return 되면 현재 시작값 방문 표시 해제

print(0)


# 백준 14501 퇴사

n = int(input())
schedule = []
for _ in range(n):
    t, p = map(int, input().split())
    schedule.append([t,p])

def dfs(day, pay):
    global max_pay
    if day == n:
        max_pay = max(pay,max_pay)
        return

    t = schedule[day][0] #현재 날짜의 다음 상담 소요일
    p = schedule[day][1] #현재 날짜의 다음 상담 페이
    if day + t <= n:
        dfs(day + t, pay+p)
    dfs(day+1, pay)

max_pay = 0
for i in range(n):
    dfs(i, 0)

print(max_pay)

# 1463 1로 만들기
# Bottom-up 방식

n = int(input())
d = [0]*(n+1)
d[1] = 0
for i in range(2, n+1):
    d[i] = d[i-1] + 1
    if i%2 == 0 and d[i] > d[i//2] + 1:
        d[i] = d[i//2] + 1
    if i%3 == 0 and d[i] > d[i//3] + 1:
        d[i] = d[i//3] + 1
print(d[n])

# 모음사전
L, C = map(int, input().split())
words = list(input().split())
words.sort()
def solution(depth, index, memo):
    if depth == L:
        vo, co = 0, 0
        for w in memo:
            if w in 'aeiou':
                vo += 1
            else:
                co += 1
        if vo >= 1 and co >= 2:
            print(memo)
            return

    for i in range(index, C):
        solution(depth+1, i+1, memo + words[i])

solution(0, 0, "")


## 1759 암호 만들기

from collections import deque
n, m = map(int, input().split())
graph = [list(map(str, input().rstrip())) for _ in range(n)]
queue = set()

d_row = [0, -1, 0, 1]
d_col = [1, 0, -1, 0]

def solution():
    word = graph[0][0]
    queue.add((0, 0, word))
    global result
    while queue:
        x, y, word = queue.pop()
        result = max(result, len(word))
        for i in range(4):
            nx = d_row[i] + x
            ny = d_col[i] + y
            if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
                continue
            if graph[nx][ny] in word:
                continue
            queue.add((nx, ny, word+graph[nx][ny]))

result = 0
solution()
print(result)


##\ 5014 스타트링크
F, S, G, U, D = map(int, input().split())
visited = [-1] * (F + 1)

from collections import deque
def bfs():
    q = deque()
    q.append(S)
    visited[S] = 0
    while q:
        x = q.popleft()
        if x == G:
            return visited[x]
        for nx in (x+U, x-D):
            if 1 <= nx <= F and visited[nx] == -1:
                q.append(nx)
                visited[nx] = visited[x] + 1

    return "use the stairs"

print(bfs())

"""
브루트 포스
= 브루트 포스는 모든 경우의 수를 다 해보는 것이다.
중요한것은 모든 경우의수가 몇가지인지 먼저 알아보는게 중요하다
방법의 개수가 크면 시간초과가 나기때문에 모든 경우에 적용할수는 없구 경우의수가 작은 경우에만 가능하다.

    브루트 포스로 문제를 풀기 위해서는 다음과 같은 3가지 단계를 생각해볼수 있다.
    1. 문제의 간으한 경우의수를 계산해본다.
        - O(방법의 개수 * 시도하는 복잡도)
    2. 가능한 모든 방법을 다 만들어본다.
        -하나도 빠짐 없이 만들어야 한다.
        - 대표적으로 그냥 해보는 방법, for 문 사용, 순열 사용, 재귀 호출 사용, 비트마스크 사용이 있다. 재귀함수를 사용하는 방법이 중요하다.
    3. 각각의 방법을 이용해 답을 구해본다.(최소, 최대, 경우의수)
        - 문제에 나와있는 대로 답을 계산해본다.
    
모든 경우의 수를 다 구해야하는 문제는 재귀함수로!! for문, 비트마스크 방식을 대체 가능하다.
"""

### 일곱 난쟁이
dwarfs = [int(input()) for _ in range(9)]

# 풀이 1
import sys
n = 9
a = [int(input()) for _ in range(n)]
a.sort()
total = sum(a)
for i in range(0, n):
    for j in range(i+1, n):
        if total - a[i] - a[j] == 100:
            for k in range(0, n):
                if i == k or j == k: # 두명의 난쟁이 제외
                    continue
                print(a[k]) # 남은 7명의 난쟁이키를 print
            sys.exit(0) # 프로그램을 정상적으로 종료시키고 싶을 때

# 풀이 2

def dfs(depth, result):
    if depth == 7:
        if sum(result) == 100:
            for i in sorted(result):
                print(i)
            exit()
        else:
            return
    for next in dwarfs:
        dfs(depth+1, result.append(next))
        result.pop()


# 사탕게임

n = int(input())
graph = [list(map(str, input().rstrip())) for _ in range(n)]

d_row = [0, -1, 0, 1]
d_col = [1, 0, -1, 0]

result = 0
def count_str():
    max_candy = 0
    same_candy = 1

    # 행 체크
    for x in range(n):
        same_candy = 1
        for y in range(n - 1):
            if graph[x][y] == graph[x][y + 1]:
                same_candy += 1
            else:
                same_candy = 1
            # 최대 개수면 갱신
            if same_candy > max_candy:
                max_candy = same_candy

    # 열 체크
    for y in range(n):
        same_candy = 1
        for x in range(n - 1):
            if graph[x][y] == graph[x + 1][y]:
                same_candy += 1
            else:
                same_candy = 1
            # 최대 개수면 갱신
            if same_candy > max_candy:
                max_candy = same_candy

    return max_candy

for x in range(n):
    for y in range(n):
        for i in range(4):
            nx = d_row[i] + x
            ny = d_col[i] + y
            if nx < 0 or ny < 0 or nx > n - 1 or ny > n - 1:
                continue
            graph[x][y] = graph[nx][ny]
            graph[nx][ny] = graph[x][y]
            result = max(result, count_str())
            graph[x][y] = graph[nx][ny]
            graph[nx][ny] = graph[x][y]

print(result)


# 날짜 계산
## 범위 주의해!!!!!! 다시 풀기

E, S, M = map(int, input().split())
earth, sun, moon = 1, 1, 1
year = 1
while True:
    if (earth, sun, moon) == (E, S, M):
        print(year)
        exit()

    (earth, sun, moon, year) = (earth+1, sun+1, moon+1, year+1)

    if earth == 16:
        earth = 1
    if sun == 29:
        sun = 1
    if moon == 20:
        moon = 1

## 리모콘
# 쓰면서 이해하고 연습해

import sys

input = sys.stdin.readline
target = int(input())
n = int(input())
broken = list(map(int, input().split()))

# 현재 채널에서 + 혹은 -만 사용하여 이동하는 경우
min_count = abs(100 - target)

# 여기서 range를 N의 최대 범위인 500,000이 아닌 그 두 배 1,000,000로 해준 것은,
# 수빈이가 이동하려는 채널의 범위는 500,000 이하이지만 채널 자체는 무한대라는 점 때문이다.

for channel in range(1000001): # 갈수 있는 채널의 수
    channel = str(channel)

    for j in range(len(channel)):
        # 각 숫자가 고장났는지 확인 후, 고장 났으면 break
        if int(channel[j]) in broken:
            break

        # 고장난 숫자 없이 마지막 자리까지 왔다면 min_count 비교 후 업데이트
        elif j == len(channel) - 1:
            min_count = min(min_count, abs(int(channel) - target) + len(channel))

print(min_count)

## 토마토

from collections import deque
queue = deque()
m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

d_row = [0, -1, 0, 1]
d_col = [1, 0, -1, 0]

def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = d_row[i] + x
            ny = d_col[i] + y
            if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
                continue
            if graph[nx][ny] == 0:
                queue.append([nx, ny])
                graph[nx][ny] = graph[x][y] + 1


for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i, j])
bfs()
result= 0
flag = False
for row in range(n):
    if 0 in graph[row]:
        flag = True
        break
    result = max(result, max(graph[row]))

if flag:
    print(-1)
else:
    print(result-1)




## 1679 숨바꼭질

## 풀이 1 (런타임 에러 실패!!ㅠㅠ)
## 실패 원인
# 1. next 범위가 뒤에 있어서 범위 초과돼서 그런거임 if not visited[next] and 0 <= next <= 100000 ->  인덱스 에러 발생함
# 2. visited[next] = True 안해줘서
# 실수 하지마!!!!
## 수정하고 성공
# -> if 0 <= next <= 100000 and not visited[next]:
# visited[next] = True

from collections import deque
import sys
input=sys.stdin.readline

queue = deque()
n, m = map(int, input().split())

visited = [False] * 100001

def bfs():
    queue.append([n, 0])
    visited[n] = True
    while queue:
        now,cnt = queue.popleft()
        if now == m:
            print(cnt)
            break
        for next in (now-1, now+1, now*2):
            if not visited[next] and 0 <= next <= 100000:
                queue.append([next, cnt+1])
                visited[next] = True

bfs()

## 풀이2 (성공)

visited = [0] * 100001

def bfs():
    q = deque()
    q.append(n)

    while q:
        x = q.popleft()
        if x == m:
            print(visited[x])
            break
        for i in (x - 1, x + 1, x * 2):
            if 0 <= i <= 100000 and visited[i] == 0:
                visited[i] = visited[x] + 1
                q.append(i)

bfs()

## 영역 구하기

from collections import deque
n, m, k = map(int, input().split())
graph = [[0] * m for _ in range(n)]

################ 이 부분 계속 보고 이해하기###############
for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2): # 반대로 뒤집혀서 y가 행 역할하고 있음
        for j in range(x1, x2):
            graph[i][j] = 1
####################################################

d_row = [0, -1, 0, 1]
d_col = [1, 0, -1, 0]
def bfs(i, j):
    queue = deque()
    queue.append([i, j])
    graph[i][j] = 1
    cnt = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = d_row[i] + x
            ny = d_col[i] + y
            if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
                continue
            if graph[nx][ny] == 0:
                queue.append([nx,ny])
                graph[nx][ny] = 1
                cnt += 1

    return cnt

result = []
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            result.append(bfs(i, j))

print(len(result))
for i in sorted(result):
    print(i, end = " ")

## 1, 2, 3 더하기
def add_num(now, goal):
    if now > goal:
        return 0
    if now == goal:
        return 1
    cnt = 0
    for i in range(1, 4):
        cnt += add_num(now+i, goal)

    return cnt

t = int(input())
for _ in range(t):
    goal = int(input())
    print(add_num(0, goal))

# 이모티콘
# S개의 이모티콘을 만드는데 걸리는 시간의 최소값을 구하는 문제

# 각각의 연산 방법에 따라서
# 화면에 이모티콘 개수 S 개와 클립보드에 있는 이모티콘의 개수 C가 중요하다.

# 1: 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
# 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
# 3. 화면에 있는 이모티콘 중 하나를 삭제한다.

# 구현 코드 방식
# 1. 큐에 시작점을 넣고
# 2. while queue가 비어있지 않은동안
# 2-1. 큐에서 pop
# 2-2. x와 연결된 y를 모두 queue에 push

# 방문 여부를 체크하기 위해서는 연산이 2개 이니깐 visited을 이차원으로 만들어준다.
# visited[x][y] = -1 이면 방문안함
# visited[x][y] >= 0 이면 방문했고, 최소 시간을 저장해준다.

# 화면에 이모티콘은 1개다
# 할수 있는 연산
# 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
# 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
# 3. 화면에 있는 이모티콘 중 하나를 삭제

# 첫째 줄에 이모티콘을 n개 만들기 위해 필요한 시간의 최솟값을 출력한다.

# 방법
# 연산1의 방법: (S, C) -> (S, S) - 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
# 연산2의 방법: (S, C) -> (S+C, C) - 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
# 연산3의 방법: (S, C) -> (S-1, C) - 화면에 있는 이모티콘 중 하나를 삭제한다.

# 화면에 이모티콘 개수 = S 개
# 클립보드에 있는 이모티콘의 개수 = C

from collections import deque

n = int(input())
dist = [[-1] * (n + 1) for _ in range(n + 1)]
q = deque()
q.append((1, 0))
dist[1][0] = 0  # 초기화면에 이미 이모티콘 1개가 있음
while q:
    s, c = q.popleft()
    # 모든 방법을 다 해봐야행
    # !!!!!bfs 는 범위랑 방문 여부 무조건 체크!!!! 까먹지 말기!!!!!!
    if dist[s][s] == -1:  # 방문안했으면
        dist[s][s] = dist[s][c] + 1
        q.append((s, s))
    if s + c <= n and dist[s + c][c] == -1:
        dist[s + c][c] = dist[s][c] + 1
        q.append((s + c, c))
    if s - 1 >= 0 and dist[s - 1][c] == -1:
        dist[s - 1][c] = dist[s][c] + 1
        q.append((s - 1, c))
ans = -1
for i in range(n + 1):
    if dist[n][i] != -1:  # 방문한적 있으면
        if ans == -1 or ans > dist[n][i]:
            ans = dist[n][i]
print(ans)

# 숨바꼭질 3

# 1. 걷기: X + 1 또는 X-1로 이동(1초)
# 2. 순간이동: 2 * X 로 이동(0초)

# 덱을 사용해 순간이동은(가중치가 0) 덱의 앞에, 걷기(가중치가 1)는 덱의 뒤에 넣는다.
# 큐는 2가 필요. 현재 값과 다음 값을 넣을 큐 2개 필요
# 현재 위치값은 덱의 앞에
# 다음 위치값은 덱의 뒤에


## 퇴사

n = int(input())
schedule = [list(map(int, input().split())) for _ in range(n)]

def solution(day, pay):
    global max_pay
    if day == n:
        max_pay = max(max_pay, pay)
        return

    n_day = schedule[day][0] # 다음날짜 정의
    n_pay = schedule[day][1] # 다음페이 정의
    if day + n_day <= n:
        solution(day + n_day, pay + n_pay) # 재귀 호출할때 합한 값
    solution(day+1, pay)

max_pay = 0
for i in range(n):
    solution(i, 0)

print(max_pay)


## 숨바꼭질 4

from collections import deque
N, K = map(int,input().split())
visited = [False] * (100001)

def bfs(n):
    deq = deque()
    deq.append([n, 0,[n]])
    visited[n] = True

    if n > K:
        return n - K, [int(x) for x in range(n,K - 1,-1)]

    while deq:
        x, count, road = deq.popleft()
        if x == K:
            return count, road

        for a in [x - 1, x + 1, x * 2]:
            if 0 <= a <= 100000 and visited[a] == False:
                visited[a] = True
                r = road + [a] # r는 경로, road는 이미 리스트. 따라서 리스트 + 리스트 해줘야함.
                deq.append([a, count + 1, r])

ans_count, ans_road = bfs(N)

print(ans_count)
for path in ans_road:
    print(path,end=' ')


### 2206 벽부수고 이동하기

from collections import deque
queue = deque()
n, m = map(int, input().split())
graph = [list(map(int, input().rstrip())) for _ in range(n)]
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]

d_row = [0, -1, 0, 1]
d_col = [1, 0, -1, 0]

def bfs():
    queue = deque()
    queue.append([0, 0, 0])
    visited[0][0][0] = 1
    while queue:
        x, y, c = queue.popleft()
        if (x, y) == (n-1, m-1) :
            return visited[x][y][c]
        for i in range(4):
            nx = d_row[i] + x
            ny = d_col[i] + y
            if nx < 0 or ny < 0 or nx > n-1 or ny > m-1:
                continue
            if graph[nx][ny] == 0 and visited[nx][ny][c] == 0:
                visited[nx][ny][c] = visited[x][y][c] + 1
                queue.append([nx, ny, c])
            elif graph[nx][ny] == 1 and c == 0: # c 가 0일때만 가능, visited[nx][ny][c] = 0 은 안됨!!! 그래야 c + 1 = 1 이 가능
                visited[nx][ny][c+1] = visited[x][y][c] + 1
                queue.append([nx, ny, c+1])

    return -1

print(bfs())


### 벽부수고 이동하기 4

from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
n, m = map(int, input().split())
graph = [list(map(int, list(input()))) for _ in range(n)]
group = [[-1] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
group_size = []


def bfs(sx, sy): # 0 에 그룹 넘버를 배치
    g = len(group_size)
    q = deque()
    q.append((sx, sy))
    group[sx][sy] = g
    visited[sx][sy] = True
    cnt = 1
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx, ny = x + dx[k], y + dy[k]
            if 0 <= nx < n and 0 <= ny < m:
                if visited[nx][ny] == False and graph[nx][ny] == 0:
                    visited[nx][ny] = True
                    group[nx][ny] = g
                    q.append((nx, ny))
                    cnt += 1

    group_size.append(cnt)


for i in range(n):
    for j in range(m):
        if graph[i][j] == 0 and visited[i][j] == False:
            bfs(i, j)

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            print(0, end='')
        else:
            near = set() # 그룹 넘버가 두번 들어가는것을 방지
            for k in range(4):
                nx, ny = i + dx[k], j + dy[k]
                if 0 <= nx < n and 0 <= ny < m:
                    if graph[nx][ny] == 0:
                        near.add(group[nx][ny])
            ans = 1
            for g in near:
                ans += group_size[g]
            print(ans % 10, end='')
    print()

#######풀이 2
import sys
from collections import deque

r, c = map(int, sys.stdin.readline().rsplit())
visited = [[False for _ in range(c)] for _ in range(r)]
arr = [list(map(int, list(sys.stdin.readline().rstrip()))) for _ in range(r)]
graph = [[0 for _ in range(c)] for _ in range(r)]
d = ((0, 1), (-1, 0), (0, -1), (1, 0))

for i in range(r):
    for j in range(c):
        if arr[i][j] == 1:
            graph[i][j] = 1


def bfs(i, j):
    q = deque()
    q.append((i, j))
    cnt = 1
    ones = []

    while q:
        y, x = q.popleft()

        for i in range(4):
            nx = y + d[i][0]
            ny = x + d[i][1]

            if -1 < nx < r and -1 < ny < c:
                if visited[nx][ny]:
                    continue
                visited[nx][ny] = True

                if arr[nx][ny] == 0:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    cnt += 1

                else: # arr[nx][ny] == 1
                    ones.append((nx, ny))

    for x, y in ones: # 1인 애들은 다시 visited = False 로 변경
        visited[x][y] = False
        graph[x][y] += cnt # 그리고 계산했던 cnt 를 넣기
        if graph[x][y] >= 10:
            graph[x][y] %= 10 # 벽인 곳은 이동할 수 있는 칸의 개수를 10으로 나눈 나머지를 출력한다.


for i in range(r):
    for j in range(c):
        if arr[i][j] == 0:
            if not visited[i][j]:
                visited[i][j] = True
                bfs(i, j)

for i in range(r):
    print(''.join(map(str, graph[i])))



## 아기 상어

# 저장을 어떻게 할것인가
# 1. 물고기 -> 위치(=공간을의미), 크기(graph[r][c] = (r,c)에 있는 물고기의 크기)
# 2. 아기 상어 -> 위치, 크기 , 지금까지 먹은 물고기의 개수(= 경험치(exp), 크기가 변하면 0)
# 3 공간 -> 물고기&상어 각 칸, 빈칸
#
# 1. 상어가 먹을수있는 물고기를 찾고(가장 가까운 물고기를 먹어야하기때문에 bfs사용), 상어와 물고기 거리를 모두 구한다.
# 1-1. 상어와 물고기의 거리를 모두 구하고 그 중에서 최소를 찾는다.
# 이때 저장해야하는 값은 거리와 물고기의 위치이다.
# 2. 이동해서 먹는다
# 이 1, 2를 반복하면 된다.


from collections import deque
dx = [0,0,1,-1]
dy = [1,-1,0,0]
def bfs(graph, x, y, size):
    n = len(graph)
    ans = []
    visited = [[-1]*n for _ in range(n)]
    q = deque()
    q.append((x,y))
    visited[x][y] = 0
    while q:
        x,y = q.popleft()
        for k in range(4):
            nx,ny = x+dx[k],y+dy[k]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == -1:
                ok = False
                eat = False
                # 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다.
                if graph[nx][ny] == 0:
                    ok = True
                elif graph[nx][ny] < size: # 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
                    ok = True
                    eat = True
                elif graph[nx][ny] == size: # 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
                    ok = True
                if ok:
                    q.append((nx,ny))
                    visited[nx][ny] = visited[x][y] + 1
                    if eat:
                        ans.append((visited[nx][ny],nx,ny))
    if not ans:
        return None
    ans.sort()
    return ans[0]

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
x,y = 0,0
for i in range(n):
    for j in range(n):
        if graph[i][j] == 9:
            x,y = i,j
            graph[i][j] = 0
ans = 0
size = 2
exp = 0
while True:
    p = bfs(graph, x, y, size)
    if p is None:
        break
    dist, nx, ny = p
    graph[nx][ny] = 0
    ans += dist
    exp += 1
    if size == exp:
        size += 1
        exp = 0
    x,y = nx,ny
print(ans)

### 데스나이트 -- 다시 풀기!!!!꼭 다시 풀어!!!!

from collections import deque
dx = [-2,-2,0,0,2,2]
dy = [-1,1,-2,2,-1,1]
dist = [[-1]*200 for _ in range(200)]
n = int(input())
sx,sy,ex,ey = map(int,input().split())
q = deque()
q.append((sx,sy))
dist[sx][sy] = 0
while q:
    x,y = q.popleft()
    for k in range(6):
        nx,ny = x+dx[k],y+dy[k]
        if 0 <= nx < n and 0 <= ny < n:
            if dist[nx][ny] == -1:
                q.append((nx,ny))
                dist[nx][ny] = dist[x][y] + 1
print(dist[ex][ey])

## 로또

import itertools

while True:

    array = list(map(int, input().split()))

    k = array[0]
    S = array[1:]

    for i in itertools.combinations(S, 6):
        print(*i)

    if k == 0:
        exit()
    print()

## 1182번 부분순열의 합

from itertools import combinations
n, m = map(int, input().split())
num_list = list(map(int, input().split()))
cnt = 0
combi_list = []
for i in range(1, n+1): ####범위 중요해!!!!!!! 항상 범위 신중하게 생각해!!!!!!!!
    combi_list += list(combinations(num_list, i))

for j in combi_list:
    if sum(j) == m:
        cnt += 1

print(cnt)

### 14225 부분 수열의 합

import sys
from itertools import combinations

input = sys.stdin.readline

N = int(input())
a = list(map(int, input().split()))
a.sort()
ans = set([i for i in range(1, N*max(a) + 2)])
for i in range(1, N+1):
    for j in combinations(a, i):
        if sum(j) in ans:
            ans.discard(sum(j))
print(min(ans))


## 2203 수들의 합
# 투포인터

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

print(solution2(num_list))

# 6603 부분수열의 합(브루트포스, 조합, 재귀)

# 풀이1 - 조합
import itertools

while True:

    array = list(map(int, input().split()))

    k = array[0]
    S = array[1:]

    for i in itertools.combinations(S, 6):
        print(*i)

    if k == 0:
        exit()
    print()

# 풀이2 - 재귀

