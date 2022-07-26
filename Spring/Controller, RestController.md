# @Controller / @RestController

<br><br>

## @Controller
- 뷰에 표시될 데이터가 있는 Model 객체를 생성
- 매핑되는 뷰를 반환
- @ResponseBody를 사용하여 HTTP Response Body에 데이터를 담아 요청 완료 가능(데이터 반환)
<br><br>

## @RestController
> @Controller와 @ResponseBody의 조합
- RESTful 웹서비스를 보다 쉽게 개발 할 수 있도록 Spring 4.0에서 추가됨
<br><br>

## @Controller 와 @RestController 차이점
- @Controller의 역할은 Model 객체를 만들어 데이터에 담고 View를 찾음
- @RestController는 단순히 객체만을 반환하고 객체 데이터는 JSON 또는 XML 형식으로 HTTP 응답에 담아서 전송
<br><br>

## REST(REpresentational State Transfer)
- 분산 하이퍼미디어 시스템을 위한 소프트웨어 아키텍처의 한 형식
- REST 스타일을 따르는 웹서비스를 RESTful 웹서비스라고 함
- REST 아키텍처 스타일은 모든 서버가 네트워크를 통해 다른 서버와 통신 할 수 있도록 함
- 네트워크 아키텍처 원리(자원을 정의하고 자원에 대한 주소를 지정하는 전반적인 방법)의 모음
- HTTP
- 3가지 구성요소
  - 자원(Resource) : URI
  - 행위(Verb) : HTTP Method (CRUD)
  - 표현(Representation) : 응답받는 결과 html, xml, text, json, rss 등
- URI에서 자원만을 표시하고 행위는 포함되지 않아야함
  
<br><br>

### URI URL
- URI : Uniform Resource Identifier
- URL : Uniform Resource Locator




