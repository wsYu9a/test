package com.google.common.base;

import a5.d;
import b5.g;
import b5.n;
import b5.q;
import b5.r;
import b5.s;
import b5.u;
import b5.z;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public final class Suppliers {

    @d
    public static class ExpiringMemoizingSupplier<T> implements z<T>, Serializable {
        private static final long serialVersionUID = 0;
        final z<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;

        @CheckForNull
        volatile transient T value;

        public ExpiringMemoizingSupplier(z<T> zVar, long j10, TimeUnit timeUnit) {
            this.delegate = (z) u.E(zVar);
            this.durationNanos = timeUnit.toNanos(j10);
            u.t(j10 > 0, "duration (%s %s) must be > 0", j10, timeUnit);
        }

        @Override // b5.z
        @s
        public T get() {
            long j10 = this.expirationNanos;
            long l10 = com.google.common.base.b.l();
            if (j10 == 0 || l10 - j10 >= 0) {
                synchronized (this) {
                    try {
                        if (j10 == this.expirationNanos) {
                            T t10 = this.delegate.get();
                            this.value = t10;
                            long j11 = l10 + this.durationNanos;
                            if (j11 == 0) {
                                j11 = 1;
                            }
                            this.expirationNanos = j11;
                            return t10;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return (T) q.a(this.value);
        }

        public String toString() {
            String valueOf = String.valueOf(this.delegate);
            long j10 = this.durationNanos;
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 62);
            sb2.append("Suppliers.memoizeWithExpiration(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(j10);
            sb2.append(", NANOS)");
            return sb2.toString();
        }
    }

    @d
    public static class MemoizingSupplier<T> implements z<T>, Serializable {
        private static final long serialVersionUID = 0;
        final z<T> delegate;
        volatile transient boolean initialized;

        @CheckForNull
        transient T value;

        public MemoizingSupplier(z<T> zVar) {
            this.delegate = (z) u.E(zVar);
        }

        @Override // b5.z
        @s
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    try {
                        if (!this.initialized) {
                            T t10 = this.delegate.get();
                            this.value = t10;
                            this.initialized = true;
                            return t10;
                        }
                    } finally {
                    }
                }
            }
            return (T) q.a(this.value);
        }

        public String toString() {
            Object obj;
            if (this.initialized) {
                String valueOf = String.valueOf(this.value);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
                sb2.append("<supplier that returned ");
                sb2.append(valueOf);
                sb2.append(">");
                obj = sb2.toString();
            } else {
                obj = this.delegate;
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
            sb3.append("Suppliers.memoize(");
            sb3.append(valueOf2);
            sb3.append(")");
            return sb3.toString();
        }
    }

    public static class SupplierComposition<F, T> implements z<T>, Serializable {
        private static final long serialVersionUID = 0;
        final n<? super F, T> function;
        final z<F> supplier;

        public SupplierComposition(n<? super F, T> nVar, z<F> zVar) {
            this.function = (n) u.E(nVar);
            this.supplier = (z) u.E(zVar);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            return this.function.equals(supplierComposition.function) && this.supplier.equals(supplierComposition.supplier);
        }

        @Override // b5.z
        @s
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return r.b(this.function, this.supplier);
        }

        public String toString() {
            String valueOf = String.valueOf(this.function);
            String valueOf2 = String.valueOf(this.supplier);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
            sb2.append("Suppliers.compose(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public enum SupplierFunctionImpl implements b<Object> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        @Override // b5.n
        @CheckForNull
        public Object apply(z<Object> zVar) {
            return zVar.get();
        }
    }

    public static class SupplierOfInstance<T> implements z<T>, Serializable {
        private static final long serialVersionUID = 0;

        @s
        final T instance;

        public SupplierOfInstance(@s T t10) {
            this.instance = t10;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return r.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // b5.z
        @s
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return r.b(this.instance);
        }

        public String toString() {
            String valueOf = String.valueOf(this.instance);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
            sb2.append("Suppliers.ofInstance(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class ThreadSafeSupplier<T> implements z<T>, Serializable {
        private static final long serialVersionUID = 0;
        final z<T> delegate;

        public ThreadSafeSupplier(z<T> zVar) {
            this.delegate = (z) u.E(zVar);
        }

        @Override // b5.z
        @s
        public T get() {
            T t10;
            synchronized (this.delegate) {
                t10 = this.delegate.get();
            }
            return t10;
        }

        public String toString() {
            String valueOf = String.valueOf(this.delegate);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
            sb2.append("Suppliers.synchronizedSupplier(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    @d
    public static class a<T> implements z<T> {

        /* renamed from: b */
        @CheckForNull
        public volatile z<T> f9116b;

        /* renamed from: c */
        public volatile boolean f9117c;

        /* renamed from: d */
        @CheckForNull
        public T f9118d;

        public a(z<T> zVar) {
            this.f9116b = (z) u.E(zVar);
        }

        @Override // b5.z
        @s
        public T get() {
            if (!this.f9117c) {
                synchronized (this) {
                    try {
                        if (!this.f9117c) {
                            z<T> zVar = this.f9116b;
                            Objects.requireNonNull(zVar);
                            T t10 = zVar.get();
                            this.f9118d = t10;
                            this.f9117c = true;
                            this.f9116b = null;
                            return t10;
                        }
                    } finally {
                    }
                }
            }
            return (T) q.a(this.f9118d);
        }

        public String toString() {
            Object obj = this.f9116b;
            if (obj == null) {
                String valueOf = String.valueOf(this.f9118d);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
                sb2.append("<supplier that returned ");
                sb2.append(valueOf);
                sb2.append(">");
                obj = sb2.toString();
            }
            String valueOf2 = String.valueOf(obj);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
            sb3.append("Suppliers.memoize(");
            sb3.append(valueOf2);
            sb3.append(")");
            return sb3.toString();
        }
    }

    public interface b<T> extends n<z<T>, T> {
    }

    public static <F, T> z<T> a(n<? super F, T> nVar, z<F> zVar) {
        return new SupplierComposition(nVar, zVar);
    }

    public static <T> z<T> b(z<T> zVar) {
        return ((zVar instanceof a) || (zVar instanceof MemoizingSupplier)) ? zVar : zVar instanceof Serializable ? new MemoizingSupplier(zVar) : new a(zVar);
    }

    public static <T> z<T> c(z<T> zVar, long j10, TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier(zVar, j10, timeUnit);
    }

    public static <T> z<T> d(@s T t10) {
        return new SupplierOfInstance(t10);
    }

    public static <T> n<z<T>, T> e() {
        return SupplierFunctionImpl.INSTANCE;
    }

    public static <T> z<T> f(z<T> zVar) {
        return new ThreadSafeSupplier(zVar);
    }
}
