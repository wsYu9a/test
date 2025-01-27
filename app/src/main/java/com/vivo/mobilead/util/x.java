package com.vivo.mobilead.util;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;
import java.util.UUID;

/* loaded from: classes4.dex */
public class x {
    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static String b() {
        String a2 = a();
        return (TextUtils.isEmpty(a2) || a2.length() < 16) ? a2 : a2.substring(0, 16);
    }

    public static String a(String str) {
        return a(str.getBytes());
    }

    public static String a() {
        return a(UUID.randomUUID().toString());
    }
}
