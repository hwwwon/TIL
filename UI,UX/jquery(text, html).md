## .text()
- 셀렉터 하위에 있는 자식 태그들의 문자열만 출력

```javaScript

$(function(){
  var word = $("#name").text();
  alert(word);
});

// html
<body>
  <div id="name">
    <span>안녕하세요</span>
  </div>
</body>

// alert 결과 : 안녕하세요

```

<br><br>

## .html()
- 셀렉터 하위에 있는 자식 태그들을 태그나 문자열 따질 것 없이 전부 가져옴

```javaScript

$(function(){
  var word = $("#name").text();
  alert(word);
});

// html
<body>
  <div id="name">
    <span>안녕하세요</span>
  </div>
</body>

// alert 결과 : <span>안녕하세요</span>

```

<br><br>

