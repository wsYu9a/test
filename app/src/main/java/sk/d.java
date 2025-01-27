package sk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes5.dex */
public final class d {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (int i10 = 0; i10 < digest.length; i10++) {
                byte b10 = digest[i10];
                stringBuffer.append((b10 & 255) < 16 ? "0" + Integer.toHexString(digest[i10] & 255) : Integer.toHexString(b10 & 255));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "No";
        }
    }
}
