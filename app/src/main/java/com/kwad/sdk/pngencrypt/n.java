package com.kwad.sdk.pngencrypt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class n {
    public static Charset awh = Charset.forName("ISO-8859-1");
    public static Charset awi = Charset.forName("UTF-8");
    private static ThreadLocal<Boolean> awj = new ThreadLocal<Boolean>() { // from class: com.kwad.sdk.pngencrypt.n.1
        AnonymousClass1() {
        }

        private static Boolean BO() {
            return Boolean.FALSE;
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Boolean initialValue() {
            return BO();
        }
    };

    /* renamed from: com.kwad.sdk.pngencrypt.n$1 */
    static class AnonymousClass1 extends ThreadLocal<Boolean> {
        AnonymousClass1() {
        }

        private static Boolean BO() {
            return Boolean.FALSE;
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Boolean initialValue() {
            return BO();
        }
    }

    public static byte[] BN() {
        return new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    static final int b(int i2, int i3, int i4) {
        int i5 = (i2 + i3) - i4;
        int i6 = i5 >= i2 ? i5 - i2 : i2 - i5;
        int i7 = i5 >= i3 ? i5 - i3 : i3 - i5;
        int i8 = i5 >= i4 ? i5 - i4 : i4 - i5;
        return (i6 > i7 || i6 > i8) ? i7 <= i8 ? i3 : i4 : i2;
    }

    public static int e(InputStream inputStream) {
        try {
            return inputStream.read();
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return -1;
        }
    }

    public static int e(byte[] bArr, int i2) {
        return bArr[i2] & 255;
    }

    public static int f(InputStream inputStream) {
        try {
            int read = inputStream.read();
            int read2 = inputStream.read();
            int read3 = inputStream.read();
            int read4 = inputStream.read();
            if (read == -1 || read2 == -1 || read3 == -1 || read4 == -1) {
                return -1;
            }
            return (read << 24) | (read2 << 16) | ((read3 << 8) + read4);
        } catch (IOException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return -1;
        }
    }

    public static int f(byte[] bArr, int i2) {
        return (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8);
    }

    public static final int g(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
