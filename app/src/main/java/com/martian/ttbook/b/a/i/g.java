package com.martian.ttbook.b.a.i;

import com.baidu.mobads.sdk.internal.bu;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class g {
    public static String a(String str) {
        byte[] f2;
        if (str == null || (f2 = f(str)) == null) {
            return null;
        }
        return e(f2);
    }

    public static byte[] b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Throwable th) {
            b.d.e.c.a.d.g(MiConfigSingleton.t0, th);
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return d(bArr, 0, bArr.length);
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
            byte[] b2 = b(byteArrayInputStream);
            byteArrayInputStream.close();
            return b2;
        } catch (Throwable th) {
            b.d.e.c.a.d.g(MiConfigSingleton.t0, th);
            th.printStackTrace();
            return null;
        }
    }

    private static String e(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return stringBuffer.toString();
    }

    public static byte[] f(String str) {
        if (str == null) {
            return null;
        }
        try {
            return c(str.getBytes("utf-8"));
        } catch (Throwable th) {
            b.d.e.c.a.d.g(MiConfigSingleton.t0, th);
            th.printStackTrace();
            return null;
        }
    }
}
