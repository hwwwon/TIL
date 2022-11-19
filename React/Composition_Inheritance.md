## Composition

> 합성
>
> 여러 개의 컴포넌트들을 합쳐서 새로운 컴포넌트를 만드는 것

- 여러 개의 컴포넌트들을 어떻게 조합할 것인가?
- 조합 방법에 따라 Composition의 사용 기법이 달라짐
  - Containment
  - Specialization

<br>

### Containment

> 담다, 포함하다
>
> props.children이나 직접 정의한 props를 사용하여, 하위 컴포넌트를 포함하는 형태의 합성 방법

- Sidebar나 Dialog 같은 Box 형태의 컴포넌트는 자신의 하위 컴포넌트를 미리 알 수 없음
- 각 사이트의에 따라 담을 하위 컴포넌트의 특성이 달라짐
- 기본적으로 컴포넌트의 prop에서 제공하는 children을 사용하여 조합
- 해당 컴포넌트의 하위 컴포넌트가 모두 children으로 들어감

``` jsx
// children prop을 사용한 FancyBorder 컴포넌트
function FancyBorder(props){
    return (
        <div className={'FancyBorder FancyBorder-' + props.color}>
        	{props.children}
        </div>
    );
}

/* 
React.createElement(

	type,
	[props],
	[...children]

);
*/


// FancyBorder 컴포넌트 안에 있는 모든 JSX 태그는 children으로 전달됨
function WelcomeDialog(props){
    return (
        <FancyBorder color="blue">
            <h1 className="Dialog-title">어서오세요</h1>
            <p className="Dialog-message">우리 사이트에 방문하신 것을 환영합니다!</p>
        </FancyBorder>
    );
}
```

<br>

- 여러 개의 children 집합이 필요한 경우

> 별도로 props를 정의해서  각각 원하는 컴포넌트를 넣으면 됨

```jsx
functio SplitPane(props){
    return (
        <div className="SplitPane">
            <div className="SplitPane-left">
            	{props.left}
            </div>
            <div className="SplitPane-right">
            	{props.right}
            </div>
        </div> 
    );
}

function App(props){
    return (
    	<SplitPane 
            
            left={<Contacts />}
            right={<Chat />}
            
            />
    );
}
```

<br>

### Specialization

> 범용적인 개념을 구별이 되게 구체화 하는 것 (전문화, 특수화)
>
> 범용적으로 사용할 수 있는 컴포넌트를 만들어 놓고, 이를 특수화시켜 사용함

- 기존의 객체 지향 언어에서는 상속(Inheritance)을 사용하여 Specialization을 구현
- 리액트에서는 합성(Composition)을 사용하여 Specialization을 구현

```jsx
function Dialog(props){
    return (
        <FancyBorder>
            <h1 className="Dialog-title">
            	{props.title}
            </h1>
            <p className="Dialog-message">
            	{props.message}
            </p>
        </FancyBorder>
    );
}

function WelcomeDialog(props){
    return (
    	<Dialog 
            title="어서오세요"
            message="우리 사이트에 방문하신 것을 환영합니다."
            />
    );
}
```

<br>

### Containment와 Specialization 같이 사용

- Dialog 컴포넌트

```jsx
function Dialog(props){
    return (
        <FancyBorder>
            <h1 className="Dialog-title">
            	{props.title}
            </h1>
            <p className="Dialog-message">
            	{props.message}
            </p>
            {props.children}
        </FancyBorder>
    );
}
```

```jsx
function SignUpDialog(props){
    const [nickname, setNickname] = useState('');
    
    const handleChange = e => {
        setNickname(e.target.value);
    }
    
    const handleSignUp = () => {
        alert(`어서오세요, ${nickname}님`);
    }
    
    return (
        <Dialog title="화성 탐사 프로그램" message="닉네임을 입력해 주세요"> // Specialization
            // Containment
        	<input value={nickname} onChange={handleChange} />
            <button onClick={handleSignUp}>회원가입</button>
            
        </Dialog>
    );
}
```

<br>

## Inheritance

-  Composition과 대비되는 개념
- 다른 컴포넌트로부터 상속을 받아서 새로운 컴포넌트를 만드는 것

<br>

## 결론

> 복잡한 컴포넌트를 쪼개서 여러 개의 컴포넌트로 만들고, 만든 컴포넌트들을 조합하여 새로운 컴포넌트를 만들어 사용
