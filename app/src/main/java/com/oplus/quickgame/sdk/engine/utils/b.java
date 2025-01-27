package com.oplus.quickgame.sdk.engine.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class b {
    public static String a(String str, String str2) {
        try {
            return a(a(str.getBytes(), str2.getBytes()));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append("0123456789ABCDEF".charAt((bArr[i2] >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(bArr[i2] & 15));
        }
        return stringBuffer.toString();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, IvParameterSpec ivParameterSpec) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String b(String str, String str2) {
        try {
            return a(a(str.getBytes(), str2.getBytes(), new IvParameterSpec(str.getBytes(), 0, 12)));
        } catch (Throwable th) {
            i.b("AESEncoder", "AES encrypt fail " + th);
            return "";
        }
    }
}
