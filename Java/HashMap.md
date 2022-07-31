# HashMap
> Map 인터페이스를 구현한 대표적인 Map 컬렉션

- Map 인터페이스를 상속하고 있기에 Map의 성질을 그대로 가지고 있음
- Map은 키와 값으로 구성된 Entry  객체를 저장하는 구조를 가지고 있는 자료구조
- 값은 중복 저장 가능하지 만 키는 중복저장 불가
- 만약 기존 저장된 키와 동일한 키로 값을 저장한면 기존의 값은 사라지고 새로운 값으로 대치됨
- HashMap은 Hashing을 사용하기 때문에 많은 양의 데이터를 검색하는 데 있어서 뛰어난 성능을 보임
- HashMap은 해시 함수를 통해 키와 값의 저장되는 위치를 결정하므로, 사용자는 위치와 순서를 알 수 없음
<br>

## HashMap 선언
- HashMap을 생성하려면 키 타입과 값 타입을 파라미터로 주고 기본 생성자를 호출하면됨
- 저장공간 보다 값이 추가로 들어오면 List처럼 저장공간을 추가로 늘림(한 칸씩이 아니라 약 두배로 늘림)
- 이는 과부하가 생길 수 있으므로 적정한 초기 용량을 지정해 주는 것이 좋음
```java
HashMap<String, Object> map = new HashMap<String, Object>();
```
<br>

## HashMap 값 추가
- put(key, value) 메소드를 사용하여 추가
- 선언 시 설정한 타입과 같은 타입의 Key와 Value 값을 넣어야 함
```java
HashMap<Integer, String> map = new HashMap<>(); //new에서 파라미터 생략 가능
map.put(1,"수박");
map.put(2,"체리");
map.put(3,"샤인머스캣");
map.put(4,"파인애플");
map.put(5,"딸기");
```

<br>
## HashMap 값 삭제
- remove(key) 메소드 사용
- clear() 메소드는 모든 값 제거
```java
HashMap<Integer, String> map = new HashMap<>();
map.put(1,"수박");
map.put(2,"체리");
map.put(3,"샤인머스캣");
map.put(4,"파인애플");
map.put(5,"딸기");
map.remove(1); // key1 값 제거
map.clear(); // 모든 값 제거
```
<br>

## HashMap 값 출력
- 특정 key의 value를 가져오려면 get(key)를 사용
- 전체를 출력하려면 entrySet()이나 keySet()를 사용하여 Map 객체를 반환 받은 후 출력하면 됨
- entrySet()은 key와 value 모두가 필요할 경우 사용하며 keySet()은 key만 필요할 경우 사용
- keyset()을 사용하더라도 get(key)를 사용하여 value도 출력 가능하므로 entrykey()와 keyset() 어떤 메소드를 사용하더라도 상관 없지만 
- 많은 양의 데이터를 가져와야한다면 entrySet()사용이 좋음
```java
HashMap<Integer,String> map = new HashMap<Integer,String>(){
put(1,"사과");
put(2,"바나나"); 
put(3,"포도"); 
};

System.out.println(map); // 전체 출력 : {1=사과, 2=바나나, 3=포도}
System.out.println(map.get(1)); // key 1의 value : 사과

// entrySet()
for(Entry<Integer, String> entry : map.entrySet()){
	System.out.println("key : " + entry.getkey() + "value : " + entry.getValue());
}
// key : 1 value : 사과
// key : 2 value : 바나나
// key : 3 value : 포도

// keySet()
for(Integer i : map.keySet()){
	System.out.println("key : " + i + "value : " + map.get(i))
}
// key : 1 value : 사과
// key : 2 value : 바나나
// key : 3 value : 포도
```
<br>
## Iterator 사용
- HashMap의 전체 출력 시 반복문을 사용하지 않고 Iterator 사용
```java
HashMap<Integer,String> map = new HashMap<Integer,String>(){
put(1,"사과");
put(2,"바나나"); 
put(3,"포도"); 
};

// entrySet().iterator()
Integer<Entry<Integer, String>> entries = map.entrySet().iterator();
while(entries.hasNext()){

	Map.Entry<Integer, String> entry = entries.next();
	System.out.println("key : " + entry.getKey() + "value : " + entry.getValue());

}
// key : 1 value : 사과
// key : 2 value : 바나나
// key : 3 value : 포도

//keySet().iterator()
Iterator<Integer> keys = map.keySet().iterator();
while(key.hasNext()){
	int key = keys.next();
	System.out.println("key : " + key + "value : " + map.get(key));
}
// key : 1 value : 사과
// key : 2 value : 바나나
// key : 3 value : 포도

```
>  참고 : https://coding-factory.tistory.com/556