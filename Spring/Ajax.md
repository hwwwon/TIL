# Ajax (Asynchronous JavaScript and XML)
> 자바스크립트를 이용해서 비동기식으로 XML을 이용하여 클라이언트와 서버간 통신하는 방식

- 최근에는 XML보다 JSON을 더 많이 사용함
- 자바스크립트 라이브러리 중 하나
- 브라우저가 가지고 있는 XMLHttpRequest 객체를 이용해서 전체 페이지를 새로 고치지 않고 페이지 일부만을 로드하는 기법
- 비동기식이란 여러가지 일이 동시적으로 발생한다는 뜻으로, 서버와 통신하는 동안 다른 작업을 할 수 있음

<br><br>

## Ajax의 동작방식
1. 요청: 브라우저가 서버에 정보 요청(브라우저는 Ajax 요청을 담당하는 XMLHttpRequest 객체를 구현)
  - 서버는 응답으로 데이터를 전달함 (XML, JSON)
2. 응답 : 브라우저는 콘텐츠를 처리하여 페이지에 추가

<br><br>

## jQuery를 이용한 Ajax의 이점과 사용이유
- 이점
  - Ajax의 기본 메소드를 이용하면 서버와 통신이 복잡한데 이를 간단하게 만들어줌
  - 크로스브라우징 문제를 jQuery가 알아서 해결해주어 여러가지 편리 제공
 
- 이유
  - 단순하게 웹에서 무언가를 부르거나 데이터를 조회하고 싶은 경우, 페이지 전체를 새로고침하지 않기 위해 사용
  - 일반적으로 HTTP 프로토콜은 단방향 통신이라 자원낭비와 시간낭비를 겪을 수 있는데 Ajax는 페이지 전체가 아닌 일부만 갱신하도록 XMLHttpRequest 객체를 통해 서버에 요청함
  - JSON이나 XML형태로 필요한 데이터만 받아 갱신하기 때문에 그 만큼의 자원과 시간 절약가능

<br><br>

## 기본적인 구조

```javascript
$.ajax ({
  // URL은 필수 요소이므로 반드시 구현해야 하는 Property입니다.
  url	: "url", // 요청이 전송될 URL 주소
  type	: "GET", // http 요청 방식 (default: ‘GET’)
  async : true,  // 요청 시 동기화 여부. 기본은 비동기(asynchronous) 요청 (default: true)
  cache : true,  // 캐시 여부
  timeout : 3000, // 요청 제한 시간 안에 완료되지 않으면 요청을 취소하거나 error 콜백을 호출.(단위: ms)
  data  : {key : value}, // 요청 시 포함되어질 데이터
  processData : true, // 데이터를 컨텐트 타입에 맞게 변환 여부
  contentType : "application/json", // 요청 컨텐트 타입 
  dataType    : "json", // 응답 데이터 형식 (명시하지 않을 경우 자동으로 추측)
  beforeSend  : function () {
    // XHR Header를 포함해서 HTTP Request를 하기전에 호출됩니다.
  },
  success : function(data, status, xhr) {
    // 정상적으로 응답 받았을 경우에는 success 콜백이 호출되게 됩니다.
    // 이 콜백 함수의 파라미터에서는 응답 바디, 응답 코드 그리고 XHR 헤더를 확인할 수 있습니다.
  },
  error	: function(xhr, status, error) {
        // 응답을 받지 못하였다거나 정상적인 응답이지만 데이터 형식을 확인할 수 없기 때문에 
        // error 콜백이 호출될 수 있습니다.
        // 예를 들어, dataType을 지정해서 응답 받을 데이터 형식을 지정하였지만,
        // 서버에서는 다른 데이터형식으로 응답하면  error 콜백이 호출되게 됩니다.
  },
  complete : function(xhr, status) {
    // success와 error 콜백이 호출된 후에 반드시 호출됩니다.
    // try - catch - finally의 finally 구문과 동일합니다.
  }
});
```
> 출처: https://devyj.tistory.com/1