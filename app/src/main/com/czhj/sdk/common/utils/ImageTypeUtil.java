package com.czhj.sdk.common.utils;

import com.czhj.sdk.logger.SigmobLog;
import java.io.FileInputStream;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class ImageTypeUtil {

    /* renamed from: a */
    public static final HashMap<String, String> f8646a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f8646a = hashMap;
        hashMap.put("FFD8", "jpg");
        hashMap.put("8950", "png");
        hashMap.put("4749", "gif");
        hashMap.put("4949", "tif");
        hashMap.put("424D", "bmp");
        hashMap.put("5745", "webp");
    }

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String upperCase = Integer.toHexString(b10 & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb2.append(0);
            }
            sb2.append(upperCase);
        }
        return sb2.toString();
    }

    public static String getFileHeader(String str) {
        String str2;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[2];
                fileInputStream2.read(bArr, 0, 2);
                String a10 = a(bArr);
                if (a10.equals("5249")) {
                    fileInputStream2.skip(6L);
                    fileInputStream2.read(bArr, 0, 2);
                    a10 = a(bArr);
                }
                try {
                    fileInputStream2.close();
                    return a10;
                } catch (Throwable unused) {
                    return a10;
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
                fileInputStream = fileInputStream2;
                try {
                    SigmobLog.e(th.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return str2;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            str2 = null;
        }
    }

    public static String getFileType(String str) {
        return f8646a.get(getFileHeader(str));
    }
}
