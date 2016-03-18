--시퀀스 생성
CREATE SEQUENCE hak
INCREMENT BY 1
START WITH 20160001;


drop SEQUNECE hak;

CREATE TABLE Grade(
	 hak NUMBER PRIMARY KEY,
	 id VARCHAR2(30) UNIQUE,
	 java NUMBER , 
	 sql NUMBER,
	 jsp NUMBER,
	 spring NUMBER
);


INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'hong', 60, 100, 70, 60);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'kim', 69, 40, 70, 40);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'lee', 60, 56, 80, 90);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'cha', 45, 95, 42, 80);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'park', 70, 65, 30, 100);
INSERT INTO Grade(hak, id, java, sql, jsp, spring)
VALUES (hak.NEXTVAL, 'kim2', 30, 20, 30, 70);




SELECT * FROM Grade;

SELECT * FROM Grade
WHERE id = 'kim2';
TRUNCATE TABLE Grade;

DROP TABLE Grade CASCADE;