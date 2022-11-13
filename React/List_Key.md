## List

> 같은 아이템을 순서대로 모아놓은것
- 리스트에 사용하는 자료구조로 배열(Array) 사용
- 배열 : JavaScript의 변수나 객체들을 하나의 변수로 묶어 놓은 것

<br>

## key

- 열쇠는 다 모양이 다르다
- 고유성
- 각 객체나 아이템을 구분할 수 있는 고유한 값
- 리스트에 존재하는 아이템들을 구분하기 위한 **고유한 문자열**
- 속한 리스트안에서만 고유한 키이면 됨
- key를 명시적으로 작성하지 않으면, **기본적으로 index를 key값으로 사용**

### key로 값을 사용하는 경우

> 값 중에 중복되는 값이 있으면 키의 고유성을 충족시키지 못함

```jsx
const numbers = [1,2,3,4,5];
const listItems = numbers.map((number) => 
                             
                              <li key={number.toString()}>
                              	{number}
                              </li>
                              
                             );
```

### key로 id를 사용하는 경우

```jsx
const todoItems = todos.map((todo) => 
                           
                            <li key={todo.id}>
                            	{todo.text}
                            </li>
                            
                           );
```

### key로 index를 사용하는 경우

> 아이템들의 **고유한 ID가 없을 경우에만** 사용
>
> 배열에서 아이템의 순서가 바뀔 수 있는 경우에는 key 값으로 index를 사용하는 것을 **권장하지 않음**

```jsx
const todoItems = todo.map((todo, index) => 
                          
                           <li key={index}>
                           	{todo.text}
                           </li>
                          
                          );
```



<br>

## 여러개의 Component 렌더링 하기

> map() 사용

- JavaScript 함수의 map()

  - 어떤 배열에 있는 모든 요소들의 값을 변경해서 만든 새로운 배열을 반환
  - 콜백 함수를 이용해 각각의 요소에 호출하여 그 값을 변환할 수 있음
  - **map() 함수 안에 있는 Elements는 꼭 key가 필요함**

  ```jsx
  const dobuled = numbers.map((number) => number * 2);
  --------------
  const numbers = [1,2,3,4,5];
  const listItems = numbers.map((number) => <li>{number}</li> );
  
  ReactDOM.render(
      <ul>{listItems}</ul>,
      document.getElementById('root')
  );
  ```



<br>

## 기본적인 List Component

```jsx
function NumberList(props){
    const {numbers} = props;
    const listNumber = numbers.map((number) => <li>{number}</li>);
    
    return (
        <ul>{listNumber}</ul>
    );
}

const numbers = [1,2,3,4,5];
ReactDOM.render(
	<NumberList(numbers) />,
    document.getElementById('root')
);
```

