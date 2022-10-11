## Hook의 규칙

### 1. Hook은 무조건 최상위 레벨에서만 호출해야 함

- 최상위 레벨 : React Function Component의 최상위 레벨
  - 조건문, 반복문, 중첩된 함수들 안에서 Hook을 호출하면 안됨

- Hook은 Component가 렌더링될 때마다 **매번 같은 순서로** 호출되어야 함

<br>

### 2. 리액트 함수 컴포넌트에서만 Hook을 호출해야 함

- 일반적인 자바스크립트 함수에서 Hook을 호출하면 안됨
- 리액트 함수 컴포넌트나 커스텀 훅에서만 호출가능

<br>

## Custom Hook 만들기

> 여러 컴포넌트에서 반복적으로 사용되는 로직을 Hook으로 만들어 재사용하기 위함

- 이름이 use로 시작하고 내부에서 다른 Hook을 호출하는 하나의 자바스크립트 함수

- 여러 개의 컴포넌트에서 하나의 Custom Hook을 사용할 때 컴포넌트 내부에 있는 모든 state와 effect는 전부 분리되어 있음
  - 리액트 컴포넌트는 각각의 Custom Hook 호출에 대해 분리된 state를 얻게됨
- 각 Custom Hook의 호출 또한 완전히 독립적임

```jsx
// 중복되는 코드 추출

import {useState, useEffect} from "react";

function useUserStatus(userId){
    const [isOnline, setIsOnline] = useState(null);
    
    useEffect(() => {
        function handleStatusChange(status){
            setIsOnline(status.isOnline);
        }
        
        ServerAPI.subscribeUserStatus(userId, handleStatusChange);
        return () => {
            ServerAPI.unsubscribeUserStatus(userId, handleStatusChange);
        };
    });
    
    return isOnline;
}

// Custom Hook 적용1
function UserStatus(props){
    const isOnline = useUserStatus(props.user.id);
    
    if(isOnline === null){
        return '대기중...';
    }
    
    return isOnline ? '온라인' : '오프라인';
}

// Custom Hook 적용2
function UserListItem(props){
    const isOnline = useUserStatus(props.user.id);
    
    return (
        <li style={{ color: isOnline? 'green' : 'black' }}>
        	{props.user.name}
        </li>
    );
}
```





## Hook들 사이에서 데이터를 공유하는 방법

```jsx
const userList = [
    { id:1, name: 'Inje' },
    { id:2, name: 'Hike' },
    { id:3, name: 'Steve' },
];

function ChatUserSelector(props){
    const [userId, setUserId] = useState(1);
    const isUserOnline = useUserState(userId); // 커스텀 훅에서 userId 값 사용
    
    return (
    	<>
        	<Circle color={isUserOnline ? 'green' : 'red'} />
        	<select
                value={userId}
                onChange={event => setUserId(Number(event.target.value))}
            >
        		{userList.map(() => {
                	<option key={user.id} value={user.id}>
                		{user.name}
                	</option>
            	})}
        	</select>
        </>
    );
}
```

