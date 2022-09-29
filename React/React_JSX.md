# React

> 리액트는 JavaScript library 중 하나로서 UI를 만들기 위해 사용됨



- 프레임워크 VS 라이브러리

    - 프레임워크
      - 프로그램 흐름의 제어권한이 개발자가 아닌 프레임워크에게 있음
    - 라이브러리
      - 흐름에 대한 제어를 하지 않고 개발자가 필요한 부분만 필요할 때 가져다 사용하는 형태



- SPA

> Single Page Application

    - 서버로부터 완전히 새로운 페이지를 불러오는 것이 아닌 현재의 페이지를 동적으로 다시 작성함으로써 사용자와 소통하는 웹 애플리케이션 / 웹사이트



## 리액트의 장점

1. 빠른 업데이트 & 렌더링 속도
   - Virtual DOM : 가상의 돔(Document Object Model, 웹페이지를 정의하는 하나의 객체)
     - 바뀐 부분만을 찾아서 업데이트
2. Component-Based : 여러 컴포넌트들을 조합해서 사용
   - 재사용성(Reusability)
     - 의존성 및 호환성 문제 시 재사용 불가
     - 개발기간 단축
     - 유지보수 용이
3. Meta의 Open source project
4. 활발한 지식공유 & 커뮤니티
5. 모바일 앱 개발 가능(React Native)



## 리액트의 단점

1. 방대한 학습량
2. 버전 업데이트를 하면서 바뀌는 부분이 많음
3. 높은 상태관리 복잡도(State)
   - 리덕스 등 외부상태관리 라이브러리 사용



## JSX

> A syntax extension to JavaScript
>
> JavaScript + XML/HTML

```jsx
const element = <h1>hello, world!</h1>;
```

- 역할
  - XML/HTML 코드를 JavaScript로 변환하는 과정을 거치게됨
  - JSX를 사용하지 않으면 React의 createElement 함수가 JavaScript로 변환하는 역할을 함

```jsx
// JSX를 사용한 코드
class Hello extends React.Component{
    render(){
        return <div>Hello {this.props.toWhat}</div>;
    }
}

ReactDOM.render(
	<Hello toWhat="World" />
    document.getElementById('root')
);

const element = (
    <h1 className="greeting">
    	Hello, world!
    </h1>
)
```

```javascript
// JSX를 사용하지 않은 코드, React의 createElement를 사용
class Hello extends React.Component {
    render(){
        return React.createElement('div', null, `Hello ${this.props.toWhat}`);
    }
}

ReactDOM.render(
	React.createElemnet(Hello, { toWhat: 'World'}, null),
    document.getElmentById('root')
);

const element = React.createElement(
	'h1',
    {className: 'greeting'},
    'Hello, world!'
)

/* React.createElement()의 결과로 생성된 객체 React Element
const element = {
    type: 'h1', 
    props: {
        className: 'greeting',
        children: 'Hello, world!'
    }
}

파라미터 : type, props, children
type: Element 유형(HTML tag, React Component)
props: 속성
children: 현재 Element가 포함하고 있는 자식 Element
*/

```



- 사용하는 이유 
  - 코드가 간결해짐
  - 생산성과 가독성 증가
  - 가독성이 높으면 유지보수하기도 편리해짐
  - Injection Attacks 해킹 방어(보안 향상)
  - XSS(Cross Site Scriping) 방어(보안 향상)



- 사용법

  - HTML/XML 사이에 {} 중괄호를 사용하여 JavaScript 코드를 삽입
  - 태그 속성(attribute)에 값을 넣는 방법

  ```jsx
  // 큰따옴표 사이에 문자열을 넣음(방법1)
  const element = <div tabIndex="0"></div>;
  
  // 중괄호 사이에 자바스크립트 코드를 넣음(방법2)
  const element = <img src={user.avatarUr}></img>;
  ```

  - 자식(Children)을 정의하는 방법

  ```jsx
  const element =(
      <div>
          <h1>안녕하세요</h1>
          <h2>리액트 공부</h2>
      </div>
  );
  ```

  
