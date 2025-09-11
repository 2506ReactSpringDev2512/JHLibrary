<div align=left><h3> 🎬 프로젝트 🎬 </h3></div>
<div align=left> 
  도서관 관리 사이트
</div>

---
<div align=left><h3> ⏰ 개발 기간 ⏰ </h3></div>
<div align=left> 
  2025-09-01 ~ 2025-09-12
</div>

---
<div align=left><h3> 👨‍💻 개발자 👨‍💻 </h3></div>
<div align=left> 
  김재훈, 권진호
</div>

---
<div align=left><h3> 🤜 역할 분담 🤛 </h3></div>
<div align=left> 
  김재훈 : 프론트엔드(로그인, 회원가입, 비밀번호 찾기), 백엔드(로그인, 회원가입, 비밀번호 찾기)
  
  권진호 : 프론트엔드(메인, 대여/반납, 도서목록), 백엔드(메인, 대여/반납, 도서목록)
</div>

---
<div align=left><h3> 📚 기술 스택 📚 </h3></div>
<div align=left> 
  <img src="https://img.shields.io/badge/Windows-0078D6?style=flat&logo=windows&logoColor=white">
  <img src="https://img.shields.io/badge/oracle-F80000?style=flat&logo=oracle&logoColor=white">
  <img src="https://img.shields.io/badge/java-007396?style=flat&logo=java&logoColor=white">
  <br>
  <img src="https://img.shields.io/badge/html5-E34F26?style=flat&logo=html5&logoColor=white">
  <img src="https://img.shields.io/badge/css-1572B6?style=flat&logo=css3&logoColor=white">
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat&logo=javascript&logoColor=black">
</div>

---
<div align=left><h3> 📂 프로젝트 구조 📂 </h3></div>

```
src
├─ main
│ ├─ java
│ │ └─ com
│ │ └─ kjh
│ │ └─ library
│ │ ├─ member
│ │ │ ├─ common
│ │ │ ├─ controller
│ │ │ └─ model
│ │ │ ├─ service
│ │ │ ├─ dao
│ │ │ └─ vo
│ │ ├─ lend
│ │ │ ├─ controller
│ │ │ └─ model
│ │ │ ├─ service
│ │ │ ├─ dao
│ │ │ └─ vo
│ │ ├─ rent
│ │ │ ├─ controller
│ │ │ └─ model
│ │ │ ├─ service
│ │ │ ├─ dao
│ │ │ └─ vo
│ │ └─ main
│ │ ├─ model
│ │ ├─ service
│ │ ├─ dao
│ │ └─ vo
│ └─ webapp
│ ├─ resource
│ │ └─ images
│ ├─ lib
│ └─ views
│ ├─ common
│ ├─ member
│ ├─ book
│ └─ lend
└─ index.jsp
```
                                      
---
<div align=left><h3> 🛒 DB ERD 🛒 </h3></div>
<div align="left">
<h3>< BOOK_TBL ></h3>
  
| 컬럼명         | DATA_TYPE       | COMMENT    |
|:--------------:|:---------------:|:----------:|
| BOOK_NO        | VARCHAR2(20)    | 도서번호   |
| BOOK_NAME      | VARCHAR2(200)   | 도서명     |
| BOOK_AUTHOR    | VARCHAR2(30)    | 저자       |
| BOOK_PUBLISHER | VARCHAR2(30)    | 출판사     |
| LEND_YN        | VARCHAR2(35)    | 대여여부   |
| IMAGE_PATH     | IMAGE_PATH(500) | 이미지경로 |
| DESCRIPTION    | VARCHAR2(1500)  | 책소개     |

<h3>< LENDINFO_TBL ></h3>
  
| 컬럼명               | DATA_TYPE              | COMMENT    |
|:--------------------:|:----------------------:|:----------:|
| M_ID                 | VARCHAR2(30)           | 아이디     |
| BOOK_NO              | VARCHAR2(20)           | 도서번호   |
| LEND_DATE            | DATE DEFAULT SYSDATE   | 대여일자   |
| EXPECTED_RETURN_DATE | DATE DEFAULT SYSDATE+7 | 반납예정일 |
| RETURN_DATE          | DATE DEFAULT SYSDATE   | 반납일자   |

<h3>< MEMBER_TBL ></h3>
  
| 컬럼명        | DATA_TYPE    | COMMENT    |
|:-------------:|:------------:|:----------:|
| MEMBER_ID     | VARCHAR2(20) | 아이디     |
| MEMBER_PW     | VARCHAR2(20) | 비밀번호   |
| MEMBER_NAME   | VARCHAR2(20) | 이름       |
| MEMBER_PHONE  | VARCHAR2(11) | 전화번호   |
| MEMBER_GENDER | VARCHAR2(3)  | 성별       |
| MEMBER_AGE    | NUMBER       | 나이       |
| ADMIN_YN      | CHAR(1)      | 관리자여부 |

