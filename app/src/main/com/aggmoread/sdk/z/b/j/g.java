package com.aggmoread.sdk.z.b.j;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class g {
    public static String a(String str) {
        byte[] b10;
        if (str == null || (b10 = b(str)) == null) {
            return null;
        }
        return c(b10);
    }

    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        try {
            return b(str.getBytes("utf-8"));
        } catch (Throwable th2) {
            com.aggmoread.sdk.z.b.d.a(h3.e.f26408m, th2);
            th2.printStackTrace();
            return null;
        }
    }

    private static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b10)));
        }
        return stringBuffer.toString();
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return b(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i10 < i11) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i10])));
            i10++;
        }
        return stringBuffer.toString();
    }

    public static byte[] b(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i10, i11);
            byte[] a10 = a(byteArrayInputStream);
            byteArrayInputStream.close();
            return a10;
        } catch (Throwable th2) {
            com.aggmoread.sdk.z.b.d.a(h3.e.f26408m, th2);
            th2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return messageDigest.digest();
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Throwable th2) {
            com.aggmoread.sdk.z.b.d.a(h3.e.f26408m, th2);
            th2.printStackTrace();
            return null;
        }
    }

    public static byte[] a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        byte[] bytes2 = str2.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        byte[] bArr2 = new byte[cipher.getOutputSize(bytes2.length)];
        cipher.doFinal(bArr2, cipher.update(bytes2, 0, bytes2.length, bArr2, 0));
        return bArr2;
    }
}
