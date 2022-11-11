## Form

> 사용자로부터 입력을 받기위해 사용

- HTML Form

  - 각 Element가 자체적으로 state를 관리

- Controlled Component

  - 모든 데이터를 Component state에서 관리

  

<br>

## Controlled Component

> 사용자가 입력한 값에 접근하고 제어할 수 있도록 하는 컴포넌트
>
> 값이 리액트의 통제를 받는  Input Form Element

```jsx
function NameForm(props){
    const [value, setValue] = useState('');
    
    const handleChange = (e) => {
    	setValue(e.target.value);
    }
    
    const handleSubmit = (event) => {
        alert('입력한 이름: ' + value);
        event.preventDefault();
    }
    
    return (
        <form onSubmit={handleSubmit}>
            <label>
            	이름:
                <input type="text" value={value} onChange={handleChange} />
            </label>
            <button type="submit">제출</button>
        </form>
    );
}
```

