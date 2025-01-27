package j6;

/* loaded from: classes2.dex */
public final class b extends r {

    /* renamed from: a */
    public static final char[] f27174a;

    /* renamed from: b */
    public static final char[] f27175b = {'T', 'N', '*', 'E'};

    /* renamed from: c */
    public static final char[] f27176c = {'/', m5.d.f28378d, '+', '.'};

    /* renamed from: d */
    public static final char f27177d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f27174a = cArr;
        f27177d = cArr[0];
    }

    @Override // j6.r
    public boolean[] d(String str) {
        int i10;
        if (str.length() < 2) {
            StringBuilder sb2 = new StringBuilder();
            char c10 = f27177d;
            sb2.append(c10);
            sb2.append(str);
            sb2.append(c10);
            str = sb2.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f27174a;
            boolean h10 = a.h(cArr, upperCase);
            boolean h11 = a.h(cArr, upperCase2);
            char[] cArr2 = f27175b;
            boolean h12 = a.h(cArr2, upperCase);
            boolean h13 = a.h(cArr2, upperCase2);
            if (h10) {
                if (!h11) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!h12) {
                if (h11 || h13) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                StringBuilder sb3 = new StringBuilder();
                char c11 = f27177d;
                sb3.append(c11);
                sb3.append(str);
                sb3.append(c11);
                str = sb3.toString();
            } else if (!h13) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i11 = 20;
        for (int i12 = 1; i12 < str.length() - 1; i12++) {
            if (Character.isDigit(str.charAt(i12)) || str.charAt(i12) == '-' || str.charAt(i12) == '$') {
                i11 += 9;
            } else {
                if (!a.h(f27176c, str.charAt(i12))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i12) + '\'');
                }
                i11 += 10;
            }
        }
        boolean[] zArr = new boolean[i11 + (str.length() - 1)];
        int i13 = 0;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i14));
            if (i14 == 0 || i14 == str.length() - 1) {
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
            int i15 = 0;
            while (true) {
                char[] cArr3 = a.f27166g;
                if (i15 >= cArr3.length) {
                    i10 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i15]) {
                    i10 = a.f27167h[i15];
                    break;
                }
                i15++;
            }
            int i16 = 0;
            boolean z10 = true;
            while (true) {
                int i17 = 0;
                while (i16 < 7) {
                    zArr[i13] = z10;
                    i13++;
                    if (((i10 >> (6 - i16)) & 1) == 0 || i17 == 1) {
                        z10 = !z10;
                        i16++;
                    } else {
                        i17++;
                    }
                }
                break;
            }
            if (i14 < str.length() - 1) {
                zArr[i13] = false;
                i13++;
            }
        }
        return zArr;
    }
}
