# simple-application | DDD 아키텍처를 적용한 간단한 웹 애플리케이션

DDD 아키텍처를 적용한 간단한 웹 애플리케이션입니다.
<br />
<br />
<br />

## 기능
- 간단한 계정 API으로, 계정 생성, 수정, 삭제, 조회 기능 구현 <br />
- 계정 생성 시 SMTP를 이용하여 생성된 이메일 주소로 환영 메시지 전송

> application.yml - mail의 username, password를 사용중인 네이버 계정으로 변경<br />
> MailComponent - createMail 메서드의 message.setFrom("naver email"); 부분 사용중인 네이버 이메일로 변경

##

> Language - Java 17  
> Framework - Spring Boot 2.7.5.  
> API - JPA  
> Database - H2 Database  
> Build Tool - Gradle  
<br />