<h3>< ERD ></h3>
<img width="674" height="365" alt="image" src="https://github.com/user-attachments/assets/c13c527e-619f-457b-b236-9676fbfd3fcf" />
</div>

---
<div align=left><h3> 🖼 와이어 프레임 🖼 </h3></div>
<div align=left> 
<h3>< 비로그인 메인페이지 ></h3>
<img width="1305" height="729" alt="Image" src="https://github.com/user-attachments/assets/4299d65b-539d-4b7f-a5d9-62351b934ac0" />

<h3>< 로그인 메인페이지 ></h3>
<img width="1304" height="731" alt="Image" src="https://github.com/user-attachments/assets/28fbd969-c76e-48ce-b242-4f393aedef9c" />

<h3>< 로그인 페이지 ></h3>
<img width="1304" height="729" alt="image" src="https://github.com/user-attachments/assets/9a649486-7024-4cd5-80b7-658db5e99eb2" />

<h3>< 회원가입 페이지 ></h3>
<img width="1301" height="731" alt="image" src="https://github.com/user-attachments/assets/d6f639d5-82d4-4b49-be67-182d5a3c7c3a" />

<h3>< 비밀번호 찾기 페이지 ></h3>
<img width="1306" height="732" alt="image" src="https://github.com/user-attachments/assets/6e29eb85-b97f-4520-8064-9f3de6e8c4a3" />

<h3>< 개인정보 조회 페이지 ></h3>
<img width="1304" height="733" alt="image" src="https://github.com/user-attachments/assets/960cc127-bfa8-4d32-a920-efd3136d2dfd" />

<h3>< 대여정보 조회 페이지 ></h3>
<img width="1303" height="731" alt="image" src="https://github.com/user-attachments/assets/8dafb9b6-d67c-48d4-b168-61ad8908c409" />

<h3>< 대여도서 조회 페이지 ></h3>
<img width="1305" height="728" alt="image" src="https://github.com/user-attachments/assets/e71662b8-b0e4-448e-8db4-dc185e80d508" />

<h3>< 반납도서 조회 페이지 ></h3>
<img width="1304" height="730" alt="image" src="https://github.com/user-attachments/assets/2ed23034-054d-4ac2-8258-2debb956bd6d" />

<h3>< 도서목록 페이지 ></h3>
<img width="1303" height="730" alt="image" src="https://github.com/user-attachments/assets/3ea02d2e-9b5b-4762-9a12-3864e3590d67" />

<h3>< 도서 상세 조회 페이지 ></h3>
<img width="1304" height="731" alt="image" src="https://github.com/user-attachments/assets/23b95c17-85fb-4de4-a5fa-3ec60835ada7" />
</div>

---
<div align=left><h3> 💡 핵심 원리 💡 </h3></div>

```java
              JDBCTemplate
                   ↓↑
JSP → Servlet → Service → DAO

-----------------------------

JSP

1. 사용자가 화면에서 요청
2. 요청을 통해 Servlet으로 전달

------------------------------

Servlet

3. 요청 파라미터 추출
4. Service 호출
5. 실행 후 결과 데이터를 JSP에 넘겨줌

------------------------------------

Service

6. DAO를 호출
7. JDBTemplate를 이용해 Connetion을 열고 닫음

--------------------------------------------

DAO

8. SQL Query문 사용(SELECT, INSERT, UPDATE, DELETE)
9. PreparedStatement로 DB와 통신

---------------------------------------------------

JDBCTemplate

10. getConnection() → DB 연결
11. close(), commit(), rollback() 메서드 제공

---------------------------------------------
```

---
<div align=left><h3> 💻 구현 / 미구현 💻 </h3></div>
<div align=left> 

| 구현/미구현 | 목록                                                    |
|:-----------:|:-------------------------------------------------------:|
| 구현        | 로그인, 회원가입, 대여/반납, 도서목록, 최신도서, 도서검색 |
| 미구현      | 관리자 로그인, 회원관리, 도서관리, 공지사항               |
</div>

---
<div align=left><h3> 👁‍🗨 소감(힘든점, 어려운점, 아쉬운점) 👁‍🗨 </h3></div>
<div align=left> 
  
| 이름        | 소감                        |
|:-----------:|:---------------------------:|
| 김재훈      | jsp와 Servlet을 통한 페이지의 작동원리를 어느 정도 이해 가능해졌지만, DB 연동을 확인하는 과정에서 어려움을 겪었습니다. book.bookName처럼 객체를 통해 사용할 수 있다는 점을 알게 되었습니다.|
| 권진호      |                             |
</div>
