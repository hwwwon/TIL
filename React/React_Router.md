## react-router-dom

> 리액트를 위한 라우팅 라이브러리

- router : 노선, 경로
- 라우팅을 쉽게 구현할 수 있도록 리액트 컴포넌트 형태로 제공해주는 라이브러리

- App.js 파일의 App 컴포넌트에 구현

- App 컴포넌트가 가장 처음으로 렌더링되는 컴포넌트이기 때문임

- 라우팅 구성 예시

```jsx
// 웹브라우저에서 리액트 라우터를 사용하여 라우팅을 할 수 있도록 해주는 컴포넌트 (브라우저의 history를 이용하여 경로를 탐색할 수 있도록 해줌)
<BrowserRouter>
    // 라우팅 경로를 구성할 수 있게 해주는 컴포넌트
    <Routes>
        // path(경로)와 element(경로와 일치하는 리액트 앨리먼트)라는 props를 가짐
    	<Route index element={<MainPage />} />
        <Route path="places" element={<PlacePage />} />
        <Route path="games" element={<GamePage />} />
    </Routes>
</BrowserRouter>
```

<br>

## useNavigate()

> 페이지간 이동 hook

```jsx
function SampleNavigate(props){
    const navigate = useNavigate();
    
    const moveToMain = () => {
        navigate("/");
    }
    
    return (
    	...
    );
}
```



