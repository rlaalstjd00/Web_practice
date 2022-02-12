## MyBatis 예제 

MyBatis를 이용해 이전 예제인 ajax 예제에서 SQL문과 호출 메서드의 분리 구현

> [ajax 예제 바로가기](https://github.com/rlaalstjd00/Web_practice/tree/master/00_ajax_prac)

- 로직 구현
  - joinview.jsp 에서 중복체크 버튼 누르면 `checkId()` 함수 호출, 가입하기 버튼 누르면 `sendit()` 함수 호출 
    - `checkId()` : Ajax를 이용해 checkId_db.jsp로 POST 방식의 데이터 전송.
      - checkId_db.jsp : userDAO의 `checkId()` 메서드 호출해 아이디 중복여부 확인
    - `sendit()` : 유효성검사 후 모두 통과시 join_db.jsp로 이동
      - join_db.jsp : userDAO의 `join()` 메서드 호출해 데이터 추가
  - UserDAO.java
    - `checkID()` : 아이디 중복검사 메서드. user.xml에서 User.checkId 쿼리문 실행
    - `join()` : 회원가입 메서드. user.xml에서 User.join 쿼리문 실행
    - `login()` : 로그인 메서드. user.xml에서 User.login 쿼리문 실행
  - user.xml
    - User.checkId : MYBATIS_TEST_USER 테이블과 비교해 중복된 아이디 있는지 확인
    - User.join : MYBATIS_TEST_USER에 데이터 추가
    - User.login : MYBATIS_TEST_USER 테이블과 비교해 아이디 비밀번호가 모두 일치하는지 확인
- DB 사용 테이블
  - MYBATIS_TEST_USER 테이블
    - USERID, USERPW, USERNAME 컬럼
    - USERID가 PK
- 사용 라이브러리
  - mybatis-3.5.7.jar
  - ojdbc6.jar

#### 실행 결과

Ajax 부분과 새로 추가한 로그인 부분까지 모두 문제없이 실행
