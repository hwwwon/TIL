> 2022-10-02

## Seoul에서 김서방 찾기

- 문제 설명
  - String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

- 제한 사항
  - seoul은 길이 1 이상, 1000 이하인 배열입니다.
  - seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
  - "Kim"은 반드시 seoul 안에 포함되어 있습니다.

<br>

- 나의 풀이

```java
class Solution {
    public String solution(String[] seoul) {
        
        int x = 0;
        
        for(int i = 0; i < seoul.length; i++){
            
            if(seoul[i].equals("Kim")){
                x = i;
            }
        }
        
        String answer = "김서방은 " + Integer.toString(x) + "에 있다";
        return answer;
    }
}
```



- 다른 사람 풀이

```java
import java.util.Arrays;
class Solution {
    public String solution(String[] seoul) {
        
      	//x에 김서방의 위치를 저장하세요.
        int x = Arrays.asList(seoul).indexOf("Kim");

        return "김서방은 "+ x + "에 있다";
        
    }
}
```



<br>

## 핸드폰 번호 가리기

- 문제 설명
  - 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
    전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 `*`으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

- 제한 사항
  - phone_number는 길이 4 이상, 20이하인 문자열입니다.

<br>

- 나의 풀이

```java
class Solution {
    public String solution(String phone_number) {
        
        int num = phone_number.length()-4;
        
        String end_number = phone_number.substring(num);
        
        String answer = phone_number.substring(0, num).replaceAll(".","*") + end_number;
        return answer;
    }
}
```



- 다른 사람 풀이

```java
// char 배열
class Solution {
  public String solution(String phone_number) {
      
     char[] ch = phone_number.toCharArray();
     for(int i = 0; i < ch.length - 4; i ++){
         ch[i] = '*';
     }
      
     return String.valueOf(ch);
  }
}

// 정규식 사용
class Solution {
  public String solution(String phone_number) {
    return phone_number.replaceAll(".(?=.{4})", "*");
  }
}

// 나의 풀이와 비슷한듯 다른 풀이
class Solution {
  public String solution(String phone_number) {
      String answer = "";

        for (int i = 0; i < phone_number.length() - 4; i++)
            answer += "*";

        answer += phone_number.substring(phone_number.length() - 4);

        return answer;
  }
}
```

<br>



## 없는 숫자 더하기

- 문제 설명
  - 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 `numbers`가 매개변수로 주어집니다. `numbers`에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
- 제한 사항
  - 1 ≤ `numbers`의 길이 ≤ 9
    - 0 ≤ `numbers`의 모든 원소 ≤ 9
    - `numbers`의 모든 원소는 서로 다릅니다.

<br>

- 나의 풀이

```java
class Solution {
    public int solution(int[] numbers) {
        
        int num = 0;
        
        for(int i = 0; i < numbers.length; i++){

            num += numbers[i];
            
        }
        
        int answer = 45 - num;
        return answer;
    }
}
```



- 다른 사람 풀이

```java
class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}
```

