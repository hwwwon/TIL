> 2022년 5월 25일



## class 상속 (Inheritance)

> 한 클래스에서 정의된 멤버 필드와 메소드를 다른 클래스가 물려받는 것
>
> **자식 클래스가** 부모 클래스를 선택해서 **필드와 메소드를** 물려받음

- 부모 클래스의 private 접근 필드와 메소드는 상속이라도 제외

- 부모 클래스 와 다른 패키지의 경우 default 접근을 갖는 부모 클래스의 필드와 메소든 상속이라도 제외

- Java 상속의 특징

  -  다중 상속을 지원하지 않음
  - 즉, extends 다음에는 오직 한개의 클래스만 사용

  ```java
  class Child extends Parent{ //상속 받은 자식 클래스
      
  }
  ```

  - 상속 횟수 제한 없음
  - 계층 구조의 최상위에 있는 클래스는 Java API로 제공되는 java.lang.Object 클래스
  - 따라서 모든 클래스는 Object 클래스로 부터 상속 받는 것(상속 표현 없어도 자동으로 받음)



### 상속에서의 생성자 실행

> 상속 받았을 때 부모 클래스의 생성자와 자식 클래스의 생성자 실행 순서

- 자식 클래스의 인스턴스가 생성되었을 때 부모와 자식의 생성자 모두 실행됨(자동 호출)
- 실행 순서
  1. 부모클래스의 생성자가 먼저 실행
  2. 자식 클래스 생성자 실행
- 자식 클래스의 생성자가 **호출되면** 다음으로 부모 클래스의 생성자가 **호출되고**
- 부모클래스가 호출 된 후 부모 클래스 생성자가 **먼저 실행된** 후 순서대로 자식 생성자가 **실행됨**



### 상속에서의 생성자 호출 (자식 인스턴스 생성 시 )

> 부모 클래스와 자식 클래스에 여러개의 생성자가 각각 있을 수 있음

1. 자식 인스턴스 생성 시, 상속과 관련된 클래스 중 하나라도 아무 생성자도 정의되지 않은 경우
   - 컴파일러에 의해 자동으로 기본 생성자 호출
   - 기본생성자에는 매개변수 받을 수 없으므로 매개변수를 넘겨주면 오류가 남
2. 생성자에 매개변수가 있는 경우
   - 호출된 매개변수의 조건에 맞는 생성자가 호출됨
   - 짝을 이루는 생성자가 없으면 오류 발생

#### 생성자의 짝을 맞추기 위해

> 자식 클래스와 부모 클래스이 생성자의 매치를 위해 **super()** 메소드 사용가능

- super() 메소드 : 부모 클래스의 생성자 호출, 생성자 안에서 맨 첫번째 줄에 입력해야 함

- super 레퍼런스 : 부모 클래스를 가리키는 레퍼런스

- 방법

  - 자식 클래스의 생성자에게 매개 변수 전달 시, 부모 클래스의 생성자에게 보낼 매개 변수도 같이 보내고
  - 자식 클래스의 생성자가 받아서 부모 클래스이 생성자에게 필요한 만큼의 매개변수 전달 
  - 그 방법으로 super() 메소드를 사용함

  ```java
  private String position;
  	//매개 변수가4개 있는 생성자
  	//3개는 부모클래스에게 전달, 1개는 자신이 사용
  	public Manager(String empNo, String name, String part, String position) {
  		//부모 클래스의 생성자 호출하면서 필요한 개수만큼 전달
  		super(empNo,name,part);
  		this.position = position;
  	}
  ```

  
