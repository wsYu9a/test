package com.shu.priory.d;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes3.dex */
public class g {
    public static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance(d3.d.f25247a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, rSAPublicKey);
        return cipher.doFinal(bArr);
    }
}
