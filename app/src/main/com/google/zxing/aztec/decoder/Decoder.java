package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import b6.c;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.umeng.analytics.pro.bt;
import java.util.Arrays;
import m5.h;
import p1.b;
import p3.f;
import z5.d;

/* loaded from: classes2.dex */
public final class Decoder {

    /* renamed from: b */
    public static final String[] f10548b = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c */
    public static final String[] f10549c = {"CTRL_PS", " ", "a", "b", "c", "d", e.TAG, "f", "g", "h", "i", "j", "k", t.f11204d, "m", "n", "o", "p", "q", t.f11211k, "s", bt.aO, "u", "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", bt.aJ, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d */
    public static final String[] f10550d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", hf.e.f26694a, "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e */
    public static final String[] f10551e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", h.f28447r, "+", ",", "-", b.f29697h, "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", f.f29748d, "CTRL_UL"};

    /* renamed from: f */
    public static final String[] f10552f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", b.f29697h, "CTRL_UL", "CTRL_US"};

    /* renamed from: a */
    public u5.a f10553a;

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f10554a;

        static {
            int[] iArr = new int[Table.values().length];
            f10554a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10554a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10554a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10554a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10554a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = i(zArr, i10 << 3);
        }
        return bArr;
    }

    public static String e(Table table, int i10) {
        int i11 = a.f10554a[table.ordinal()];
        if (i11 == 1) {
            return f10548b[i10];
        }
        if (i11 == 2) {
            return f10549c[i10];
        }
        if (i11 == 3) {
            return f10550d[i10];
        }
        if (i11 == 4) {
            return f10551e[i10];
        }
        if (i11 == 5) {
            return f10552f[i10];
        }
        throw new IllegalStateException("Bad table");
    }

