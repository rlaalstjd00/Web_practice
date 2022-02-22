## Front-Controller 예제 

Front-Controller 패턴 구조를 이용한 간단한 회원가입 예제

MVC model 2 의 구조를 공부하기 위함으로 별도의 유효성검사 없이 회원가입만 구현

- **로직 구현 **
  
  1. joinview.jsp 에서 회원가입 버튼 누르면 ..user/UserJoinOk.us 로 데이터 전송. 이 때 ..user/UserJoinOk.us는 파일이 아니므로 web.xml에 등록된 서블릿을 찾음. 매핑된대로 UserFrontController로 이동
  
  2. UserFrontController.java
  
     - `case "/user/UserJoinOk.us"` : UserJoinOkAction.java의 `execute()` 메서드 실행
  
     - `case "/user/UserLogin.us"` : loginview.jsp 로 이동
  
  3. UserJoinOkAction.java
  
     받아온 파라미터를 dto에 세팅후 UserDAO.java의 `join(dto)` 호출
  
  4. UserDAO.java
  
     `join()` : 회원가입 메서드. user.xml에서 User.join 쿼리문 실행
  
  5. user.xml
  
       - User.join : FC_TEST_USER에 데이터 추가
  
  
  6. 이후에 `execute()` 메서드가 세팅된 forward 값을 리턴하며 ..user/userLogin.us 로 이동 이 때도 마찬가지로 파일이 아니므로 web.xml에 등록된 서블릿을 찾고 UserFrontController로 이동후 `case`문을 따라 loginview.jsp로 이동
  
- **DB 사용 테이블**
  
  - FC_TEST_USER 테이블
    - USERID, USERPW, USERNAME 컬럼
    - USERID가 PK
  
- **사용 라이브러리**
  
  - mybatis-3.5.7.jar
  - ojdbc6.jar
  - jstl.jar
  - standard.jar

#### 실행 결과

회원가입 버튼 누르면 임시로 만들어둔 loginview.jsp로 잘 이동이 되고, 데이터도 잘 추가되었음을 확인
