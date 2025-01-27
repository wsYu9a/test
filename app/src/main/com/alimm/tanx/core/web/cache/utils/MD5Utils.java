package com.alimm.tanx.core.web.cache.utils;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public class MD5Utils {
    public static String bytesToHex(byte[] bArr, boolean z10) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10];
            if (i11 < 0) {
                i11 += 256;
            }
            if (i11 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i11));
        }
        return z10 ? stringBuffer.toString().toUpperCase() : stringBuffer.toString().toLowerCase();
    }

    public static String getMD5(String str) {
        return getMD5(str, true);
    }

    public static String getMD5(String str, boolean z10) {
        try {
            return bytesToHex(MessageDigest.getInstance("MD5").digest(str.getBytes()), z10);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
