package com.vivo.secboxsdk.jni;

import com.vivo.secboxsdk.a.b;
import com.vivo.secboxsdk.a.c;
import java.io.File;

/* loaded from: classes4.dex */
public class SecBoxNative {
    public static final int SDK_VERSION_CODE = 1;
    public static final String SDK_VERSION_NAME = "secboxsdk-v1.0.0.0-4836a5a";
    public static final String TAG = "secbox";

    /* renamed from: com.vivo.secboxsdk.jni.SecBoxNative$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                String[] a2 = c.a();
                if (a2 != null) {
                    for (String str : a2) {
                        File file = new File(str.trim(), "libvsecbox.so");
                        if (file.exists()) {
                            b.a(SecBoxNative.TAG, "secbox so_sha256=" + c.a(file) + ",len=" + file.length() + ",soFile=" + file.getAbsolutePath());
                            return;
                        }
                        b.a(SecBoxNative.TAG, "secbox soFile=" + file.getAbsolutePath() + " not exist");
                    }
                }
            } catch (Throwable th) {
                b.a(SecBoxNative.TAG, "Error: " + th.getMessage(), th);
            }
        }
    }

    static {
        try {
            startGetSoLoadInfoThread();
            System.loadLibrary("vsecbox");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native byte[] aesDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] aesEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static native byte[] rsaEncrypt(byte[] bArr);

    private static void startGetSoLoadInfoThread() {
        new Thread(new Runnable() { // from class: com.vivo.secboxsdk.jni.SecBoxNative.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String[] a2 = c.a();
                    if (a2 != null) {
                        for (String str : a2) {
                            File file = new File(str.trim(), "libvsecbox.so");
                            if (file.exists()) {
                                b.a(SecBoxNative.TAG, "secbox so_sha256=" + c.a(file) + ",len=" + file.length() + ",soFile=" + file.getAbsolutePath());
                                return;
                            }
                            b.a(SecBoxNative.TAG, "secbox soFile=" + file.getAbsolutePath() + " not exist");
                        }
                    }
                } catch (Throwable th) {
                    b.a(SecBoxNative.TAG, "Error: " + th.getMessage(), th);
                }
            }
        }).start();
    }
}
