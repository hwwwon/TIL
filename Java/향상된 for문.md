> 2022년 05월 23일



## 향상된 for문

> 배열 및 컬렉션의 항목 요소를 순차적으로 처리
>
> 인덱스를 사용하지 않고 바로 항목요소 반복

- for(변수 : 배열){...};
- 변수에 **배열 항목 하나씩 저장** 해서 사용

```java
int scores = {60,70,80,90,98};
int sum = 0;
for(int score : scores){
    sum += score;
}
// int score[0] = 60;
// int score[1] = 70;
// int score[2] = 80;
// int score[3] = 90;
// int score[4] = 98;
```

