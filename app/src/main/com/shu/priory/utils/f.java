package com.shu.priory.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.shu.priory.config.SDKConstants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class f {
    public static synchronized String a(String str) {
        synchronized (f.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb2 = new StringBuilder();
                for (byte b10 : digest) {
                    String hexString = Integer.toHexString(b10 & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    sb2.append(hexString);
                }
                return sb2.toString();
            } catch (NoSuchAlgorithmException e10) {
                h.d(SDKConstants.TAG, "md5 error:" + e10.getMessage());
                return "";
            }
        }
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(e(str), 8);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getEncPrice:" + th2.getMessage());
            return "";
        }
    }

    public static String c(String str) {
        try {
            return Base64.encodeToString(e(str), 9);
        } catch (Throwable th2) {
            h.d(SDKConstants.TAG, "getEncExt:" + th2.getMessage());
            return "";
        }
    }

    public static byte[] d(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (Integer.parseInt(lowerCase.substring(i11, i11 + 2), 16) & 255);
        }
        return bArr;
    }

    private static byte[] e(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] bytes = "5120aba7dd8880ba".getBytes("utf-8");
        byte[] bArr = new byte[16];
        byte[] bArr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i10 = 0; i10 < 16; i10++) {
            if (bytes.length > i10) {
                bArr[i10] = bytes[i10];
            } else {
                bArr[i10] = bArr2[0];
            }
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, secretKeySpec);
            return a(cipher.doFinal(str.getBytes("utf-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "DES");
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(d(str)));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }
}
