## 다익스트라 알고리즘

> DP를 활용한 최단 경로 탐색 알고리즘

- 특정한 정점에서 다른 모든 정점으로 가는 최단 경로를 기록

- 다익스트라를 구현하기 위해 저장할 두 가지

  - 해당 정점까지의 최단 거리
  - 정점을 방문했는지 여부 저장

- 다익스트라 알고리즘 순서

  - 최단 거리 값은 무한대 값으로 초기화

  ```java
  for(int i = 1; i <= n; i++){
      distance[i] = Inteager.MAX_VALUE;
  }
  ```

  - 시작 정점의 최단 거리는 0. 그리고 시작 정점을 방문처리함

  ```JAVA
  distance[start] = 0;
  visited[start] = true;
  ```

  - 시작 정점과 연결된 정점들의 최단 거리 값을 갱신

  ```java
  for(int i = 1; i <= n; i++){
      if(!visited[i] && map[start][i] != 0){
          distance[i] = map[start][i];
      }
  }
  ```

  - 방문하지 않은 정점 중 최단 거리가 최소인 정점을 찾음

  ```java
  int min = Integer.MAX_VALUE;
  int midx = -1;
  for(int i = 1; i <= n; i++){
      if(!visited[i] && distance[i] != Integer.MAX_VALUE){
          if(distance[i] < min){
              min = distance[i];
              midx = i;
          }
      }
  }
  ```

  - 찾은 정점을 방문 체크로 변경 후 해당 정점과 연결된 방문하지 않은 정점의 최단 거리 값을 갱신

  ```java
  visited[midx] = true;
  for(int i = 1; i <= n; i++){
      if(!visited[i] && map[midx[i] != 0){
          if(distance[i] > distance[midx] + map[midx][i]){
              distance[i] = distance[midx] + map[midx][i];
          }
      }
  }
  ```

  - 모든 정점을 방문 할 때까지 4 ~5번 반복



- 다익스트라 적용 시 유의점
  - 인접 행렬고 구현하면 시간 복잡도는 O(N^2)
  - 인접 리스트로 구현하면 시간 복잡도는 O(N*logN)
    - 선형 탐색으로 시간 초과가 나는 문제는 인접 리스트로 접근해야함 (우선순위 큐)
  - 간선의 값이 양수 일 때만 가능