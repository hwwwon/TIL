# Element

> 리액트 앱을 구성하는 가장 작은 블록들



- React Element
  - rendering 되기전 virtual DOM에 있는 Element



- DOM Element
  - rendering 후 Browser DOM에 있는 Element



- Elements의 생김새

  - React Element는 자바스크립트 객체 형태로 존재
  - React.createElement

  ```jsx
  // Element가 rendering 되기전 객체 형태
  {
      type: 'button', // HTML tag / 컴포넌트가 들어갈 경우 따옴표 없이 Button 
      props: {
          className: 'bg-green',
          children: {
              type: 'b',
              props: {
                  children: 'Hello, element!'
              }
          }
      }
  }
  
  // rendering 후 DOM Element
  <button class="bg-green"><b>Hello, element!</b></button>
  ```



- Component와 Element의 관계

![component_element](C:\TIL\img\component_element.jpg)



- Elements의 특징
  - React element are immuteble(불변성) : Elements 생성후에는 children이나 attributes를 바꿀 수 없음
  - 불변성 때문에 기존을 변경하는 것이아니라 Virtual DOM에서 교체되어 rendering 후 나타남



- Root DOM Node

  - React DOM에 의해 관리됨
  - 오직 react만으로 만들어진 웹사이트들은 단 하나의 Root DOM Node를 가짐
  - 반명, 기존에 있던 웹사이트에 react가 추가된 경우 분리된 여러개의 Root DOM Node를 가질 수도 있음

  ```jsx
  const element = <h1>안녕, 리액트!</h1>;
  const root = ReactDOM.createRoot(document.getElementById('root')); // DOM Element
  root.render(element) // render 파라미터 React Element
  ```

  