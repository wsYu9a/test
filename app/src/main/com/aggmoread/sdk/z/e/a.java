package com.aggmoread.sdk.z.e;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.aggmoread.sdk.z.b.d;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;

@RequiresApi(api = 21)
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private final C0190a f6145a;

    /* renamed from: com.aggmoread.sdk.z.e.a$a */
    public static class C0190a {

        /* renamed from: a */
        private final SecretKey f6146a;

        /* renamed from: b */
        private final SecretKey f6147b;

        public C0190a(SecretKey secretKey, SecretKey secretKey2) {
            this.f6146a = secretKey;
            this.f6147b = secretKey2;
            Mac b10 = a.b();
            b10.init(secretKey);
            b10.reset();
            b10.init(secretKey2);
            b10.reset();
        }

        public SecretKey a() {
            return this.f6146a;
        }

        public SecretKey b() {
            return this.f6147b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0190a)) {
                return false;
            }
            C0190a c0190a = (C0190a) obj;
            return this.f6146a.equals(c0190a.f6146a) && this.f6147b.equals(c0190a.f6147b);
        }

        public int hashCode() {
            return this.f6146a.hashCode() ^ this.f6147b.hashCode();
        }
    }

    public static class b extends a {
        public b(C0190a c0190a) {
            super(c0190a);
        }

        public String a(long j10, byte[] bArr) {
            return a(b(j10, bArr));
        }

        public byte[] b(long j10, byte[] bArr) {
            byte[] a10 = a(8, bArr);
            ByteBuffer.wrap(a10).putLong(16, j10);
            return b(a10);
        }
    }

    public a(C0190a c0190a) {
        this.f6145a = c0190a;
    }

    private static long a(long j10) {
        return ((j10 % 1000) * 1000) | ((j10 / 1000) << 32);
    }

    public static Mac b() {
        try {
            return Mac.getInstance("HmacSHA1");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static int c(byte[] bArr) {
        a(bArr.length >= 4, "array too small: %s < %s", Integer.valueOf(bArr.length), 4);
        return (bArr[3] & 255) | ((bArr[2] & 255) << 8) | (bArr[0] << b5.a.B) | ((bArr[1] & 255) << 16);
    }

    private int d(byte[] bArr) {
        try {
            Mac b10 = b();
            b10.init(this.f6145a.b());
            b10.update(bArr, 16, bArr.length - 20);
            b10.update(bArr, 0, 16);
            return c(b10.doFinal());
        } catch (InvalidKeyException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private void e(byte[] bArr) {
        int i10 = 16;
        int length = bArr.length;
        int i11 = length - 20;
        int i12 = (length - 1) / 20;
        a(i12 <= 769, "Payload is %s bytes, exceeds limit of %s", Integer.valueOf(i11), 15380);
        Mac b10 = b();
        byte[] bArr2 = new byte[23];
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int i15 = i13 * 20;
            int min = Math.min(i11 - i15, 20);
            try {
                b10.reset();
            } catch (InvalidKeyException | ShortBufferException e10) {
                e = e10;
            }
            try {
                b10.init(this.f6145a.a());
                b10.update(bArr, 0, i10);
                if (i14 != 0) {
                    b10.update(bArr2, 20, i14);
                }
                b10.doFinal(bArr2, 0);
                for (int i16 = 0; i16 < min; i16++) {
                    int i17 = i15 + 16 + i16;
                    bArr[i17] = (byte) (bArr[i17] ^ bArr2[i16]);
                }
                Arrays.fill(bArr2, 0, 20, (byte) 0);
                if (i14 != 0) {
                    int i18 = i14 + 19;
                    byte b11 = (byte) (bArr2[i18] + 1);
                    bArr2[i18] = b11;
                    if (b11 != 0) {
                        i13++;
                        i10 = 16;
                    }
                }
                i14++;
                i13++;
                i10 = 16;
            } catch (InvalidKeyException e11) {
                e = e11;
                throw new IllegalStateException(e);
            } catch (ShortBufferException e12) {
                e = e12;
                throw new IllegalStateException(e);
            }
        }
    }

    private static String a(String str, byte[] bArr, byte[] bArr2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr2, 0, 16);
        Date date = new Date(wrap.getLong(0));
        return str + ": initVector={timestamp " + DateFormat.getDateTimeInstance().format(date) + ", serverId " + wrap.getLong(8);
    }

    public byte[] b(byte[] bArr) {
        a(bArr.length >= 20, "Invalid plainData, %s bytes", Integer.valueOf(bArr.length));
        byte[] bArr2 = (byte[]) bArr.clone();
        try {
            ByteBuffer.wrap(bArr2).putInt(bArr2.length - 4, d(bArr2));
            e(bArr2);
            d.c("DCC_TAG", a("Encrypted", bArr, bArr2));
            return bArr2;
        } catch (Throwable th2) {
            d.c("DCC_TAG", a("Encrypted (failed)", bArr, bArr2));
            throw th2;
        }
    }

    public String a(byte[] bArr) {
        Base64.Encoder urlEncoder;
        String encodeToString;
        if (bArr == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return android.util.Base64.encodeToString(bArr, 9);
        }
        urlEncoder = Base64.getUrlEncoder();
        encodeToString = urlEncoder.encodeToString(bArr);
        return encodeToString;
    }

    private static void a(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public byte[] a(int i10, byte[] bArr) {
        byte[] bArr2 = new byte[i10 + 20];
        if (bArr == null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr2);
            wrap.putLong(0, a(System.currentTimeMillis()));
            wrap.putLong(8, ThreadLocalRandom.current().nextLong());
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(16, bArr.length));
        }
        return bArr2;
    }
}
