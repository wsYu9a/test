package e5;

import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class k {

    /* renamed from: a */
    public static final k f25622a = new a();

    /* renamed from: b */
    public static final k f25623b = new b(-1);

    /* renamed from: c */
    public static final k f25624c = new b(1);

    public class a extends k {
        public a() {
            super(null);
        }

        @Override // e5.k
        public k d(double d10, double d11) {
            return o(Double.compare(d10, d11));
        }

        @Override // e5.k
        public k e(float f10, float f11) {
            return o(Float.compare(f10, f11));
        }

        @Override // e5.k
        public k f(int i10, int i11) {
            return o(Ints.e(i10, i11));
        }

        @Override // e5.k
        public k g(long j10, long j11) {
            return o(Longs.d(j10, j11));
        }

        @Override // e5.k
        public k i(Comparable<?> comparable, Comparable<?> comparable2) {
            return o(comparable.compareTo(comparable2));
        }

        @Override // e5.k
        public <T> k j(@d1 T t10, @d1 T t11, Comparator<T> comparator) {
            return o(comparator.compare(t10, t11));
        }

        @Override // e5.k
        public k k(boolean z10, boolean z11) {
            return o(Booleans.d(z10, z11));
        }

        @Override // e5.k
        public k l(boolean z10, boolean z11) {
            return o(Booleans.d(z11, z10));
        }

        @Override // e5.k
        public int m() {
            return 0;
        }

        public k o(int i10) {
            return i10 < 0 ? k.f25623b : i10 > 0 ? k.f25624c : k.f25622a;
        }
    }

    public /* synthetic */ k(a aVar) {
        this();
    }

    public static k n() {
        return f25622a;
    }

    public abstract k d(double d10, double d11);

    public abstract k e(float f10, float f11);

    public abstract k f(int i10, int i11);

    public abstract k g(long j10, long j11);

    @Deprecated
    public final k h(Boolean bool, Boolean bool2) {
        return k(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract k i(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> k j(@d1 T t10, @d1 T t11, Comparator<T> comparator);

    public abstract k k(boolean z10, boolean z11);

    public abstract k l(boolean z10, boolean z11);

    public abstract int m();

    public k() {
    }

    public static final class b extends k {

        /* renamed from: d */
        public final int f25625d;

        public b(int i10) {
            super(null);
            this.f25625d = i10;
        }

        @Override // e5.k
        public int m() {
            return this.f25625d;
        }

        @Override // e5.k
        public k d(double d10, double d11) {
            return this;
        }

        @Override // e5.k
        public k e(float f10, float f11) {
            return this;
        }

        @Override // e5.k
        public k f(int i10, int i11) {
            return this;
        }

        @Override // e5.k
        public k g(long j10, long j11) {
            return this;
        }

        @Override // e5.k
        public k i(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        @Override // e5.k
        public k k(boolean z10, boolean z11) {
            return this;
        }

        @Override // e5.k
        public k l(boolean z10, boolean z11) {
            return this;
        }

        @Override // e5.k
        public <T> k j(@d1 T t10, @d1 T t11, Comparator<T> comparator) {
            return this;
        }
    }
}
