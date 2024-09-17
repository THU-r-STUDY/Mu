# [백준 1931_1](https://www.acmicpc.net/problem/1931). Task Scheduling

## ✏️ 문제 설명
* 하나의 작업에는 시작 시각, 종료 시각이 주어져 있음
* 최대한 많은 수의 작업을 할당하는 문제

## ✏️ Solution
1. 입력값을 2차원 배열 `tasks`에 입력받는다.
   0번째 열은 시작시각(`startTime`), 1번째 열은 종료시각(`finTime`)
2. 종료시각에 대해 `tasks`를 오름차순으로 정리한다.(TimSort)
   이 때 `Arrays.sort` 메서드 사용
3. `int lastFin = 0`을 선언한다.
4. `tasks`를 순회하며 아래와 같은 연산을 수행한다.
   * 현재 `index`의 `startTime`이 `lastFin`보다 크거나 같으면
   * `lastFin`을 현재 `index`의 `finTime`으로 변경하고
   * `count(소스 코드에서는 allocatedTasksIndex)`를 하나씩 늘린다.

## ✏️ 복잡도 분석
```
for(int i = 0; i < N; i++) {

    tasks[i][0] = sc.nextInt();  // 시작 시간 입력
    
    tasks[i][1] = sc.nextInt();  // 종료 시간 입력   
    
}
```


👉 입력처리: O(N)


```
Arrays.sort(tasks, (a, b) -> Integer.compare(a[1], b[1]));
```

👉 정렬: O(N log N)


```
for(int i = 0; i < tasks.length; i++) {


    if(tasks[i][0] >= lastFin) {
    
        lastFin = tasks[i][1];
        
        allocatedTasks[allocatedTasksIndex++] = i;
        
    }
    
}
```
👉 회의 선택: O(N)

  ### 전체 시간 복잡도: O(N log N)
