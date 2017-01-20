package com.on_site.kamayan;

import org.junit.Assert;

public class TestCase extends Assert {
    public static final Object __ = "FILL ME IN";
    public static final Class<FillMeInException> ___ = FillMeInException.class;

    public static <T extends Throwable> void assertThrows(Class<T> exceptionClass, Runnable fn) {
        try {
            fn.run();
            fail("Expected exception of type " + exceptionClass.getName() + ", but nothing was thrown.");
        } catch (Throwable t) {
            if (!exceptionClass.isInstance(t)) {
                fail("Expected exception of type " + exceptionClass.getName() + ", but got type " + t.getClass().getName() + " instead.");
            }
        }
    }
}
