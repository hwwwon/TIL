## Shared State

- State에 있는 데이터를 여러 개의 하위 컴포넌트에서 공통적으로 사용하는 경우
- 하위 컴포넌트가 공통된 부모 컴포넌트의 state를 공유하여 사용하는 것



<br>

## 하위 Component에서 State공유하기

- 예시
    - 사용자로부터 온도를 입력받아서 각각 섭씨온도와 화씨 온도를 표시해주고
    - 해당 온도에서 물이 끓는지를 출력해주는 컴포넌트

``` jsx
// 물이 끓는 온도 컴포넌트
function BoilingVerdict(props){
    if (props.celsius >= 100){
        return <p>물이 끓습니다.</p>;
    }
    
    return <p>물이 끓지 않습니다.</p>;
}

function Calculator(props){
    const [temperature, setTemperature] = useState('');
    
    const handleChange = e => {
        setTemperature(e.target.value);
    };
    
    return (
        <fieldset>
            <legend>섭씨 온도를 입력하세요: </legend>
            <input value={temperature} onchange={handleChange} />
            <BoilingVerdict celsius={parseFloat(temperature) />
        </fieldset>
    );
}
```

<br>

- 입력 컴포넌트 추출

> 섭씨 온도와 화씨 온도를 따로 입력할 수 있도록하여, 재사용 가능한 형태로 컴포넌트를 만들어 사용하는 것이 효율적이기 때문

```jsx
const scaleNames = {
    c: '섭씨',
    f: '화씨'
};

function TemperatureInput(props){
    const [temperature, setTemperature] = useState('');
    
    const handleChange = e => {
        setTemperature(e.target.value);
    };
    
    return (
        <fieldset>
            <legend>
            	 온도를 입력해 주세요(단위: {scaleNames[props.scale]}):
            </legend>
            <input value={temperature} onChange={handleChange} />
        </fieldset>
    );
}

function Calculator(props){
    return (
        <div>
        	<TemperatureInput scale="c" />
            <TemperatureInput scale="f" />
        </div>
    );
}
```

<br>

- 온도 변환 함수 작성

```jsx
// 섭씨온도를 화씨온도로 변환
function toCelsius(fahrenheit){
    return (fahrenheit - 32) * 5 / 9;
}

// 화씨온도를 섭씨온도로 변환
function toFahrenheit(celsius){
    return (celsius * 9 / 5) + 32;
}

// 입력받은 값을 변환해주는 함수
function tryConvert(temperature, convert) {
    
    const input = parseFloat(temperature);
    
    // 예외처리
    if (Number.isNaN(input)){
        return '';
    }
    
    const output = convert(input);
    const rounded = Math.round(output * 1000) / 1000;
    return rounded.toString();
}

tryConvert('abc', toCelsius); // 예외처리로 ''(empty string) 리턴
tryConvert('10.22', tofahrenheit); // '50.396' 리턴
```

<br>

- Shared State 적용 (Lifting State Up)

> 하위 컴포넌트의 state를 공통 상위 컴포넌트로 올림

```jsx
// TemperatureInput 
const handleChange = e => {
    // 변경 전 : setTemperature(e.target.value);
    // onTemperatureChange 상위 컴포넌트로 변경된 값을 전달
    props.onTemperatureChange(e.target.value);
};

// TemperatureInput 컴포넌트에서 리턴 부분 수정
return (
	...
    // 변경전 : <input value={temperature} onChange={handleChange} />
    // state를 사용하는 것이 아니라 props통해서 가져옴
    // 상위 컴포넌트로 입력받은 값을 전달해야함
               <input value={props.temperature} onChange={handleChange} />
    ...
    );

// 최종적으로 변경된 컴포넌트
// useState 사용 안함
// 상위 컴포넌트로부터 전달받은 값만을 사용
const scaleNames = {
    c: '섭씨',
    f: '화씨'
};

function TemperatureInput(props){
    const handleChange = e => {
        props.onTemperaturneChange(e.target.value);
    };
    
    return (
    	fieldset>
            <legend>
            	 온도를 입력해 주세요(단위: {scaleNames[props.scale]}):
            </legend>
            <input value={props.temperature} onChange={handleChange} />
        </fieldset>
    );
}
```

- Calculator 컴포넌트 변경하기

```jsx
function Calculator(props){
    const [temperature, setTemperature] = useState('');
    const [scale, setScale] = useState('c');
    
    const handleCelsiusChange = (temperature) => {
        setTemperature(temperature);
        setScale('c');
    };
    
    const handleFahrenheitChange = (temperature) => {
        setTemperature(temperature);
        setScale('f');
    };
    
    const celsius = scale === 'f' ? tryConvert(temperature, toCelsius) : temperature;
    const fahrenheit = scale === 'c' ? tryConvert(temperature, toFahrenheit) : temperature;
    
    return (
        <div>
        
            <TemperatureInput 
                scale="c"
                temperature={celsius}
                onTemperatureChange={handleCelsiusChange}/>
            <TemperatureInput 
                scale="f"
                temperature={fahrenheit}
                onTemperatureChange={handleFahrenheitChange}/>
            <BoilingVerdict 
                celsius={parseFloat(celsius)} />
        
        </div>
    );
    
}
```

