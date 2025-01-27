package com.google.common.primitives;

import a5.b;
import b5.u;
import com.google.common.base.Converter;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@b
@n5.b
/* loaded from: classes2.dex */
public final class Longs {

    /* renamed from: a */
    public static final int f10189a = 8;

    /* renamed from: b */
    public static final long f10190b = 4611686018427387904L;

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int d10 = Longs.d(jArr[i10], jArr2[i10]);
                if (d10 != 0) {
                    return d10;
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    @b
    public static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        public LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Long) && Longs.m(this.array, ((Long) obj).longValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LongArrayAsList)) {
                return super.equals(obj);
            }
            LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
            int size = size();
            if (longArrayAsList.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != longArrayAsList.array[longArrayAsList.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + Longs.k(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int m10;
            if (!(obj instanceof Long) || (m10 = Longs.m(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return m10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int q10;
            if (!(obj instanceof Long) || (q10 = Longs.q(this.array, ((Long) obj).longValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return q10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i10, int i11) {
            u.f0(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i12 = this.start;
            return new LongArrayAsList(jArr, i10 + i12, i12 + i11);
        }

        public long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 10);
            sb2.append('[');
            sb2.append(this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 >= this.end) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.array[i10]);
            }
        }

        public LongArrayAsList(long[] jArr, int i10, int i11) {
            this.array = jArr;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int i10) {
            u.C(i10, size());
            return Long.valueOf(this.array[this.start + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Long set(int i10, Long l10) {
            u.C(i10, size());
            long[] jArr = this.array;
            int i11 = this.start;
            long j10 = jArr[i11 + i10];
            jArr[i11 + i10] = ((Long) u.E(l10)).longValue();
            return Long.valueOf(j10);
        }
    }

    public static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = new LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Longs.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Long l10) {
            return l10.toString();
        }

        @Override // com.google.common.base.Converter
        public Long doForward(String str) {
            return Long.decode(str);
        }
    }

    public static final class a {

        /* renamed from: a */
        public static final byte[] f10191a;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i10 = 0; i10 < 10; i10++) {
                bArr[i10 + 48] = (byte) i10;
            }
            for (int i11 = 0; i11 < 26; i11++) {
                byte b10 = (byte) (i11 + 10);
                bArr[i11 + 65] = b10;
                bArr[i11 + 97] = b10;
            }
            f10191a = bArr;
        }

        public static int a(char c10) {
            if (c10 < 128) {
                return f10191a[c10];
            }
            return -1;
        }
    }

    public static byte[] A(long j10) {
        byte[] bArr = new byte[8];
        for (int i10 = 7; i10 >= 0; i10--) {
            bArr[i10] = (byte) (255 & j10);
            j10 >>= 8;
        }
        return bArr;
    }

    @a5.a
    @CheckForNull
    public static Long B(String str) {
        return C(str, 10);
    }

    @a5.a
    @CheckForNull
    public static Long C(String str, int i10) {
        if (((String) u.E(str)).isEmpty()) {
            return null;
        }
        if (i10 < 2 || i10 > 36) {
            StringBuilder sb2 = new StringBuilder(65);
            sb2.append("radix must be between MIN_RADIX and MAX_RADIX but was ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        }
        int i11 = str.charAt(0) == '-' ? 1 : 0;
        if (i11 == str.length()) {
            return null;
        }
        int i12 = i11 + 1;
        int a10 = a.a(str.charAt(i11));
        if (a10 < 0 || a10 >= i10) {
            return null;
        }
        long j10 = -a10;
        long j11 = i10;
        long j12 = Long.MIN_VALUE / j11;
        while (i12 < str.length()) {
            int i13 = i12 + 1;
            int a11 = a.a(str.charAt(i12));
            if (a11 < 0 || a11 >= i10 || j10 < j12) {
                return null;
            }
            long j13 = j10 * j11;
            long j14 = a11;
            if (j13 < j14 - Long.MIN_VALUE) {
                return null;
            }
            j10 = j13 - j14;
            i12 = i13;
        }
        if (i11 != 0) {
            return Long.valueOf(j10);
        }
        if (j10 == Long.MIN_VALUE) {
            return null;
        }
        return Long.valueOf(-j10);
    }

    public static List<Long> c(long... jArr) {
        return jArr.length == 0 ? Collections.emptyList() : new LongArrayAsList(jArr);
    }

    public static int d(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 > j11 ? 1 : 0;
    }

    public static long[] e(long[]... jArr) {
        int i10 = 0;
        for (long[] jArr2 : jArr) {
            i10 += jArr2.length;
        }
        long[] jArr3 = new long[i10];
        int i11 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, i11, jArr4.length);
            i11 += jArr4.length;
        }
        return jArr3;
    }

    @a5.a
    public static long f(long j10, long j11, long j12) {
        u.s(j11 <= j12, "min (%s) must be less than or equal to max (%s)", j11, j12);
        return Math.min(Math.max(j10, j11), j12);
    }

    public static boolean g(long[] jArr, long j10) {
        for (long j11 : jArr) {
            if (j11 == j10) {
                return true;
            }
        }
        return false;
    }

    public static long[] h(long[] jArr, int i10, int i11) {
        u.k(i10 >= 0, "Invalid minLength: %s", i10);
        u.k(i11 >= 0, "Invalid padding: %s", i11);
        return jArr.length < i10 ? Arrays.copyOf(jArr, i10 + i11) : jArr;
    }

    public static long i(byte[] bArr) {
        u.m(bArr.length >= 8, "array too small: %s < %s", bArr.length, 8);
        return j(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long j(byte b10, byte b11, byte b12, byte b13, byte b14, byte b15, byte b16, byte b17) {
        return ((b11 & 255) << 48) | ((b10 & 255) << 56) | ((b12 & 255) << 40) | ((b13 & 255) << 32) | ((b14 & 255) << 24) | ((b15 & 255) << 16) | ((b16 & 255) << 8) | (b17 & 255);
    }

    public static int k(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static int l(long[] jArr, long j10) {
        return m(jArr, j10, 0, jArr.length);
    }

    public static int m(long[] jArr, long j10, int i10, int i11) {
        while (i10 < i11) {
            if (jArr[i10] == j10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int n(long[] r8, long[] r9) {
        /*
            java.lang.String r0 = "array"
            b5.u.F(r8, r0)
            java.lang.String r0 = "target"
            b5.u.F(r9, r0)
            int r0 = r9.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r8.length
            int r3 = r9.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r9.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r8[r3]
            r5 = r9[r2]
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Longs.n(long[], long[]):int");
    }

    public static String o(String str, long... jArr) {
        u.E(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(jArr.length * 10);
        sb2.append(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            sb2.append(str);
            sb2.append(jArr[i10]);
        }
        return sb2.toString();
    }

    public static int p(long[] jArr, long j10) {
        return q(jArr, j10, 0, jArr.length);
    }

    public static int q(long[] jArr, long j10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (jArr[i12] == j10) {
                return i12;
            }
        }
        return -1;
    }

    public static Comparator<long[]> r() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long s(long... jArr) {
        u.d(jArr.length > 0);
        long j10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long j11 = jArr[i10];
            if (j11 > j10) {
                j10 = j11;
            }
        }
        return j10;
    }

    public static long t(long... jArr) {
        u.d(jArr.length > 0);
        long j10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long j11 = jArr[i10];
            if (j11 < j10) {
                j10 = j11;
            }
        }
        return j10;
    }

    public static void u(long[] jArr) {
        u.E(jArr);
        v(jArr, 0, jArr.length);
    }

    public static void v(long[] jArr, int i10, int i11) {
        u.E(jArr);
        u.f0(i10, i11, jArr.length);
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            long j10 = jArr[i10];
            jArr[i10] = jArr[i12];
            jArr[i12] = j10;
            i10++;
        }
    }

    public static void w(long[] jArr) {
        u.E(jArr);
        x(jArr, 0, jArr.length);
    }

    public static void x(long[] jArr, int i10, int i11) {
        u.E(jArr);
        u.f0(i10, i11, jArr.length);
        Arrays.sort(jArr, i10, i11);
        v(jArr, i10, i11);
    }

    @a5.a
    public static Converter<String, Long> y() {
        return LongConverter.INSTANCE;
    }

    public static long[] z(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).toLongArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = ((Number) u.E(array[i10])).longValue();
        }
        return jArr;
    }
}
