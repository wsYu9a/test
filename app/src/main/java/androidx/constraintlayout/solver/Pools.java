package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
final class Pools {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f1207a = false;

    interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i2);
    }

    static class SimplePool<T> implements Pool<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f1208a;

        /* renamed from: b, reason: collision with root package name */
        private int f1209b;

        SimplePool(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1208a = new Object[i2];
        }

        private boolean a(T t) {
            for (int i2 = 0; i2 < this.f1209b; i2++) {
                if (this.f1208a[i2] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public T acquire() {
            int i2 = this.f1209b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            Object[] objArr = this.f1208a;
            T t = (T) objArr[i3];
            objArr[i3] = null;
            this.f1209b = i2 - 1;
            return t;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T t) {
            int i2 = this.f1209b;
            Object[] objArr = this.f1208a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f1209b = i2 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i2) {
            if (i2 > tArr.length) {
                i2 = tArr.length;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                T t = tArr[i3];
                int i4 = this.f1209b;
                Object[] objArr = this.f1208a;
                if (i4 < objArr.length) {
                    objArr[i4] = t;
                    this.f1209b = i4 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
