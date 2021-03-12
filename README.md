# Spring_caffemore

- 스프링 서버용 (카카오맵 api 활용)

서버 작동 후 localhost:8080 입력하면 됨!

push, clone 시 토큰 이용해야 organization repo push, clone 가능함... 

https://velog.io/@ruddms936/github-토큰-생성

위에 거 참고하셈요 


### 기능

- 주소 선택 시 (강남구 -> 강동구) 바뀐 주소대로 다시 카페 검색

- 지도 움직일 시 바뀐 위치 기반으로 카페 검색

- 왼쪽 리스트에 마우스 올릴 시 해당 카페위치에 카페 이름 나타남 

Screen Shot
====

메인 화면 
---

1 ) 로그인 하지 않은 경우 

<img src="https://user-images.githubusercontent.com/66946182/110210400-e1b78780-7ed4-11eb-9d84-8eefdfb29a22.png">

2 ) 로그인을 하면 

<img src="https://user-images.githubusercontent.com/66946182/110653622-c57f5780-8200-11eb-837c-602ec5b5e44c.png">


로그인 화면 
---

<img src="https://user-images.githubusercontent.com/66946182/110210435-0dd30880-7ed5-11eb-88af-d14734029528.png">


회원 가입 화면 
---

- 로그인 시 노출될 닉네임 설정 가능 


<img src="https://user-images.githubusercontent.com/66946182/110888379-653b0380-832f-11eb-84c5-ff64a88b2dd3.png">


카페 지도 
---


1 ) 기본 창 크기인경우

<img src="https://user-images.githubusercontent.com/66946182/110203625-8f656f00-7eb2-11eb-82d3-8efa47453d83.png">


2 ) 창 크기를 줄일 경우 

<div>
<img src="https://user-images.githubusercontent.com/66946182/110203832-99d43880-7eb3-11eb-8a07-4a4bc4a287d8.png" width = "45%">
<img src="https://user-images.githubusercontent.com/66946182/110203635-9c825e00-7eb2-11eb-967c-68cdec597523.png" width = "45%">
</div>

카페 정보
---

1 ) 로그인을 하지 않은 경우 

<img src="https://user-images.githubusercontent.com/66946182/110569584-098a4200-8198-11eb-9bcc-7f802b8820e3.png">

2 ) 로그인을 한 경우 

<img src="https://user-images.githubusercontent.com/66946182/110653340-805b2580-8200-11eb-9ab0-ea57acf971bc.png">

<img src="https://user-images.githubusercontent.com/66946182/110652797-0c208200-8200-11eb-969e-8bdcbab4837e.png">

<img src="https://user-images.githubusercontent.com/66946182/110887798-4be58780-832e-11eb-900b-f0d2c9eb4b53.png">

리뷰 작성
---

- 로그인을 한 경우 리뷰 작성 가능. 사용자가 글 작성시 노출될 닉네임을 설정 가능(회원 데이터베이스의 닉네임과는 다름)

<img src="https://user-images.githubusercontent.com/66946182/110888201-12f9e280-832f-11eb-8c54-66b2f0821305.png">


프로필 화면
---

- 로그인을 한 경우 프로필 화면에서 닉네임과 포인트, 작성한 리뷰 확인 가능 

<img src="https://user-images.githubusercontent.com/66946182/110887833-5a33a380-832e-11eb-9838-0d0500511811.png">


데이터베이스
---

익명의 리뷰와 회원 다대일 매핑 

<img src="https://user-images.githubusercontent.com/66946182/110888058-c31b1b80-832e-11eb-8f96-2d98a43c69c3.png" width = "60%">
