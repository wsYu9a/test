package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class b {
    public static File a(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = Array.get(invoke, i2);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                    return new File(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Environment.getExternalStorageDirectory();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr3[i2] = (byte) i2;
        }
        if (bArr2.length == 0) {
            bArr3 = null;
        } else {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                i4 = ((bArr2[i3] & 255) + (bArr3[i5] & 255) + i4) & 255;
                byte b2 = bArr3[i5];
                bArr3[i5] = bArr3[i4];
                bArr3[i4] = b2;
                i3 = (i3 + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < bArr.length; i8++) {
            i6 = (i6 + 1) & 255;
            i7 = ((bArr3[i6] & 255) + i7) & 255;
            byte b3 = bArr3[i6];
            bArr3[i6] = bArr3[i7];
            bArr3[i7] = b3;
            int i9 = ((bArr3[i6] & 255) + (bArr3[i7] & 255)) & 255;
            bArr4[i8] = (byte) (bArr3[i9] ^ bArr[i8]);
            bArr4[i8] = (byte) (bArr4[i8] ^ 42);
        }
        return bArr4;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a2 = a(bArr, bArr2);
                    if (a2 != null) {
                        if (a2.length > 0) {
                        }
                    }
                    return a2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] a2 = a(bArr, bArr2);
                    if (a2 != null) {
                        if (a2.length > 0) {
                        }
                    }
                    return a2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
