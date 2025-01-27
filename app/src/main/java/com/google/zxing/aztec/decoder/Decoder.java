package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.zxing.FormatException;
import com.google.zxing.common.b;
import com.google.zxing.common.d;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.common.reedsolomon.c;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.ranger.e;
import com.opos.mobad.f.a.j;
import com.umeng.analytics.pro.am;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Decoder {

    /* renamed from: a */
    private static final String[] f8193a = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b */
    private static final String[] f8194b = {"CTRL_PS", " ", "a", "b", "c", "d", e.TAG, "f", OapsKey.KEY_GRADE, "h", "i", j.f20763a, "k", t.f9404d, "m", "n", "o", "p", "q", t.k, "s", "t", "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", am.aD, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c */
    private static final String[] f8195c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: d */
    private static final String[] f8196d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: e */
    private static final String[] f8197e = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", BaseWrapper.ENTER_ID_MESSAGE, ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: f */
    private com.google.zxing.o.a f8198f;

    private enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f8199a;

        static {
            int[] iArr = new int[Table.values().length];
            f8199a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8199a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8199a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8199a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8199a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = i(zArr, i2 << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) throws FormatException {
        com.google.zxing.common.reedsolomon.a aVar;
        int i2 = 8;
        if (this.f8198f.d() <= 2) {
            i2 = 6;
            aVar = com.google.zxing.common.reedsolomon.a.f8346c;
        } else if (this.f8198f.d() <= 8) {
            aVar = com.google.zxing.common.reedsolomon.a.f8350g;
        } else if (this.f8198f.d() <= 22) {
            i2 = 10;
            aVar = com.google.zxing.common.reedsolomon.a.f8345b;
        } else {
            i2 = 12;
            aVar = com.google.zxing.common.reedsolomon.a.f8344a;
        }
        int c2 = this.f8198f.c();
        int length = zArr.length / i2;
        if (length < c2) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i2;
        int[] iArr = new int[length];
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = j(zArr, length2, i2);
            i3++;
            length2 += i2;
        }
        try {
            new c(aVar).a(iArr, length - c2);
            int i4 = (1 << i2) - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < c2; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw FormatException.getFormatInstance();
                }
                if (i7 == 1 || i7 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(c2 * i2) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < c2; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i4 - 1) {
                    Arrays.fill(zArr2, i8, (i8 + i2) - 1, i10 > 1);
                    i8 += i2 - 1;
                } else {
                    int i11 = i2 - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e2) {
            throw FormatException.getFormatInstance(e2);
        }
    }

    private boolean[] d(b bVar) {
        boolean e2 = this.f8198f.e();
        int d2 = this.f8198f.d();
        int i2 = (e2 ? 11 : 14) + (d2 << 2);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[k(d2, e2)];
        int i3 = 2;
        if (e2) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                iArr[(i5 - i7) - 1] = (i6 - r12) - 1;
                iArr[i5 + i7] = (i7 / 15) + i7 + i6 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < d2) {
            int i10 = ((d2 - i8) << i3) + (e2 ? 9 : 12);
            int i11 = i8 << 1;
            int i12 = (i2 - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 << 1;
                int i15 = 0;
                while (i15 < i3) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = bVar.e(iArr[i16], iArr[i17]);
                    int i18 = iArr[i17];
                    int i19 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = bVar.e(i18, iArr[i19]);
                    int i20 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = bVar.e(iArr[i19], iArr[i20]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = bVar.e(iArr[i20], iArr[i16]);
                    i15++;
                    d2 = d2;
                    e2 = e2;
                    i3 = 2;
                }
                i13++;
                i3 = 2;
            }
            i9 += i10 << 3;
            i8++;
            i3 = 2;
        }
        return zArr;
    }

    private static String e(Table table, int i2) {
        int i3 = a.f8199a[table.ordinal()];
        if (i3 == 1) {
            return f8193a[i2];
        }
        if (i3 == 2) {
            return f8194b[i2];
        }
        if (i3 == 3) {
            return f8195c[i2];
        }
        if (i3 == 4) {
            return f8196d[i2];
        }
        if (i3 == 5) {
            return f8197e[i2];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i2 = 0;
        while (i2 < length) {
            if (table != Table.BINARY) {
                int i3 = table == Table.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int j2 = j(zArr, i2, i3);
                i2 += i3;
                String e2 = e(table, j2);
                if (e2.startsWith("CTRL_")) {
                    table2 = g(e2.charAt(5));
                    if (e2.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(e2);
                }
                table = table2;
            } else {
                if (length - i2 < 5) {
                    break;
                }
                int j3 = j(zArr, i2, 5);
                i2 += 5;
                if (j3 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    j3 = j(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= j3) {
                        break;
                    }
                    if (length - i2 < 8) {
                        i2 = length;
                        break;
                    }
                    sb.append((char) j(zArr, i2, 8));
                    i2 += 8;
                    i4++;
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    private static Table g(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    public static String h(boolean[] zArr) {
        return f(zArr);
    }

    private static byte i(boolean[] zArr, int i2) {
        int length = zArr.length - i2;
        return (byte) (length >= 8 ? j(zArr, i2, 8) : j(zArr, i2, length) << (8 - length));
    }

    private static int j(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    private static int k(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    public d c(com.google.zxing.o.a aVar) throws FormatException {
        this.f8198f = aVar;
        boolean[] b2 = b(d(aVar.a()));
        d dVar = new d(a(b2), f(b2), null, null);
        dVar.n(b2.length);
        return dVar;
    }
}
