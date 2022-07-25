# AI / API

# Naver CLOVA

- 네이버 인공지능 플랫폼
- API 형태로 이용가능

## Naver AI API 서비스

- CLOVA Face Recognition(CFR)
- CLOVA OCR (Optical Character Recognition)
- CLOVA Speech Recognition(CSR)
- CLOVA Voice - Premium
- CLOVA Chatbot
- Pose Estimation
- Object Detection / Papago

# CLOVA Face Recognition (CFR)

- 이미지 속의 얼굴을 감지하고 인식하여 얻은 다양한 정보 제공하는 API 서비스
- 입력된 비전 데이터(이미지 파일)를 통해 얼굴을 인식하거나 얼굴을 감지
- 유명인 얼굴인식, 얼굴 감지

# CLOVA OCR (Optical Character Recognition)

- 광학 문자 인식 API 서비스
- 사진(이미지) 속에서 텍스트 정보를 찾고 의미를 판별하는 기술
- 언어와 이미지 데이터를 입력 받고, 그에 맞는 인식결과 텍스트로 반환
- 텍스트 : 이미지 내에서 텍스트 추출 반환
- 영수증 : 영수증을 읽어서 추출 항목 반환

# CLOVA Speech Recognition(CSR)

- 음성 합성 API 서비스
- 텍스트를 음성으로 변환
- TTS(Text-to-Speech)
- 텍스트 파일을 입력 받아서 변환된 음성 파일 반환 - mp3/wav
- 언어, 음색 선택 가능

# CLOVA Voice - Premium

- CLOVA Speech Recognition(CSR)
- 서비스 통합

# CLOVA Chatbot

- 챗봇 제작 API 서비스
- 사용자 질문 의도를 이해하여 고객 대응 등 다양한 서비스에 활용할 수 있는 챗봇 제작 지원

# Pose Estimation

- 입력된 비전 데이터를 통해 사람을 인식하고 포즈 분석
- 이미지 속의 사람을 감지하고 주요 신체부위(18개)의 좌표정보와 정확도를 얻을 수 있음

# Object Detection

- 이미지 내에 사람, 자동차, 동물 등 객체의 타입과 위치를 감지하여 정보를 제공
- 탐지된 객체명, 객체의 수, 바운딩 박스용 좌표, 객체별 확률값

# 사용 방법

- 서비스 요청 (뷰 페이지 : index.jsp)
- 컨트롤러
- 서비스
    - API 요청 코드를 서비스 클래스의 메소드 작성
    - JSON 파싱 / 결과 반환
- 컨트롤러
- 뷰 페이지로 결과 출력

# 사용방법

> Spring pom.xml dependency : org.json 추가
- 서비스 요청 (뷰 페이지)
- 컨트롤러
- 서비스
    - API 요청 코드를 서비스 클래스이 메소드 작성
    - JSON 파싱 / 결과 반환
    - VO / 리스트 사용
- 컨트롤러
- 뷰페이지로 결과 출력