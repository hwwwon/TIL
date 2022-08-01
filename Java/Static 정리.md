## Static 멤버
- 클래스에 고정된 필드와 메소드(정적필드, 정적 메소드)
- 정적 멤버는 클래스에 소속된 멤버로, 객체 내부에 존재하지 않고 메소드 영역에 존재함
- 따라서 정적 멤버는 객체를 생성하지 않고 클래스로 바로 접근하여 사용함

<br>
## 정적 멤버 선언
- 필드 또는 메소드를 선언할 때 static 키워드를 붙임
```java
public class 클래스 {
	// 정적 필드
	static 타입 필드 = 초기값;

	// 정적 메소드
	static 리턴타입 메소드 (매개변수,...){...}
}
```


## 정적 멤버 사용
-  클래스 이름과 함께 .(도트) 연산자로 접근 가능
- 클래스.필드;
- 클래스.메소드(매개값);
<br>

## 인스턴스 멤버 선언 VS 정적 멤버 선언 기준

- 필드
	- 객체마다 가지고 있어야할 데이터 : 인스턴스 필드
	- 공용적인 데이터 : 정적 필드
	```java
		public class Calculator{
			String color; // 계산기 별로 색이 다를 수 있음
			static double pi = 3.14159; // 계산기에서 사용하는 파이 값은 동일함
		}
```
- 메소드
	- 인스턴스 필드로 작업해야할 메소드 : 인스턴스 메소드
	- 인스턴스 필드로 작업하지 않는 메소드 : 정적 메소드
	```java
	public Calculator{
		String color;
		void setColor(String color) {
			this.color = color;
		}
		static int plus(int x, int y){return x + y;}
		static int minus(int x, int y){return x - y;}
	}
```
<br>

## 정적 초기화 블록
- 클래스가 메소드 영역으로 로딩될 때 자동으로 실행하는 블록
- 정적 필드의 복잡한 초기화 작업과 정적 메소드 호출 가능(인스턴스필드와 인스턴스 메소드호출 불가 )
-  객체 자신의 참조인 this 사용 불가
- 클래스 내부에 여러 개가 선언되어도 상관 없고, 선언된 순서대로 실행됨
- 형태 
	- static {...}
<br>
## 싱글톤(singleton)
- 하나의 애플리케이션 내에서 단 하나만 생성되는 객체
- 싱글톤 만드는 방법
	1. 외부에서 new 연산자로 생성자를 호출할 수 없도록 막음
		- 생성자 앞에 pirvate 접근 제한자를 붙임
	2. 클래스 자신의 타입으로 정적 필드를 선언하고, 자신의 객체를 생성해 초기화함
		- private 접근 제한자를 붙여 외부에서 필드값을 변경할 수 없도록 막음
	3. 외부에서 호출 할 수 있는 정적 메소드인 getInstance()를 선언함
		- 정적 필드에서 참조하고 있는 자신의 객체를 리턴하도록 함

```java
public class 클래스명 {

	// 정적 필드
	private static 클래스 singleton = new 클래스();

	// 생성자
	private 클래스(){}

	// 정적 메소드
	static 클래스타입 getInstance(){
		return singleton;
	}

}
```
- 클래스.getInstance(); 로 싱글톤 얻기
