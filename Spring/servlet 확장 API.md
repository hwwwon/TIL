## Servlet 포워드

> 하나의 서블릿에서 다른 서블릿이나 JSP와 연동하는 방법

- 요청에 대한 추가 작업을 다른 서블릿에게 수행하게 함
- 요청에 포함된 정보를 다른 서블릿이나 JSP가 공유할 수 있음
- 요청에 정보를 포함시켜서 다른 서블릿에 전달 가능
- 모델 2 개발 시 서블릿에서 JSP로 데이터를 전달하는 데 사용됨

### 여러가지 포워드 방법

1. redirect
   - sendRedirect() 메서드 사용
   - sendRedirect("포워드 할 서블릿 또는 JSP");
2. Refresh
   - addHeader() 메서드 사용
   - response.addHeader("Refresh, 경과시간(초); url= 요청할 서블릿 또는 JSP");
3. location
   - location 객체의 href 속성 이용
   - location.href='요청 할 서블릿 또는 JSP';
4. dispatch
   - 일반적인 포워딩 기능 지칭
   - forward() 메서드 사용
   - RequestDispatcher dis = request.getRequestDispatcher("포워드 할 서블릿 또는 JSP");
   - dis.forward(request, response);

- redirect, refreash, location 방법은 웹 브라우저를 거쳐 다른 서블릿이나 JSP에게 요청하는 방법
- dispatch 방법은 서블릿에서 클라이언트를 거치지 않고 바로 다른 서블릿에게 요청하는 방법





