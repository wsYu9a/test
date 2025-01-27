package com.czhj.sdk.common.utils;

import android.graphics.Bitmap;
import com.baidu.mobads.sdk.internal.a;
import com.kuaishou.weapon.p0.t;
import java.util.HashMap;
import vb.e;

/* loaded from: classes2.dex */
public class ImageUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f8647a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f8647a = hashMap;
        hashMap.put("FFD8FF", "jpg");
        hashMap.put("89504E47", "png");
        hashMap.put("47494638", "gif");
        hashMap.put("49492A00", "tif");
        hashMap.put("424D", "bmp");
        hashMap.put("41433130", "dwg");
        hashMap.put("38425053", "psd");
        hashMap.put("7B5C727466", "rtf");
        hashMap.put("3C3F786D6C", "xml");
        hashMap.put("68746D6C3E", a.f6640f);
        hashMap.put("44656C69766572792D646174653A", "eml");
        hashMap.put("D0CF11E0", "doc");
        hashMap.put("5374616E64617264204A", "mdb");
        hashMap.put("252150532D41646F6265", "ps");
        hashMap.put("255044462D312E", "pdf");
        hashMap.put("504B0304", "docx");
        hashMap.put("52617221", "rar");
        hashMap.put("57415645", "wav");
        hashMap.put("41564920", "avi");
        hashMap.put("2E524D46", t.f11223w);
        hashMap.put("000001BA", "mpg");
        hashMap.put("000001B3", "mpg");
        hashMap.put("6D6F6F76", "mov");
        hashMap.put("3026B2758E66CF11", "asf");
        hashMap.put("4D546864", "mid");
        hashMap.put("1F8B08", "gz");
        hashMap.put("4D5A9000", "exe/dll");
        hashMap.put("75736167", e.f31296c);
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

    public static String getFileType(String str) {
        return f8647a.get(a(str));
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:
    
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r4) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L17
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L17
            r4 = 4
            byte[] r2 = new byte[r4]     // Catch: java.lang.Throwable -> L15
            r3 = 0
            r1.read(r2, r3, r4)     // Catch: java.lang.Throwable -> L15
            java.lang.String r0 = a(r2)     // Catch: java.lang.Throwable -> L15
        L11:
            r1.close()     // Catch: java.lang.Throwable -> L1c
            goto L1c
        L15:
            goto L19
        L17:
            r1 = r0
        L19:
            if (r1 == 0) goto L1c
            goto L11
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.utils.ImageUtils.a(java.lang.String):java.lang.String");
    }
}
