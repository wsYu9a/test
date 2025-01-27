package b.h.a.e;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class a {
    public static String a(String str, String str2) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes());
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return b(cipher.doFinal(str2.getBytes()));
    }

    private static String b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append("0123456789abcdef".charAt((bArr[i2] >> 4) & 15));
            sb.append("0123456789abcdef".charAt(bArr[i2] & 15));
        }
        return sb.toString();
    }
}
