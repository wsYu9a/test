package com.google.zxing.oned;

/* loaded from: classes.dex */
public final class b extends r {

    /* renamed from: a */
    private static final char[] f8523a;

    /* renamed from: b */
    private static final char[] f8524b = {'T', 'N', '*', 'E'};

    /* renamed from: c */
    private static final char[] f8525c = {'/', ':', '+', '.'};

    /* renamed from: d */
    private static final char f8526d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f8523a = cArr;
        f8526d = cArr[0];
    }

    @Override // com.google.zxing.oned.r
    public boolean[] d(String str) {
        int i2;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c2 = f8526d;
            sb.append(c2);
            sb.append(str);
            sb.append(c2);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f8523a;
            boolean h2 = a.h(cArr, upperCase);
            boolean h3 = a.h(cArr, upperCase2);
            char[] cArr2 = f8524b;
            boolean h4 = a.h(cArr2, upperCase);
            boolean h5 = a.h(cArr2, upperCase2);
            if (h2) {
                if (!h3) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!h4) {
                if (h3 || h5) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                StringBuilder sb2 = new StringBuilder();
                char c3 = f8526d;
                sb2.append(c3);
                sb2.append(str);
                sb2.append(c3);
                str = sb2.toString();
            } else if (!h5) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i3 = 20;
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else {
                if (!a.h(f8525c, str.charAt(i4))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
                }
                i3 += 10;
            }
        }
        boolean[] zArr = new boolean[i3 + (str.length() - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i6));
            if (i6 == 0 || i6 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i7 = 0;
            while (true) {
                char[] cArr3 = a.f8515d;
                if (i7 >= cArr3.length) {
                    i2 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i7]) {
                    i2 = a.f8516e[i7];
                    break;
                }
                i7++;
            }
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i5] = z;
                    i5++;
                    if (((i2 >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        z = !z;
                        i8++;
                    } else {
                        i9++;
                    }
                }
                break;
            }
            if (i6 < str.length() - 1) {
                zArr[i5] = false;
                i5++;
            }
        }
        return zArr;
    }
}
