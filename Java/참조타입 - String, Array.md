> 2022년 5월 24일



## 참조 타입

> 주소를 통해 객체를 참조 (주소가 저장됨)

- 배열타입, 열거타입, 클래스, 인터페이스

### 1.String 타입

- 문자열을 저장하는 클래스 타입

- String 객체로 생성됨

- String 객체 생성 방법 2가지

  1.  변수에 문자열을 저장하여 생성

     ```java
     // 동일한 String 객체 참조
     String name1 = "butter";
     String name2 = "butter";
     ```

  2.  **new연산자** 를 사용

     ```java
     // 서로 다른 String 객체 참조, 문자열 값은 동일
     String name1 = new String("butter");
     String name2 = new String("butter");
     ```

- == / != 와 .equals()

  - == / != : 동일한 객체를 참조하는지 비교
  - .equals() : 값이 같은지 비교



### 2. 배열

> 같은 타입의 데이터를 연속된 공간에 저장하는 자료구조

- 사용 이유 : 같은 타입의 변수 사용 시 변수 선언 개수를 줄일 수 있음, 첨자(인덱스)를 사용하여 원소 선택하고 값 저장 순서는 0부터 시작

- for문과 잘 사용됨

- 선언 형식 2가지 : **첫번째 방식을** 주로 사용함

  1. 데이터타입[] 변수;

     `int[] num;`

  2. 데이터타입 변수[];

     `int num[];`

- 배열 선언 후 **메모리 공간을** 할당 받아야만 사용 가능

- 배열의 메모리 공간 할당

  - **new 키워드를** 사용하여 메모리 공간 할당

    ```java
    // 선언과 동시에 메모리 공간 할당
    int[] num = new int[5];
    
    int[] a; //선언만 (아직사용x)
    a = new int[3]; //메모리 할당 (사용o)
    ```

- 배열의 초기값

  - 숫자 : 0(정수), 0.0(실수)
  - boolean : false
  - 참조타입: null

- 초기화 직접 할당

  - 선언 + 기억장소 + 원소에 값 저장을 동시에 수행
  
    `int[] num = {1,2,3,4,5};`
  
  - 주의! : {1,2,3,4,5} 이런 형식은 초기화만 가능하고 할당은 안됨
  
    ```java
    int[] c;
    c = {1,2,3,4,5} // 불가능, 에러 발생
    ```
  
- 배열의 길이

  - 배열에 저장할 수 있는 전체 항목의 수(배열의 크기)를 구하기 위해 **.length** 사용
  - 배열명.length



### 3. 2차원 배열

- 형식 : `int[][] a = new int[3][4]; `  행3개 열4개

- 초기화 직접 할당

  - 선언 + 기억장소 + 원소에 값 저장을 동시에 수행

    `int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};` 행3개 열4개



### 4. 비정방형 배열

> 각 행마다 열의 개수가 다른 배열

- 메모리 할당 시 **열의 개수를 정하지 않고** 동적으로 열의 개수 할당

- `int[][] a = new int[4][]`

  ```java
  a[0] = new int[3]; // 0행에 3개의 원소 생성
  a[1] = new int[2]; // 1행에 2개의 원소 생성
  a[2] = new int[1]; // 2행에 1개의 원소 생성
  a[3] = new int[4]; // 3행에 4개의 원소 생성
  ```

- 초기화

  - `int[][] a = {{1,2},{3},{4,5,6}};`



### 5. 배열 복사

- 2가지 방법

  1. for문을 사용해 각 원소의 값 하나씩 복사

     ```java
     int[] oldArray = {1,2,3};
     int[] newArray = new int[5];
     
     for(int i = 0; i < oldArray.length; i++){
         newArray[i] = oldArray[i]; 
     }
     
     for(int i = 0; i < newArray.length; i++){
         System.out.print(newArray[i]+" ");
     } // 1 2 3 0 0 
     ```

  2.  System.arraycopy() 메소드 사용

     - System.arraycopy(원본배열, 시작인덱스, 대상배열, 시작인덱스, 복사할 항목 개수)

     ```java
     String[] oldArray = {"java", "DB", "class"};
     String[] newArray = new String[4];
     
     System.arraycopy(oldArray,0,newArray,0,oldArray.length);
     
     for(int i = 0; i < newArray.length; i++){
         System.out.print(newArray[i]+", ");
     } // java, DB, class, null
     ```



### 6. 객체 배열

> 하나의 배열로 객체를 관리
>
> 객체를 가리키는 참조 변수를 원소로 갖는 배열

```java
import java.util.Scanner;

public class Course {
	String courseName;
	String professor;
	String year;
	int score;
	
	Scanner sc = new Scanner(System.in);
	
	public void inputInfo() {
		System.out.print("과목명: ");
		courseName = sc.next();
		System.out.print("교수: ");
		professor = sc.next();
		System.out.print("학년: ");
		year = sc.next();
		System.out.print("이수학점: ");
		score = sc.nextInt();
	}
	
	public void outputInfo() {
		System.out.print(courseName + " ");
		System.out.print(professor + " ");
		System.out.print(year + "학년 ");
		System.out.print(score + "학점\n");
	}
	
}

public class CourseMain {

	public static void main(String[] args) {
		// c : 배열을 가리키는 참조변수
        // c[i] : 객체를 가리키는 참조변수
        
		Course[] c = new Course[3]; // 참조변수 3개 생성 c[0],c[1],c[2]
		
		for(int i =0; i < c.length; i++) {
			c[i] = new Course(); // 객체 생성 
			c[i].inputInfo(); // Course 클래스의 메소드로 객체내용 생성
			
		}
		for(int i =0; i < c.length; i++) {
			c[i].outputInfo();
			
		}

	}

}
```
