package f5;

import b5.u;
import javax.annotation.CheckForNull;

@a5.b
@f
/* loaded from: classes2.dex */
public abstract class l extends h {

    /* renamed from: b */
    public static final int f25998b = 32;

    public static int c(CharSequence charSequence, int i10, int i11) {
        u.E(charSequence);
        if (i10 >= i11) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i12 = i10 + 1;
        char charAt = charSequence.charAt(i10);
        if (charAt < 55296 || charAt > 57343) {
            return charAt;
        }
        if (charAt > 56319) {
            String valueOf = String.valueOf(charSequence);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 88);
            sb2.append("Unexpected low surrogate character '");
            sb2.append(charAt);
            sb2.append("' with value ");
            sb2.append((int) charAt);
            sb2.append(" at index ");
            sb2.append(i10);
            sb2.append(" in '");
            sb2.append(valueOf);
            sb2.append("'");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i12 == i11) {
            return -charAt;
        }
        char charAt2 = charSequence.charAt(i12);
        if (Character.isLowSurrogate(charAt2)) {
            return Character.toCodePoint(charAt, charAt2);
        }
        String valueOf2 = String.valueOf(charSequence);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 89);
        sb3.append("Expected low surrogate but got char '");
        sb3.append(charAt2);
        sb3.append("' with value ");
        sb3.append((int) charAt2);
        sb3.append(" at index ");
        sb3.append(i12);
        sb3.append(" in '");
        sb3.append(valueOf2);
        sb3.append("'");
        throw new IllegalArgumentException(sb3.toString());
    }

    private static char[] f(char[] cArr, int i10, int i11) {
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
        int g10 = g(str, 0, length);
        return g10 == length ? str : e(str, g10);
    }

    @CheckForNull
    public abstract char[] d(int i10);

    public final String e(String str, int i10) {
        int length = str.length();
        char[] a10 = k.a();
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int c10 = c(str, i10, length);
            if (c10 < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] d10 = d(c10);
            int i13 = (Character.isSupplementaryCodePoint(c10) ? 2 : 1) + i10;
            if (d10 != null) {
                int i14 = i10 - i11;
                int i15 = i12 + i14;
                int length2 = d10.length + i15;
                if (a10.length < length2) {
                    a10 = f(a10, i12, length2 + (length - i10) + 32);
                }
                if (i14 > 0) {
                    str.getChars(i11, i10, a10, i12);
                    i12 = i15;
                }
                if (d10.length > 0) {
                    System.arraycopy(d10, 0, a10, i12, d10.length);
                    i12 += d10.length;
                }
                i11 = i13;
            }
            i10 = g(str, i13, length);
        }
        int i16 = length - i11;
        if (i16 > 0) {
            int i17 = i16 + i12;
            if (a10.length < i17) {
                a10 = f(a10, i12, i17);
            }
            str.getChars(i11, length, a10, i12);
            i12 = i17;
        }
        return new String(a10, 0, i12);
    }

    public int g(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            int c10 = c(charSequence, i10, i11);
            if (c10 < 0 || d(c10) != null) {
                break;
            }
            i10 += Character.isSupplementaryCodePoint(c10) ? 2 : 1;
        }
        return i10;
    }
}
