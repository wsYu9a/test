package we;

import hf.d;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class c implements a {

    /* renamed from: a */
    public static final String f31709a = "MD5";

    /* renamed from: b */
    public static final int f31710b = 36;

    public final byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e10) {
            d.d(e10);
            return null;
        }
    }

    @Override // we.a
    public String generate(String str) {
        return new BigInteger(a(str.getBytes())).abs().toString(36);
    }
}
