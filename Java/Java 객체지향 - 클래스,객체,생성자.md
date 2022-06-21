> 2022년 05월 23일



## 객체 지향 (OOP, Object Oriented Programming)

> 캡슐화, 상속, 다형성

### 1. 클래스

> 사용자 정의 자료형

- 인스턴스(객체) 생성 해서 사용
- 객체: 필드(속성)와 메소드가 있음
- 객체와 인스턴스 
  - 객체 : 일반적인 용어
  - 인스턴스 : 특정 클래스의 객체 강조 (해당 클래스의 인스턴스)
- 소스파일에 포함된 클래스는 컴파일 할 때 각 클래스(.class)로 나눠 짐 



### 2. 객체

- 참조변수: 객체를 참조하는 변수

- 생성

  - 참조 변수 선언과 동시에 객체 생성(메모리공간 확보)

  ```java
  // 클래스명 참조변수 = new 클래스();
  
  Student std = new Student();
  ```

- 생성된 객체에 접근하여 사용

  - 참조변수(객체).필드
  - 참조변수(객체).메소드

- 필드, 메소드 선언 형식

```java
// 접근 제어자 데이터타입 변수명
private int a;

// 접근제어자 반환형 메소드명(매개변수){
//	return ; 반환 값이 있는 경우
//}
public int sum(int x, int y){
    return x+y;
}
// 반환 값 없는 경우
public void sum(int x, int y){
    
}

//매개변수는 있어도 되고 없어도 됨 메소드 기능에 따라 선택
```



### +가변인자 (...)

> 매개변수로 가변인자를 받는 경우

- 매개 변수 전달 시 고정 개수가 아니라 전달된 값의 수에 따라 자동으로 **배열** 생성

```java
public class Calculator{
    
    public int sum(int ... valuse){ //전달 받은 값의 수에 따라 자동으로 배열 생성
        int sum = 0;
        for(int i : values) {
			sum += i;
		}
    }   
}
public class CalculatorMain{
    public static void main(String[] args){
        Calculator c = new Calculator();
        
        int result = c.sum(1,2,3,4);
        System.out.println("합: " + result); // 합: 10
    }
}
```



### 3. 생성자 (Constructor)

> 객체가 생성되는 순간에 자동으로 호출되는 **메소드**
>
> 객체를  생성했을 때 초기화를 위해 사용

- 특징
  - 클래스의 이름과 동일
  - 반환값 / 반환형 없음
  - new 연산자를 통해 객체를 생성할 때만 단 한 번 자동으로 호출됨
  - **생성자 오버로딩**
    -  생성자를 여러개 만들 수 있음
    - 매개변수의 개수, 데이터 타입, 순서를 다르게 지정
    - 인스턴스(객체)가 생성되서 호출될 시 매개변수의 개수, 데이터 타입, 순서가 같은 생성자가 호출됨
- 유형
  - 디폴트 생성자
    - 매개변수가 없고 실행 내용도 없이 자동으로 생성되는 생성자
  - 매개변수가 있는 생성자
    - 객체 생성 시 값을 자동으로 전달하는 생성자



### 4. this

> this레퍼런스, this() 메소드

- this 레퍼런스

  - 클래스 내에서 객체 자신을 가리키는 레퍼런스
- this()

  - 한 생성자 안에서 다른 생성자를 호출 할 때 사용, 다른 생성자와 일치한 매개변수 개수, 자료형, 순서로 작성
  - 생성자 안에서만 사용가능
  - 첫 번째 줄에 적어야함



### 5. Setter, Getter 메소드

- Setter : 멤버 **필드 의 값을** 설정할 때 사용하는 메소드

  - setXxx() : set필드명()
  - 예) setName() : name 필드의 값을 설정하는 메소드

  ```java
  private String name;
  public void setName(String name){
      this.name = name;
  }
  ```



- Getter : 멤버 필드의 값을 가져와서 사용할 때 사용하는 메소드

  - getXxx : get필드명()
  - 예) getName() : name 필드의 값을 반환하는 메소드

  ```java
  public String getName(){
      return name;
  }
  ```
