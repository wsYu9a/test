package l5;

import b5.u;
import com.google.common.math.LongMath;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@a5.a
@a5.c
@e
/* loaded from: classes2.dex */
public final class i {

    public static final class b {

        /* renamed from: a */
        public final int f27919a;

        public /* synthetic */ b(int i10, a aVar) {
            this(i10);
        }

        public c a(int i10) {
            return new c(this.f27919a, i10);
        }

        public d b(Collection<Integer> collection) {
            return new d(this.f27919a, Ints.B(collection));
        }

        public d c(int... iArr) {
            return new d(this.f27919a, (int[]) iArr.clone());
        }

        public b(int i10) {
            u.e(i10 > 0, "Quantile scale must be positive");
            this.f27919a = i10;
        }
    }

    public static final class c {

        /* renamed from: a */
        public final int f27920a;

        /* renamed from: b */
        public final int f27921b;

        public /* synthetic */ c(int i10, int i11, a aVar) {
            this(i10, i11);
        }

        public double a(Collection<? extends Number> collection) {
            return e(Doubles.z(collection));
        }

        public double b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public double c(int... iArr) {
            return e(i.l(iArr));
        }

        public double d(long... jArr) {
            return e(i.m(jArr));
        }

        public double e(double... dArr) {
            u.e(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (i.j(dArr)) {
                return Double.NaN;
            }
            long length = this.f27921b * (dArr.length - 1);
            int g10 = (int) LongMath.g(length, this.f27920a, RoundingMode.DOWN);
            int i10 = (int) (length - (g10 * this.f27920a));
            i.u(g10, dArr, 0, dArr.length - 1);
            if (i10 == 0) {
                return dArr[g10];
            }
            int i11 = g10 + 1;
            i.u(i11, dArr, i11, dArr.length - 1);
            return i.k(dArr[g10], dArr[i11], i10, this.f27920a);
        }

        public c(int i10, int i11) {
            i.h(i11, i10);
            this.f27920a = i10;
            this.f27921b = i11;
        }
    }

    public static final class d {

        /* renamed from: a */
        public final int f27922a;

        /* renamed from: b */
        public final int[] f27923b;

        public /* synthetic */ d(int i10, int[] iArr, a aVar) {
            this(i10, iArr);
        }

        public Map<Integer, Double> a(Collection<? extends Number> collection) {
            return e(Doubles.z(collection));
        }

        public Map<Integer, Double> b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public Map<Integer, Double> c(int... iArr) {
            return e(i.l(iArr));
        }

        public Map<Integer, Double> d(long... jArr) {
            return e(i.m(jArr));
        }

        public Map<Integer, Double> e(double... dArr) {
            int i10 = 0;
            int i11 = 1;
            u.e(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (i.j(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.f27923b;
                int length = iArr.length;
                while (i10 < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i10]), Double.valueOf(Double.NaN));
                    i10++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.f27923b;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (i12 >= this.f27923b.length) {
                    break;
                }
                long length2 = r5[i12] * (dArr.length - i11);
                int g10 = (int) LongMath.g(length2, this.f27922a, RoundingMode.DOWN);
                int i14 = i12;
                int i15 = (int) (length2 - (g10 * this.f27922a));
                iArr3[i14] = g10;
                iArr4[i14] = i15;
                iArr5[i13] = g10;
                int i16 = i13 + 1;
                if (i15 != 0) {
                    iArr5[i16] = g10 + 1;
                    i13 += 2;
                } else {
                    i13 = i16;
                }
                i12 = i14 + 1;
                i11 = 1;
            }
            Arrays.sort(iArr5, 0, i13);
            i.t(iArr5, 0, i13 - 1, dArr, 0, dArr.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr6 = this.f27923b;
                if (i10 >= iArr6.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i17 = iArr3[i10];
                int i18 = iArr4[i10];
                if (i18 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr6[i10]), Double.valueOf(dArr[i17]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr6[i10]), Double.valueOf(i.k(dArr[i17], dArr[i17 + 1], i18, this.f27922a)));
                }
                i10++;
            }
        }

