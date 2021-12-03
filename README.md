# Eclipse-JSP
## <2020 Servlet&JSP 프로그래밍>

## 데이터베이스 정보
- 50_project
```sql
CREATE USER NEWLEC IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE, DBA TO NEWLEC;

CREATE TABLE NOTICE (
    ID NUMBER,
    TITLE VARCHAR(100),
    WRITE_ID VARCHAR(50),
    CONTENT VARCHAR(4000),
    REGDATE DATE,
    HIT NUMBER,
    FILES VARCHAR(4000)
);
INSERT INTO NOTICE VALUES (6, 'TITLE', 'WRITE_ID', 'CONTENT', SYSDATE, 6, 'FILES');
SELECT * FROM NOTICE;
```
- 82_notice_view
```sql
CREATE TABLE COMMENT2 (
    ID NUMBER,
    CONTENT VARCHAR(4000),
    REGDATE DATE,
    WRITE_ID VARCHAR(50),
    NOTICE_ID NUMBER
);
INSERT INTO COMMENT2 VALUES (1, '내용1', SYSDATE, '사용자1', 1);
SELECT * FROM COMMENT2;

```
- 86_admin : notice 테이블에 대한 컬럼 추가(글 공개 여부)
![ex_screen] (notice-pub.PNG)

# Reference
- https://www.youtube.com/watch?v=qfGbsEdMaV4&list=PLq8wAnVUcTFVOtENMsujSgtv2TOsMy8zd&index=5
- https://www.notion.so/JSP-09499dda8867425696c660d7d65454a2
