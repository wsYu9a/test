package com.vivo.mobilead.util;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: b */
    private static final String f30750b = "o";

    /* renamed from: c */
    private static byte[] f30751c = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: a */
    private Cipher f30752a;

    private static class b {

        /* renamed from: a */
        private static final o f30753a = new o();
    }

    /* synthetic */ o(a aVar) {
        this();
    }

    public static o a() {
        return b.f30753a;
    }

    private final String b(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i2 = 0;
            for (byte b2 : digest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
            }
            return new String(cArr2).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    private o() {
        try {
            this.f30752a = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (NoSuchAlgorithmException e2) {
            x0.b(f30750b, "" + e2.getMessage());
        } catch (NoSuchPaddingException e3) {
            x0.b(f30750b, "" + e3.getMessage());
        } catch (Exception e4) {
            x0.b(f30750b, "" + e4.getMessage());
        }
    }

    public String a(String str, String str2) {
        return a(str, a(str2));
    }

    public String a(String str, byte[] bArr) {
        try {
            return new String(a(Base64.decode(str, 0), bArr), "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    private byte[] a(byte[] bArr, byte[] bArr2) throws Exception {
        return a(bArr, bArr2, 2);
    }

    private byte[] a(byte[] bArr, byte[] bArr2, int i2) throws Exception {
        this.f30752a.init(i2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(f30751c));
        return this.f30752a.doFinal(bArr);
    }

    public byte[] a(String str) {
        String b2 = b(str + "MYfLBmRgKecqe2610B7+jt2rVdTeFDsR1IqqW92w6FM=");
        if (TextUtils.isEmpty(b2)) {
            b2 = "99e23fb052699749627a10fed365b9d1";
        }
        return b2.getBytes();
    }
}
