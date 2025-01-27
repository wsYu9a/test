package b.b.a.d;

import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class c {
    private static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(str.getBytes());
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(bArr);
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append(Character.forDigit((bArr[i2] & 240) >> 4, 16));
            stringBuffer.append(Character.forDigit(bArr[i2] & 15, 16));
        }
        return stringBuffer.toString();
    }
}
