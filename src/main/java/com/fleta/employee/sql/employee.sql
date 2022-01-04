CREATE TABLE employee (
	사번 VARCHAR(10) PRIMARY KEY NOT NULL UNIQUE,
    사진 VARCHAR(100),
    이름 VARCHAR(10) NOT NULL,
    입사년월일 DATETIME NOT NULL,
    국적 VARCHAR(10) NOT NULL,
    생년월일 DATETIME NOT NULL,
    성별 VARCHAR(2) NOT NULL,
    우편번호 VARCHAR(10),
    주소 VARCHAR(50),
    상세주소 VARCHAR(50),
    전화번호 VARCHAR(20),
    휴대폰번호 VARCHAR(20),
    이메일 VARCHAR(50),
    부서 VARCHAR(20) NOT NULL,
    직급 VARCHAR(10) NOT NULL,
    직종 VARCHAR(20) NOT NULL,
    퇴사년월일 DATETIME,
    CONSTRAINT employee_constraint
    FOREIGN KEY(사번)
    REFERENCES auth(사번)
    ON DELETE CASCADE
);