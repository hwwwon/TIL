> 2022년 05월 22일



## Java 특징

- 플랫폼 독립적(cpu나 운영체제에 상관없이 실행)
- WORA(Write Once Run Anywhere)
  - 이식성이 높은 이유 : JVM(자바가상머신)
  - 컴파일된 자바코드가 바이트 코드형태의 클래스 파일로 생성되고 cpu나 OS에 맞는  JVM이 실행됨
- 진정한 의미의 객체 지향 언어(클래스, 상속, 다형성, 캡슐화 등)
- multi thread 지원 (비동기)
- 동적 로딩(Dynamic Loading) 지원
- Garbage Collector
- 메모리 자동으로 관리
- 막강한 오픈 소스 라이브러리 풍부



---------



## 자바 응용프로그램 종류

- 데스트톱 : eclipse
- 애플릿(Applet) : 웹페이지에 내장되어 실행(브라우저), JVM필요
- 서블릿(Servlet)
  - 서버에서 실행되는 서버용 자바 프로그램으로, 웹서버에 의해 실행 제어
  - 애플릿이나 자바스크립트 코드와 통신
  - DB나 다른 서버와 연동하여 대규모 복잡한 응용프로그램 구현에 사용
- 모바일 : Java ME



-----------



## 자바 개발 환경

### 1. JDK (Java Development Kit) 

>  자바 응용 프로그램을 개발하고 실행하는 총체적 환경

- 컴파일러
- JVM (자바 가상 기계, Java Virtual Machine) 
- JRE (Java Run-time Enviroment)

### 2. 이클립스(Eclipse)

- IDE (자바 통합 개발환경, Integrated Development Enviroment)



----------



## 자바 개발 도구

- JDK의 bin 디렉터리에 exe 파일로 포함
- javac : 자바 소스를 바이트 코드로 변환하는 컴파일러
- java : 자바 응용프로그램
- javadoc : HTML 형태의 API 도큐먼트 생성
- jar : 자바 클래스 파일을 압축한 JAR 파일 생성 관리
- jdb : 실행 중 오류를 찾는데 사용하는 디버거



----------



## 자바 패키지(Package)

- 자바에서 **서로 관련된 클래스들을** 분류하여 묶어놓은 것
- 패키지 안의 클래스를 사용하는 2가지 경우
  1. 같은 패키지의 다른 java 파일에서 만든 클래스 사용 - 사용하고자 하는 클래스의 객체 생성해서 멤버를 사용
  2. 다른 패키지에 있는 클래스 사용 -  **import** 하여 사용
- 클래스 작성 시 패키지 선언을 하지 않는 경우 default package에 속하게 됨
- 사용 이유 : 계층구조 관리, 접근제한, 동일한 이름의 클래스 다른패키지에서 사용, 높은 소프트웨어 재사용성



--------



## 자바 실행

>  자바 응용프로그램의 실행은 public인 main()부터 시작

```java
package ch01.sec01; //패키지명

public class className{ //패키지에 생성된 클래스명
    public static void main(String[] args){
        
    }
}
```

- publilc : 다른 클래스에서 main() 메소드에 접근허용(실행 시 JVM이 호출 할 수 있도록 접근 허용)
- static :  객체 생성(인스턴스) 없이 호출 가능
  - main()가 포함된 클래스는 먼저 실행되므로 이 클래스는 객체가 생성되기 전에 JVM에게 호출되야함  따라서,  static 사용
- void : return 값이 없음을 의미, 작업 수행하고 그냥 종료
- 하나의 클래스에 main()는 하나만 존재
- 클래스마다 main() 존재 할 수 있지만 동일한 .java 파일인 경우 public main() 클래스는 하나만 존재 (실행의 시작점 이기 때문에)
- 이 public 클래스 이름이 파일 명이 됨
- String[] args : 매개변수로 문자열 배열 받음