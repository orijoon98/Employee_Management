CREATE TABLE bank (
	사번 VARCHAR(10) PRIMARY KEY NOT NULL UNIQUE,
    급여이체은행 VARCHAR(10),
    계좌번호 VARCHAR(20),
    예금주 VARCHAR(10),
    CONSTRAINT bank_constraint
    FOREIGN KEY(사번)
    REFERENCES auth(사번)
    ON DELETE CASCADE
);