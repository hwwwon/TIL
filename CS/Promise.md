> 출처 :  https://joshua1988.github.io/web-development/javascript/promise-for-beginners/

<br>

## Promise

> 자바스크립트 비동기 처리에 사용되는 **객체**

- 자바스크립트 비동기 처리 : 특정 코드의 실행이 완료될 때까지 기다리지 않고 다음 코드를 먼저 수행하는 자바스크립트 특성

- **Promise가 필요한 이유**

  - 주로 서버에서 받아온 데이터를 화면에 표시할 때 사용

  ```js
  // 일반적으로 웹 애플리케이션을 구현할 때, 서버에서 데이터를 요청하고 받아오기 위해 사용하는 API
  $.get('url주소/products/1', function(response){
      ...
  });
  ```

  - 서버에 데이터를 요청하면 데이터를 받아오기도 전에 마치 데이터를 다 받아온 것 마냥
  - 화면에 데이터를 표시하려고 하면 오류가 발생하거나 빈 화면이 뜸
  - 이와 같은 문제점을 해결하기 위한 방법 중 하나가 Promise

<br>

## 프로미스 코드(기초)

- 간단한 ajax 통신 코드
- ajax 통신 API를 이용하여 지정된 url에서 1번 상품 데이터를 받아오는 코드
- 비동기식 처리를 위해 Promise 대신에 Callback  함수 사용

```js
function getData(callbackFunc){
    $.get('url주소/products/1', function(response){
        // 서버에서 받은 데이터 response를 callbackFunc 함수에 넘겨줌
        callbackFunc(response);
    });
}

getData(function(tableData){
    // $.get()의 response 값이 tableData에 전달됨
    console.log(tableData);
});
```

<br>

- Promise 적용 코드
- new Promise(), resolve(), then()와 같은 프로미스 API를 사용한 구조

```js
function getData(callback){
    // new Promise() 추가
    return new Promise(function(resolve, reject){
        &.get('url주소/products/1', function(response){
            // 데이터를 받으면 resolve() 호출
            resolve(response);
        });
    });
    
}

//getData()의 실행이 끝나면 호출되는 then()
getData().then(function(tableData){
    // resolve()의 결과 값이 여기로 전달됨
    //$.get()의 response 값이 tableData에 전달됨
    console.log(tableData);
});
```

<br>

## Promise의 3가지 상태(states)

- 프로미스를 사용할 때 알아야하는 가장 기본적인 개념
- 상태(states) : 프로미스의 처리 과정
- new Promise()로 프로미스를 생성하고 종료될 때까지 3가지 상태를 가짐
  - pending(대기): 비동기 처리로 로직이 아직 완료되지 않은 상태
  - Fulfilled(이행): 비동기 처리가 **완료되어** 프로미스가 결과 값을 반환해준 상태
  - Rejected(실패): 비동기 처리가 실패하거나 오류가 발생한 상태

<br>

### pending(대기)

- new Promise() 메서드를 호출하면 대기 상태가 됨
- 콜백 함수를 선언할 수 있고, 콜백 함수의 인자는 resolve, reject

```js
new Promise(function(resolve, reject){
	...
});
```



<br>

### Fulfilled(이행)

- 콜백함수의 인자 resolve를 실행하명 이행상태가 됨

```js
new Promise(function(resolve, reject){
    resolve();
});
```

- 이행 상태가 되면 then()을 이용하여 처리 결과 값을 받을 수 있음

```js
function getData(){
    return new Promise(function(resolve, reject){
        var data = 100;
        resolve(data);
    });
}

// resolve()의 결과 값 data를 resolveData로 받음
getData().then(function(resolveData){
    console.log(resolveData); // 100
});
```

<br>

### Rejected(실패)

```js
new Promise(function(resolve, reject){
    reject();
});
```

- 실패 상태가 되면 실패한 이유(실패처리의 결과 값)를 catch()를 통해 받을 수 있음

```js
function getData(){
    return new Promise(function(resolve, reject){
        reject(new Error("Request is failed"));
    });
}

// reject()의 결과 값 Error를 err에 받음
getData().then().catch(function(err){
    console.log(err);
});
```

