# Eclipse-JSP
## <2020 Servlet&JSP 프로그래밍>

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
