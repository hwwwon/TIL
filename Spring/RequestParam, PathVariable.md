# @RequestParam, @PathVariable
> 데이터 전달을 위해 사용됨
- 데이터를 주고 받을 때 요청과 응답이 끝나면 연결이 끊어짐
- http에서 요청간에 데이터를 보장해 주지 않아서 데이터 보관을 보장함
- http의 비연결성을 극복하고 데이터를 전달할 때 uri를 통해 전달된 값을 파라미터로 받아옴

<br><br>

## uri를 통해 값을 전달하는 방식 2가지
- http://localhost8080/board?page=1&listSize=10
  - 쿼리 스트링 Get 방식의 통신
- http://localhost8080/board/1
  - RESTful 방식, POST 방식


<br><br>

## @RequestParam 사용

```java
@RequestMapping("/mappingName1")
public String getBoardList( @RequestParam(value = "page", required = false, defaultValue = "1") int page, @RequestParam(value = "listSize", defaultValue = "10") int listSize) {

  return "result1";
}
```
- value : uri에서 바인딩하여 별칭으로 정할 값
- required : true일 시 필수적으로 값이 전달되어야 하며 없으면 에러 발생 (default는 true)
- defaultValue :  값이 없을 때 기본값으로 사용될 값
- name : uri에서 바인딩할 파라미터 이름
<br><br>

## @PathVariable 사용

```java
@RequestMapping("/mappingName2")
public String updateBoard(@PathVariable("id") int id, @RequestParam Map<String, Object> params){

  return "result2";
}
```
- 어떤 요청이든 하나만 사용 가능


<br><br>

## 정리
- @RequestParam과 @PathVariable은 둘 다 데이터를 받아오는데 사용
- @PathVairable은 값을 하나만 받아올 수 있으므로, 쿼리스트링 등을 이용한 여러 개 데이터를 받아올 때는 @RequestParam 사용
- @RequestParam은 uri를 통해 전달된 값이 아니더라도, ajax 요청을 통해 body에 담아온 데이터를 여러 타입으로 받을 수 있음



