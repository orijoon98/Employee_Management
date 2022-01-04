CREATE TABLE role (
	사번 VARCHAR(10) PRIMARY KEY NOT NULL UNIQUE,
    등급 VARCHAR(10) NOT NULL,
    CONSTRAINT role_constraint
    FOREIGN KEY(사번)
    REFERENCES auth(사번)
    ON DELETE CASCADE
);