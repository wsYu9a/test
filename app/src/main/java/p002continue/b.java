package p002continue;

import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static final byte[] f25192a;

    public static class a {
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        }
    }

    static {
        byte[] bArr;
        try {
            bArr = "c36a8935eef1352d".getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        f25192a = bArr;
    }
}
