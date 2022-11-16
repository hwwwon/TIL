## Event

> 특정 사건

- DOM Event

```html
<button onclick="activate()">
	Activate
</button>
```

- react Event

```jsx
<button onClick={activate}>
	Activate
</button>
```

- 차이점
  - 이벤트 이름 표기법 : 리액트는 카멜 표기법을 사용 (camelCase)
  - DOM에서는 이벤를 처리할 함수를 문자열로 전달, 리액트에서는 함수 그대로 전달

<br>

## Event Handler

> Event Listener : 어떤 사건이 발생하면 사건을 처리하는 역할

### class component

```jsx
class Toggle extends React.Component{
    constructor(props) {
        super(props);
        
        this.state = {isToggleOn: true};
        // callback에서 'this'를 사용하기 위해서는 바인딩을 필수적으로 해줘야함
        this.handleClick = this.handleClick.bind(this);
    }
    
    handleClick() {
        this.setState(prevState => ({
            isToggleOn: !prevState.isToggleOn
        }));
    }
    render(){
        return(
            <button onClick={this.handleClick}>
            	{this.state.isToggleOn ? '켜짐' : '꺼짐'}
            </button>
        );
    }
}
```

- 바인드(bind)하는 이유 : js에서는 기본적으로 class 함수들이 바운드되지 않기 때문에, 바인드 하지 않으면 this.handleClick은 글로벌스코프(Global Scope)에서 호출되게되고 여기서 this.handleClick은 undefined로 사용할 수 없음
- Class fileds syntax 사용 (바인드 사용하지 않을 때)

```jsx
class MyButton extends React.Component {
    handleClick = () => {
        console.log('this is:', this);
    }
    render(){
        return (
            <button onClick={this.handleClick}>
            	Click
            </button>
        );
    }
}
```

- Arrow function 사용(바인드 사용하지 않을 때)

```jsx
class MyButton extends React.Component {
    handleClick(){
        console.log('this is:', this);
    }
    render(){
        return (
            // myButton 컴포넌트가 랜더링될 때 마다 다른 콜백 함수가 생성되는 문제 발생
            // 하위 컴포넌트의 props으로 넘겨지게 되면, 추가적인 랜더링 발생이되므로 성능저하 발생 가능
            <button onClick={() => this.handleClick()}>
            	Click
            </button>
        );
    }
}
```

<br>

### function component

```jsx
function Toggle(porps){
    const [isToggleOn, setISToggleOn] = useState(true);
    
    // 방법1. 함수 안에 함수로 정의
    function handleClick(){
        setIsToggleOn((isToggleOn) => !isToggleOn);
    }
    
    // 방법2. arrow function을 사용하여 정의
    const handleClick = () => {
        setIsToggleOn((isTobbldon) => !isToggleOn);
    }
    
    return(
        // this 사용하지 않음
        <button onClick={handleClick}> 
        	{isToggleOn ? '켜짐' : '꺼짐'}
        </button>
    );
}
```



## Arguments 전달

> Argument : 주장
>
> 함수(Event Handler, 파라미터, 매개변수)에 전달할 데이터

### class component

```jsx
// Arrow function 사용
<button onClick={(event) => this.deleteItem(id, event)}>삭제하기</button>

// bind 사용
<button onClick={this.deleteItem.bind(this, id)}>삭제하기</button>
```

### function component

```jsx
function MyButton(props){
    // 매개변수 순서 상관없음
    const handleDelete = (id, event) => {
        console.log(id, event.target);
    };
    
    return(
        <button onClick={(event) => handleDelete(1, event)}>
        	삭제하기
        </button>
    );
}
```

