package cn.vlion.ad.inland.base.util.md5;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class MD5Utils {
    public static String encode(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("md5").digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public static String getMD5Code(String str) {
        int i10;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i11 = 0; i11 < digest.length; i11++) {
                if (Integer.toHexString(digest[i11] & 255).length() == 1) {
                    stringBuffer.append("0");
                    i10 = digest[i11] & 255;
                } else {
                    i10 = digest[i11] & 255;
                }
                stringBuffer.append(Integer.toHexString(i10));
            }
            return stringBuffer.toString();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }
}
