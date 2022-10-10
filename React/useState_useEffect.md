## useState()

> state를 사용하기 위한 Hook

- 사용법

```jsx
// const [변수명, set함수명] = useState(초기값);  useState를 호출하면 리턴 값으로 배열이 나옴

import React, { useState } from "react";

function Counter(props){
    const [count, setCount] = useState(0); // 변수 각각에 대해 set함수가 따로 존재
    
    return (
        <div>
            <p>총 {count}번 클릭했습니다.</p>
            <button onClick={() => setCount(count + 1)}>
            	클릭
            </button>
        </div>
    );
}
```

<br>

## useEffect()

> Side effect를 수행하기 위한 Hook
>
> 생명주기 함수와 동일한 기능수행 가능

- **side effect : 효과, 영향 (부작용X)**

  - 수동으로 DOM을 변경하거나 Server에서 데이터를 받아오는 등의 작업

  - 다른 컴포넌트에 영향을 미칠 수 있으며, 렌더링 중에는 작업이 완료될 수 없기 때문
  - 렌더링이 끝난 이후에 실행되어야 하는 작업들

- Class Component의 Lifecycle 함수인 componentDidMount(), componentDidUpdate(), componentWillUnmount()와 동일한 기능을 하나로 통합해서 제공

- 사용법

  - **useEffect(이펙트 함수, 의존성 배열);**
  - 이펙트 함수 : 처음 컴포넌트가 렌더링된 이후(mount)와 재렌더링 이후(update)에 때 실행됨
  - 의존성 배열 : effect가 의존하고있는 배열, 배열안에 있는 변수 중에 하나라도 값이 변경되면 "이펙트 함수"가 실행됨

- **의존성 배열이 빈 배열인 경우**

  - useEffect(이펙트 함수, []);
  - 이펙트 함수가 mount와 unmount 시에 단 한번씩만 실행됨
  - 해당 이펙트 함수가 props나 state에 있는 어떤 값에도 의존하지 않는 것이 됨으로 여러번 실행되지 않음

- **의존성 배열을 생략할 경우**

  - useEffect(이펙트 함수);
  - 컴포넌트가 업데이트될 때마다 호출 됨

- 특징

	- Function Component 안에서 선언되기 때문에, 해당 컴포넌트의 props와 state에 접근 가능
	- 하나의 컴포넌트에  useEffect Hook 여러개 사용 가능

```jsx
import React, { useState, useEffect} from "react";

function Counter(props){
    const [count, setCount] = useState(0);
    
    // componentDidMount, componentDidUpdate와 비슷하게 작동
    useEffect(() => {
        // 브라우저 API를 사용해서 document의 title을 업데이트 함
        document.title = `You clicked ${count} times`;
    });
    
    return (
        <div>
            <p>총 {count}번 클릭했습니다.</p>
            <button onClick={() => setCount(count + 1)}>
            	클릭
            </button>
        </div>
    );
}
```

- componentWillUnmount

```jsx
import React, { useState, useEffect } from "react";

function UserStatus(props){
    const [isOnline, setIsOnline] = useState(null);
    
    function handleStatusChange(status){
        setIsOnline(status.isOnline);
    }
    
    useEffect(() => {
        ServerAPI.subsribeUserState(props.user.id, handleStatusChange);
        //컴포넌트가 마운트 해제되기 전에 실행됨(componentWillUnmount)
        return () => {
            ServerAPI.unsubscribeUserStatus(props.user.id, handleStatusChange);
        };
    });
    
    if(isOnline === null){
        return `대기 중...`;
    }
    
    return isOnline? `온라인` : `오프라인`;
}
```