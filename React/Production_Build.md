## Production 빌드

> 코드와 애플리케이션이 사용하는 이미지, CSS 파일 등의 파일을 모두 모아 패키징 하는 과정

- 빌드 과정
  - Obfuscation(난독화): 코드가 식별이 불가능하도록 함
  - unification: 필요없는 공백이나 줄바꿈 문자들을 제거

- 터미널 (Terminal)에 빌드 명령어 작성
  - `$ npm run build`

- serve 패키지 설치

  - static 파일들을 serving해주는 역할을 하는 프로그램
  - 글로벌 모드로 설치

  - `$ npm install -g serve`
  - 빌드 폴더를 기반으로 웹 애플리케이션을 서빙
  - `$ serve -s build`
  - 네트워크 주소 (http://192.168.0.10:3000)

- 빌드를 통해 생성된 정적인 파일들을 배포하려는 서버에 올리는 과정