## enum(열거형)

> Enumeration : 열거, 목록

- 서로 연관된 상수들의 집합

- 상수 그룹(final처럼 바꿀 수 없는 수)을 나타내는 특수한 클래스

<br/>

#### 특징

- 열거형을 만들려면 class, interface 대신 enum 키워드를 사용
- 상수를 쉼표로 구분하며 대문자로 작성함
- 열거형으로 선언된 순서에 따라 0부터 index를 가짐 (순차적으로 증가)
- 마지막 열거형 선언 이후에는 세미콜론을 찍지 않음
- 생성자와 메서드 추가 가능
- 클래스 내부와 외부에 선언하는 방식이 있음

```java
public enum Gender{
    MALE, FEMALE
}

// enum 생성자, 세미콜론을 마지막에 붙여야함
public enum Gender{
    MALE("M"), FEMALE("FE");
    
    private final String value;
    
    Gender(String value){
        this.value = value;
    }
    public String value(){
        return value;
    }
}

// Gender.MALE.name() 
// Male
// Gender.MAEL.value()
// M
```

<br/>

#### 장점

- 코드가 단순지며, 가독성이 좋음
- 문자열과 비교해 IDE의 적극적 지원을 받을 수 있음 (자동완성, 오타검증, 텍스트 리팩토링 등)
- 허용 가능한 값들을 제한 할 수 있음
- 리팩토링 시 변경 범위가 최소화 됨
- 데이터들 간의 연관관계 표현
- 상태, 행위를 한 곳에서 관리
- 클래스를 상수처럼 사용
- 인스턴스 생성과 상속을 방지하여 상수값의 타입 안정성 보장
- 새로운 상수들의 타입을 정의하므로 정의한 타입외를 가진 데이터 값을 컴파일시 체크 가능

- enum 키워드를 통해 구현 의도 파악 가능