![](https://joshua1988.github.io/images/posts/web/javascript/promise.svg)





### 쉬운 예제

```js
function getData(){
    return new Promise(function(resolve, reject){
        $.get('url주소/products/1', function(response){
            if(response){
                reslove(response);
            }
            reject(new Error("Request is failed"));
        });
    });
}

// 위  $.get() 호출 결과에 따라 'response' 또는 'Error' 출력
getData().then(function(data){
    console.log(data); // response 값 출력
}).catch(function(err){
    console.error(err); // Error 출력
});
```

<br>

## 여러 개의 프로미스 연결하기 (Promise Chaining)

- then() 메소드 호출하고 나면 새로운 프로미스 객체가 반환됨

```js
function getData(){
    return new Promise({
        ...
    });
}
                       
// then() 으로 여러 개의 프로미스를 연결한 방식
getData()
    .then(function(data){
        ...
    })
    .then(function(){
        ...
    })
    .then(function(){
        ...
    });
```

- 하나의 프로미스 객체를 여러번 호출하여 연결

```js
// setTimeout() API 사용
new Promise(function(resolve, reject){
  setTimeout(function() {
    resolve(1);
  }, 2000);
})
.then(function(result) {
  console.log(result); // 1
  return result + 10;
})
.then(function(result) {
  console.log(result); // 11
  return result + 20;
})
.then(function(result) {
  console.log(result); // 31
});
```

<br>

### 실무에 있을 법한 Pormise Chaining

- 사용자 로그인 인증 로직
  - 페이지에 입력된 사용자 정보를 받아와 파싱, 인증 등의 작업을 거치는 코드를 나타냄
  - userInfo는 사용자 정보가 담긴 객체
  - paseValue, auth, display는 각각 프로미스를 반환해주는 함수로 가정

```js
var userInfo = {
  id: 'test@abc.com',
  pw: '****'
};

function parseValue() {
  return new Promise({
    // ...
  });
}
function auth() {
  return new Promise({
    // ...
  });
}
function display() {
  return new Promise({
    // ...
  });
}


getData(userInfo)
.then(parseValue)
.then(auth)
.then(display);
```

<br>

## Promise의 에러 처리 방법

- 실제 서비스를 구현하다 보면 네트워크 연결, 서버 문제 등으로 인해 오류 발생 가능
- 2가지 방법

### then()의 두 번째 인자로 에러를 처리

```js
getData().then(
	handleSuccess,
    handleError
);
```

<br>

### catch() 이용

```js
getData().then().catch();
```

<br>

- 예제

```js
function getData(){
    return new Promise(function(resolve, reject){
        reject('faild');
    });
}

// 1. then()의 두 번째 ㅇ니자로 에러를 처리
getData().then(function(){
    ....
}, function(err){
    console.log(err);
});

// 2. catch()로 에러를 처리하는 코드
getData().then().catch(function(err){
    console.log(err);
});
```

<br>

### 가급적 catch() 사용

> then() 내부에서 일어나는 오류를 잡을 수 있음

- then()의 두 번째 인자로 사용할 경우

```js
// then()의 두 번째 인자로는 감지하지 못하는 오류
function getData() {
  return new Promise(function(resolve, reject) {
    resolve('hi');
  });
}

getData().then(function(result) {
  console.log(result);
  throw new Error("Error in then()"); // Uncaught (in promise) Error: Error in then()
}, function(err) {
  console.log('then error : ', err);
});

```

![](https://joshua1988.github.io/images/posts/web/javascript/then-not-handling-error.png)

- catch() 사용할 경우

```js
// catch()로 오류를 감지하는 코드
function getData() {
  return new Promise(function(resolve, reject) {
    resolve('hi');
  });
}

getData().then(function(result) {
  console.log(result); // hi
  throw new Error("Error in then()");
}).catch(function(err) {
  console.log('then error : ', err); // then error :  Error: Error in then()
});

```

![](https://joshua1988.github.io/images/posts/web/javascript/catch-handling-error.png)

- 따라서, 더 많은 예외 처리 상황을 위해 catch()를 사용하는 것이 좋음