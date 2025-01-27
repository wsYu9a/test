package com.oplus.quickgame.sdk.engine.ui;

import com.baidu.mobads.sdk.internal.bu;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes4.dex */
public class MD5Util {
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String convertHashToString(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        for (byte b2 : bArr) {
            str = str + Integer.toString((b2 & 255) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }

    public static String generateMD5(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
                int i2 = 0;
                while (i2 != -1) {
                    i2 = fileInputStream2.read(bArr);
                    if (i2 > 0) {
                        messageDigest.update(bArr, 0, i2);
                    }
                }
                String convertHashToString = convertHashToString(messageDigest.digest());
                try {
                    fileInputStream2.close();
                    return convertHashToString;
                } catch (Exception unused) {
                    return convertHashToString;
                }
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String hex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i3] = cArr2[(b2 >> 4) & 15];
            cArr[i4] = cArr2[b2 & 15];
            i2++;
            i3 = i4 + 1;
        }
        return new String(cArr);
    }

    public static String md5Hex(String str) {
        try {
            return md5Hex(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String md5Hex(byte[] bArr) {
        try {
            return hex(MessageDigest.getInstance(bu.f5659a).digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
