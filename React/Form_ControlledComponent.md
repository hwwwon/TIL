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
    
    // 제어 및 변경
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

- 사용자의 입력을 직접적으로 제어할 수 있음

<br>

## 여러 종류의 Form

### Textarea

> 여러 줄에 걸쳐 긴 텍스트를 입력받기 위한 HTML 태그

```jsx
functio RequestForm(props){
    const [value, setValue] = useState('요청사항을 입력하세요.');
    
    const handleChange = e => {
        setValue(e.target.value);
    }
    
    const handleSubmit = e => {
        alert('입력한 요청사항 : ' + value);
        e.preventDefault();
    }
    
    return (
        <form onSubmit={handleSubmit}>
            <lable>
            	요청사항: 
                <textarea value={value} onChange={handleChange} />
            </lable>
            <button type="submit">제출</button>
        </form>
    );
}
```



<br>

### Select

> Drop-down 목록을 보여주기위한 HTML 태그

```jsx
functio RequestForm(props){
    const [value, setValue] = useState('grape');
    
    const handleChange = e => {
        setValue(e.target.value);
    }
    
    const handleSubmit = e => {
        alert('선택한 과일 : ' + value);
        e.preventDefault();
    }
    
    return (
        <form onSubmit={handleSubmit}>
            <lable>
            	과일을 선택하세요: 
                <select value={value} onChange={handleChange}>
                    <option value="apple">사과</option>
                    <option value="banana">바나나</option>
                    <option value="grape">포도</option>
                    <option value="watermelon">수박</option>
                </select>
            </lable>
            <button type="submit">제출</button>
        </form>
    );
}
```

- 여러 개의 옵션 선택 가능
- multiple 사용, value에 배열 넣기
  - `<select multiple={true} value={['B', 'C']}>...</select>`

<br>

### File input 태그

> 디바이스의 저장 장치로부터 하나 또는 여러 개의 파일을 선택할 수 있게 해주는 HTML 태그
>
> `<input type="file" />`

- 값이 '읽기전용'이기 때문에, Uncontrolled Component
- 값이 리액트의 통제를 받지 않음



## Multiple Inputs

> 하나의 컴포넌트에서 여러개의 입력을 다뤄야 할 경우

- **여러개의 State를 선언하여** 각각의 입력에 대해 사용

```jsx
function Reservation(props){
    const [haveBreakfast, setHaveBreakfast] = useState(true);
    const [numberOfGuest, setNumberOfGuest] = useState(2);
    
    const handleSubmit = e => {
        alert(`아침식사 여부: ${haveBreakfast}, 방문객 수: ${numberOfGuest}`);
        e.preventDefault();
    }
    
    return (
        <form onSubmit={handleSubmit}>
            <label>
            	아침식사 여부:
                <input 
                    type="checkbox"
                    checked = {haveBreakfast}
                    onChange = {event => { setHaveBreakfast(event.target.checked); }}
                    />
            </label>
            <br />
            <label>
            	방문객 수:
                <input 
                    type="number"
                    value = {numberOfGuest}
                    onChange = {event => { setNumberOfGuest(event.target.value); }}
                    />
            </label>
        </form>
    );
}
```

<br>

## Input Null Value

> value prop는 넣으면서, 사용자가 자유롭게 입력할 수 있도록 하는 방법
>
> 값에 'undefined' 또는 'null'을 넣어주면 됨

```jsx
// 입력 불가 상태
ReactDOM.render(<input value='hi' />, rootNode);

// 1초 후, 입력 가능 상태
setTimeout(function(){
    ReactDOM.render(<input value={null} />, rootNode);
}, 1000);
```