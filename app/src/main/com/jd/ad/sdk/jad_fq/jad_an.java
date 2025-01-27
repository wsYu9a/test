package com.jd.ad.sdk.jad_fq;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class jad_an {
    public static String jad_an(String str) {
        if (str.length() <= 59) {
            return "";
        }
        String substring = str.substring(0, 59);
        String substring2 = str.substring(59);
        String jad_cp = jad_cp(substring);
        String jad_dq = jad_dq(substring);
        SecretKeySpec secretKeySpec = new SecretKeySpec(jad_cp.getBytes("UTF-8"), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(jad_dq.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return new String(cipher.doFinal(Base64.decode(substring2, 8)), "UTF-8");
    }

    public static byte[] jad_bo(String str) {
        int nextInt = new SecureRandom().nextInt(10);
        String substring = "abcdefghij".substring(nextInt, nextInt + 1);
        StringBuilder sb2 = new StringBuilder(58);
        SecureRandom secureRandom = new SecureRandom();
        for (int i10 = 0; i10 < 58; i10++) {
            sb2.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(secureRandom.nextInt(62)));
        }
        String str2 = substring + sb2.toString();
        String jad_cp = jad_cp(str2);
        String jad_dq = jad_dq(str2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(jad_cp.getBytes("UTF-8"), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(jad_dq.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return (str2 + Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 11)).getBytes(StandardCharsets.UTF_8);
    }

    public static String jad_cp(String str) {
        int indexOf;
        return (str == null || (indexOf = "abcdefghij".indexOf(str.substring(0, 1))) == -1) ? "" : str.substring(indexOf + 1, indexOf + 33);
    }

    public static String jad_dq(String str) {
        int indexOf;
        return (str == null || (indexOf = "abcdefghij".indexOf(str.substring(0, 1))) == -1) ? "" : str.substring(indexOf + 33, indexOf + 49);
    }
}
