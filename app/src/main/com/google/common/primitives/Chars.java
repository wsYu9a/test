package com.google.common.primitives;

import a5.a;
import a5.b;
import a5.c;
import b5.u;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;

@b(emulated = true)
@n5.b
/* loaded from: classes2.dex */
public final class Chars {

    /* renamed from: a */
    public static final int f10177a = 2;

    @b
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        public CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Character) && Chars.n(this.array, ((Character) obj).charValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharArrayAsList)) {
                return super.equals(obj);
            }
            CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
            int size = size();
            if (charArrayAsList.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != charArrayAsList.array[charArrayAsList.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + Chars.l(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int n10;
            if (!(obj instanceof Character) || (n10 = Chars.n(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
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
            if (!(obj instanceof Character) || (r10 = Chars.r(this.array, ((Character) obj).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return r10 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int i10, int i11) {
            u.f0(i10, i11, size());
            if (i10 == i11) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i12 = this.start;
            return new CharArrayAsList(cArr, i10 + i12, i12 + i11);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 3);
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

        public CharArrayAsList(char[] cArr, int i10, int i11) {
            this.array = cArr;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i10) {
            u.C(i10, size());
            return Character.valueOf(this.array[this.start + i10]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Character set(int i10, Character ch2) {
            u.C(i10, size());
            char[] cArr = this.array;
            int i11 = this.start;
            char c10 = cArr[i11 + i10];
            cArr[i11 + i10] = ((Character) u.E(ch2)).charValue();
            return Character.valueOf(c10);
        }
    }

    public enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i10 = 0; i10 < min; i10++) {
                int e10 = Chars.e(cArr[i10], cArr2[i10]);
                if (e10 != 0) {
                    return e10;
                }
            }
            return cArr.length - cArr2.length;
        }
    }

    public static char[] A(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).toCharArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = ((Character) u.E(array[i10])).charValue();
        }
        return cArr;
    }

    @c
    public static byte[] B(char c10) {
        return new byte[]{(byte) (c10 >> '\b'), (byte) c10};
    }

    public static List<Character> c(char... cArr) {
        return cArr.length == 0 ? Collections.emptyList() : new CharArrayAsList(cArr);
    }

    public static char d(long j10) {
        char c10 = (char) j10;
        u.p(((long) c10) == j10, "Out of range: %s", j10);
        return c10;
    }

    public static int e(char c10, char c11) {
        return c10 - c11;
    }

    public static char[] f(char[]... cArr) {
        int i10 = 0;
        for (char[] cArr2 : cArr) {
            i10 += cArr2.length;
        }
        char[] cArr3 = new char[i10];
        int i11 = 0;
        for (char[] cArr4 : cArr) {
            System.arraycopy(cArr4, 0, cArr3, i11, cArr4.length);
            i11 += cArr4.length;
        }
        return cArr3;
    }

    @a
    public static char g(char c10, char c11, char c12) {
        u.g(c11 <= c12, "min (%s) must be less than or equal to max (%s)", c11, c12);
        return c10 < c11 ? c11 : c10 < c12 ? c10 : c12;
    }

    public static boolean h(char[] cArr, char c10) {
        for (char c11 : cArr) {
            if (c11 == c10) {
                return true;
            }
        }
        return false;
    }

    public static char[] i(char[] cArr, int i10, int i11) {
        u.k(i10 >= 0, "Invalid minLength: %s", i10);
        u.k(i11 >= 0, "Invalid padding: %s", i11);
        return cArr.length < i10 ? Arrays.copyOf(cArr, i10 + i11) : cArr;
    }

    @c
    public static char j(byte[] bArr) {
        u.m(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return k(bArr[0], bArr[1]);
    }

    @c
    public static char k(byte b10, byte b11) {
        return (char) ((b10 << 8) | (b11 & 255));
    }

    public static int l(char c10) {
        return c10;
    }

    public static int m(char[] cArr, char c10) {
        return n(cArr, c10, 0, cArr.length);
    }

    public static int n(char[] cArr, char c10, int i10, int i11) {
        while (i10 < i11) {
            if (cArr[i10] == c10) {
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
    public static int o(char[] r5, char[] r6) {
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
            char r3 = r5[r3]
            char r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Chars.o(char[], char[]):int");
    }

    public static String p(String str, char... cArr) {
        u.E(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder((str.length() * (length - 1)) + length);
        sb2.append(cArr[0]);
        for (int i10 = 1; i10 < length; i10++) {
            sb2.append(str);
            sb2.append(cArr[i10]);
        }
        return sb2.toString();
    }

    public static int q(char[] cArr, char c10) {
        return r(cArr, c10, 0, cArr.length);
    }

    public static int r(char[] cArr, char c10, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            if (cArr[i12] == c10) {
                return i12;
            }
        }
        return -1;
    }

    public static Comparator<char[]> s() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char t(char... cArr) {
        u.d(cArr.length > 0);
        char c10 = cArr[0];
        for (int i10 = 1; i10 < cArr.length; i10++) {
            char c11 = cArr[i10];
            if (c11 > c10) {
                c10 = c11;
            }
        }
        return c10;
    }

    public static char u(char... cArr) {
        u.d(cArr.length > 0);
        char c10 = cArr[0];
        for (int i10 = 1; i10 < cArr.length; i10++) {
            char c11 = cArr[i10];
            if (c11 < c10) {
                c10 = c11;
            }
        }
        return c10;
    }

    public static void v(char[] cArr) {
        u.E(cArr);
        w(cArr, 0, cArr.length);
    }

    public static void w(char[] cArr, int i10, int i11) {
        u.E(cArr);
        u.f0(i10, i11, cArr.length);
        for (int i12 = i11 - 1; i10 < i12; i12--) {
            char c10 = cArr[i10];
            cArr[i10] = cArr[i12];
            cArr[i12] = c10;
            i10++;
        }
    }

    public static char x(long j10) {
        if (j10 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return CharCompanionObject.MAX_VALUE;
        }
        if (j10 < 0) {
            return (char) 0;
        }
        return (char) j10;
    }

    public static void y(char[] cArr) {
        u.E(cArr);
        z(cArr, 0, cArr.length);
    }

    public static void z(char[] cArr, int i10, int i11) {
        u.E(cArr);
        u.f0(i10, i11, cArr.length);
        Arrays.sort(cArr, i10, i11);
        w(cArr, i10, i11);
    }
}
