package com.martian.libsupport;

import android.util.Base64;
import androidx.core.os.EnvironmentCompat;
import com.baidu.mobads.sdk.internal.bu;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class b {
    public static String a(String content, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, new SecretKeySpec(key.substring(0, 16).getBytes(), "AES"));
        return Base64.encodeToString(cipher.doFinal(content.getBytes()), 0);
    }

    public static String b(String text) {
        return l.p() ? new String(Base64.decode(text, 0), StandardCharsets.UTF_8) : "";
    }

    public static String c(String text) {
        return Base64.encodeToString(text.getBytes(), 0);
    }

    public static String d(TreeMap<String, String> params, String appkey) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        sb.append("key=");
        sb.append(appkey);
        return e(sb.toString().getBytes()).toUpperCase();
    }

    public static String e(byte[] buffer) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(buffer);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i2 = 0;
            for (byte b2 : digest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }

    public static String f(byte[] bytes) {
        try {
            byte[] digest = MessageDigest.getInstance(bu.f5659a).digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
