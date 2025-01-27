package com.vivo.push.util;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes4.dex */
public final class u {

    /* renamed from: a */
    private static String f25147a = "RSA";

    public static String a(Key key) {
        return Base64.encodeToString(key.getEncoded(), 2);
    }

    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(f25147a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) throws Exception {
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKey);
        signature.update(bArr);
        return signature.verify(bArr2);
    }
}
