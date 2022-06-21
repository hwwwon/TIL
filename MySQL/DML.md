## DML (Data Manipulation Language)

>데이터 조작어 (데이터 입력 / 수정 / 삭제 / 검색)
>
>INSERT, UPDATE, DELETE, SELECT

### INSERT

- 테이블에 새로운 행을 삽입하는 명령어

```mysql
insert into 테이블명 (열이름 리스트) values(값리스트);
insert into student(stdNo, stdName, stdYear, dptNo) values("2022011","홍길동",4,"1");

insert into 테이블명 values(값리스트);
-- 모든 열에 값 저장
```

 #### + Data Import

- CSV 파일을 읽어서 테이블 생성 및 데이터 입력

- product.csv

- 파일 임포트 시 제약조건 없어짐
  - prdNo를 varchar(10) not null로 변경 후
  
  - 기본키 제약조건 추가 : PK_product_prdNo
  
    ```mysql
    alter table product 
    	add  constraint PK_product_prdNo 
        primary key (prdNo);
    ```
  
    



--------



### UPDATE

- 특정 열의 값을 수정하는 명령어

- 조건에 맞는 행을 찾아서 열의 값 수정

  ```mysql
  update 테이블명 set 열 = 값 where 조건;
  update product set prdName = 'UHD TV' where prdNo='5'; 
  ```

  

---------



### DELETE

- 테이블에 있는 기존 행을 삭제하는 명령어

  ```mysql
  delete from 테이블명 where 조건;
  delete from product where prdName = '그늘막 텐트';
  
  -- 테이블의 모든 행 삭제
  delete from 테이블명;
  delete from product; -- table을 삭제하는것은 아님
  ```

  

-----------



### SELECT

- 테이블에서 조건에 맞는 행 검색

- 기본 형식

  ```mysql
  -- 작성 순서
  SELECT [ALL(*)|DISTINCT] 열이름 리스트 FROM 테이블명
  [WHERE 조건]
  [GROUP BY 열이름]
  [HAVING 그룹조건]
  [ORDER BY 열이름 (ASC/DESC)] -- 오름차순(default) 내림차순
  ```

- 중복제거

  - DISTINCT
  - 속성값이 중복되는 것이 있으면 한 번만 출력



---------



### GROUP BY

- GROUP BY 속성
- 그룹 질의를 기술할 때 사용
- 특정 열로 그룹화한 후 각 그룹에 대해 한 행씩 질의 결과 생성
- SELECT절에서는 GROUP BY에서 사용한 열과 집계 함수만 나올 수 있음

```mysql
select * from book order by bookName desc;

-- 상위 N개만 출력 : limit N
select * from book 
order by bookName limit 5;

-- 또는 offset 0 설정 (offset 시작 위치 ) : 첫 번째부터 시작
select * from book
order by bookName limit 5 offset 0;

-- 또는 limit 시작, 출력 개수
select * from book
order by bookName limit 0, 5; -- 첫 번째부터 5개

-- 2차 정렬
-- 재고 수량이 동일한 경우, 저자명으로 오름차순 2차 정렬
select bookAuthor, bookName, bookStock from book order by bookStock desc, bookAuthor asc; 
-- 1차 재고수량 내림차순, 2차 저자 오름차순 정렬

```



#### + ascii,  substring

```mysql
-- 영어 대문자 A ~ Z :  65~ 90
-- 영어 소문자 a ~ z : 97 ~ 122
-- 숫자 0 ~ 9 : 48 ~ 57

-- 한글 - 영문- 숫자 순서로 출력 (내림차순)alter
select * from book
order by (case when ascii(substring(bookName, 1))between 48 and 57 then 3 when ascii(substring(bookName, 1)) < 122 then 2 else 1 end), bookName desc;

-- substring(속성명(문자열), 시작지점) 시작 1~
```



### HAVING

- HAVING 검색조건
- GROUP BY 절에 의해 구성된 그룹들에 대해 적용할 조건 기술
- SUM, AVG, MAX, MIN, COUNT 등의 집계 함수와 함께 사용(조건으로 집계함수만 사용)
- 반드시 GROUP BY 절과 같이 사용
- WHERE 절보다 뒤에 작성



