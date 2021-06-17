# DB_calingcard_TermProject
DataBase 명함관리 시스템

## 👬 팀원
  - [박형민](https://github.com/thalals/)
  - [전세현](https://github.com/jeonhl7579)
  
## ⚙️ 1. 환경
   * Jsp&Servlet
   * Mysql
   * Apache Tomcat
   * MVC2 패턴 

## 2. 사용자 요구사항
| 명함관리 S/W 시스템 요구사항 |

	1. 명함에는 개인정보가 적혀있다.
	2. 명함에는 소속 단체의 정보가 적혀있다 
	3. 명함이 저장될 때 기록 날짜가 기록된다.(관리된다)
	4. 소속단체의 정보가 있을 경우 소속 단체의 이름은 반드시 저장된다
	  (관리된다.)
	5. 그 외에도 소속단체의 정보는 주소, 전화번호, 우편번호, 팩스번호,
	 이메일 주소,  등이 있을 수 있다.
	6. 개인 정보에는 팀명, 직책, 이메일 주소, 경력이 있을 수도 있다.
	7. 소속단체의 전화번호는 하나 이상 일수도 있다.
	8. 명함에는 반드시 성함과 전화번호가 적혀 있어야한다.
	9. 사용자는 명함을 하나 이상 가질 수 있다.
	10. 사용자는 아이디, 비밀번호, 사용자 이름을 가진다.


## 3. 프로그램 구조
[엔티티 구조]

![image](https://user-images.githubusercontent.com/42319300/122406787-151dae00-cfbc-11eb-988a-6aab1d0dc5d9.png)

[테이블 구조]

![image](https://user-images.githubusercontent.com/42319300/122406951-38485d80-cfbc-11eb-8260-49e725686930.png)

## 4. 기능 구현
1. 회원가입, 로그인
2. 명함 관리
  - 명함 추가
     - 회사 생성(추가)
     - 회사 전화번호 추가 (최대 2개)
  - 명함 수정
  - 명함 삭제
  - 명함에 기록된 회사 정보 조회

3. 명함 검색
  - 카테고리별 검색 : 이름, 부서, 전화번호, 이메일

## ✔️ 5. 실행 화면

![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/42319300/122411768-fc16fc00-cfbf-11eb-8264-dbf66d37c08b.gif)




