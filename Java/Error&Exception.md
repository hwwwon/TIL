## 오류의 종류

- 에러 (Error)
  - 컴파일 에러
  - 런타임 에러
- 예외 (Exception)



## Error

- 하드웨어의 잘못된 동작 또는 고장으로 인한 오류
- 에러가 발생하면 프로그램 종료
- 정상 실행 상태도 돌아갈 수 없음
- 컴파일 에러
  - 문법에 맞지 않을 경우 발생
  - 컴파일 시 처리 가능
  - 이클립스에서 코드 작성하고 저장하는 순간 컴파일이 되면서 오류가 확인됨
- 런타임 에러
  - 프로그램 실행 중 발생하는 오류
  - 프로그램 강제 종료
  - 잘못된 메모리 접근, 논리오류, 사용자의 잘못된 입력 등



--------------------------



## Exception

- 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인한 오류
- 예외가 발생되면 프로그램 종료
- **예외처리를(Execption Handling)** 통해 정상 실행 상태로 돌아갈 수 있음
- 오류 중에서 대처 가능한 오류



### 예외의 종류

- **일반 예외 (Exception)**

  - 컴파일 체크
  - 예외 처리 코드가 없으면 컴파일 오류 발생

- **실행 예외 (RuntimeException)**

  - 예외 처리 코드를 생략하더라도 컴파일이 되는 예외
  - 경험에 따른 예외 처리 코드 작성 필요함

  

### 자바에서 예외 관리

- 자바에서는 예외를 클래스로 관리함
- JVM은 프로그램을 실행하는 도중에 예외가 발생하면 해당 예외 클래스 객체를 생성하여 예외 처리 코드에서 예외 객체를 이용할 수 있도록 함
- 모든 예외 클래스들은 java.lang.Exception 클래스를 상속 받음



### 실행 예외

- NullPointerException
  - 객체 참조가 없는 상태
  - null  값을 갖는 참조 변수로 객체 접근 연산자인 도트(.)를 사용했을 때 발생
  - String data = null;
  - System.out.println(data.equals("자바"));
- ArrayIndexOutOfBoundsException
  - 배열에서 인덱스 범위 초과하여 사용할 경우 발생
- NumberFormatException
  - 숫자 처리에서 발생하는 예외[]
- ClassCastException
  - 타입 변환이 되지 않을 경우 발생
  - 타입 변환 발생
    - 상위 클래스와 하위 클래스 간 발생
    - 구현 클래스와 인터페이스 간에 발생
    - 자동 타입변환 / 강제 타입변환
    - instanceof 연산자로 확인



### 예외처리 코드 (try ~ catch)

- 예외 발생 시 프로그램 종료되지 않고 정상 실행을 유지할 수 있도록 처리하는 코드
- 일반 예외 : 반드시 처리해야 컴파일 가능
- 실행 예외
  - 컴파일러가 체크해주지 않으며 개발자의 경험에 의해 작성
  - 일부는 이클립스가 주의를 주기 때문에 미리 알 수 있음
- try ~ catch ~ finally 블록을 이용해서 예외처리 코드 작성

```java
try{
    
    //예외가 발생할 수 있는 실행 문장

}catch(처리할 예외 타입 선언){
    
    //예외 처리 문장
    //예외가 발생하지 않으면 이 부분은 수행되지 않음

}finally{ //생략 가능
    //예외 발생 여부와 상관없이 무조건 실행되는 문장
}
```

- try ~ catch 구문 삽입 방법
  1. 컴파일러가 제시할 경우
     - 빨간 줄 위에 마우스 대고 Surround with try / catch 선택
  2. 직접 삽입할 경우
     - 메뉴 Source / Surround with try / catch
     - 예외 처리할 문장 모두 드래그해서 선택 후 지정



### 다중 catch

> 예외 별로 예외 처리 코드 다르게 구현

- catch 블록 여러 개 포함
- **단 하나의 catch 블록만 수행됨**
  - try블록에서 여러 예외가 동시에 발생하지 않고 문장 순서대로 수행하면서 첫 번째 하나의 예외가 발생하면
  - 즉시 실행을 멈추고 **해당 catch 블록으로 이동**



#### catch 순서

- 예외를 처리할 catch 블록은 **위에서부터 차례대로 검색**
- 만일, 상위 클래스의  catch 블록이 위에 있다면
- 하위 클래스의 catch 블록은 실해되지 않음
- 이유 : 하위 예외는 상위 예외를 상속했으므로 상위 타입만으로도 적용되기 때문에
- Exception은 모든 예외처리를 포함한 최상위 예외타입으로 다중 catch문을 사용하지 않고 Exception catch블록만 적어도 됨
- 따라서, 순서는 하위 클래스 catch 블록을 위에 작성





----------------------------------------





### throws

- 메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할
- 메소드 선언부 끝에 추가하여 작성

```java
//리턴타입 메소드명(매개변수) throws 예외클래스1, 예외클래스2,...{

}
```

- 발생할 수 있는 예외 종류별로 throws 뒤에 나열하는 것이 일반적이지만
- throws Exception만으로 간단한 예외를 떠넘길 수 있음
- throws가 붙어 있는 메소든 반드시 try 블록 내에서 호출되어야 함



### 사용자 정의 예외와 예외 발생

- 사용자 정의 예외 클래스 선언
  - 자바 표준 API에서 제공하지 않는 예외 처리
  - 개발자가 직접 정의해서 처리
  - 애플리케이션 서비스와 관련된 예외 
  - 예 : 잔고 부족 예외, 계좌 이체 실패 예외, 회원 가입 실패 예외, ...



- 선언 방법 : 예외 클래스를 상속 받는 클래스로 생성
  1. 컴파일러가 체크하는 일반 예외로 선언 (Exception 상속)
  2. 컴파일러가 체크하지 않는 실행 예외 선언 (RuntimeException 상속)

```java
public class XXXException extends [Exception | RuntimeException]{
    public XXXException(){}
    public XXXExcption(String message){super(message);}
}
```



-------------------------------------------------------------



#### getMessage()

- 예외 발생시킬 때 생성자 매개값으로 전달해서 예외 객체 내부에 저장된 메시지 리턴
- 원인 세분화하기 위해 예외 코드 포함
- catch절에서 활용



#### printStack Trace()

- 예외 발생 코드를 추적한 내용을 모두 콘솔에 출력
- 프로그램 테스트 시 오류 찾을 때 유용하게 활용 가능

