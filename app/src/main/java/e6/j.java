package e6;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a */
    public static final char f25727a = 129;

    /* renamed from: b */
    public static final char f25728b = 230;

    /* renamed from: c */
    public static final char f25729c = 231;

    /* renamed from: d */
    public static final char f25730d = 235;

    /* renamed from: e */
    public static final char f25731e = 236;

    /* renamed from: f */
    public static final char f25732f = 237;

    /* renamed from: g */
    public static final char f25733g = 238;

    /* renamed from: h */
    public static final char f25734h = 239;

    /* renamed from: i */
    public static final char f25735i = 240;

    /* renamed from: j */
    public static final char f25736j = 254;

    /* renamed from: k */
    public static final char f25737k = 254;

    /* renamed from: l */
    public static final String f25738l = "[)>\u001e05\u001d";

    /* renamed from: m */
    public static final String f25739m = "[)>\u001e06\u001d";

    /* renamed from: n */
    public static final String f25740n = "\u001e\u0004";

    /* renamed from: o */
    public static final int f25741o = 0;

    /* renamed from: p */
    public static final int f25742p = 1;

    /* renamed from: q */
    public static final int f25743q = 2;

    /* renamed from: r */
    public static final int f25744r = 3;

    /* renamed from: s */
    public static final int f25745s = 4;

    /* renamed from: t */
    public static final int f25746t = 5;

    public static int a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        if (i10 < length) {
            char charAt = charSequence.charAt(i10);
            while (g(charAt) && i10 < length) {
                i11++;
                i10++;
                if (i10 < length) {
                    charAt = charSequence.charAt(i10);
                }
            }
        }
        return i11;
    }

    public static String b(String str) {
        return c(str, SymbolShapeHint.FORCE_NONE, null, null);
    }

    public static String c(String str, SymbolShapeHint symbolShapeHint, t5.c cVar, t5.c cVar2) {
        int i10 = 0;
        g[] gVarArr = {new a(), new c(), new l(), new m(), new f(), new b()};
        h hVar = new h(str);
        hVar.o(symbolShapeHint);
        hVar.m(cVar, cVar2);
        if (str.startsWith(f25738l) && str.endsWith(f25740n)) {
            hVar.s(f25731e);
            hVar.n(2);
            hVar.f25718f += 7;
        } else if (str.startsWith(f25739m) && str.endsWith(f25740n)) {
            hVar.s(f25732f);
            hVar.n(2);
            hVar.f25718f += 7;
        }
        while (hVar.j()) {
            gVarArr[i10].a(hVar);
            if (hVar.f() >= 0) {
                i10 = hVar.f();
                hVar.k();
            }
        }
        int a10 = hVar.a();
        hVar.q();
        int b10 = hVar.h().b();
        if (a10 < b10 && i10 != 0 && i10 != 5) {
            hVar.s((char) 254);
        }
        StringBuilder b11 = hVar.b();
        if (b11.length() < b10) {
            b11.append(f25727a);
        }
        while (b11.length() < b10) {
            b11.append(p(f25727a, b11.length() + 1));
        }
        return hVar.b().toString();
    }

    public static int d(float[] fArr, int[] iArr, int i10, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i11 = 0; i11 < 6; i11++) {
            int ceil = (int) Math.ceil(fArr[i11]);
            iArr[i11] = ceil;
            if (i10 > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i10 = ceil;
            }
            if (i10 == ceil) {
                bArr[i11] = (byte) (bArr[i11] + 1);
            }
        }
        return i10;
    }

    public static int e(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 += bArr[i11];
        }
        return i10;
    }

    public static void f(char c10) {
        String hexString = Integer.toHexString(c10);
        throw new IllegalArgumentException("Illegal character: " + c10 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean g(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    public static boolean h(char c10) {
        return c10 >= 128 && c10 <= 255;
    }

    public static boolean i(char c10) {
        if (c10 == ' ') {
            return true;
        }
        if (c10 < '0' || c10 > '9') {
            return c10 >= 'A' && c10 <= 'Z';
        }
        return true;
    }

    public static boolean j(char c10) {
        return c10 >= ' ' && c10 <= '^';
    }

    public static boolean k(char c10) {
        if (c10 == ' ') {
            return true;
        }
        if (c10 < '0' || c10 > '9') {
            return c10 >= 'a' && c10 <= 'z';
        }
        return true;
    }

    public static boolean l(char c10) {
        if (n(c10) || c10 == ' ') {
            return true;
        }
        if (c10 < '0' || c10 > '9') {
            return c10 >= 'A' && c10 <= 'Z';
        }
        return true;
    }

    public static boolean m(char c10) {
        return false;
    }

    public static boolean n(char c10) {
        return c10 == '\r' || c10 == '*' || c10 == '>';
    }

    public static int o(CharSequence charSequence, int i10, int i11) {
        float[] fArr;
        if (i10 >= charSequence.length()) {
            return i11;
        }
        float f10 = 2.0f;
        int i12 = 6;
        int i13 = 4;
        int i14 = 3;
        if (i11 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[6];
            fArr[0] = 1.0f;
            fArr[1] = 2.0f;
            fArr[2] = 2.0f;
            fArr[3] = 2.0f;
            fArr[4] = 2.0f;
            fArr[5] = 2.25f;
            fArr[i11] = 0.0f;
        }
        int i15 = 0;
        while (true) {
            int i16 = i10 + i15;
            if (i16 == charSequence.length()) {
                byte[] bArr = new byte[i12];
                int[] iArr = new int[i12];
                int d10 = d(fArr, iArr, Integer.MAX_VALUE, bArr);
                int e10 = e(bArr);
                if (iArr[0] == d10) {
                    return 0;
                }
                if (e10 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (e10 == 1 && bArr[i13] > 0) {
                    return i13;
                }
                if (e10 == 1 && bArr[2] > 0) {
                    return 2;
                }
                if (e10 != 1 || bArr[i14] <= 0) {
                    return 1;
                }
                return i14;
            }
            char charAt = charSequence.charAt(i16);
            i15++;
            if (g(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (h(charAt)) {
                float ceil = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil;
                fArr[0] = ceil + f10;
            } else {
                float ceil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = ceil2;
                fArr[0] = ceil2 + 1.0f;
            }
            if (i(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (k(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (l(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (j(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (h(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (m(charAt)) {
                fArr[5] = fArr[5] + 4.0f;
            } else {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i15 >= 4) {
                int[] iArr2 = new int[i12];
                byte[] bArr2 = new byte[i12];
                d(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int e11 = e(bArr2);
                int i17 = iArr2[0];
                int i18 = iArr2[5];
                if (i17 < i18 && i17 < iArr2[1] && i17 < iArr2[2] && i17 < iArr2[3] && i17 < iArr2[4]) {
                    return 0;
                }
                if (i18 < i17) {
                    break;
                }
                byte b10 = bArr2[1];
                byte b11 = bArr2[2];
                byte b12 = bArr2[3];
                byte b13 = bArr2[4];
                if (b10 + b11 + b12 + b13 == 0) {
                    break;
                }
                if (e11 == 1 && b13 > 0) {
                    return 4;
                }
                if (e11 == 1 && b11 > 0) {
                    return 2;
                }
                if (e11 == 1 && b12 > 0) {
                    return 3;
                }
                int i19 = iArr2[1];
                if (i19 + 1 < i17 && i19 + 1 < i18) {
                    if (i19 + 1 < iArr2[4] && i19 + 1 < iArr2[2]) {
                        int i20 = iArr2[3];
                        if (i19 < i20) {
                            return 1;
                        }
                        if (i19 == i20) {
                            for (int i21 = i10 + i15 + 1; i21 < charSequence.length(); i21++) {
                                char charAt2 = charSequence.charAt(i21);
                                if (n(charAt2)) {
                                    return 3;
                                }
                                if (!l(charAt2)) {
                                    break;
                                }
                            }
                            return 1;
                        }
                    }
                    f10 = 2.0f;
                    i12 = 6;
                    i13 = 4;
                    i14 = 3;
                }
            }
            f10 = 2.0f;
            i12 = 6;
            i13 = 4;
            i14 = 3;
        }
        return 5;
    }

    public static char p(char c10, int i10) {
        int i11 = c10 + ((i10 * TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE) % 253) + 1;
        if (i11 > 254) {
            i11 -= 254;
        }
        return (char) i11;
    }
}
