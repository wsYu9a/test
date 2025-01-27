package com.cdo.oaps.ad;

import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    static final int f6534a = 255;

    /* renamed from: c */
    static final int f6536c = 76;

    /* renamed from: d */
    static final int f6537d = 8;

    /* renamed from: e */
    static final int f6538e = 4;

    /* renamed from: f */
    static final int f6539f = 64;

    /* renamed from: g */
    static final byte f6540g = 61;

    /* renamed from: h */
    static final int f6541h = -128;

    /* renamed from: i */
    static final int f6542i = 16;

    /* renamed from: j */
    static final int f6543j = 24;
    private static byte[] k = new byte[255];

    /* renamed from: b */
    static final byte[] f6535b = "\r\n".getBytes();
    private static byte[] l = new byte[64];

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 255; i5++) {
            k[i5] = (byte) (-1);
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            k[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            k[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            k[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = k;
        bArr[43] = (byte) 62;
        bArr[47] = (byte) 63;
        for (int i9 = 0; i9 <= 25; i9++) {
            l[i9] = (byte) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            l[i2] = (byte) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            l[i3] = (byte) (i4 + 48);
            i3++;
            i4++;
        }
        byte[] bArr2 = l;
        bArr2[62] = (byte) 43;
        bArr2[63] = (byte) 47;
    }

    private static boolean a(byte b2) {
        return b2 == 61 || k[b2] != -1;
    }

    public static byte[] a(byte[] bArr) {
        byte[] b2 = b(bArr);
        int i2 = 0;
        if (b2.length != 0) {
            int length = b2.length / 4;
            int length2 = b2.length;
            while (true) {
                int i3 = length2 - 1;
                if (b2[i3] != 61) {
                    byte[] bArr2 = new byte[length2 - length];
                    int i4 = 0;
                    while (i2 < length) {
                        int i5 = i2 * 4;
                        byte b3 = b2[i5 + 2];
                        byte b4 = b2[i5 + 3];
                        byte[] bArr3 = k;
                        byte b5 = bArr3[b2[i5]];
                        byte b6 = bArr3[b2[i5 + 1]];
                        if (b3 != 61 && b4 != 61) {
                            byte b7 = bArr3[b3];
                            byte b8 = bArr3[b4];
                            bArr2[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                            bArr2[i4 + 1] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                            bArr2[i4 + 2] = (byte) ((b7 << 6) | b8);
                        } else if (b3 == 61) {
                            bArr2[i4] = (byte) ((b6 >> 4) | (b5 << 2));
                        } else if (b4 == 61) {
                            byte b9 = bArr3[b3];
                            bArr2[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                            bArr2[i4 + 1] = (byte) (((b6 & 15) << 4) | ((b9 >> 2) & 15));
                        }
                        i2++;
                        i4 += 3;
                    }
                    return bArr2;
                }
                if (i3 == 0) {
                    break;
                }
                length2 = i3;
            }
        }
        return new byte[0];
    }

    public static byte[] a(byte[] bArr, boolean z) {
        int i2;
        int length = bArr.length * 8;
        int i3 = length % 24;
        int i4 = length / 24;
        int i5 = i3 != 0 ? (i4 + 1) * 4 : i4 * 4;
        if (z) {
            byte[] bArr2 = f6535b;
            i2 = bArr2.length == 0 ? 0 : (int) Math.ceil(i5 / 76.0f);
            i5 += bArr2.length * i2;
        } else {
            i2 = 0;
        }
        byte[] bArr3 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 76;
        while (i6 < i4) {
            int i10 = i6 * 3;
            byte b2 = bArr[i10];
            byte b3 = bArr[i10 + 1];
            byte b4 = bArr[i10 + 2];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i11 = b2 & ByteCompanionObject.MIN_VALUE;
            int i12 = b2 >> 2;
            if (i11 != 0) {
                i12 ^= Downloads.Impl.STATUS_RUNNING;
            }
            byte b7 = (byte) i12;
            int i13 = b3 & ByteCompanionObject.MIN_VALUE;
            int i14 = b3 >> 4;
            if (i13 != 0) {
                i14 ^= org.mozilla.universalchardet.prober.g.n;
            }
            byte b8 = (byte) i14;
            int i15 = b4 >> 6;
            if ((b4 & ByteCompanionObject.MIN_VALUE) != 0) {
                i15 ^= TinkerReport.KEY_LOADED_EXCEPTION_DEX;
            }
            byte[] bArr4 = l;
            bArr3[i7] = bArr4[b7];
            bArr3[i7 + 1] = bArr4[(b6 << 4) | b8];
            bArr3[i7 + 2] = bArr4[(b5 << 2) | ((byte) i15)];
            bArr3[i7 + 3] = bArr4[b4 & Utf8.REPLACEMENT_BYTE];
            i7 += 4;
            if (z && i7 == i9) {
                byte[] bArr5 = f6535b;
                System.arraycopy(bArr5, 0, bArr3, i7, bArr5.length);
                i8++;
                int length2 = bArr5.length;
                i7 += bArr5.length;
                i9 = ((i8 + 1) * 76) + (length2 * i8);
            }
            i6++;
        }
        int i16 = i6 * 3;
        if (i3 == 8) {
            byte b9 = bArr[i16];
            byte b10 = (byte) (b9 & 3);
            int i17 = b9 & ByteCompanionObject.MIN_VALUE;
            int i18 = b9 >> 2;
            if (i17 != 0) {
                i18 ^= Downloads.Impl.STATUS_RUNNING;
            }
            byte[] bArr6 = l;
            bArr3[i7] = bArr6[(byte) i18];
            bArr3[i7 + 1] = bArr6[b10 << 4];
            byte b11 = (byte) 61;
            bArr3[i7 + 2] = b11;
            bArr3[i7 + 3] = b11;
        } else if (i3 == 16) {
            byte b12 = bArr[i16];
            byte b13 = bArr[i16 + 1];
            byte b14 = (byte) (b13 & 15);
            byte b15 = (byte) (b12 & 3);
            int i19 = b12 & ByteCompanionObject.MIN_VALUE;
            int i20 = b12 >> 2;
            if (i19 != 0) {
                i20 ^= Downloads.Impl.STATUS_RUNNING;
            }
            byte b16 = (byte) i20;
            int i21 = b13 & ByteCompanionObject.MIN_VALUE;
            int i22 = b13 >> 4;
            if (i21 != 0) {
                i22 ^= org.mozilla.universalchardet.prober.g.n;
            }
            byte[] bArr7 = l;
            bArr3[i7] = bArr7[b16];
            bArr3[i7 + 1] = bArr7[((byte) i22) | (b15 << 4)];
            bArr3[i7 + 2] = bArr7[b14 << 2];
            bArr3[i7 + 3] = (byte) 61;
        }
        if (z && i8 < i2) {
            byte[] bArr8 = f6535b;
            System.arraycopy(bArr8, 0, bArr3, i5 - bArr8.length, bArr8.length);
        }
        return bArr3;
    }

    static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (a(bArr[i3])) {
                bArr2[i2] = bArr[i3];
                i2++;
            }
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b2 = bArr[i3];
            if (b2 != 9 && b2 != 10 && b2 != 13 && b2 != 32) {
                bArr2[i2] = bArr[i3];
                i2++;
            }
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    public static byte[] d(byte[] bArr) {
        return a(bArr, false);
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, true);
    }

    public static boolean f(byte[] bArr) {
        byte[] c2 = c(bArr);
        if (c2.length != 0) {
            for (byte b2 : c2) {
                if (!a(b2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Object a(Object obj) {
        if (obj instanceof byte[]) {
            return g((byte[]) obj);
        }
        throw new d("Parameter supplied to Base64 decode is not a byte[]");
    }

    public Object b(Object obj) {
        if (obj instanceof byte[]) {
            return h((byte[]) obj);
        }
        throw new e("Parameter supplied to Base64 encode is not a byte[]");
    }

    public byte[] g(byte[] bArr) {
        return a(bArr);
    }

    public byte[] h(byte[] bArr) {
        return a(bArr, false);
    }
}
