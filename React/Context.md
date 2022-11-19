## Context

> 리액트 컴포넌트들 사이에서 데이터를 기존의 props로 전달하는 대신, Component Tree를 통해 곧바로 Component로 전달하는 새로운 방식제공

- 어떤 컴포넌트라도 쉽게 데이터에 접근 가능

- 기존 방식 

<img src="..\img\root_DOM_node.jpg" style="height: 250px">

- Context 사용
  - 데이터를 필요로하는 컴포넌트에 곧바로 전달
  - 코드 간소화
  - 코드를 한 곳에서 관리하기때문에 디버깅 용이


<img src="..\img\context.jpg" style="height: 250px">



- Context를 사용해야 하는 경우

>  여러 개의 컴포넌트들이 접근해야 하는 데이터 (로그인 여부, 로그인 정보, UI 테마 , 현재 언어 등)

```jsx
functio App(props){
    return <Toolbar theme="dark" />;
}

function Toolbar(props){
    
    // 이 Toolbar 컴포넌트는 ThemeButton에 theme을 넘겨주기 위해 'theme' prop을 가져아함
    // 현재 테마를 알아야 하는 모든 버튼에 대해 props로 전달하는 비효율 발생
    // 직관적이지 않음
    retrun (
        <div>
        	<ThemeButton theme={props.theme} />
        </div>
    );
}

function ThemeButton(props){
    return <Button theme={props.theme} />;
}
```

<br>

- Context 사용 예

> React.createContext() 사용

```jsx
// 컨텍스트는 데이터를 매번 컴포넌트를 통해 전달할 필요 없이, 컴포넌트 트리로 곧바로 전달
// 여기에서는 현재 테마를 위한 컨텍스트를 생성하며, 기본값은 'light'
const ThemeContext = React.createContext('light');

// Provider를 사용하여 하위 컴포넌트들에게 현재 테마 데이터 전달
// 모든 하위 컴포턴트들은 컴포넌트 트리 하단에 얼마나 깊이 있는지 관계없이 데이터 접근 가능
// 여기에서는 현재 테마값으로 'dark'를 전달
function App(props){
    return (
    
        <ThemeContext.Provider value="dark">
        	<Toolbar />
        </ThemeContext.Provider>
    
    );
}

// 이제 중간에 위치한 컴포넌트는 테마 데이터를 하위 컴포넌트에 전달하지 않아도 됨
function Toolbar(props){
    return (
        <div>
        	<ThemeButton />
        </div>
    );
}

// 리액트는 가장 가까운 상위 테마 Provider를 찾아서 해당되는 값을 사용함
// 만약 해당하는 Provider가 없을 경우, 기본값을 사용 ('light')
// 여기서는 상위 Provider가 있기 때문에 현재 테마의 값은 'dark'
function TememButton(props){
    return (
        <ThemeContext.Consumer>
        	{value => <Button theme={value} /> }
        </ThemeContext.Consumer>
    );
}
```

<br>

### Context를 사용하기 전에 고려할 점

- Component와 Context가 연동되면 **재사용성이 떨어짐**

- 다른 레벨의 많은 컴포넌트가 데이터를 필요로 하는 것이 아니라면, 기존에 사용하던 props를 통해 넘겨주는것이 좋음 (Component Composition 방법)

```jsx
// 하위 컴포넌트로 데이터를 계속 넘겨주는 예시
// Page 컴포넌트는 PageLayout 컴포넌트를 렌더링
<Page user={user} avatarSize={avatarSize} />

// PageLayout 컴포넌트는 NavigationBar 컴포넌트를 렌더링
<PageLayout user={user} avatarSize={avatarSize} />

// NavigationBar 컴포넌트는 Link 컴포넌트를 렌더링
<NavigationBar user={user} avatarSize={avatarSize} />

// Link 컴포넌트는 Avatar 컴포넌트를 렌더링
<Link href={user.permalink}>
	<Avatar user={user} avatarSize={avatarSize} />
</Link>
```

- Context를 사용하지 않고 해결

> 컴포넌트를 변수에 저장하여 직접 넘겨주는 것 (Element Variable 형태)

```jsx
// 가장 상위레벨에 있는 컴포넌트(Page)만 아바타 컴포넌트에서 필요로 하는 user와 avatarSize에 대해 알고 있으면됨
// props를 사용하지 않아 코드를 간결하게 만들면서, 최상위 컴포넌트에 좀 더 많은 권한을 부여해줌
// 데이터가 많아질수록 상위 컴포넌트에 몰리기 때문에, 상위 컴포넌트는 복잡해지고 하위 컴포넌트들은 너무 유연해지게 됨
function Page(props){
    const user = props.user;
    
    const userLink = (
        <Link href={user.permalink}>
        	<Avatar user={user} avatarSize={props.avatarSize} />
        </Link>
    );
    
    // Page 컴포넌트는 PageLayout 컴포넌트를 렌더링
    // 이때 props로 userLink를 함께 전달
    return <PageLayout userLink={userLink} />;
}

// pageLayout 컴포넌트는 NavigationBar 컴포넌트를 렌더링
<PageLayout userLink={...} />

// NavigationBar 컴포넌트는 props로 전달받은 userLink element를 리턴
<NavigationBar userLink={...} />
```

<br>

- 하위 컴포넌트를 여러개의 변수로 나누어 전달

> 하위 컴포넌트의 의존성을 상위 컴포넌트와 분리할 필요가 있는 대부분의 경우에 사용됨

```jsx
function Page(props){
    const user = props.user;
    
    const topBar = (
        <NavigationBar>
            <Link href={user.permalink}>
            	<Avatar user={user} size={props.avatarSize} />
            </Link>
        </NavigationBar>
    );
    
    const content = <Feed user={user} />;
    
    return (
    	<PageLayout 
            	topBar={topBar}
            	content={content}
            />
    );
}
```

- 렌더링 전에 하위 컴포넌트가 상위 컴포넌트와 통신해야하는 경우 render props를 사용하여 처리할 수 있음

- 하나의 데이터에 다양한 레벨에 있는 중첩된 컴포넌트들이 접근해야할 필요가 있는 경우 Context 사용해야함

- Context는 해당 데이터와 데이터의 변경사항을 모두 하위 컴포넌트들에게 Broadcast 해주기 때문임

- 현재 지역정보, UI 테마,  캐싱된 데이터

