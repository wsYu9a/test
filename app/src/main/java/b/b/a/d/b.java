package b.b.a.d;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class b {
    public static String a(int i2, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(i2, secretKeySpec);
            byte[] doFinal = cipher.doFinal(i2 == 2 ? a.d(str) : str.getBytes("UTF-8"));
            return i2 == 2 ? new String(doFinal) : a.b(doFinal);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String b(String str, String str2) {
        return a(1, str, str2);
    }

    private static String c(String str, String str2) {
        return a(2, str, str2);
    }
}
