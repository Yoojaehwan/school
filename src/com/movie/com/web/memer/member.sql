SELECT * FROM TEST;
CREATE TABLE Member(
	 id VARCHAR2(30) PRIMARY KEY,
	 name VARCHAR2(30) NOT NULL,
	 password VARCHAR2(30) NOT NULL, 
	 addr VARCHAR2(100),
	 birth NUMBER	
);

INSERT INTO Member(id, name, password, addr, birth)
VALUES ('hong', '홍길동', '1', '서울', 800101);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('kim', '김유신', '1', '경기', 900224);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('lee', '이순신', '1', '부산', 880909);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('cha', '차두리', '1', '대전', 820115);
INSERT INTO Member(id, name, password, addr, birth)
VALUES ('park', '박지성', '1', '인천', 810221);

SELECT * FROM Member
WHERE id = 'kim';