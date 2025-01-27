package com.google.common.primitives;

import a5.a;
import a5.b;
import a5.c;
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
import kotlin.jvm.internal.ShortCompanionObject;
import n5.i;

@b(emulated = true)
@n5.b
/* loaded from: classes2.dex */
public final class Shorts extends i {

    /* renamed from: a */
    public static final int f10192a = 2;

    /* renamed from: b */
    public static final short f10193b = 16384;

    public enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int e10 = Shorts.e(sArr[i10], sArr2[i10]);
                if (e10 != 0) {
                    return e10;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    @b
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        public ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Short) && Shorts.n(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != shortArrayAsList.array[shortArrayAsList.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + Shorts.l(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int n10;
            if (!(obj instanceof Short) || (n10 = Shorts.n(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return n10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int r10;
            if (!(obj instanceof Short) || (r10 = Shorts.r(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return r10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i10, int i11) {
            u.f0(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i12 = this.start;
            return new ShortArrayAsList(sArr, i10 + i12, i12 + i11);
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 6);
            sb2.append('[');
            sb2.append((int) this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 >= this.end) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append((int) this.array[i10]);
            }
        }

        public ShortArrayAsList(short[] sArr, int i10, int i11) {
            this.array = sArr;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int i10) {
            u.C(i10, size());
            return Short.valueOf(this.array[this.start + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Short set(int i10, Short sh2) {
            u.C(i10, size());
            short[] sArr = this.array;
            int i11 = this.start;
            short s10 = sArr[i11 + i10];
            sArr[i11 + i10] = ((Short) u.E(sh2)).shortValue();
            return Short.valueOf(s10);
        }
    }

    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        @Override // com.google.common.base.Converter
        public String doBackward(Short sh2) {
            return sh2.toString();
        }

        @Override // com.google.common.base.Converter
        public Short doForward(String str) {
            return Short.decode(str);
        }
    }

    @a
    public static Converter<String, Short> A() {
        return ShortConverter.INSTANCE;
    }

    public static short[] B(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = ((Number) u.E(array[i10])).shortValue();
        }
        return sArr;
    }

    @c
    public static byte[] C(short s10) {
        return new byte[]{(byte) (s10 >> 8), (byte) s10};
    }

    public static List<Short> c(short... sArr) {
        return sArr.length == 0 ? Collections.emptyList() : new ShortArrayAsList(sArr);
    }

    public static short d(long j10) {
        short s10 = (short) j10;
        u.p(((long) s10) == j10, "Out of range: %s", j10);
        return s10;
    }

    public static int e(short s10, short s11) {
        return s10 - s11;
    }

    public static short[] f(short[]... sArr) {
        int i10 = 0;
        for (short[] sArr2 : sArr) {
            i10 += sArr2.length;
        }
        short[] sArr3 = new short[i10];
        int i11 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, i11, sArr4.length);
            i11 += sArr4.length;
        }
        return sArr3;
    }

    @a
    public static short g(short s10, short s11, short s12) {
        u.m(s11 <= s12, "min (%s) must be less than or equal to max (%s)", s11, s12);
        return s10 < s11 ? s11 : s10 < s12 ? s10 : s12;
    }

    public static boolean h(short[] sArr, short s10) {
        for (short s11 : sArr) {
            if (s11 == s10) {
                return true;
            }
        }
        return false;
    }

    public static short[] i(short[] sArr, int i10, int i11) {
        u.k(i10 >= 0, "Invalid minLength: %s", i10);
        u.k(i11 >= 0, "Invalid padding: %s", i11);
        return sArr.length < i10 ? Arrays.copyOf(sArr, i10 + i11) : sArr;
    }

    @c
    public static short j(byte[] bArr) {
        u.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @c
    public static short k(byte b10, byte b11) {
        return (short) ((b10 << 8) | (b11 & 255));
    }

    public static int l(short s10) {
        return s10;
    }

    public static int m(short[] sArr, short s10) {
        return n(sArr, s10, 0, sArr.length);
    }

    public static int n(short[] sArr, short s10, int i10, int i11) {
        while (i10 < i11) {
            if (sArr[i10] == s10) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0023, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int o(short[] r5, short[] r6) {
        /*
            java.lang.String r0 = "array"
            b5.u.F(r5, r0)
            java.lang.String r0 = "target"
            b5.u.F(r6, r0)
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2a
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L29
            int r3 = r0 + r2
            short r3 = r5[r3]
            short r4 = r6[r2]
            if (r3 == r4) goto L26
            int r0 = r0 + 1
            goto L10
        L26:
            int r2 = r2 + 1
            goto L18
        L29:
            return r0
        L2a:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Shorts.o(short[], short[]):int");
    }

    public static String p(String str, short... sArr) {
        u.E(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(sArr.length * 6);
        sb2.append((int) sArr[0]);
        for (int i10 = 1; i10 < sArr.length; i10++) {
            sb2.append(str);
            sb2.append((int) sArr[i10]);
        }
        return sb2.toString();
    }

    public static int q(short[] sArr, short s10) {
        return r(sArr, s10, 0, sArr.length);
    }

    public static int r(short[] sArr, short s10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (sArr[i12] == s10) {
                return i12;
            }
        }
        return -1;
    }

    public static Comparator<short[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    @c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short t(short... sArr) {
        u.d(sArr.length > 0);
        short s10 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            short s11 = sArr[i10];
            if (s11 > s10) {
                s10 = s11;
            }
        }
        return s10;
    }

    @c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short u(short... sArr) {
        u.d(sArr.length > 0);
        short s10 = sArr[0];
        for (int i10 = 1; i10 < sArr.length; i10++) {
            short s11 = sArr[i10];
            if (s11 < s10) {
                s10 = s11;
            }
        }
        return s10;
    }

    public static void v(short[] sArr) {
        u.E(sArr);
        w(sArr, 0, sArr.length);
    }

    public static void w(short[] sArr, int i10, int i11) {
        u.E(sArr);
        u.f0(i10, i11, sArr.length);
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            short s10 = sArr[i10];
            sArr[i10] = sArr[i12];
            sArr[i12] = s10;
            i10++;
        }
    }

    public static short x(long j10) {
        return j10 > 32767 ? ShortCompanionObject.MAX_VALUE : j10 < -32768 ? ShortCompanionObject.MIN_VALUE : (short) j10;
    }

    public static void y(short[] sArr) {
        u.E(sArr);
        z(sArr, 0, sArr.length);
    }

    public static void z(short[] sArr, int i10, int i11) {
        u.E(sArr);
        u.f0(i10, i11, sArr.length);
        Arrays.sort(sArr, i10, i11);
        w(sArr, i10, i11);
    }
}
