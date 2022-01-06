package com.fleta.employee.exception;

public class InvalidPasswordException extends RuntimeException {
    private final static String MESSAGE = "비밀번호를 다시 입력해주세요.";

    public InvalidPasswordException() {
        super(MESSAGE);
    }

    public static String getErrorMessage() {
        return MESSAGE;
    }
}
