package com.on_site.kamayan;

import com.google.common.base.Joiner;

import java.util.Arrays;

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

    public static void assertEquals(int expected, Integer actual) {
        assertEquals(expected, (Object) actual);
    }

    public static void assertMethodExists(Object object, String method, Class<?>... paramTypes) {
        try {
            object.getClass().getMethod(method, paramTypes);
        } catch (NoSuchMethodException e) {
            String paramsString = Joiner.on(", ").join(Arrays.stream(paramTypes).map(Class::getName).toArray());
            fail("Expected method `" + method + "(" + paramsString + ")` to exist, but it didn't.");
        }
    }
}
