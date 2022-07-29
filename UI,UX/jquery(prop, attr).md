## .prop()
- 지정한 선택자를 가진 첫번째 요소의 속성 값을 가져오거나 속성값을 추가
- 주의할 점은 HTML 입장에서 속성(attribute)이 아닌 JavaScript입장에서의 **속성(porperty)임**
- 속성 값 가져오기 : .prop(propertyName);
- 속성 추가하기 : .prop(propertyName, value);

<br><br>

## .attr()
- 요소(element)의 **속성(attribute)의 값을** 가져오거나 속성을 추가
- 속성 값 가져오기 : .attr(attributeName);
- 속성 추가하기 : .attr(attributeName, value);

<br><br>

## prop()와 attr()의 사용
- HTML에 쓴 속성 값을 다루고 싶을 때는 .attr()를 사용
- javaScript의 프로퍼티 값을 사용할 경우 .prop() 사용

<br><br>

## 사용 예제
- 예제1
```
1. <a id="line" href="#comments">코멘트</a>
2. var $line_comment = $('#line');
3. alert($line_comment.attr('href')); // href 속성 값 표시
4. alert($line_comment.prop('href')); // href 프로퍼티 값을 표시

// attr 결과 값은 "#comments"
// prop 결과 값은 "http://test.com/path/page#comments"

```
- 예제2
```
1. <checkbox id="agree" type="checkbox" checked />
2. var $checkbox = $('#agree');
3. alert($checkbox.attr('checked')); // checked 속성 값 표시
4. alert($checkbox.prop('checked')); // checked 프로퍼티 값 표시

// attr 결과 값은 "checked"
// prop 결과 값은 "true"

```

> 출처 : electronic-moongchi.tistory.com/41

