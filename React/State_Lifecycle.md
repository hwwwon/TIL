# State

> 리액트 Component의 상태(데이터)

- 리액트 Component의 변경 가능한 데이터
- State는 개발자가 정의함
- 랜더링이나 데이터 흐름에 사용되는 값만 state에 포함시켜야함(성능)

- state는 JavaScript 객체

```jsx
class LikeButton extends React.Component{
    constructor(props){ // 모든 class component에 존재하는 constructor 함수(생성자)
        super(props);
        
        this.state = {
          liked: false;  // class component는 생성자에서 state 정의
        };
    }
}
```

- state는 직접 수정 불가능(하면 안됨)

```jsx
// state를 직접 수정 (잘못된 사용법)
this.state={
  name: 'Hyewon'  
};

// setState 함수를 통한 수정 (정상적인 사용법)
this.setState({
    name: 'Hyewon'
});
```

<br>

# Lifecycle(생명주기)

> 컴포넌트의 생성 부터 사라지는 사이클

- 리액트 Class Component의 Lifecycle
    - 출생(Mounting) : componentDidMount 함수 호출
    - 인생(Updating) : componentDidUpdate 함수 호출
    - 사망(Unmounting) : 상위 컴포넌트에서 해당 컴포넌트를 더이상 화면에 표시하지 않게 될 때, componentWillUnmount 함수 호출

- Component가 계속 존재하는 것이 아니라, 시간의 흐름에 따라 생성되고 업데이트되다가 사라짐
