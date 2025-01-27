package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class Pools {

    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t);
    }

    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f1991a;

        /* renamed from: b, reason: collision with root package name */
        private int f1992b;

        public SimplePool(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1991a = new Object[i2];
        }

        private boolean a(@NonNull T t) {
            for (int i2 = 0; i2 < this.f1992b; i2++) {
                if (this.f1991a[i2] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            int i2 = this.f1992b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            Object[] objArr = this.f1991a;
            T t = (T) objArr[i3];
            objArr[i3] = null;
            this.f1992b = i2 - 1;
            return t;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (a(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i2 = this.f1992b;
            Object[] objArr = this.f1991a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f1992b = i2 + 1;
            return true;
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: c, reason: collision with root package name */
        private final Object f1993c;

        public SynchronizedPool(int i2) {
            super(i2);
            this.f1993c = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public T acquire() {
            T t;
            synchronized (this.f1993c) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            boolean release;
            synchronized (this.f1993c) {
                release = super.release(t);
            }
            return release;
        }
    }

    private Pools() {
    }
}
