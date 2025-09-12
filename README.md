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
  <img src="https://img.shields.io/badge/oracle-F80000?style=flat&logo=oracle&logoColor=white">
  <img src="https://img.shields.io/badge/java-007396?style=flat&logo=java&logoColor=white">
  <br>
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
<div align=left><h3> 🖼 구현 화면 🖼 </h3></div>
<div align=left> 
<h3>< 비로그인 메인페이지 ></h3>
<img width="1918" height="944" alt="image" src="https://github.com/user-attachments/assets/cc2f30a7-af7a-4e96-b0c0-5cfe47e63ff6" />

<h3>< 로그인 메인페이지 ></h3>
<img width="1919" height="939" alt="image" src="https://github.com/user-attachments/assets/cabf830d-5718-4f5e-98f2-215a6b04d1cd" />

<h3>< 로그인 페이지 ></h3>
<img width="1920" height="943" alt="image" src="https://github.com/user-attachments/assets/a31d6462-67f7-4269-9a52-5628ce6c954a" />

<h3>< 회원가입 페이지 ></h3>
<img width="1919" height="936" alt="image" src="https://github.com/user-attachments/assets/aa3b7167-29be-4848-becd-db5a744c4cfd" />

<h3>< 비밀번호 찾기 페이지 ></h3>
<img width="1919" height="943" alt="image" src="https://github.com/user-attachments/assets/61c9fa18-f8c8-4b8f-8c1c-e11b007d3ca5" />

<h3>< 개인정보 조회 페이지 ></h3>
<img width="1920" height="937" alt="image" src="https://github.com/user-attachments/assets/ef8666a1-7506-4473-89a6-064534771856" />

<h3>< 대여정보 조회 페이지 ></h3>
<img width="1918" height="931" alt="image" src="https://github.com/user-attachments/assets/2329fcbf-8058-47ff-81f4-0b0cc05b5c1b" />


<h3>< 대여도서 조회 페이지 ></h3>
<img width="1910" height="932" alt="image" src="https://github.com/user-attachments/assets/faf00476-c4d4-4df1-809f-e514eb17f0cc" />


<h3>< 반납도서 조회 페이지 ></h3>
<img width="1916" height="935" alt="image" src="https://github.com/user-attachments/assets/5393a76b-223b-4e1b-8f07-935084619e49" />


<h3>< 도서목록 페이지 ></h3>
<img width="1909" height="929" alt="image" src="https://github.com/user-attachments/assets/fd5b9202-deae-4e06-b2e1-1d0bdbc01856" />


<h3>< 도서 상세 조회 페이지 ></h3>
<img width="1915" height="936" alt="image" src="https://github.com/user-attachments/assets/13cd3122-9206-42c1-8da9-b9557ed8a5b9" />

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
| 권진호      | 에러가 나는 상황을 많이 마주하며 에러에 대한 대처 능력을 키울 수 있었습니다. 또한, 프로젝트 구조에 익숙해지고 세부적으로는 각 클래스에 기능을 나누어 놓는것에 대한 연습이 되었으며 협업에 관해서 조금이나마 알게 되었습니다. |
</div>
