package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class k0 {
    public static String a(byte[] bArr) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bArr) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    hexString = '0' + hexString;
                }
                sb2.append(hexString.toUpperCase());
            }
            LogVlion.e("VlionAESGCMUtils:加密json=" + sb2.toString());
            return sb2.toString();
        } catch (Throwable th2) {
            LogVlion.e("VlionAESGCMUtils parseByte2HexStr " + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return "";
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr3));
            return cipher.doFinal(bArr);
        } catch (Throwable th2) {
            LogVlion.e("VlionAESGCMUtils aesCbcEncrypt " + th2);
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return new byte[0];
        }
    }

    public static String a(String str) {
        try {
            return a(a(str.getBytes(), "0f731cb0409bfcc2".getBytes(), "ec2a0a620780".getBytes()));
        } catch (Throwable th2) {
            p.a(th2, "VlionAESGCMUtils encrypt ", th2);
            return "";
        }
    }
}
