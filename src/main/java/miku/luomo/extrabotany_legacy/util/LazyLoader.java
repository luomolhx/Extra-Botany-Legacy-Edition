package miku.luomo.extrabotany_legacy.util;

import java.util.function.Supplier;

public class LazyLoader<T> {

    private final Supplier<T> supplier;
    private volatile T value;

    public LazyLoader(final Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if (value == null) {
            synchronized (this) {
                if (value == null) {
                    value = supplier.get();
                }
            }
        }
        return value;
    }
}
