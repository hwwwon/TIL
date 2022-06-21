## DDL(Data Definition Language)

> 데이터 정의어
>
> CREATE / ALTER / DROP 

- DB / Table 이나 관계의 구조를 생성하는데 사용

### CREATE

- DB 및 객체 생성

- 테이블, 도메인, 뷰, 인덱스, 스키마 구조 정의

- CREATE TABLE

  - 테이블 구성
  - 속성(열)과 속성(열)에 관한 제약 정의
  - 기본키 : PRIMARY KEY
  - 외래키 : FOREIGN KEY

- 기본 형식

  ```mysql
  CREATE TABLE 테이블명(
  	열이름 데이터타입 [,.. 제약조건] 
  );
  -- 제약조건
  -- [NOT NULL] [UNQUE] [DEFAULT]
  -- [FOREIGN KEY 열 이름 REFERENCES 테이블(기본키)]
  -- [CONSTRAINT명] 제약조건 이름
  ```


- 제약조건

|         표기 형식          |                   설명                    |
| :------------------------: | :---------------------------------------: |
|          NOT NULL          |            빈 값 허용하지 않음            |
|          DEFAULT           |              기본값으로 설정              |
|        PRIMARY KEY         |                기본키 설정                |
|        FOREIGN KEY         |  외래키 설정(참조값 이외의 값 입력 불가)  |
|         REFERENCES         | 외래키가 참조할 테이블(부모 테이블 ) 설정 |
|           UNIQUE           |  중복값이 없도록 설정 (대체키 설정 의미)  |
|           CHECK            |        특정 내용의 제약 조건 설정         |
| ON DELETE / ON UPDATE 옵션 | 참조되는 테이블의 행 삭제 및 갱신 시 옵션 |

- **기본 스키마 설정 **

  - CREATE SCHEMA 스키마명

     DEFAULT CHARACTER SET utf8;
    // 기본 문자형식 지정

- **DEFAULT 스키마 설정**

  - SQL문에 작성 : **use 스키마명;**
  - 해당 스키마 마우스 우 클릭 : Set as a Default Schema 선택

- **기본키(PRIMARY KEY)** 제약 조건

  - 유일성
  -  NOT NULL

  ```mysql
  -- 기본키 제약조건 설정 방법1
  CREATE TABLE product(
  	prdNo CHAR(10) NOT NULL PRIMARY KEY,  -- 기본키 속성에 직접 지정
      prdName VARCHAR(30) NOT NULL,
      prdPrice INT,
      prdCompany VARCHAR(30)
  );
  
  -- 기본키 제약조건 설정 방법2
  CREATE TABLE product2(
  	prdNo CHAR(10) NOT NULL,
      prdName VARCHAR(30) NOT NULL,
      prdPrice INT,
      prdCompany VARCHAR(30),
      PRIMARY KEY(prdNo) -- 기본키로 속성 지정
  );
  
  -- 기본키 제약조건 설정 방법3
  CREATE TABLE product3(
  	prdNo CHAR(10) NOT NULL,
      prdName VARCHAR(30) NOT NULL,
      prdPrice INT,
      prdCompany VARCHAR(30),
      CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo) -- 제약조건 명 지정
  );
  -- 복합키 사용시 각 속성에 기본키 지정하면 안됨
  -- 복합키 : CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo, prdName)
  ```

- **외래키(FOREIGN KEY)** 제약 조건

  - 참조하고자하는 테이블의 기본키 속성
  - 주의 !
    - 테이블 생성 순서 주의(참조되는 기본키를 가진 테이블이 우선)
    - 외래키를 사용할 때 참조되는 테이블의 속성 값을 먼저 지정
    - 참조되는 테이블의 기본키를 삭제할 수 없음 (참조 무결성)
    - 참조되는 테이블을 삭제하고 싶을 경우 외래키를 가진 테이블을 먼저 삭제 한 후 참조되는 테이블 삭제


  ```mysql
  CREATE TABLE department(
  	departCode char(10) not null  primary key,
  	departName varchar(30) not null,
      departCall char(20) not null
  );
  
  CREATE TABLE student(
  	stdNo char(10) not null,  
      stdName varchar(20) not null,
      stdYear char(5),
      stdAddress varchar(40) not null,
      departCode char(20) not null,
      constraint PK_student_stdNo primary key(stdNo),
      constraint FK_student_department foreign key (departCode) 
      references department(departCode)
      );
  ```

- CHAR() : 고정 길이 문자  VARCHAR() : 가변길이문자




-------

### ALTER

>  테이블에 대한 정의 변경
>
>  새로운 열 **추가,** 특정 열의 디폴트 값 **변경,** 특정 열 **삭제** 등
>
>  제약조건이나 키에 대한 변경 가능

