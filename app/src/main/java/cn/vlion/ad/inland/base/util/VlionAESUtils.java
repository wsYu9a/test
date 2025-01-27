package cn.vlion.ad.inland.base.util;

import cn.vlion.ad.inland.base.p;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class VlionAESUtils {
    private static byte[] aesCbcDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Throwable th2) {
            LogVlion.e("VlionAESUtils aesCbcDecrypt " + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return new byte[0];
        }
    }

    private static byte[] aesCbcEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Throwable th2) {
            LogVlion.e("VlionAESUtils aesCbcEncrypt " + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return new byte[0];
        }
    }

    public static String decrypt(String str, String str2, String str3) {
        try {
            return new String(aesCbcDecrypt(parseHexStr2Byte(str), str2.getBytes(), str3.getBytes()));
        } catch (Throwable th2) {
            p.a(th2, "VlionAESUtils decrypt ", th2);
            return "";
        }
    }

    public static String encrypt(String str, String str2, String str3) {
        try {
            return parseByte2HexStr(aesCbcEncrypt(str.getBytes(), str2.getBytes(), str3.getBytes()));
        } catch (Throwable th2) {
            p.a(th2, "VlionAESUtils encrypt ", th2);
            return "";
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bArr) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                sb2.append(hexString.toUpperCase());
            }
            LogVlion.e("getAdData:加密json=" + sb2.toString());
            return sb2.toString();
        } catch (Throwable th2) {
            LogVlion.e("VlionAESUtils parseByte2HexStr " + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public static byte[] parseHexStr2Byte(String str) {
        try {
            if (str.length() < 1) {
                return new byte[0];
            }
            byte[] bArr = new byte[str.length() / 2];
            for (int i10 = 0; i10 < str.length() / 2; i10++) {
                int i11 = i10 * 2;
                int i12 = i11 + 1;
                bArr[i10] = (byte) ((Integer.parseInt(str.substring(i11, i12), 16) * 16) + Integer.parseInt(str.substring(i12, i11 + 2), 16));
            }
            return bArr;
        } catch (Throwable th2) {
            LogVlion.e("VlionAESUtils parseHexStr2Byte " + th2);
            VlionSDkManager.getInstance().upLoadCatchException(new Throwable(th2.toString() + " :" + str));
            return new byte[0];
        }
    }
}
