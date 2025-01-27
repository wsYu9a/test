package e5;

import com.google.common.collect.Ordering;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@a5.b
@m
/* loaded from: classes2.dex */
public final class u1<T> {

    /* renamed from: a */
    public final int f25656a;

    /* renamed from: b */
    public final Comparator<? super T> f25657b;

    /* renamed from: c */
    public final T[] f25658c;

    /* renamed from: d */
    public int f25659d;

    /* renamed from: e */
    @CheckForNull
    public T f25660e;

    public u1(Comparator<? super T> comparator, int i10) {
        this.f25657b = (Comparator) b5.u.F(comparator, "comparator");
        this.f25656a = i10;
        b5.u.k(i10 >= 0, "k (%s) must be >= 0", i10);
        b5.u.k(i10 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i10);
        this.f25658c = (T[]) new Object[l5.f.d(i10, 2)];
        this.f25659d = 0;
        this.f25660e = null;
    }

    public static <T extends Comparable<? super T>> u1<T> a(int i10) {
        return b(i10, Ordering.natural());
    }

    public static <T> u1<T> b(int i10, Comparator<? super T> comparator) {
        return new u1<>(Ordering.from(comparator).reverse(), i10);
    }

    public static <T extends Comparable<? super T>> u1<T> c(int i10) {
        return d(i10, Ordering.natural());
    }

    public static <T> u1<T> d(int i10, Comparator<? super T> comparator) {
        return new u1<>(comparator, i10);
    }

    public void e(@d1 T t10) {
        int i10 = this.f25656a;
        if (i10 == 0) {
            return;
        }
        int i11 = this.f25659d;
        if (i11 == 0) {
            this.f25658c[0] = t10;
            this.f25660e = t10;
            this.f25659d = 1;
            return;
        }
        if (i11 < i10) {
            T[] tArr = this.f25658c;
            this.f25659d = i11 + 1;
            tArr[i11] = t10;
            if (this.f25657b.compare(t10, (Object) a1.a(this.f25660e)) > 0) {
                this.f25660e = t10;
                return;
            }
            return;
        }
        if (this.f25657b.compare(t10, (Object) a1.a(this.f25660e)) < 0) {
            T[] tArr2 = this.f25658c;
            int i12 = this.f25659d;
            int i13 = i12 + 1;
            this.f25659d = i13;
            tArr2[i12] = t10;
            if (i13 == this.f25656a * 2) {
                k();
            }
        }
    }

    public void f(Iterable<? extends T> iterable) {
        g(iterable.iterator());
    }

    public void g(Iterator<? extends T> it) {
        while (it.hasNext()) {
            e(it.next());
        }
    }

    public final int h(int i10, int i11, int i12) {
        Object a10 = a1.a(this.f25658c[i12]);
        T[] tArr = this.f25658c;
        tArr[i12] = tArr[i11];
        int i13 = i10;
        while (i10 < i11) {
            if (this.f25657b.compare((Object) a1.a(this.f25658c[i10]), a10) < 0) {
                i(i13, i10);
                i13++;
            }
            i10++;
        }
        T[] tArr2 = this.f25658c;
        tArr2[i11] = tArr2[i13];
        tArr2[i13] = a10;
        return i13;
    }

    public final void i(int i10, int i11) {
        T[] tArr = this.f25658c;
        T t10 = tArr[i10];
        tArr[i10] = tArr[i11];
        tArr[i11] = t10;
    }

    public List<T> j() {
        Arrays.sort(this.f25658c, 0, this.f25659d, this.f25657b);
        int i10 = this.f25659d;
        int i11 = this.f25656a;
        if (i10 > i11) {
            T[] tArr = this.f25658c;
            Arrays.fill(tArr, i11, tArr.length, (Object) null);
            int i12 = this.f25656a;
            this.f25659d = i12;
            this.f25660e = this.f25658c[i12 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f25658c, this.f25659d)));
    }

    public final void k() {
        int i10 = (this.f25656a * 2) - 1;
        int p10 = l5.f.p(i10, RoundingMode.CEILING) * 3;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            int h10 = h(i11, i10, ((i11 + i10) + 1) >>> 1);
            int i14 = this.f25656a;
            if (h10 <= i14) {
                if (h10 >= i14) {
                    break;
                }
                i11 = Math.max(h10, i11 + 1);
                i13 = h10;
            } else {
                i10 = h10 - 1;
            }
            i12++;
            if (i12 >= p10) {
                Arrays.sort(this.f25658c, i11, i10 + 1, this.f25657b);
                break;
            }
        }
        this.f25659d = this.f25656a;
        this.f25660e = (T) a1.a(this.f25658c[i13]);
        while (true) {
            i13++;
            if (i13 >= this.f25656a) {
                return;
            }
            if (this.f25657b.compare((Object) a1.a(this.f25658c[i13]), (Object) a1.a(this.f25660e)) > 0) {
                this.f25660e = this.f25658c[i13];
            }
        }
    }
}
