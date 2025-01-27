package com.google.common.base;

import b5.g;
import b5.q;
import b5.s;
import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: b */
    public State f9100b = State.NOT_READY;

    /* renamed from: c */
    @CheckForNull
    public T f9101c;

    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9102a;

        static {
            int[] iArr = new int[State.values().length];
            f9102a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9102a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @CheckForNull
    public abstract T a();

    @CanIgnoreReturnValue
    @CheckForNull
    public final T b() {
        this.f9100b = State.DONE;
        return null;
    }

    public final boolean c() {
        this.f9100b = State.FAILED;
        this.f9101c = a();
        if (this.f9100b == State.DONE) {
            return false;
        }
        this.f9100b = State.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        u.g0(this.f9100b != State.FAILED);
        int i10 = a.f9102a[this.f9100b.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            return c();
        }
        return true;
    }

    @Override // java.util.Iterator
    @s
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9100b = State.NOT_READY;
        T t10 = (T) q.a(this.f9101c);
        this.f9101c = null;
        return t10;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
