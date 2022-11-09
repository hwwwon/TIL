## Conditional Rendering

> 조건(조건문)에 따른(true, flase) 렌더링 (조건부 렌더링)
>
> 어떠한 조건에 따라서 렌더링이 달라지는 것

```jsx
function UserGreeting(props){
    return <h1>다시 오셨군요!</h1>;
}

function GuestGreeting(props){
    return <h1>회원가입을 해주세요.</h1>;
}

function Greeting(props){
    const isLoggedIn = props.isLoggedIn;
    
    if(isLoggedIn) {
        return <UserGreeting />;
    }
    retrun <GuestGreeting />;
}
```



- JavaScript의 Truthy와 Falsy
  - Truthy : true는 아니지만 true로 여겨지는 값
  - Falsy : false는 아니지만 false로 여겨지는 값

``` js
// truethy
true
{} (empty object)
[] (empty array)
42 (number, not zero)
"0", "false" (string, not empty)

// falsy
false
0, -0 (zero, minus zero)
0n (BigInt zero)
'', '', `` (empty string)
null
undefined
NaN (not a number)
```

<br>

## Element Variables

> 앨리먼트 변수 : 리액트 앨리먼트를 변수처럼 다루는 것

```jsx
function LoginButton(props){
    return(
        <button onClick={props.onClick}>
        	로그인
        </button>
    );
}

function LogoutButton(props){
    return (
        <button onClick={props.onClick}>
        	로그아웃
        </button>
    );
}

function LoginControl(props){
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    
    const handleLoginClick = () => {
        setIsLoggedIn(true);
    }
    
    const handleLogoutClick = () => {
        setIsLoggedIn(false);
    }
    
    let button;
    if(isLoggedIn){
        button = <LogoutButton onClick={handleLogoutClick} />;
    }else{
        button = <LoginButton onClick={handleLoginClick} />;
    }
    
    return(
        <div>
        	<Greeting isLoggedIn={isLoggedIn} />
            {button}
        </div>
    );
}
```

<br>

## Inline Conditions

> 조건문을 코드 안에 집어넣는 것
>
> 해당 코드가 필요한 라인에 직접 집어 넣어 사용

- Inline If
  - {} 중괄호 사용
  - If문의 경우 && 연산자를 사용
  - && : 모두 ture이어야 true
    - 단축 평가
    - true && expresstion = expresstion
    - false && expresstion = false
  - false expresstion 사용시 주의 : false expresstion 결과값이 그대로 리턴


```jsx
function Mailbox(props){
    const unreadMessages = props.unreadMessages;
    
    return(
        <div>
            <h1>안녕</h1>
            {unreadMessages.length > 0 &&
                <h2>
             		현재 {unreadMessages.length}개의 읽지 않은 메시지가 있습니다.
             	</h2>
            }
        </div>
    );
}
```

  <br>

- Inline If-Else
  - 조건문의 값에 따라서 다른 Element를 렌더링 할 때 사용
  - ? 연산자 사용 (삼항연산자)
  - condition ? true : false

```jsx
function UserStatus(props){
    return(
        <div>
            이 사용자는 현재 <b>{porps.isLoggedIn ? '로그인' : '로그아웃'}</b> 상태입니다.
        </div>
    );
}

function LoginControl(props){
    const[isLoggedIn, setIsLoggedIn] = useState(false);
    
    const handleLoginClick = () => {
        setIsLoggedIn(true);
    }
    
    const handleLogoutClick = () => {
        setIsLoggedIn(false);
    }
    
    return(
        <div>
        	<Greeting isLoggedIn={isLoggedIn} />
            {isLoggedIn
            	? <LogoutButton onClick={handleLogoutClick} />
             	: <LoginButton onClick={handleLoginClick} />
            }
        </div>
    );
}
```



## Component 렌더링 막기

> null을 리턴하면 렌더링되지 않음

```jsx
function WarningBanner(props){
    if(!props.warning){
        return null;
    }
    return (
        <div>경고!</div>
    );
}

function MainPage(props){
    const [showWarning, setShowWarning] = useState(false);
    
    const handleToggleClick = () => {
        
        setShowWarning(prevShowWarning => !prevShowWarning);
    }
    
    return(
        <div>
        	<WarningBanner warning={showWarning} />
            <button onClick={handleToggleClick}>
            	{showWarning ? '감추기' : '보이기'}
            </button>
        </div>
    );
}
```

