package com.fleta.employee.util;

import com.fleta.employee.exception.NotExistRequestValueException;

public class RequestUtil {
    public static void checkNeedValue(Object... args) {
        for (Object arg : args) {
            if (arg == null) {
                throw new NotExistRequestValueException();
            }
        }
    }
}
