package com.fleta.employee.exception;

public class DuplicateMemberException extends RuntimeException {
    private static final String MESSAGE = "이미 사용중인 ID입니다.";

    public DuplicateMemberException() {
        super(MESSAGE);
    }

    public static String getErrorMessage() {
        return MESSAGE;
    }
}