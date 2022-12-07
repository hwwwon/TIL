## Context API

> React에서 제공하는 API

- Context 생성
  - **React.createContext() 함수 사용**
  - `const MyContext = React.createContext(기본값);`
  - Context 객체가 생성됨
  - 렌더링 될 때 Context 객체를 구독하는 하위 컴포넌트가 존재하면, 현재 Context 값을 가장 가까이에 있는 상위레벨의 Provider로 부터 받아옴
  - 만약 상위레벨에 매칭되는 Provider가 없다면 기본값이 사용 됨
  - 기본값은 Provider없이 컴포넌트를 테스트 할 때 유용함
  - 기본값으로 undefined를 넣으면 기본값이 사용되지 않음
- Context.Provider
  - 모든 Context 객체는 Provider라는 React Component를 가지고 있음
  - Context.Provider로 하위 컴포넌트들을 감싸주면, 모든 하위 컴포넌트들이 해당 컨텍스트의 데이터에 접근할 수 있음
  - `<MyContext.Provider value={/* some value */}>`
  - value prop은 provider 컴포넌트의 하위 컴포넌트들에게 전달되는 데이터
- Context.Consumer
  - Context 컴포넌트의 변화를 지켜보다가 값이 변하면 재렌더링 됨
  - 하나의 Provider 컴포넌트는 여러개의 Consuming 컴포넌트와 연결될 수 있고
  - 여러개의 Provider 컴포넌트는 중첩되어 사용될 수 있음
  - 값을 판단하는 기준은 자바스크립트 객체의 Object.is()와 같은 방식으로 판단함

<br>

### Provider value에서 주의 사항

> Provider 컴포넌트가 재렌더링될 때마다 모든 하위 Consumer 컴포넌트가 재렌더링 됨

- Provider 컴포넌트의 value가 매번 새롭게 생성

```jsx
function APP(Props){
    return (
        <MyContext.Provider value={{ something: 'something' }}>
        	<Toolbar />
        </MyContext.Provider>
    );
}
```

- 이를 방지하기 위해서는 value prop에 직접 넣는 것이 아닌 컴포넌트의 state 사용
- state를 사용하여 불필요한 재렌더링을 막음

```jsx
function APP(props){
    const [value, setValue] = useState({ something: 'something' });
    
    return (
        <MyContext.Provider value={value}>
        	<Toolbar />
        </MyContext.Provider>
    );
}
```

<br>

### Class Component의 Context 구독

> Class.contextType
>
> Provider 하위에 있는 Class Component에서 Context의 데이터에 접근하기 위해 사용
>
> 단 하나의  context만을 구독할 수 있음

```jsx
class MyClass extends React.Component {
    componentDidMount(){
        // MyContext의 값을 이용하여 원하는 작업 수행 가능
        let value = this.context;
    }
    
    componentDidUpdate(){
        // MyContext의 값을 이용하여 원하는 작업 수행 가능
        let value = this.context;
    }
    
    componentWillUnmount(){
        // MyContext의 값을 이용하여 원하는 작업 수행 가능
        let value = this.context;
    }
    
    render(){
        // MyContext의 값에 따라 컴포넌트들을 렌더링
        let value = this.context;
    }
}

MyClass.contextType = MyContext;
```

<br>

### Function Component의 Context 구독

> Context.Consumer

```jsx
<MyContext.Consumer>
    // function as a child
	{value => /* 컨텍스트의 값에 따라서 컴포넌트들을 렌더링 */}
</MyContext.Consumer>
```

- function as a child

  > 컴포넌트의 자식으로 함수를 사용하는 방법

  - 리액트에서는 children이라는 prop으로 하위 컴포넌트를 전달
  - 컴포넌트대신 함수 사용

```jsx
// children이라는 prop을 직접 선언하는 방식
<Profile children={name => <p>이름: {name}</p>} />

// Profile 컴포넌트로 감싸서 children으로 만드는 방식
<Profile>{name => <p>이름: {name}</p>}</Profile>
```

<br>

### Context.displayName

> Context 객체는 displayName이라는 문자열 속성을 가짐

```jsx
const MyContext = React.createContext('기본값');
MyContext.displayName = 'MyDisplayName';

// 개발자 도구에 "MyDisplayName.Provider"로 표시됨
<MyContext.Provider></MyContext.Provider>

// 개발자 도구에 "MyDisplayName.Consumer"로 표시됨
<MyContext.Consumer></MyContext.Consumer>
```

<br>

### 여러 개의 Context 사용하기

- 여러 개의 Context를 동시에 사용할 수 있지만,  많은 컨텍스트의 값이 자주 함께 사용될 경우 모든 값을 한번에 제공해주는 별도의 render prop 컴포넌트를 직접만드는것이 나을 수 있음

```jsx
// 테마를 위한 컨텍스트
const ThemeContext = React.createContext('light');

// 로그인 한 사용자를 위한 컨텍스트
const UserContext = React.createContext({
    name: 'Guest',
});

class App extends React.Component{
    render(){
        const {signedInUser, theme} = this.props;
        
        // APP component that provides initial context values
        return (
            <ThemeContext.Provider value={theme}>
                <UserContext.Provider value={signedInUser}>
                	<Layout />
                </UserContext.Provider>
            </ThemeContext.Provider>
        );
    };
}

function Layout(){
    return (
        <div>
        	<Sidebar />
            <Content />
        </div>
    );
}

// zjsxprtmxm 컴포넌트는 두 개의 컨텍스트로부터 값을 가져와서 렌더링함
function Content(){
    return (
        <ThemeContext.Consumer>
        	{theme => (
                <UserContext.Consumer>
                	{user => (
                    	<ProfilePage user={user} theme={theme} />
                    )}
                </UserContext.Consumer>
            )}
        </ThemeContext.Consumer>
    );
}
```

<br>

### useContext()

> hook을 이용한 Context 사용

- function component에서 context를 사용하기위해, componet를 매번 context.Consumer 컴포넌트로 감싸줘야하는 번거로움 해결
- 컨텍스트를 쉽게 사용할 수 있음

```jsx
functio MyComponent(props){
    // useContext의 파라미터로 Context 객체를 꼭 넣어줘야 함
    const value = useContext(MyContext);
    
    return (
    	...
    );
}
```

- 상위 Provider의 Context 값이 변경되면 변경된 값과 함께 useContext hook을 사용하는 컴포넌트가 재렌더링되기 때문에, 해당 컴포넌트가 꽤 무거운 작업일 경우에는 별도로 최적화 작업을 해줘야 함