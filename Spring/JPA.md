## JPA

> Java Persistence API

- 자바 진영에서 ORM (Object-Relational Mapping) 기술 표준으로 사용되는 인터페이스 모음
- 자바 어플리케이션에서 관계형 데이터 베이스를 사용하는 방식 정의한 인터페이스
- 인터페이스이기 때문에 Hibernate, OpenJPA 등이 JPA를 구현함

</br>

####  ORM

- 애플리케이션 Class와 RDB(Relational DataBase)의 테이블을 매핑
- 자동으로 영속화 해줌
- 장점
  - SQL문이 아닌 Method를 통해 DB 조작가능 (개발자는 비즈니스 로직 구성에만 집중 가능)
  - Query와 같이 필요한 선언문, 할당 등의 부수적인 코드가 줄어듬
  - 객체에 대한 코드를 별도로 작성하여 코드의 가독성을 높임
  - 객체 지향적인 코드 작성이 가능해 생산성 증가
  - 매핑 정보가 Class로 명시되어 ERD를 보는 의존도를 낮출 수 있고 유지보수 및 리팩토링에 유리
- 단점
  - 프로젝트 규모가 크고 복잡하여 설계가 잘못된 경우, 속도 저하 및 일관성을 무너뜨리는 문제 발생 가능
  - 복잡하고 무거운 Query는 속도를 위해 별도의 튜닝이 필요하기 때문에 결국 SQL문을 써야할 수도 있음
  - 학습 비용이 비쌈

</br>

#### JPA 사용 이유

- 반복적인 CRUD SQL을 처리해줌
- 개발자는 어떤 SQL이 실행될지 생각만하면 되고, 쉽게 예측 가능
- 네이티브 SQL이라는 기능을 제공해서 관계 매핑이 어렵거나 성능에 대한 이슈가 우려되는 경우 SQL 직접 작성해 사용 가능
- 객체 중심적 개발 가능 (생산성 향상, 유지보수 수월)
- 패러다임의 불일치 해결 (java와 DB에서 연관 관계 해결)
  - Class에서 또다른 Class Type을 필드 변수로 가지고 있음

![연관관계](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcizFYS%2Fbtq0UbOH4oy%2Fk3F6DvtQsdl0kh2Qb5rkGk%2Fimg.png)

- JPA는 수정 메소드를 제공하지 않지만, 데이터 수정 시 매핑된 객체(테이블 데이터)를 조회해서 값을 변경한 후 커밋하면 DB 서버에 UPDATE문을 전송하여 UPDATE 실행
- Spring Data JPA 프레임워크

</br>

![JPA](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbFmukB%2Fbtq0qA03yL7%2FD2Sys7i6RaEBAd6cK0fuFk%2Fimg.png)