    public static String f(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb2 = new StringBuilder(20);
        Table table2 = table;
        int i10 = 0;
        while (i10 < length) {
            if (table != Table.BINARY) {
                int i11 = table == Table.DIGIT ? 4 : 5;
                if (length - i10 < i11) {
                    break;
                }
                int j10 = j(zArr, i10, i11);
                i10 += i11;
                String e10 = e(table, j10);
                if (e10.startsWith("CTRL_")) {
                    table2 = g(e10.charAt(5));
                    if (e10.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb2.append(e10);
                }
                table = table2;
            } else {
                if (length - i10 < 5) {
                    break;
                }
                int j11 = j(zArr, i10, 5);
                int i12 = i10 + 5;
                if (j11 == 0) {
                    if (length - i12 < 11) {
                        break;
                    }
                    j11 = j(zArr, i12, 11) + 31;
                    i12 = i10 + 16;
                }
                int i13 = 0;
                while (true) {
                    if (i13 >= j11) {
                        i10 = i12;
                        break;
                    }
                    if (length - i12 < 8) {
                        i10 = length;
                        break;
                    }
                    sb2.append((char) j(zArr, i12, 8));
                    i12 += 8;
                    i13++;
                }
                table = table2;
            }
        }
        return sb2.toString();
    }

    public static Table g(char c10) {
        return c10 != 'B' ? c10 != 'D' ? c10 != 'P' ? c10 != 'L' ? c10 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    public static String h(boolean[] zArr) {
        return f(zArr);
    }

    public static byte i(boolean[] zArr, int i10) {
        int length = zArr.length - i10;
        return (byte) (length >= 8 ? j(zArr, i10, 8) : j(zArr, i10, length) << (8 - length));
    }

    public static int j(boolean[] zArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i10 + i11; i13++) {
            i12 <<= 1;
            if (zArr[i13]) {
                i12 |= 1;
            }
        }
        return i12;
    }

    public static int k(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 << 4)) * i10;
    }

    public final boolean[] b(boolean[] zArr) throws FormatException {
        int i10;
        b6.a aVar;
        if (this.f10553a.d() <= 2) {
            aVar = b6.a.f1286j;
            i10 = 6;
        } else {
            i10 = 8;
            if (this.f10553a.d() <= 8) {
                aVar = b6.a.f1290n;
            } else if (this.f10553a.d() <= 22) {
                aVar = b6.a.f1285i;
                i10 = 10;
            } else {
                aVar = b6.a.f1284h;
                i10 = 12;
            }
        }
        int c10 = this.f10553a.c();
        int length = zArr.length / i10;
        if (length < c10) {
            throw FormatException.getFormatInstance();
        }
        int length2 = zArr.length % i10;
        int[] iArr = new int[length];
        int i11 = 0;
        while (i11 < length) {
            iArr[i11] = j(zArr, length2, i10);
            i11++;
            length2 += i10;
        }
        try {
            new c(aVar).a(iArr, length - c10);
            int i12 = 1 << i10;
            int i13 = i12 - 1;
            int i14 = 0;
            for (int i15 = 0; i15 < c10; i15++) {
                int i16 = iArr[i15];
                if (i16 == 0 || i16 == i13) {
                    throw FormatException.getFormatInstance();
                }
                if (i16 == 1 || i16 == i12 - 2) {
                    i14++;
                }
            }
            boolean[] zArr2 = new boolean[(c10 * i10) - i14];
            int i17 = 0;
            for (int i18 = 0; i18 < c10; i18++) {
                int i19 = iArr[i18];
                if (i19 == 1 || i19 == i12 - 2) {
                    Arrays.fill(zArr2, i17, (i17 + i10) - 1, i19 > 1);
                    i17 += i10 - 1;
                } else {
                    int i20 = i10 - 1;
                    while (i20 >= 0) {
                        int i21 = i17 + 1;
                        zArr2[i17] = ((1 << i20) & i19) != 0;
                        i20--;
                        i17 = i21;
                    }
                }
            }
            return zArr2;
        } catch (ReedSolomonException e10) {
            throw FormatException.getFormatInstance(e10);
        }
    }

    public d c(u5.a aVar) throws FormatException {
        this.f10553a = aVar;
        boolean[] b10 = b(d(aVar.a()));
        d dVar = new d(a(b10), f(b10), null, null);
        dVar.n(b10.length);
        return dVar;
    }

    public final boolean[] d(z5.b bVar) {
        boolean e10 = this.f10553a.e();
        int d10 = this.f10553a.d();
        int i10 = (e10 ? 11 : 14) + (d10 << 2);
        int[] iArr = new int[i10];
        boolean[] zArr = new boolean[k(d10, e10)];
        int i11 = 2;
        if (e10) {
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[i12] = i12;
            }
        } else {
            int i13 = i10 / 2;
            int i14 = ((i10 + 1) + (((i13 - 1) / 15) * 2)) / 2;
            for (int i15 = 0; i15 < i13; i15++) {
                iArr[(i13 - i15) - 1] = (i14 - r12) - 1;
                iArr[i13 + i15] = (i15 / 15) + i15 + i14 + 1;
            }
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < d10) {
            int i18 = ((d10 - i16) << i11) + (e10 ? 9 : 12);
            int i19 = i16 << 1;
            int i20 = (i10 - 1) - i19;
            int i21 = 0;
            while (i21 < i18) {
                int i22 = i21 << 1;
                int i23 = 0;
                while (i23 < i11) {
                    int i24 = i19 + i23;
                    int i25 = i19 + i21;
                    zArr[i17 + i22 + i23] = bVar.e(iArr[i24], iArr[i25]);
                    int i26 = iArr[i25];
                    int i27 = i20 - i23;
                    zArr[(i18 * 2) + i17 + i22 + i23] = bVar.e(i26, iArr[i27]);
                    int i28 = i20 - i21;
                    zArr[(i18 * 4) + i17 + i22 + i23] = bVar.e(iArr[i27], iArr[i28]);
                    zArr[(i18 * 6) + i17 + i22 + i23] = bVar.e(iArr[i28], iArr[i24]);
                    i23++;
                    d10 = d10;
                    e10 = e10;
                    i11 = 2;
                }
                i21++;
                i11 = 2;
            }
            i17 += i18 << 3;
            i16++;
            i11 = 2;
        }
        return zArr;
    }
}
