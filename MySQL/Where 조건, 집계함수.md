## WHERE 조건

|         종류          |        연산자        |                          설명 / 예                           |
| :-------------------: | :------------------: | :----------------------------------------------------------: |
|         비교          | =, <, >, <=, >=, !=  |                값의 크기를 비교하여 질의 검색                |
|         범위          |       BETWEEN        | 검사 값이 기술된 두 값 사이에 속하는지 검사하여 질의 처리(이상, 이하) |
|     리스트에 포함     |      IN, NOT IN      | 검사 값이 주어진 값의 리스트에 속하는지 여부 검사 price IN (10000, 20000, 30000) |
|         NULL          | IS NULL, IS NOT NULL |                        price IS NULL                         |
|         논리          |       AND, OR        |             단순 탐색 조건을 결합하여 질의 처리              |
| 패턴 매칭 문자열 검색 |         LIKE         |             문자열의 일부가 일치하는 데이터 검색             |



### 패턴 매칭 (LIKE)

| 와일드카드 문자 |               설명               |     예     |
| :-------------: | :------------------------------: | :--------: |
|        %        |  0개 이상의 문자를 가진 문자열   | LIKE '홍%' |
|        _        | 단일 문자(수 만큼의 문자로 구성) | LIKE '__'  |

| 문자열 연산 예 |                            설명                            |
| :------------: | :--------------------------------------------------------: |
|     '홍%'      |               '홍'으로 시작하는 문자열 검색                |
|     '%길%'     | '길'을 포함하는 문자열 ('길' 앞, 뒤에 아무 문자나 와도 됨) |
|     '%동'      |                   '동'으로 끝나는 문자열                   |
|     '____'     |    4개의 문자로 구성된 문자열 (밑줄문자 1개가 1개 문자)    |



---------





## 집계함수

> 여러 튜플을 집계한 하나의 결과를 출력하는 것

- SUM() : 합계
- AVG() : 평균
- COUNT(속성명) : 선택된 열의 행 수 (널 값은 제외)
- COUNT(*) : 전체 행의 수
- MAX() : 최대
- MIN() : 최소

```mysql
-- 열 이름으로 한글도 가능
select sum(bookStock) as "총 재고량" from book;

-- 열 이름으로 작은 따옴표도 사용 가능
select sum(bookStock) as '총 재고량2' from book;

-- 열 이름에 공백이 들어 있지 않으면 따옴표 없어도 됨
select sum(bookStock) as 총재고량3 from book;

select max(bsQTY) as "최대 주문수량", min(bsQTY) as "최소 주문수량" from bookSale;

select count(*) as "총 판매 건수" from bookSale;

select count(clientHobby) as "취미" from client;

-- null과 공백 제외
select count(clientHobby) as "취미 수" from client where clientHobby not in (''); 
select count(clientHobby) as "취미 수" from client where clientHobby != ''; 
```