package com.on_site.kamayan;

public class Ref<T> {
    private T object;

    public Ref() {
        this(null);
    }

    public Ref(T object) {
        this.object = object;
    }

    public static <T> Ref<T> of(T object) {
        return new Ref<>(object);
    }

    public T set(T newValue) {
        T oldValue = object;
        object = newValue;
        return oldValue;
    }

    public T get() {
        return object;
    }
}
