> 2022년 05월 23일



## Java API

> 주요 기능들을 미리 구현한 클래스 라이브러리로 묶어 놓은 패키지들
>
> 쉽고 빠르게 자바 프로그램을 개발하는데 도움을 줌
>
> import 패키지.클래스;  => import 단축키  ctrl + shift + o

- 하나의 패키지에 있는 여러 클래스를 사용할 경우
  - import 패키지.*

- util 패키지

  - **Scanner**  : Scanner 객체가 키보드로부터 입력한 값을 바이트로 읽어들여 데이터 형에 맞춰 변환하여 반환

  ```java
  import java.util.Scanner;
  
  Scanner sc = new Scanner(System.in);
  
  int num = sc.nextInt(); //입력받은 값을 변수에 저장
  String name = sc.next();
  char a = sc.next().charAt(0);
  
  // '\n까지 포함한 라인 전체를 문자열로 반환'
  // 따라서 위에 다른 next***메서드를 사용하면 sc.nextLine()을 한 번 사용하여 버퍼를 비워줘야 함 
  String address = sc.nextLine(); 
  
  // nextByte(), nextShort(), nextLong(), nextFloat(), nextDouble()
  ```

  

  - **Random** 

  ```java
  import java.util.Random;
  
  Random r = new Random();
  
  int rNum = r.nextInt(10)+1; //1~10범위의 수 중에서 랜덤 숫자 생성
  // for문 사용해서 랜덤 숫자 생성 횟수 지정 가능
  ```

  ##### + java.lang 패키지 : Math 

  > JDK에서 제공하는 최상위 클래스
  >
  > import 호출하지 않아도 됨

  ```java
  //랜덤 숫자 생성과정
  // (1) 0 < 랜덤숫자 < 1 범위에서 실수 형태의 값으로 랜덤 숫자 발생
  // (2) 정수 부분의 값 추출: 곱하기 10
  // (3) 정수타입으로 변환 : (int)
  // (4) 1~10 사이의 정수 발생: 시작 숫자를 지정: +1(기본값 지정: 범위의 시작 값)
  // double rNum = Math.random()
  int rNum = (int)(Math.random()*10)+1;
  ```

  

  

- text 패키지

  - **DecimalFormat**

  ```java
  import java.text.DecimalFormat;
  
  //소수점 자리수
  DecimalFormat df = new DecimalFormat("0.00");
  //천단위 구분
  DecimalFormat df = new DecimalFormat("#,###");
  DecimalFormat df = new DecimalFormat("#,###.00");
  
  System.out.println(df.format(변수명));
  ```

  ##### + 형식화된 출력 : printf()
  
  > 지시자를 통해 변수의 값을 여러가지 형식으로 변환하여 출력하는 기능
  >
  > 지시자는 값을 어떻게 출력할 것인지 지정
  
  ```java
  String store = "편의점";
  double discount = 4.875655;
  int day = 3;
  System.out.printf("%s에서 %d일간 %.2f퍼센트 할인",store,day,discount);
  // 편의점에서 3일간 4.88퍼센트 할인
  ```
  
  | 지시자 |                    설명                     |
  | :----: | :-----------------------------------------: |
  |   %b   |            Boolean 형식으로 출력            |
  |   %d   |     10진(decimal) 정수의 형식으로 출력      |
  |   %f   | 부동 소수점(floating-point)의 형식으로 출력 |
  |   %c   |                 문자로 출력                 |
  |   %s   |                문자열로 출력                |
  |   %o   |       8진(octal) 정수의 형식으로 출력       |
  | %x, %X |   16진(hexa-decimal) 정수의 형식으로 출력   |
  | %e, %E |    지수(exponent) 표현식의 형식으로 출력    |
  |   %n   |                 줄바꿈(\n)                  |
  
  

