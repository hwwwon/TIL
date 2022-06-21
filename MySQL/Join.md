## Join

> 여러 개의 테이블을 결합하여 조건에 맞는 행 검색

- 종류
  - Inner join (내부 조인) : 가장 많이 사용, inner 생략 가능
    - 공통되는 열이 있을 때
    - 공통 속성의 **속성 값이 동일한 튜플만 반환**
    - **조인 조건 : 기본키 == 외래키**
  - Outer join (외부 조인)
    - 공통되는 열이 없을 때
    - 공통된 속성을 매개로 하는 정보가 없더라도 버리지 않고 릴레이션에 표시
    - 값이 없는 대응 속성에는 NULL 값을 채워서 반환
    - 좌측 외부 조인 (left outer join) : 좌측 릴레이션의 정보 유지
    - 우측 외부 조인 (right outer join) : 우측 릴레이션의 정보 유지
    - 완전 외부 조인 (full outer join) : 두 릴레이션의 모든 정보 유지
    - mysql에서는 full outer join 지원하지 않음 : left join과 right join을 union해서 사용



-----------

### Inner join

- 기본 형식

  ```mysql
  select 열리스트 from 테이블명1
  inner join 테이블명2 on 조인조건(기본키 = 외래키);
  
  select client.clientNo, client.clientName, booksale.bsQty from booksale join client on client.clientNo = booksale.clientNo;
  ```

- 테이블명 대신 별칭(Alias) 사용

  ```mysql
  select C.clientNo, C.clientName, BS.bsQty from booksale BS join client C on C.clientNo = BS.clientNo;
  ```

- 3개의 테이블 결합 : 조인 조건 2개

  ```mysql
  -- order by 사용
  -- 주문일 오름차순 정렬 (2번째 속성명)
  
  select C.clientName, BS.bsDate, B.bookName, B.bookPrice, BS.bsQty, B.bookPrice * BS.bsQty as "주문액" from booksale Bs
  inner join client C on C.clientNo = Bs.clientNo
  inner join book B on B.bookNo = Bs.bookNo 
  order by 2;
  
  -- 주문액 내림차순 정렬
  -- 공백(띄어쓰기) 없는 경우 따옴표를 사용하지 않고 정렬 사용가능
  -- 따옴표 사용 시 정렬 적용 안됨
  select C.clientName, BS.bsDate, B.bookName, B.bookPrice, BS.bsQty, B.bookPrice * BS.bsQty as 주문액 from booksale Bs
  inner join client C on C.clientNo = Bs.clientNo
  inner join book B on B.bookNo = Bs.bookNo 
  order by 주문액 desc;
  ```





---------

### Outer join

```mysql
-- 좌측 외부 조인
-- 고객 중에서 한 번도 구매한 적이 없는 고객 출력
select C.clientNo ,C.clientName
from client C left outer join booksale BS on C.clientNo = BS.clientNo
where Bs.bsNO is null order by C.clientNo;

-- 우측 외부 조인
-- 한 번이라도 주문한 적이 있는 고객의 번호, 이름 출력
-- 중복된 경우 한번만 출력
select distinct C.clientNo, C.clientName 
from client C right outer join booksale BS on C.clientNo = BS.clientNo order by C.clientNo;

-- 완전 외부 조인
select * from client C left join booksale BS on C.clientNo = BS.clientNo

union 

select * from client C right join bookSale Bs on C.clientNo = BS.clientNo;
```

