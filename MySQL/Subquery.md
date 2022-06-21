## Subquery

> 하위 질의 또는 부속 질의라고 함
>
> 하나의 SQL문 안에 다른 SQL문의 중첩

- 쿼리 1차 수행한 다음, 반환값(결과)을 다음 쿼리에 포함시켜서 사용
- 다른 테이블에서 가져온 데이터로 현재 테이블에 있는 정보를 찾거나 가공할 때 사용



#### 조인 VS 서브쿼리

- 조인
  - 여러 테이블의 데이터를 모두 합쳐서 계산
  - 카티전곱 후 조건에 맞는 행 검색 (예. 15 x 3 = 45행 반환 후 조건 검색)
  - 카티전 곱 연산 + select 연산
- 서브쿼리
  - 필요한 데이터만 찾아서 제공
  - 15행을 검색한 결과를 가지고 3행에서 검색 (총 18행 검색)
  - 경우에 따라 조인보다 성능이 더 좋을 수 도 있지만  대량의 데이터에서 서브 쿼리를 수행할 때 성능이 더 나쁠 수 있음



------------------

### subquery

- 구성 및 형식

  - 메인쿼리와 서브쿼리로 구성

    ```mysql
    SELECT SUM(bsQty) from booksale 
    where clientNo = (select clientNo from client where clientName = '홍길동');
    ```

    

  - **단일 행** 서브쿼리

    - 서브쿼리 결과 값이 단일 행
    -  **=** 연산자 사용

  ```mysql
  select bsDate, bsQty
  from booksale
  where clientNo = (select clientNo from client
  where clientName = '홍길동');
  -- 홍길동이라는 이름을 가진 사람이 1명만 있는 경우에 사용 가능
  -- 동명이인이 있는 경우 단일 행이 아니기 때문에 오류 발생
  
  select bookName, bookPrice from book
  where bookPrice = ( select max(bookPrice) from book);
  -- 가장 비싼 도서의 도서명과 가격
  ```

  

  

  - **다중 행** 서브쿼리

    - 서브쿼리 결과 값이 여러 행
    - IN, ANY, ALL, EXISTS 연산자 사용

  ```mysql
  -- 한 번도 도서를 주문한 적이 없는 고객의 고객번호, 고객명 출력
  select clientNo, clientName from client 
  where clientNo not in (select clientNo from booksale);
  ```



- 서브쿼리 결과가 단일행인지 다중행인지 확실치 않을 경우 in 사용하면 오류 없음



- 서브쿼리 연산자

| 연산 |               연산자               | 반환 행 |
| :--: | :--------------------------------: | :-----: |
| 비교 |        =, >, <, >=, <=, !=         |  단일   |
| 집합 |             IN, NOT IN             |  다중   |
| 존재 |         EXISTS, NOT EXISTS         |  다중   |
| 한정 | ALL(모두), ANY/SOME(최소 하나라도) |  다중   |



### IN과 EXISTS의 차이

- IN
  - 서브쿼리에서 조건에 해당되는 행의 열을 비교하여 값 확인
  - 서브 쿼리의 결과 값을 메인 쿼리에 대입하여 조건 비교 후 결과 출력
  - NULL값 제외, 공백 포함
  
  ```mysql
  select clientNo, clientName from client 
  where clientNo in (select clientNo from booksale);
  -- 도서를 구매한 적이 있는 고객의 고객번호, 고객명
  ```
  
  
  
- EXISTS
  - 서브 쿼리에서 조건에 해당되는 행의 존재 여부만 확인(TRUE / FALSE 반환)
  - IN에 비해 성능 좋음
  - EXISTS 키워드 앞에 속성명, 수식 등 올 수 없음
  - WHERE 절에 외래키 제약조건 지정
  - NULL 값 포함 : NULL 값도 결과에 포함 (IN은 NULL 값이 결과에 포함되지 않음)
  - 공백 포함
  
  ```mysql
  select clientNo, clientName from client 
  where not exists (select clientNo from booksale where client.clientNo = booksale.clientNo);
  -- 한 번도 주문한 적이 없는 고객의 고객번호, 고객명
  ```
  
  



### ALL / ANY, SOME

- 관계 연산자 뒤에 위치

- ALL

  - 검색 조건이 서브 쿼리의 결과의 모든 값에 만족하면 참이되는 연산자
  - 조건 > ALL (서브 쿼리 결과)

  ```mysql
  select clientNo, bsNo, bsQty from booksale where bsQty > all (select bsQty from booksale where clientNo = '2');
  -- 검색 조건이 서브 쿼리의 결과의 모든 값에 만족하면 참이 되는 연산자
  -- 2번 고객이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구입한 고객의 고객번호, 주문번호, 주문 수량
  ```

  

- ANY, SOME

	- 검색 조건이 서브 쿼리의 결과 중에서 하나 이상에 만족하면 참이되는 연산자
	- 조건 > ANY (서브 쿼리 결과)
	
	```mysql
	select clientNo, bsNo, bsQty from booksale where bsQty > any (select bsQty from booksale where clientNo = '2');
	-- 최소 한 번이라도
	-- 2번 고객보다 한 번 이라도 더 많은 주문을 한 적이 있는 고객의  고객번호, 주문번호, 주문수량
	```
	
	

-----------------------------



### 서브 쿼리 유형

| 명칭             | 사용위치  | 동의어               | 설명                                         |
| ---------------- | --------- | -------------------- | -------------------------------------------- |
| 스칼라 서브 쿼리 | SELECT 절 | 열이름 위치에 표기   | 단일 열 반환                                 |
| 인라인 뷰        | FROM 절   | 테이블명 위치에 표기 | 결과를 뷰(view) 형태로 반환 (가상 테이블)    |
| 중첩 서브 쿼리   | WHERE 절  |                      | 술어와 같이 사용 결과를 한정시키기 위해 사용 |



- 스칼라 서브 쿼리 (Scalar Subquery)

  - **SELECT 절에서 사용**
  - 결과 값을 **단일 열의** 스칼라 값으로 반환
  - 스칼라 값이 들어갈 수 있는 모든 곳에서 사용가능
  - **일반적으로 SELECT문과 UPDATE문에서 사용**

  ```MYSQL
  select clientNo , (select clientName from client where client.clientNo = booksale.clientNo) as "고객명", sum(bsQty) as "총주문"
  from booksale group by clientNo;
  -- 고객별 총 주문 수량 출력
  ```

  

- 인라인 뷰 (Inline View) 부속 질의

  - **FROM 절에서 사용**
  - 즉, 테이블명 대신 인라인 뷰 서브쿼리 결과 (가상 테이블) 사용
  - 쿼리 결과로 반환되는 데이터는 다중 행, 다중 열이어도 상관없음
  - **가상의 뷰 형태로 제공**
  - 개발 중 뷰가 필요한 모든 경우에 뷰를 생성하면 관리할 양이 너무 많아짐
  - 트랜잭션 관리나 성능상의 문제 발생할 수 있는 경우에 인라인 뷰 사용

  ```mysql
  select bookName, bookPrice, sum(bsQty) as "총판매수량" , sum(bookPrice) as "총판매액" 
  from (select bookNo, bookName, bookPrice from book where bookPrice >= 25000) book, booksale
  where book.bookNo = booksale.bookNo
  group by book.bookNo order by 총판매액 desc;
  -- 도서 가격이 25,000원 이상인 도서에 대해 도서별로 도서명, 도서가격, 총판매수량, 총판매액
  -- 총판매액 기준 내림차순 정렬
  ```

  
