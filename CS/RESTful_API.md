## RESTful API

> REpresentational State Trasfer
>
> 웹을 이용할 때 제약조건들을 정의하는 소프트웨어 아키텍쳐 스타일

- HTTP URL을 통해 자원(Resource)를 명시하고  HTTP Method(GET, POST, PUT, PATCH, DELETE)를 통해서 **해당 자원(URL)에 대한 CRUD(Create, Read, Update, Delete)를 적용하는 것**

- HTTP 장점을 살리고자 하는 통신규약

- 규약을 바탕으로 리소스 중심의 설계 및 기능에 맞는 HTTP Method 사용하여 설계된 API

- HTTP Method 

  - GET : 지정된 URL에서 리소스의 표현을 조회

  - POST : 지정된 URL에 신규 리소스를 생성
  - PUT : 지정된 URL에 리소스를 생성하거나 업데이트
  - PATCH :  리소스의 부분 업데이트
  - DELETE : 지정된 URL의 리소스를 제거

<br>

### REST 특징

> REST 아키텍쳐에 적용되는 6가지 제한 조건

- 인터페이스 일관성 : 일관적인 인터페이스로 분리되어야 함
- 무상태 : 각 요청 간 클라이언트의 context, 세션과 같은 상태 정보를 서버에 저장하지 않음
- 캐시 처리 가능 : 클라이언트는 응답을 캐싱할 수 있어야함, 캐시를 통해 대량의 요청을 효율적으로 처리 가능
- 계층화 : 클라이언트는 대상 서버에 직접 연결되어있는지, Proxy를 통해 연결되었는지 알 수 없음
- Code on Demand :  자바 애플릿이나 자바스크립트의 제공을 통해 서버가 클라이언트를 실행시킬 수 있는 로직을 전송하여 기능을 확장시킬 수 있음
- 클라이언트 / 서버 구조 : 아키텍처를 단순화 시키고 작은 단위로 분리 함으로써 클라이언트 서버의 각 파트가 독립적으로 구분되어 서로간의 의존성 줄임

<br>

### REST 구성요소

1. 자원(Resource) : HTTP URL
2. 자원에 대한 행위 : HTTP Method
3. 자원에 대한 표현 (Representations)

<br>

--------------

### REST API 설계 Rules및 예시

- 소문자 사용
- 언더바(_) 대신 하이픈(-) 사용
- 마지막에 슬래시를 포함하지 않음 (**슬래시("/")는 계층 관계를 나타낼 때 사용**)
- 행위를 포함하지 않음
  - 틀린 예시 : `POST http://cocoon1787.tistory.com/users/post/1`
  - 알맞은 예시 : `DELETE http://cocoon1787.tistory.com/users/1`

- 파일 확장자는 URL에 포함시키지 않음
  - 틀린 예시 : ` http://cocoon1787.tistory.com/users/photo.jpg`
  - 알맞은 예시 :  `GET http://cocoon1787.tistory.com/users/photo  `
  - ` HTTP/1.1 Host: cocoon1787.tistory.com Accept: image/jpg`
  - URL에 메시지 body 내용의 포맷을 나타내기 위한 파일 확장자를 적지 않음, 대신 Accept header를 사용
- 자원에는 형용사, 동사가 아닌 **명사** 사용
- 컨트롤 자원을 의미하는 경우 예외적으로 **동사** 사용