## DB 설계
- 사용자의 요구를 분석하고 컴퓨터에 저장할 수 있는 DB의 구조에 맞게 변경 후 DBMS로 구현
- 일반 사용자들이 사용할 수 있는 것

## 설계 순서
1. 요구사항 분석
2. 개념적 데이터설계
3. 논리적 데이터설계
4. 물리적 데이터설계
5. 구현

<br>

## 데이터 모델링의 개념
- 데이터 모델링
	- 현실 세계에 존재하는 개체의 구성 요소가 가지는 값(데이터)을 컴퓨터 세계에 표현하기 위한 현실세계와 컴퓨터 세계 사이의 변환 과정
	- 현실 세계의 복잡한 개념을 단순화 / 추상화 시켜서 DB화 하는 기법
	- 프로젝트 분석과 설계 단계에서 가장 중요한 작업 중 하나

- 데이터 모델링 과정에서 수행되는 작업
	- 데이터 베이스 내에 존제하는 데이터 타입 정의
	- 데이터 사이의 관계 규정
	- 데이터의 의미와 데이터에 가해진 제약조건 명시

- 데이터 모델링 과정

	![image](https://github.com/hwwwon/TIL/blob/master/img/%EB%AA%A8%EB%8D%B8%EB%A7%81.png)

<br>

## 개념적 모델링
- 현실 세계를 추상적인 개념인 개체 타입과 관계 타입으로 표현
- 요구사항 분석 결과를 토대로 업무의 핵심적인 개념을 구분하고 개체(entity) 추출, 관계 정의
- ER 다이어그램 (ERD: Entity Relationship Diagram)이라는 표준화된 그림으로 표현

<br>

## 논리적 모델링
- 실제 데이터베이스로 구현하기 위한 모델을 만드는 과정
- 개념적 모델링에서 산출된  ERD를 사용하고자하는 DBMS에 맞게 사상(맵핑: mapping)하는 과정
- 논리적 모델링 과정 중 수행 작업
	- 개념적 모델링에서 추출하지 않았던 상세 속성 모두 추출
	- 정규화 수행
	- 데이터 표준화 수행

<br>

## 물리적 모델링
- 작성된 논리적 모델을 실체 컴퓨터의 저장 장치에 저장하기 위한 물리적 구조를 정의하는 과정
- 데이터베이스가 최적의 성능을 낼 수 있도록 DBMS의 특성에 맞게 저장구조 정의

-----------
<br>

![image](https://github.com/hwwwon/TIL/blob/master/img/%EB%AA%A8%EB%8D%B8%EB%A7%812.png)