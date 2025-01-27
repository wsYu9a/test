package b.g.a.a.a.d;

import b.g.a.b.d;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes4.dex */
public class c implements a {

    /* renamed from: a */
    private static final String f4888a = "MD5";

    /* renamed from: b */
    private static final int f4889b = 36;

    private byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e2) {
            d.d(e2);
            return null;
        }
    }

    @Override // b.g.a.a.a.d.a
    public String generate(String str) {
        return new BigInteger(a(str.getBytes())).abs().toString(36);
    }
}