        public d(int i10, int[] iArr) {
            for (int i11 : iArr) {
                i.h(i11, i10);
            }
            u.e(iArr.length > 0, "Indexes must be a non empty array");
            this.f27922a = i10;
            this.f27923b = iArr;
        }
    }

    public static void h(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            StringBuilder sb2 = new StringBuilder(70);
            sb2.append("Quantile indexes must be between 0 and the scale, which is ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static int i(int[] iArr, int i10, int i11, int i12, int i13) {
        if (i10 == i11) {
            return i10;
        }
        int i14 = i12 + i13;
        int i15 = i14 >>> 1;
        while (i11 > i10 + 1) {
            int i16 = (i10 + i11) >>> 1;
            int i17 = iArr[i16];
            if (i17 > i15) {
                i11 = i16;
            } else {
                if (i17 >= i15) {
                    return i16;
                }
                i10 = i16;
            }
        }
        return (i14 - iArr[i10]) - iArr[i11] > 0 ? i11 : i10;
    }

    public static boolean j(double... dArr) {
        for (double d10 : dArr) {
            if (Double.isNaN(d10)) {
                return true;
            }
        }
        return false;
    }

    public static double k(double d10, double d11, double d12, double d13) {
        if (d10 == Double.NEGATIVE_INFINITY) {
            return d11 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d11 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d10 + (((d11 - d10) * d12) / d13);
    }

    public static double[] l(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = iArr[i10];
        }
        return dArr;
    }

    public static double[] m(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = jArr[i10];
        }
        return dArr;
    }

    public static c n() {
        return s(2).a(1);
    }

    public static void o(double[] dArr, int i10, int i11) {
        int i12 = (i10 + i11) >>> 1;
        double d10 = dArr[i11];
        double d11 = dArr[i12];
        boolean z10 = d10 < d11;
        double d12 = dArr[i10];
        boolean z11 = d11 < d12;
        boolean z12 = d10 < d12;
        if (z10 == z11) {
            v(dArr, i12, i10);
        } else if (z10 != z12) {
            v(dArr, i10, i11);
        }
    }

    public static int p(double[] dArr, int i10, int i11) {
        o(dArr, i10, i11);
        double d10 = dArr[i10];
        int i12 = i11;
        while (i11 > i10) {
            if (dArr[i11] > d10) {
                v(dArr, i12, i11);
                i12--;
            }
            i11--;
        }
        v(dArr, i10, i12);
        return i12;
    }

    public static b q() {
        return s(100);
    }

    public static b r() {
        return s(4);
    }

    public static b s(int i10) {
        return new b(i10);
    }

    public static void t(int[] iArr, int i10, int i11, double[] dArr, int i12, int i13) {
        int i14 = i(iArr, i10, i11, i12, i13);
        int i15 = iArr[i14];
        u(i15, dArr, i12, i13);
        int i16 = i14 - 1;
        while (i16 >= i10 && iArr[i16] == i15) {
            i16--;
        }
        if (i16 >= i10) {
            t(iArr, i10, i16, dArr, i12, i15 - 1);
        }
        int i17 = i14 + 1;
        while (i17 <= i11 && iArr[i17] == i15) {
            i17++;
        }
        if (i17 <= i11) {
            t(iArr, i17, i11, dArr, i15 + 1, i13);
        }
    }

    public static void u(int i10, double[] dArr, int i11, int i12) {
        if (i10 != i11) {
            while (i12 > i11) {
                int p10 = p(dArr, i11, i12);
                if (p10 >= i10) {
                    i12 = p10 - 1;
                }
                if (p10 <= i10) {
                    i11 = p10 + 1;
                }
            }
            return;
        }
        int i13 = i11;
        for (int i14 = i11 + 1; i14 <= i12; i14++) {
            if (dArr[i13] > dArr[i14]) {
                i13 = i14;
            }
        }
        if (i13 != i11) {
            v(dArr, i13, i11);
        }
    }

    public static void v(double[] dArr, int i10, int i11) {
        double d10 = dArr[i10];
        dArr[i10] = dArr[i11];
        dArr[i11] = d10;
    }
}
