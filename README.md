# oauth2--no-spring-security-with-session

oauth2를 학습하는 프로젝트입니다.
스프링 시큐리티 없이, 세션 방식으로 소셜 로그인을 구현합니다. (현재 네이버 로그인 기반)

## stack
- java 17
- springBoot 3.2.9
- jpa
- oauth2 + session (without spring security)
- feign client


## 시퀀스 다이어그램
![oauth-login drawio](https://github.com/user-attachments/assets/f81cfbdb-aa01-4f5f-9c4e-e427e6fd12b4)

1. 클라이언트의 프론트에서 서버로 oauth 로그인 페이지 url을 요청합니다.
2. 서버는 oauth 로그인 페이지 url을 생성하여 프론트에 응답합니다. (redirect 하지 않았음)
3. 프론트는 oauth 로그인 페이지 url로 로그인을 요청합니다.
4. authorization 서버는 유저에 대한 code(토큰용 인증 코드)와 state를 redirect url로 응답합니다.
5. redirect url을 통해 서버가 응답 받아 authorization 서버에 access 토큰을 요청합니다.
6. authorization 서버는 access 토큰을 응답합니다.
7. 서버는 access 토큰을 통해 resource 서버에 회원 정보를 요청합니다.
8. resource 서버는 회원 정보를 응답합니다.
9. 서버는 회원 정보를 통해 회원 존재 여부를 판단합니다.
10. 1) 회원이 존재하지 않으면 회원 가입을 한 뒤, 세션에 회원 정보를 담아 응답합니다.
    2) 회원이 존재하면 세션에 회원 정보를 담아 응답합니다.

### 프로젝트 주의사항
- oauth2의 흐름을 이해하기 위한 프로젝트이며 feign client나 jpa 등은 필수가 아닙니다.
- oauth 로그인 페이지 url을 조합하는 주체는 백, 프론트 모두 될 수 있습니다.
- 해당 프로젝트에서 redirect url을 통해 응답 받는 주체는 애플리케이션 서버지만 이 또한 백, 프론트 모두 될 수 있습니다.
