# Hooks

> 리액트 함수 컴포넌트 (React Function Component)

- 개념
  - 리액트 Component에는 Function Component와 Class Component가 있음
  - Class Component에서는 생성자에서 state를 정의하고 Lifecycle method를 제공함
  - 반면, Function Component에서는 state 사용이 불가능하고 Lifecycle에 따른 기능 구현이 불가함
  - 따라서 Function Component의 이런 기능을 지원하기 위해서 나온 것이 Hook
  - 마치 갈고리를 거는 것처럼 끼워 같이 수행되는 것
  - Hooks의 이름은 모두 use로 시작
  - useState(), useEffect()


<br>

## Hooks API

> React에 내장된 Hook API

- 기본 Hook
  - useState
  - useEffect
  - useContext
- 추가 Hooks
  - useReducer
  - useCallback
  - useMemo
  - useRef
  - useImperativeHandle
  - useLayoutEffect
  - useDebugValue
  - useDeferredValue
  - useTransition
  - useId
- Libary Hooks
  - useSyncExternalStore
  - useInsertionEffect
