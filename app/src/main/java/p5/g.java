package p5;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

@a5.c
@m
/* loaded from: classes2.dex */
public final class g {
    public static <V> AtomicReference<V> a() {
        return new AtomicReference<>();
    }

    public static <V> AtomicReference<V> b(@l0 V v10) {
        return new AtomicReference<>(v10);
    }

    public static <E> AtomicReferenceArray<E> c(int i10) {
        return new AtomicReferenceArray<>(i10);
    }

    public static <E> AtomicReferenceArray<E> d(E[] eArr) {
        return new AtomicReferenceArray<>(eArr);
    }
}
