package f5;

import b5.u;
import javax.annotation.CheckForNull;

@a5.b
@f
/* loaded from: classes2.dex */
public abstract class d extends h {

    /* renamed from: b */
    public static final int f25982b = 2;

    public static char[] e(char[] cArr, int i10, int i11) {
        if (i11 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i11];
        if (i10 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i10);
        }
        return cArr2;
    }

    @Override // f5.h
    public String b(String str) {
        u.E(str);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (c(str.charAt(i10)) != null) {
                return d(str, i10);
            }
        }
        return str;
    }

    @CheckForNull
    public abstract char[] c(char c10);

    public final String d(String str, int i10) {
        int length = str.length();
        char[] a10 = k.a();
        int length2 = a10.length;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            char[] c10 = c(str.charAt(i10));
            if (c10 != null) {
                int length3 = c10.length;
                int i13 = i10 - i11;
                int i14 = i12 + i13;
                int i15 = i14 + length3;
                if (length2 < i15) {
                    length2 = ((length - i10) * 2) + i15;
                    a10 = e(a10, i12, length2);
                }
                if (i13 > 0) {
                    str.getChars(i11, i10, a10, i12);
                    i12 = i14;
                }
                if (length3 > 0) {
                    System.arraycopy(c10, 0, a10, i12, length3);
                    i12 += length3;
                }
                i11 = i10 + 1;
            }
            i10++;
        }
        int i16 = length - i11;
        if (i16 > 0) {
            int i17 = i16 + i12;
            if (length2 < i17) {
                a10 = e(a10, i12, i17);
            }
            str.getChars(i11, length, a10, i12);
            i12 = i17;
        }
        return new String(a10, 0, i12);
    }
}
