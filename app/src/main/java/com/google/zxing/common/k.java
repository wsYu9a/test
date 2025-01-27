package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a */
    private static final String f8326a;

    /* renamed from: b */
    public static final String f8327b = "SJIS";

    /* renamed from: c */
    public static final String f8328c = "GB2312";

    /* renamed from: d */
    private static final String f8329d = "EUC_JP";

    /* renamed from: e */
    private static final String f8330e = "UTF8";

    /* renamed from: f */
    private static final String f8331f = "ISO8859_1";

    /* renamed from: g */
    private static final boolean f8332g;

    static {
        String name = Charset.defaultCharset().name();
        f8326a = name;
        f8332g = f8327b.equalsIgnoreCase(name) || f8329d.equalsIgnoreCase(name);
    }

    private k() {
    }

    public static String a(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return map.get(decodeHintType).toString();
            }
        }
        int length = bArr2.length;
        boolean z = true;
        int i2 = 0;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i3 = 0;
        boolean z3 = true;
        boolean z4 = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i4 < length && (z || z3 || z4)) {
            int i14 = bArr2[i4] & 255;
            if (z4) {
                if (i5 > 0) {
                    if ((i14 & 128) != 0) {
                        i5--;
                    }
                    z4 = false;
                } else if ((i14 & 128) != 0) {
                    if ((i14 & 64) != 0) {
                        i5++;
                        if ((i14 & 32) == 0) {
                            i7++;
                        } else {
                            i5++;
                            if ((i14 & 16) == 0) {
                                i8++;
                            } else {
                                i5++;
                                if ((i14 & 8) == 0) {
                                    i9++;
                                }
                            }
                        }
                    }
                    z4 = false;
                }
            }
            if (z) {
                if (i14 > 127 && i14 < 160) {
                    z = false;
                } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                    i11++;
                }
            }
            if (z3) {
                if (i6 > 0) {
                    if (i14 >= 64 && i14 != 127 && i14 <= 252) {
                        i6--;
                    }
                    z3 = false;
                } else {
                    if (i14 != 128 && i14 != 160 && i14 <= 239) {
                        if (i14 <= 160 || i14 >= 224) {
                            if (i14 > 127) {
                                i6++;
                                int i15 = i12 + 1;
                                if (i15 > i2) {
                                    i2 = i15;
                                    i12 = i2;
                                } else {
                                    i12 = i15;
                                }
                            } else {
                                i12 = 0;
                            }
                            i13 = 0;
                        } else {
                            i3++;
                            int i16 = i13 + 1;
                            if (i16 > i10) {
                                i10 = i16;
                                i13 = i10;
                            } else {
                                i13 = i16;
                            }
                            i12 = 0;
                        }
                    }
                    z3 = false;
                }
            }
            i4++;
            bArr2 = bArr;
        }
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z3 && i6 > 0) {
            z3 = false;
        }
        return (!z4 || (!z2 && (i7 + i8) + i9 <= 0)) ? (!z3 || (!f8332g && i10 < 3 && i2 < 3)) ? (z && z3) ? (!(i10 == 2 && i3 == 2) && i11 * 10 < length) ? f8331f : f8327b : z ? f8331f : z3 ? f8327b : z4 ? f8330e : f8326a : f8327b : f8330e;
    }
}
