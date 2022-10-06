> 2022-10-05
>
> Lv1을 풀어보고 Lv2에 도전해보고 싶어서 풀어봤지만, 나의 실력에서는 아직 어려운 부분이 많았다. 다른 사람 풀이를 통해 다른 관점에서 풀이를 접해보면서 다양한 생각을 해볼 수 있었다.

<br>

## 멀리 뛰기

- 문제 설명
  - 효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
    (1칸, 1칸, 1칸, 1칸)
    (1칸, 2칸, 1칸)
    (1칸, 1칸, 2칸)
    (2칸, 1칸, 1칸)
    (2칸, 2칸)
    의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
- 제한 사항
  - n은 1 이상, 2000 이하인 정수입니다.

<br>

- 나의 풀이

```java
class Solution {
    public long solution(int n) {
        
        long[] arr = new long[2001]; // n이 1이상 2000이하인 정수 이므로 크기 지정
        arr[1] = 1; // 칸 수가 1칸인 경우의 수 (1칸)
        arr[2] = 2; // 칸 수가 2칸인 경우의 수 (1칸, 1칸) / (2칸)
        
        // 3부터는 앞과 앞앞의 경우의 수를 더하는 패턴(피보나치수열) 사용
        for(int i = 3; i <= n; i++){
            arr[i] = (arr[i-2]+arr[i-1]) % 1234567;
        }
        
        return arr[n];
    }
}
```



- DP(Dynamic Programming) 점화식 / 피보나치수열
  - DP :  동적프로그래밍, 중복되는 결과를 배열에 저장해 같은 결과가 나오는 식은 배열에서 꺼내쓰도록 하는 방법 사용
  - 점화식 : 음이 아닌 정수 n에 대해 수열{an}의 이웃하는 여러 항들사이의 관계식

<br>

## 최댓값과 최솟값

- 문제 설명
  - 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
    예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.

- 제한 사항
  - s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.

<br>

- 나의 풀이

```java
import java.util.Arrays;
class Solution {
    public String solution(String s) {                
        
        String arr[] = s.split(" ");
        int arr2[] = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        int maxNum = arr2[0];
        int minNum = arr2[0];
        
        for(int i = 0; i < arr2.length; i++){
            
            if(maxNum <= arr2[i]){
                maxNum = arr2[i];
            }
            if(minNum >= arr2[i]){
                minNum = arr2[i];
            }
            
        }       
        
        String answer = minNum + " " + maxNum;
        return answer;
    }
}
```



- 다른 사람 풀이

```java
// 나의 풀이와 비슷하지만 훨씬 깔끔한 코드
public class GetMinMaxString {
    public String getMinMaxString(String str) {
        String[] tmp = str.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(tmp[0]);
        for (int i = 1; i < tmp.length; i++) {
                n = Integer.parseInt(tmp[i]); // 형변환
            if(min > n) min = n;
            if(max < n) max = n;
        }

        return min + " " + max;

    }
}

// int형 배열을 오름차순 정렬시켜 최솟값, 최댓값 구한 풀이 
import java.util.Arrays;

public class GetMinMaxString {
    public String getMinMaxString(String str) {

        String[] array = str.split(" ");
        int[] arrayInt = new int[array.length];

        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = Integer.parseInt(array[i]); // 형변환
        }

        Arrays.sort(arrayInt);
        String result = arrayInt[0] + " " + arrayInt[arrayInt.length - 1];

        return result;

    }

}

```



<br>

## JedenCase 문자열 만들기

- 문제 설명
  - JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
    문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.
- 제한 조건
  - s는 길이 1 이상 200 이하인 문자열입니다.
  - s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
    - 숫자는 단어의 첫 문자로만 나옵니다.
    - 숫자로만 이루어진 단어는 없습니다.
    - 공백문자가 연속해서 나올 수 있습니다.



<br>

> 문제를 풀어서 테스트에는 성공했지만 제출시 런타임 오류 발생
>
> 공백칸을 유지하여 반환해야하는 문제 때문에 오류가 발생하는 것이었음(공백이 여러번 들어가 있거나 마지막에 공백이 들어간 문자열인 경우)

- 나의 풀이

```java
// 런타임 오류 발생한 코드
// 단순하게 새로 배열만들어서 대소문자 변환후 조인하면 된다고 생각해서 작성한 코드
// 입력값의 공백도 그대로 반환해줘야함
import java.util.ArrayList;
class Solution {
    public String solution(String s) {
        
		String[] ArraysStr = s.split(" ");
        ArrayList<String> newArr = new ArrayList<>();
        String answer = "";
        
        for(int i = 0; i < ArraysStr.length; i++){
            
            newArr.add(ArraysStr[i].substring(0,1).toUpperCase() + ArraysStr[i].substring(1).toLowerCase());
            answer = String.join(" ", newArr);
        }
        
        return answer;
    }
}
```



- 다른 사람 풀이

```java
// 풀이1
class Solution {
    public String solution(String s) {
        
        //StringBuffer는 문자열을 추가(append)하거나 변경 할 때 주로 사용하는 자료형
        StringBuffer sb = new StringBuffer();
        
        s = s.toLowerCase(); // 전체 소문자로 변경
        
        sb.append(Character.toUpperCase(s.charAt(0))); //제일 첫 문자 대문자로 변경
        
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ' ') sb.append(" "); // 공백이면 공백 append
            else if(s.charAt(i - 1) == ' ') // 바로 앞이 공백이면 대문자로 변경
                sb.append(Character.toUpperCase(s.charAt(i)));
            else sb.append(s.charAt(i)); // 위 경우를 제외한 나머지 모두 append
        }
        
        return sb.toString(); // 전체 내용을 String 개체로 생성하여 반환
    }
}

// 풀이2
class Solution {
  public String solution(String s) {
      
        String answer = "";
        String[] sp = s.toLowerCase().split(""); // 소문자로변경후 글자 하나씩 자른 배열
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false; // 공백일 경우 true, 공백 아니면 false
        }

        return answer;
  }
}

```



- **length / length() / size() 차이**
  - length : 배열의 길이
  - length() : 문자열의 길이
  - size() : 컬렉션프레임워크 타입의 길이