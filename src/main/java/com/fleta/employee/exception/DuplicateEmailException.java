package com.fleta.employee.exception;

public class DuplicateEmailException extends RuntimeException{
    private static final String MESSAGE = "이미 사용중인 이메일입니다.";

    public DuplicateEmailException() {
        super(MESSAGE);
    }

    public static String getErrorMessage() {
        return MESSAGE;
    }
}
