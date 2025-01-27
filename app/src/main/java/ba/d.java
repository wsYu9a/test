package ba;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class d {
    public static String a(String str, String str2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, new SecretKeySpec(str2.substring(0, 16).getBytes(), "AES"));
        return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
    }

    public static String c(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String d(TreeMap<String, String> treeMap, String str) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue());
            sb2.append("&");
        }
        sb2.append("key=");
        sb2.append(str);
        return e(sb2.toString().getBytes()).toUpperCase();
    }

    public static String e(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i10 = 0;
            for (byte b10 : digest) {
                int i11 = i10 + 1;
                cArr2[i10] = cArr[(b10 >>> 4) & 15];
                i10 += 2;
                cArr2[i11] = cArr[b10 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public static String f(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
