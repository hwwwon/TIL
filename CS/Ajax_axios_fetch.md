## Ajax

> Asynchronous JavaScript And XML

- 자바스크립트를 이용해 클라이언트와 서버 간의 데이터를 주고받는 비동기 HTTP 통신
- XMLHttpRequest(XHR) 객체를 이용해서 전체 페이지가 아닌 필요한 데이터만 불러올 수 있음

- 장점
  - Jquery를 통해 쉽게 구현 가능
  - Error, Success, Complete의 상태를 통해 실행 흐름 조절 가능
- 단점
  - Jquery를 사용해야 간편하고 호환성이 보장됨
  - Promise 기반이 아님



<br>

## axios

> Node.js와 브라우저를 위한 Promise API를 활용하는 HTTP 통신 라이브러리

- 비동기로 HTTP 통신을 할 수 있으며 return을 promise 객체로 해주기 때문에,  response 데이터를 다루기 쉬움
- 장점
  - response timeout (fetch에는 없는 기능) 처리 방법 존재
  - Promise 기반으로 만들어졌기 때문에 데이터 다루기 편리
  - 브라우저 호환성이 뛰어남
- 단점
  - 사용을 위해 모듈 설치 필요 (npm install axios)



<br>

## fetch

> ES6부터 들어온 JavaScript 내장 라이브러리

- 장점

  - 자바스크립트의 내장 라이브러리이므로 별도로 import할 필요 없음
  - Promise 기반으로 만들어졌기 때문에 axios와 마찬가지로 데이터 다루기가 쉬움
  - 내장 라이브러리이기 때문에 업데이트에 따를 에러 방지 가능

- 단점

  - 지원하지 않는 브라우저 존재 (IE11...)
  - 네트워크 에러 발생 시 response timeout이 없어서 기다려야함
  - JSON으로 변환해주는 과정 필요
  - 상대적으로 axios에 비해 기능이 부족

  

<br>

## 요약

- 간단한 통신의 경우엔 fetch를 사용
- 기능이 좀 더 필요하다면 axios를 사용
- React-Native와 같이 업데이트가 잦은 경우에는 fetch가 내장 라이브러리이기 때문에 좀 더 안정적일 수 있음

