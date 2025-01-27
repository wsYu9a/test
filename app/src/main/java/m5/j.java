package m5;

import b5.u;
import javax.annotation.CheckForNull;

@a5.b
@a
/* loaded from: classes2.dex */
public final class j extends f5.l {

    /* renamed from: e */
    public static final char[] f28482e = {'+'};

    /* renamed from: f */
    public static final char[] f28483f = "0123456789ABCDEF".toCharArray();

    /* renamed from: c */
    public final boolean f28484c;

    /* renamed from: d */
    public final boolean[] f28485d;

    public j(String str, boolean z10) {
        u.E(str);
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String concat = str.concat("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        if (z10 && concat.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.f28484c = z10;
        this.f28485d = h(concat);
    }

    public static boolean[] h(String str) {
        char[] charArray = str.toCharArray();
        int i10 = -1;
        for (char c10 : charArray) {
            i10 = Math.max((int) c10, i10);
        }
        boolean[] zArr = new boolean[i10 + 1];
        for (char c11 : charArray) {
            zArr[c11] = true;
        }
        return zArr;
    }

    @Override // f5.l, f5.h
    public String b(String str) {
        u.E(str);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            boolean[] zArr = this.f28485d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return e(str, i10);
            }
        }
        return str;
    }

    @Override // f5.l
    @CheckForNull
    public char[] d(int i10) {
        boolean[] zArr = this.f28485d;
        if (i10 < zArr.length && zArr[i10]) {
            return null;
        }
        if (i10 == 32 && this.f28484c) {
            return f28482e;
        }
        if (i10 <= 127) {
            char[] cArr = f28483f;
            return new char[]{'%', cArr[i10 >>> 4], cArr[i10 & 15]};
        }
        if (i10 <= 2047) {
            char[] cArr2 = f28483f;
            return new char[]{'%', cArr2[(i10 >>> 10) | 12], cArr2[(i10 >>> 6) & 15], '%', cArr2[((i10 >>> 4) & 3) | 8], cArr2[i10 & 15]};
        }
        if (i10 <= 65535) {
            char[] cArr3 = f28483f;
            return new char[]{'%', 'E', cArr3[i10 >>> 12], '%', cArr3[((i10 >>> 10) & 3) | 8], cArr3[(i10 >>> 6) & 15], '%', cArr3[((i10 >>> 4) & 3) | 8], cArr3[i10 & 15]};
        }
        if (i10 <= 1114111) {
            char[] cArr4 = f28483f;
            return new char[]{'%', 'F', cArr4[(i10 >>> 18) & 7], '%', cArr4[((i10 >>> 16) & 3) | 8], cArr4[(i10 >>> 12) & 15], '%', cArr4[((i10 >>> 10) & 3) | 8], cArr4[(i10 >>> 6) & 15], '%', cArr4[((i10 >>> 4) & 3) | 8], cArr4[i10 & 15]};
        }
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("Invalid unicode character value ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // f5.l
    public int g(CharSequence charSequence, int i10, int i11) {
        u.E(charSequence);
        while (i10 < i11) {
            char charAt = charSequence.charAt(i10);
            boolean[] zArr = this.f28485d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i10++;
        }
        return i10;
    }
}
