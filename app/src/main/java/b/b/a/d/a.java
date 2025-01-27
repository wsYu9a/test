package b.b.a.d;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4252a = 128;

    /* renamed from: b, reason: collision with root package name */
    private static final int f4253b = 64;

    /* renamed from: c, reason: collision with root package name */
    private static final int f4254c = 24;

    /* renamed from: d, reason: collision with root package name */
    private static final int f4255d = 8;

    /* renamed from: e, reason: collision with root package name */
    private static final int f4256e = 16;

    /* renamed from: f, reason: collision with root package name */
    private static final int f4257f = 4;

    /* renamed from: g, reason: collision with root package name */
    private static final int f4258g = -128;

    /* renamed from: h, reason: collision with root package name */
    private static final char f4259h = '=';

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f4260i = new byte[128];

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f4261j = new char[64];

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 128; i5++) {
            f4260i[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            f4260i[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            f4260i[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            f4260i[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = f4260i;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i9 = 0; i9 <= 25; i9++) {
            f4261j[i9] = (char) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            f4261j[i2] = (char) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            f4261j[i3] = (char) (i4 + 48);
            i3++;
            i4++;
        }
        char[] cArr = f4261j;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char c2 = cArr[i3];
            if (!(c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t')) {
                cArr[i2] = cArr[i3];
                i2++;
            }
        }
        return i2;
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[(i2 != 0 ? i3 + 1 : i3) * 4];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int i7 = i5 + 1;
            byte b2 = bArr[i5];
            int i8 = i7 + 1;
            byte b3 = bArr[i7];
            int i9 = i8 + 1;
            byte b4 = bArr[i8];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i10 = b2 & ByteCompanionObject.MIN_VALUE;
            int i11 = b2 >> 2;
            if (i10 != 0) {
                i11 ^= Downloads.Impl.STATUS_RUNNING;
            }
            byte b7 = (byte) i11;
            int i12 = b3 & ByteCompanionObject.MIN_VALUE;
            int i13 = b3 >> 4;
            if (i12 != 0) {
                i13 ^= g.n;
            }
            byte b8 = (byte) i13;
            int i14 = (b4 & ByteCompanionObject.MIN_VALUE) == 0 ? b4 >> 6 : (b4 >> 6) ^ TinkerReport.KEY_LOADED_EXCEPTION_DEX;
            int i15 = i6 + 1;
            char[] cArr2 = f4261j;
            cArr[i6] = cArr2[b7];
            int i16 = i15 + 1;
            cArr[i15] = cArr2[(b6 << 4) | b8];
            int i17 = i16 + 1;
            cArr[i16] = cArr2[(b5 << 2) | ((byte) i14)];
            cArr[i17] = cArr2[b4 & Utf8.REPLACEMENT_BYTE];
            i4++;
            i6 = i17 + 1;
            i5 = i9;
        }
        if (i2 == 8) {
            byte b9 = bArr[i5];
            byte b10 = (byte) (b9 & 3);
            int i18 = b9 & ByteCompanionObject.MIN_VALUE;
            int i19 = b9 >> 2;
            if (i18 != 0) {
                i19 ^= Downloads.Impl.STATUS_RUNNING;
            }
            int i20 = i6 + 1;
            char[] cArr3 = f4261j;
            cArr[i6] = cArr3[(byte) i19];
            int i21 = i20 + 1;
            cArr[i20] = cArr3[b10 << 4];
            cArr[i21] = f4259h;
            cArr[i21 + 1] = f4259h;
        } else if (i2 == 16) {
            byte b11 = bArr[i5];
            byte b12 = bArr[i5 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            int i22 = b11 & ByteCompanionObject.MIN_VALUE;
            int i23 = b11 >> 2;
            if (i22 != 0) {
                i23 ^= Downloads.Impl.STATUS_RUNNING;
            }
            byte b15 = (byte) i23;
            int i24 = b12 & ByteCompanionObject.MIN_VALUE;
            int i25 = b12 >> 4;
            if (i24 != 0) {
                i25 ^= g.n;
            }
            int i26 = i6 + 1;
            char[] cArr4 = f4261j;
            cArr[i6] = cArr4[b15];
            int i27 = i26 + 1;
            cArr[i26] = cArr4[((byte) i25) | (b14 << 4)];
            cArr[i27] = cArr4[b13 << 2];
            cArr[i27 + 1] = f4259h;
        }
        return new String(cArr);
    }

    private static boolean c(char c2) {
        return c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t';
    }

    public static byte[] d(String str) {
        int i2;
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        if (charArray == null) {
            i2 = 0;
        } else {
            int length = charArray.length;
            i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char c2 = charArray[i3];
                if (!(c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t')) {
                    charArray[i2] = charArray[i3];
                    i2++;
                }
            }
        }
        if (i2 % 4 != 0) {
            return null;
        }
        int i4 = i2 / 4;
        if (i4 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i4 * 3];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4 - 1) {
            int i8 = i6 + 1;
            char c3 = charArray[i6];
            if (f(c3)) {
                int i9 = i8 + 1;
                char c4 = charArray[i8];
                if (f(c4)) {
                    int i10 = i9 + 1;
                    char c5 = charArray[i9];
                    if (f(c5)) {
                        int i11 = i10 + 1;
                        char c6 = charArray[i10];
                        if (f(c6)) {
                            byte[] bArr2 = f4260i;
                            byte b2 = bArr2[c3];
                            byte b3 = bArr2[c4];
                            byte b4 = bArr2[c5];
                            byte b5 = bArr2[c6];
                            int i12 = i7 + 1;
                            bArr[i7] = (byte) ((b2 << 2) | (b3 >> 4));
                            int i13 = i12 + 1;
                            bArr[i12] = (byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15));
                            i7 = i13 + 1;
                            bArr[i13] = (byte) ((b4 << 6) | b5);
                            i5++;
                            i6 = i11;
                        }
                    }
                }
            }
            return null;
        }
        int i14 = i6 + 1;
        char c7 = charArray[i6];
        if (!f(c7)) {
            return null;
        }
        int i15 = i14 + 1;
        char c8 = charArray[i14];
        if (!f(c8)) {
            return null;
        }
        byte[] bArr3 = f4260i;
        byte b6 = bArr3[c7];
        byte b7 = bArr3[c8];
        int i16 = i15 + 1;
        char c9 = charArray[i15];
        char c10 = charArray[i16];
        if (f(c9) && f(c10)) {
            byte b8 = bArr3[c9];
            byte b9 = bArr3[c10];
            int i17 = i7 + 1;
            bArr[i7] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr[i17] = (byte) (((b7 & 15) << 4) | ((b8 >> 2) & 15));
            bArr[i17 + 1] = (byte) (b9 | (b8 << 6));
            return bArr;
        }
        if (e(c9) && e(c10)) {
            if ((b7 & 15) != 0) {
                return null;
            }
            int i18 = i5 * 3;
            byte[] bArr4 = new byte[i18 + 1];
            System.arraycopy(bArr, 0, bArr4, 0, i18);
            bArr4[i7] = (byte) ((b6 << 2) | (b7 >> 4));
            return bArr4;
        }
        if (e(c9) || !e(c10)) {
            return null;
        }
        byte b10 = bArr3[c9];
        if ((b10 & 3) != 0) {
            return null;
        }
        int i19 = i5 * 3;
        byte[] bArr5 = new byte[i19 + 2];
        System.arraycopy(bArr, 0, bArr5, 0, i19);
        bArr5[i7] = (byte) ((b6 << 2) | (b7 >> 4));
        bArr5[i7 + 1] = (byte) (((b10 >> 2) & 15) | ((b7 & 15) << 4));
        return bArr5;
    }

    private static boolean e(char c2) {
        return c2 == '=';
    }

    private static boolean f(char c2) {
        return c2 < 128 && f4260i[c2] != -1;
    }
}
