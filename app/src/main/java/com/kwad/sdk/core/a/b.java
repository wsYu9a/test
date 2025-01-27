package com.kwad.sdk.core.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public final class b {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private static byte[] a(byte[] bArr, byte[] bArr2, int i10) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(i10, secretKeySpec);
            return cipher.doFinal(bArr2);
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, 1);
    }

    private static void e(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        gZIPOutputStream2.finish();
                        gZIPOutputStream2.flush();
                        com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static byte[] f(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th3) {
                th2 = th3;
                byteArrayOutputStream = null;
            }
            try {
                e(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th4) {
                th2 = th4;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th2;
            }
        } catch (Throwable th5) {
            byteArrayInputStream = null;
            th2 = th5;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] g(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th2;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th3) {
                th2 = th3;
                byteArrayOutputStream = null;
            }
            try {
                f(byteArrayInputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                return byteArray;
            } catch (Throwable th4) {
                th2 = th4;
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(byteArrayInputStream);
                throw th2;
            }
        } catch (Throwable th5) {
            byteArrayInputStream = null;
            th2 = th5;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a(String str, byte[] bArr) {
        return a(str.getBytes(UTF_8), bArr, 2);
    }

    private static void f(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(inputStream);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream);
                    return;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream2 = gZIPInputStream;
            com.kwad.sdk.crash.utils.b.closeQuietly(gZIPInputStream2);
            throw th;
        }
    }
}
