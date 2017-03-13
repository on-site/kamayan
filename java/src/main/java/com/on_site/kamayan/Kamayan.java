package com.on_site.kamayan;

import com.google.common.base.Joiner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Kamayan {
    private Kamayan() {}

    public static <T> T getField(Object object, Class<T> expectedReturnType, String firstFieldName, String... fieldNames) {
        try {
            Field field = getField(object.getClass(), firstFieldName);
            field.setAccessible(true);
            object = field.get(object);

            for (int i = 0; i < fieldNames.length; i++) {
                field = getField(object.getClass(), fieldNames[i]);
                field.setAccessible(true);
                object = field.get(object);
            }

            return expectedReturnType.cast(object);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setField(Object object, String fieldName, Object value) {
        try {
            Field field = getField(object.getClass(), fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getField(fieldName);
        } catch (NoSuchFieldException e) {
            return getDeclaredField(clazz, fieldName);
        }
    }

    private static Field getDeclaredField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            clazz = clazz.getSuperclass();

            if (clazz == null) {
                throw e;
            }

            return getDeclaredField(clazz, fieldName);
        }
    }

    public static void times(int n, Consumer<Integer> fn) {
        range(0, n - 1, fn);
    }

    public static void range(int start, int end, Consumer<Integer> fn) {
        for (int i = start; i <= end; i++) {
            fn.accept(i);
        }
    }

    public static String wrap(String str, int length) {
        List<String> lines = new ArrayList<>();

        while (str.length() > length) {
            if (str.indexOf(' ') < 0) {
                lines.add(str);
                str = "";
            } else if (str.indexOf(' ') > length) {
                lines.add(str.substring(0, str.indexOf(' ')));
                str = str.substring(str.indexOf(' ') + 1);
            } else {
                int index = str.substring(0, length + 1).lastIndexOf(' ');
                lines.add(str.substring(0, index));
                str = str.substring(index + 1);
            }
        }

        if (!str.isEmpty()) {
            lines.add(str);
        }

        return Joiner.on("\n").join(lines);
    }

    public static TodoException todo(String... lines) {
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("")) {
                lines[i] = "\n\n";
            }
        }

        String[] paragraphs = ("TODO:\n" + Joiner.on(" ").join(lines)).replaceAll("(?m)^ +", "").replaceAll("(?m) +$", "").split("\n");

        for (int i = 0; i < paragraphs.length; i++) {
            paragraphs[i] = wrap(paragraphs[i], 80);
        }

        throw new TodoException(Joiner.on("\n").join(paragraphs));
    }
}
