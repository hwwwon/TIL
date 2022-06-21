> 2022년 05월 19일 목요일

# Why Git & Github?

![Git로고]( https://user-images.githubusercontent.com/49775540/168756716-68f9aebb-380f-4897-8141-78d8403f6113.png)

### Git

- 분산 버전 관리 프로그램
- 백업 , 복구, 협업을 위해 사용
- [Git 공식문서]( https://git-scm.com/book/ko/v2)

### Github

- Git을 사용하는 프로젝트 협업을 위한 웹호스팅 서비스
- 포트폴리오를 자랑 할 수 있는 공간
- 1일 1커밋하기
- [이동욱님 Github 계정](https://github.com/jojoldu)



# CLI

> CLI(Command Line Interface, 커맨드 라인 인터페이스)는 터미널을 통해 사용자와 컴퓨터가 상호작용하는 방식을 뜻한다.

## 터미널 명령어 정리

| 명령어 |              설명               |
| :----: | :-----------------------------: |
| mkdir  |            폴더 생성            |
| touch  |            파일생성             |
|   ls   |   현재 폴더의 파일 목록 출력    |
|   cd   |        다른 폴더로 이동         |
|   rm   | 파일 삭제 / 폴더 삭제 (-r 옵션) |

## 예시

```
$ mkdir test

$ touch a.txt

$ ls
$ ls -a

$ cd ..
$ cd test

$ rm a.txt
$ rm -r test
```

# Visual Studio Code

> Visual Studio Code(비주얼 스튜디오 코드)는 마이크로 소프트에서 개발한 텍스트 에디터의 한 종류이다.

### 장점

- Windows, Mac, Linux 운영체제를 모두 지원한다.
- 기존 개발 도구보다 빠르고 가볍다.
- Extension을 통해 다양한 기능을 설치할 수 있어서, 무한한 확장성을 가진다.
- 무료로 사용 가능하다.

### Git Bash 연동하기

1. 터미널을 연다. (Ctrl + `)
2. 화살표를 누르고 *Select Default Profile*을 클릭한다.
3. Git Bash를 선택한다.
4. 휴지통을 눌러서 터미널을 종료하고, 재시작한다.
   - 휴지통은 Kill Terminal 로써, 터미널 자체를 아예 종료한다.
   - 닫기는 Close Terminal 로써, 터미널을 종료하지 않고 창만 보이지 않게 만든다.
5. 기본 터미널이 Git Bash로 열리는지 확인한다.

# Markdown

> Markdown (마크다운)은 일반 텍스트 기반의 경량 Markup (마크업) 언어이다.

### Markup (마크업) 이란?

- 마크(Mark)로 둘러싸인 언어를 뜻한다. 마크란 글의 역할을 지정하는 표시이다.
- HTML도 마크업 언어인데, 글에 제목의 역할을 부여할 때 `<h1>제목</h1>` 과 같이 작성한다.

### 마크다운의 장점과 단점

1. 장점
   - 문법이 직관적이고 쉽다.
   - 지원 가능한 플랫폼과 프로그램이 다양하다.
2. 단점
   - 표준이 없어서 사용자마다 문법이 상이하다.
   - 모든 HTML의 기능을 대신하지는 못한다.

### 주의 사항

- 마크다운의 본질은 글에 **역할**을 부여하는 것이다.
- 반드시 역할에 맞는 마크다운 문법을 작성한다. 글씨를 키우고 싶다고 해서 본문에 제목의 역할을 부여하면 안된다.

### 참고자료

- [Markdown Guide]( https://www.markdownguide.org/basic-syntax/)
- [마크다운 문법 정리]( https://gist.github.com/ihoneymon/652be052a0727ad59601)




## VScode 터미널로 Git 시작하기

>터미널 단축키는 **ctrl + `** (Backtick)
>
>Default profile을 Git Bash로 설정

<img src = "..\img\vscodeGitbash.png" height ="200px" width="300px" align="left"></img>  

<br/><br/><br/><br/><br/><br/><br/><br/>

------
# Git 기초

### 로컬 사용자 등록

> 최초 한 번만 설정

- 누가 커밋기록을 남겼는지 확인하기 위함

```
// git 사용자 지정하기 (name, email)
$ git config --global user.name 깃아이디
$ git config --global user.email 깃가입한이메일

// 등록된 내용 확인
$ git config --global --list
```



### 로컬 저장소 지정

- git init
- 현재 작업 중인 디렉토리(파일)를 Git으로 관리한다는 명령어
- 작업 중인 디렉토리들이 속해있는 디렉토리의 경로에서 수행

```
$ git init
Initialized empty Git repository in 디렉토리경로

// 현재 파일 목록과 숨김파일 목록도 보여줌
// .git이 있으면 git이 관리하는 로컬저장소로 지정됬음
$ ls -a
./ ../ .git
```



### Git 동작원리(add/commit)

| working directory(tree) |   staging area(Index)    | git directory  |
| :---------------------: | :----------------------: | :------------: |
|   untracked/ tracked    | commit 할 준비가 된 파일 | version1,2,... |

- **working directory** 에서 **staging area** 로 이동
  - git add .
  - git add 코드파일/폴더

```
// 모든(처음 보내는 파일, 수정 추가된 파일 등) 파일 보내기
$ git add .

// 특정 파일 지정해서 보내기
$ git add a.txt

// 특정 폴더
$ git add style/
```

- **staging area** 에서 **git directory**로 이동
  - git commit -m "내용" (history에 기록됨)
  - 메세지 내용은 커밋과 관련된 적절한 내용을 작성
  - 첫 커밋은 root-commit
  - 각각의 커밋은 SHA-A 해시 알고리즘에 의해 반환 된 고유의 값을 ID로 가짐
  - 새로운 version 생성

### git status

- Working Directory와 Staging Area에 있는 파일의 현재 상태를 알려주는 명령어
- 파일의 현재 상태를 확인 함으로써 적절한 명령어 사용 가능
- 상태
  - untracked: Git이 관리하지 않는 파일(한번도 Staging Area에 올라간 적 없는 파일)
  - Trakcked: Git이 관리하는 파일
    - Unmodified: 최신 상태
    - Modified:  수정되었지만 아직 Staging Area에 반영되지 않은 상태 (git add 안함)
    - Staged: Staging Area에 올라간 상태



### git log

- **커밋의 내역(ID, 작성자, 시간, 메세지 등)을 조회** 할 수 있는 명령어
- 옵션
  - --oneline : 한 줄로 축약해서 보여줌
  - --graph : 브랜치와 머지 내역을 그래프로 보여줌
  - --all : 현재 브랜치를 포함한 모든 브랜치의 내역을 보여줌
  - --reverse : 커밋 내역의 순서를 반대로 보여줌 (최신이 가장 아래)
  - -p : 파일의 변경 내용도 같이 보여줌
  - -2 : 원하는 갯수 만큼의 내역을 보여줌 (2 말고 임의의 숫자 사용 가능)
- q 입력해서 종료



####  + 명령어의 인자와 옵션

- 인자 : 명령어의 동작 대상을 지정. 따라서 생략 불가능

  ` git add a.txt` 에서 `a.txt` 가 인자

- 옵션 : 명령어의 동작 방식을 추가적으로 지정. 따라서 생략 가능 