- 기본 형식

  - ALTER TABLE 

  |    표기 형식     |                 설명                 |
  | :--------------: | :----------------------------------: |
  |       ADD        |               열 추가                |
  |  RENAME COLUMN   |          열의 **이름** 변경          |
  |      MODIFY      |      열의 데이터 **형식** 변경       |
  |      CHANGE      | 열의 **이름**과 데이터 **형식** 변경 |
  |       DROP       |          여러 개의 열 삭제           |
  |   DROP COLUMN    |               열 삭제                |
  | DROP PRIMARY KEY |             기본키 삭제              |
  | DROP CONSTRAINT  |            제약조건 삭제             |

- 추가 (ADD)

```mysql
-- 열 추가
alter table  테이블명 add 속성명 제약조건;
alter table board add boradNo varcher(20);

-- 여러개의 열 추가
alter table 테이블명 add(속성명1 제약조건, 속성명2 제약조건, ...);
alter table board add(boardName varchar(20), boardDate date);

-- 제약조건 추가
alter table department add constraint PK_department_dptCode primary key(dptCode); -- 기본키 제약조건
 -- check 제약조건 : 주의!! 기존 데이터가 새로 추가하는 제약조건에 위배되는지 확인
alter table book3 add check (bookPrice > 1000);
```

- 열의 이름 변경(RENAME) -  데이터 타입 적으면 안됨 (오류)

```mysql
alter talbe  테이블명 rename column 기존 속성명 to 새로운 속성명;
alter table student rename column stdCall to stdTel;
```

- 변경(수정) (MODIFY)

```mysql
-- 데이터 형식 변경
alter table student modify stdAge int;

-- 열의 이름과 데이터 형식 변경
alter table 테이블 명 change 기존 속성명 새로운 속성명 데이터 형식;
alter table student change stuName stdName varchar(30);

-- 제약조건 변경 : null 허용으로 변경
alter table student modify stdName varchar(20) null;

alter table product modify prdName varchar(20),
					modify prdMaker varchar(30),
                    modify prdColor varchar(10),
                    modify ctgNo varchar(10);
```


- 삭제 (DROP)

```mysql
  -- 열 삭제
  alter table 테이블명 drop column 속성명;
  -- 여러개의 열 삭제
  alter table 테이블명 drop 속성명1, drop 속성명2, drop 속성명3, ...;
  -- 제약조건 및 키 삭제
  alter table student drop constraint FK_std_department;
  alter table department drop primary key;
```


- 자동 증가 : 고유성을 위해 PK를 int 타입으로 겹치지 않게 인덱스를 계속 올림

  - AUTO_INCREMENT   -- 속성 값을 자동으로 증가
  - AUTO_INCREMENT = 100  -- 기본값 100 부터 증가
  - SET @@AUTO_INCREMENT_INCREMENT = 3  -- 3씩 증가

  ```mysql
  create table board (
  	boradNo int AUTO_INCREMENT not null primary key,
      boardTitle varchar(30) not null,
      boardAuthor varchar(20),
      boardContnet varchar(200) not null
  );
  
  alter table board auto_increment = 100;
  set @@auto_increment_increment =3;
  ```
  
- cascade : 참조하는 테이블의 튜플이 삭제되면 관련 튜플도 모두 삭제되고, 속성이 변경되면 속성 값도 모두 변경

    ```mysql
    alter table student add constraint FK_student_department
        foreign key (dptCode) references department(dptCode)
        on delete cascade;
    ```




- check 제약조건 추가 / 삭제 / 수정
    - 삭제 시 제약조건 이름 필요
    - 제약조건 확인하는 방법으로 제약조건 이름 확인

#### 	+  테이블 확인 및 제약조건 확인

```mysql
-- 테이블의 구조 확인
describe 테이블명;
-- 테이블 전체 확인
select * form 테이블명;
-- 제약조건 확인 ,자동으로 생성된 키 이름 확인 가능
select * from information_schema.table_constraints
where table_schema = "스키마 이름" and table_name = "테이블 이름";
```






-------

### DROP

-  DB 및 객체 삭제

```mysql
/*
	테이블 삭제
		- drop table;
        - 테이블 구조와 데이터 모두 삭제
        - (데이터만 삭제 시 DML의 delete 문 사용)
	테이블 삭제 시 주의 
		- 외래키 제약 조건이 설정되어 있는 기준 테이블 삭제시 오류 발생
        - 외래키 제약 조건이 설정되어 있는 테이블 먼저 삭제 후 
        - 외래키 제약조건 삭제 후
        - 기준 테이블 삭제 가능
        
	* 테이블 삭제 시 외래키 제약조건 확인 할 필요 없도록 설정 : 바로 삭제되도록 
		set foreign_key_checks  = 0;
        - 외래키 제약조건 검사 해제하고 테이블 바로 삭제
        
	* 외래키 제약조건 검사하도록 재설정
		- set foreign_key_checks  = 1;
*/

-- publisher 테이블 삭제 : 외래키 제약조건 위배 오류
drop table publisher;

-- 테이블 삭제 시 외래키 제약조건 확인 할 필요 없도록 설정 : 바로 삭제되도록 
set foreign_key_checks  = 0;

-- 외래키 제약조건 검사ㅏ도록 재설정
set foreign_key_checks  = 1;
```

