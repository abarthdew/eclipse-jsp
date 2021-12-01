# Eclipse-JSP
## <2020 Servlet&JSP 프로그래밍>
## 4. 톰캣9 설치하기
- TOMCAT 9 설치
- 압축해제 후 C:\Users\auswo\eclipse\apache-tomcat-9.0.54\bin\startup.bat 배치파일 실행
- JAVA_HOME 환경변수가 올바르게 설정되어 있어야 정상적으로 뜸
- 실행 후 http://localhost:8080/로 접속하면 톰캣 화면이 뜸
## 5. 웹문서 추가해보기
- C:\Users\auswo\eclipse\apache-tomcat-9.0.54\webapps\ROOT에 hello.txt 추가
- http://localhost:8080/와 http://localhost:8080/index.jsp는 같음(index.jsp = 기본 디렉토리)
- http://localhost:8080/hello.txt에 접속하면 hello.txt가 뜸

## 데이터베이스 정보
```sql
CREATE USER NEWLEC IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE, DBA TO NEWLEC;

create table notice (
    id number,
    title varchar(100),
    write_id varchar(50),
    content varchar(4000),
    regdate date,
    hit number,
    files varchar(4000)
);
INSERT INTO NOTICE VALUES (6, 'TITLE', 'WRITE_ID', 'CONTENT', SYSDATE, 6, 'FILES');
SELECT * FROM NOTICE;
```
```sql
create table comment2 (
    ID NUMBER,
    CONTENT VARCHAR(4000),
    REGDATE DATE,
    WRITE_ID VARCHAR(50),
    NOTICE_ID NUMBER
);

```

# Reference
- https://www.youtube.com/watch?v=qfGbsEdMaV4&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd&index=5
- https://www.notion.so/JSP-09499dda8867425696c660d7d65454a2
