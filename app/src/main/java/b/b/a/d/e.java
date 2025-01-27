package b.b.a.d;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    private static String f4264a = "DESede/ECB/PKCS5Padding";

    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(f4264a);
            cipher.init(1, secretKeySpec);
            return a.b(cipher.doFinal(str2.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "DESede");
            Cipher cipher = Cipher.getInstance(f4264a);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(a.d(str2)));
        } catch (Exception unused) {
            return null;
        }
    }
}
