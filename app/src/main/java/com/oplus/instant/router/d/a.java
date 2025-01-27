package com.oplus.instant.router.d;

import android.util.Base64;
import com.oplus.instant.router.h.d;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class a {
    public static String a(String str, String str2) {
        try {
            return b(c(str.getBytes(), str2.getBytes()));
        } catch (Throwable th) {
            d.c("AESEncoder", "AES encrypt fail", th);
            return null;
        }
    }

    private static String b(byte[] bArr) {
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

    private static byte[] c(byte[] bArr, byte[] bArr2) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    private static byte[] d(byte[] bArr, byte[] bArr2, IvParameterSpec ivParameterSpec) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr2);
    }

    public static String e(String str, String str2) {
        try {
            return b(d(str.getBytes(), str2.getBytes(), new IvParameterSpec(Base64.decode(str, 0), 0, 12)));
        } catch (Throwable th) {
            d.c("AESEncoder", "AES encrypt fail", th);
            return null;
        }
    }
}
