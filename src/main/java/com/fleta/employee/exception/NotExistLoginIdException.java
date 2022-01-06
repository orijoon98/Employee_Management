package com.fleta.employee.exception;

public class NotExistLoginIdException extends RuntimeException{
    private static final String MESSAGE = "가입되지 않은 아이디입니다.";

    public NotExistLoginIdException() {
        super(MESSAGE);
    }

    public static String getErrorMessage() {
        return MESSAGE;
    }
}
