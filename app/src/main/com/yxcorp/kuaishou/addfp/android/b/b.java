package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class b {
    public static File a(Context context, boolean z10) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", null);
            Method method2 = cls.getMethod("getPath", null);
            Method method3 = cls.getMethod("isRemovable", null);
            Object invoke = method.invoke(storageManager, null);
            int length = Array.getLength(invoke);
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = Array.get(invoke, i10);
                String str = (String) method2.invoke(obj, null);
                if (z10 == ((Boolean) method3.invoke(obj, null)).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return Environment.getExternalStorageDirectory();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    return a(bArr, bArr2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    return a(bArr, bArr2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            bArr3[i10] = (byte) i10;
        }
        if (bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < 256; i13++) {
                int i14 = bArr2[i11] & 255;
                byte b10 = bArr3[i13];
                i12 = (i14 + (b10 & 255) + i12) & 255;
                bArr3[i13] = bArr3[i12];
                bArr3[i12] = b10;
                i11 = (i11 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < bArr.length; i17++) {
            i15 = (i15 + 1) & 255;
            byte b11 = bArr3[i15];
            i16 = ((b11 & 255) + i16) & 255;
            bArr3[i15] = bArr3[i16];
            bArr3[i16] = b11;
            int i18 = ((bArr3[i15] & 255) + (b11 & 255)) & 255;
            byte b12 = (byte) (bArr3[i18] ^ bArr[i17]);
            bArr4[i17] = b12;
            bArr4[i17] = (byte) (b12 ^ 42);
        }
        return bArr4;
    }
}
