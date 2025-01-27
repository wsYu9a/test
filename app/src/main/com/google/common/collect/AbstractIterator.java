package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import e5.a1;
import e5.d1;
import e5.z1;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@a5.b
@e5.m
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> extends z1<T> {

    /* renamed from: b */
    public State f9331b = State.NOT_READY;

    /* renamed from: c */
    @CheckForNull
    public T f9332c;

    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9333a;

        static {
            int[] iArr = new int[State.values().length];
            f9333a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9333a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @CheckForNull
    public abstract T a();

    @CanIgnoreReturnValue
    @CheckForNull
    public final T b() {
        this.f9331b = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f9331b = State.FAILED;
        this.f9332c = a();
        if (this.f9331b == State.DONE) {
            return false;
        }
        this.f9331b = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        b5.u.g0(this.f9331b != State.FAILED);
        int i10 = a.f9333a[this.f9331b.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    @d1
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9331b = State.NOT_READY;
        T t10 = (T) a1.a(this.f9332c);
        this.f9332c = null;
        return t10;
    }

    @d1
    public final T peek() {
        if (hasNext()) {
            return (T) a1.a(this.f9332c);
        }
        throw new NoSuchElementException();
    }
}
