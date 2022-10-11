## useMemo()

> Memoized value를 리턴하는 Hook

- Memoization(최적화)
  - 비용이 높은, 연산량이 많이 드는 함수의 호출결과를 저장하고 같은 입력값으로 함수를 호출하면 새로 함수를 호출하는 것이 아니라 저장된 결과를 리턴함
  - 호출 시간 단축과 불필요한 중복연산 제거함으로써 컴퓨터 자원을 적게 사용함
  - Memoization된 결과값을 Memoized value라고 부름
- 사용법

```jsx
const memoizedValue = useMemo(
    // 파라미터로 받는 Memoized value를 생성하는 create function
	() => {
        // 연산량이 높은 작업을 수행하여 결과를 반환
        return computeExpensiveValue(의존성 변수1, 의존성 변수2);
    },
    [의존성 변수1, 의존성 변수2] // 파라미터로 받는 의존성 배열
);
```

- 장점

  - 다시 렌더링될 때 마다 연산량이 높은 작업을 반복하는 것을 피할 수 있음
  - 결과적으로 빠른 렌더링속도를 얻을 수 있음

- 유의점

  - useMemo()로 전달된 함수는 랜더링이 일어나는 동안 실행됨
  - **따라서 랜더링이 될 때 실행되면 안되는 작업을 useMemo()에 넣으면 안됨 (sideEffect X)**
  - 의존성 배열을 넣지 않을 경우, 매 렌더링마다 create function이 실행됨으로 useMemo()를 사용하는 의미가 사라짐 **(의존성 배열을 꼭 사용하자)**
  - 의존성 배열이 빈 배열일 경우, 컴포넌트 **Mount 시에만 create function이 호출 됨(값 변경X)**



<br>

## useCallback()

> useMemo() Hook과 유사하지만, 값이 아닌 **함수를 반환**
>
> 의존성 배열의 값이 변한 경우에만 함수를 재정의해서 리턴

- 사용법

```jsx
const momoizedCallback = useCallback(
    // 파라미터로 받는 create function (Callback, 콜백)
	() => {
        doSomthing(의존성 변수1, 의존성 변수2);
    },
    [의존성 변수1, 의존성 변수2] // 파라미터로 받는 의존성 배열
    
    // 의존성 배열의 값이 바뀌면 Memoized callback function 반환
);
```



<br>

### useMemo(), useCallback()

- 동일한 역할을 하는 두 줄의 코드

```jsx
// useCallback(함수, 의존성 배열);
// useMemo(() => 함수, 의존성 배열);
```

<br>



## useRef()

> Reference를 사용하기 위한 Hook
>
> Reference 객체 반환

- Reference : 특정 컴포넌트에 접근할 수 있는 **객체**

- refObject.current : 레퍼런트 객체의 current 속성
  - **현재 참조하고 있는 Element**
  - 본질적으로 `useRef`는 `.current` 프로퍼티에 변경 가능한 값을 담고 있는 “상자”와 같음
- 반환된 객체는 컴포넌트의 전 생애주기를 통해 유지됨
- 사용법

```jsx
// const refContainer = useRef(초깃값); 해당 초기값으로 초기화된 레퍼런스 객체를 반환
function TextInputWithFocusButton(props){
    const inputElem = useRef(null);
    
    const onButtonClick = () => {
        // 'current'는 Mount된 input element를 가리킴
        inputElem.current.focus();
    };
    
    return (
    	<>
        	<input ref={inputElem} type="text" />
        	<button onClick={onButtonClick}>
        		Focus the input
        	</button>
        </>
    );
}    
```

- 유의점
  - useRef() Hook은 내부의 데이터(current 속성)가 변경되었을 때 별도로 알려주지 않음
  - `.current` 프로퍼티를 변형하는 것이 재 렌더링을 발생시키지는 않음
  - ref의 DOM node가 연결되거나 분리되었을 경우 코드를 실행하고 싶다면(DOM node의 변화를 알기 위해)
  - Callback ref 방식 사용 : 다른 노드에 연결될 때마다 콜백 호출

```jsx
// 콜백 ref는 렌더링 된 <h1> 컴포넌트가 재렌더링되는 동안 모두 존재하기 때문에 컴포넌트가 마운트 및 마운트 해제될 때만 호출됨
function MeasureExample(props){
    const [height, setHeight] = useState(0);
    
    const measureRef = useCallback(node => {
        if(node !== null){
            setHeight(node.getBoundingClientRect().height);
        }
    }, []); // Mount, Unmount 될때만 호출
    
    return (
    	<>
        	<h1 ref={measureRef}>안녕, 리액트</h1>
        	<h2>위 헤더의 높이는 {Math.round(height)}px 입니다.</h2>
        </>
    );
}
```

