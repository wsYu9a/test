package p2;

import android.util.Base64;
import java.security.SecureRandom;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static volatile SecureRandom f29717a;

    /* renamed from: b */
    public static final char[] f29718b = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    public static SecureRandom b() {
        if (f29717a != null) {
            return f29717a;
        }
        synchronized (c.class) {
            try {
                if (f29717a == null) {
                    f29717a = new SecureRandom();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f29717a;
    }

    public static byte[] c(byte b10) {
        return new byte[]{b10};
    }

    public static byte[] d(char c10) {
        return new byte[]{(byte) (c10 & 255)};
    }

    public static byte[] e(char c10, char c11) {
        return new byte[]{(byte) (c10 & 255), (byte) (c11 & 255)};
    }

    public static byte[] f(int i10) {
        return new byte[]{(byte) i10, (byte) (i10 >> 8), (byte) (i10 >> 16), (byte) (i10 >> 24)};
    }

    public static byte[] g(long j10) {
        return new byte[]{(byte) j10, (byte) (j10 >> 8), (byte) (j10 >> 16), (byte) (j10 >> 24), (byte) (j10 >> 32), (byte) (j10 >> 40), (byte) (j10 >> 48), (byte) (j10 >> 56)};
    }

    public static byte[] h(short s10) {
        return new byte[]{(byte) s10, (byte) (s10 >> 8)};
    }

    public static byte[] i(byte[]... bArr) {
        int i10 = 0;
        for (byte[] bArr2 : bArr) {
            i10 += bArr2.length;
        }
        byte[] bArr3 = null;
        int i11 = 0;
        for (byte[] bArr4 : bArr) {
            if (bArr3 == null) {
                bArr3 = Arrays.copyOf(bArr4, i10);
                i11 = bArr4.length;
            } else {
                System.arraycopy(bArr4, 0, bArr3, i11, bArr4.length);
                i11 += bArr4.length;
            }
        }
        return bArr3;
    }

    public static String j(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            int i11 = i10 * 2;
            char[] cArr2 = f29718b;
            cArr[i11] = cArr2[(b10 & 255) >>> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public static byte[] k() {
        byte[] bArr = new byte[2];
        b().nextBytes(bArr);
        return bArr;
    }

    public static byte[] l() {
        byte[] bArr = new byte[4];
        b().nextBytes(bArr);
        return bArr;
    }
}
