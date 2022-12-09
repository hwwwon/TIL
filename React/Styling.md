## CSS와 selector

> CSS: Cascading Style Sheets : 계단식(우선순위) 스타일 시트
>
> selector: element에 스타일이 적용되는 규칙, 스타일을 어느 element에 적용할지를 선택

- Selector의 유형
  - Element selector : 특정 html 태그
  - ID selector : '#' 사용, 하나의 element에만 사용
  - Class selector : '.' 사용, 여러개 element에 사용 가능
  - Universal selector : '*'사용, 전체 element에 적용
  - Grouping selector : ','사용으로 구분, 여러개의 선택자를 그룹으로 묶어 하나의 스타일 적용
  - Element의 상태와 관련된 selector
    - :hover
    - :active
    - :focus
    - :checked
    - :first-child, :last-child

<br>

## Layout과 관련된 속성

- display : none | block | inline | flex;

- visibility : visible | hidden;

- position : static | fixed | relative | absolute;

### Flexbox

> 기존 CSS 레이아웃의 사용의 불편함을 개선하기 위해 등장
>
> container안에 item들을 어떻게 배치할지

- container와 안에 포함된 item들(elements)로 구성됨

```css
#container{
    display: flex;
    flex-direction: row | column | row-reverse | column-reverse;
    justify-content: flex-start | center | flex-end | space-between | space-around;
    align-items: stretch | flex-start | center | flex-end | baseline;
}
```

<br>

## Font와 관련된 속성

```css
#title{
    /* 사용할 글꼴에 띄어쓰기가 있으면 큰따옴표로 묶어줘야함
    사용할 글꼴을 찾지 못할 경우를 대비해 다음으로 사용할 글꼴을 순서대로 나열(콤마사용) */
    font-family: "사용할 글꼴 이름", <일반적인 글꼴 분류>;
    font-size: value;
    font-weight: normal | bold | (100 ~ 900); 
    font-style: normal | italic | oblique;
}
```

- 일반적인 글꼴 분류 (Generic font family)
  - serif : 각 글자의 모서리에 작은 테두리를 갖고 있는 형태의 글꼴
  - sans-serif : 모서리에 테두리가 없이 깔끔한 선을 가진 글꼴
  - monospace : 모든 글자가 같은 가로길이를 가지는 글꼴
  - cursive: 사람이 쓴 손글씨 모양의 글꼴
  - fantasy : 장식이 들어간 형태의 글꼴

<br>

## styled-components

- 설치하기

```
# npm을 사용하는 경우
npm install --save styled-components

# yarn을 사용하는 경우
yarn add styled-components
```

- 간단한 예제 코드

```jsx
import React from "react";
import styled from 'styled-components';

const Wrapper = styled.div`
	padding: 1em;
	background: grey;
`;

const Title = styled.h1`
	font-size: 1.5em;
	color: white;
	text-align: center;
`;

function MainPage(props){
    return (
        <Wrapper>
            <Title>
            	안녕, 리액트!
            </Title>
        </Wrapper>
    );
}

export default MainPage;
```

<br>

### styled-components 기본 사용법

- **Tagged template literal** 사용하여 구성요소의 스타일을 지정

- literal : 소스코드의 고정된 값 (상수와 다른 개념)

  ```jsx
  // 변수를 사용할 때 상수를 의미하는 const 사용
  // 왼쪽: 상수, 오른쪽: 리터럴
  
  // 정수 리터럴 (Integer literal)
  const myNumber = 10;
  
  // 문자열 리터럴 (String literal)
  const myStr = 'Hello';
  
  // 배열 리터럴 (Array literal)
  const myArray = [];
  
  // 객체 리터럴 (Object literal)
  const myObject = {};
  ```

  <br>

- template literal

  - literal을 template 형태로 사용하는 JavaScript 문법
  - 백틱(``)을 사용하여 문자열 작성하고, 그 안에 대체가능한 expression(대체, substitution)을 넣는 방법
  - Untagged template literal
  - Tagged template literal

  ```jsx
  // Untagged template literal
  // 단순한 문자열
  `string text`
  
  // 여러 줄에 걸친 문자열
  `string text line1
  string text line2`
  
  // 대체 가능한 expression이 들어있는 문자열
  `string text ${expression} string text`
  
  -----------
  // Tagged template literal
  // myFunction의 파라미터로 expression으로 구분된 문자열 배열과 expression이 순서대로 들어간 형태로 호출됨
  myFunction`string text ${expression} string text`;
  
  // Tagged template literal 예제
  const name = '혜원';
  const region = '서울';
  
  function myTagFunction(strings, nameExp, regionExp){
      let str0 = string[0]; // "제 이름은 "
      let str1 = string[1]; // "이고, 사는 곳은 "
      let str2 = string[2]; // "입니다."
      
      // 여기에서도 template literal을 사용해 리턴 가능
      return `${str0}${nameExp}${str1}${regionExp}${str2}`;
  }
  
  const output = myTagFunction`제 이름은 ${name}이고, 사는 곳은 ${region}입니다.`;
  
  // 출력 결과
  // 제 이름은 혜원이고, 사는 곳은 서울입니다.
  console.log(output);
  ```

  <br>

  ### styled-components의 props 사용

  > 조건이나, 동적으로 변하는 스타일 적용

  ```jsx
  import React from "react";
  import styled form "styled-components";
  
  const Button = styled.button'
  	color: ${props => props.dark ? "white" : "dark"};
  	background: ${props => props.dark ? "black" : "white"};
  	border: 1px solid black;
  ';
  
  function Sample(props){
      return (
          <div>
              <Button>Normal</Button>
              <Button dark>Dark</Button>
          </div>
      );
  }
  
  export default Sample;
  ```

  <br>

  ### styled-components의 스타일 확장하기

  > 스타일 확장기능 제공
  >
  > styled(컴포넌트)

  ```jsx
  import React from "react";
  import styled from 'styled-components';
  
  // Button 컴포넌트
  const Button = styled.button`
  	color: grey;
  	border: 2px solid palevioletred;
  `;
  
  // Button에 style이 추가된 RoundedButton 컴포넌트
  const RoundedButton = styled(Button)`
  	border-radius: 16px;
  `;
  
  function Sample(props){
      return (
          <div>
              <Button>Normal</Button>
              <RoundedButton>Rounded</RoundedButton>
          </div>
      );
  }
  
  export default Sample;
  ```

  