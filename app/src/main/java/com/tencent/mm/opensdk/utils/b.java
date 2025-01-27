package com.tencent.mm.opensdk.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static Context f23087a;

    /* renamed from: b */
    private static final int f23088b;

    /* renamed from: c */
    private static final int f23089c;

    /* renamed from: d */
    private static final int f23090d;

    /* renamed from: e */
    public static ThreadPoolExecutor f23091e;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f23088b = availableProcessors;
        int i10 = availableProcessors + 1;
        f23089c = i10;
        int i11 = (availableProcessors * 2) + 1;
        f23090d = i11;
        f23091e = new ThreadPoolExecutor(i10, i11, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    }

    public static int a(ContentResolver contentResolver, Uri uri) {
        Log.i("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver == null || uri == null) {
            Log.w("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
            return 0;
        }
        InputStream inputStream = null;
        try {
            try {
                InputStream openInputStream = contentResolver.openInputStream(uri);
                if (openInputStream == null) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return 0;
                }
                int available = openInputStream.available();
                try {
                    openInputStream.close();
                } catch (IOException unused2) {
                }
                return available;
            } catch (Exception e10) {
                Log.w("MicroMsg.SDK.Util", "getFileSize fail, " + e10.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return 0;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th2;
        }
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }

    public static int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        if (f23087a != null && str.startsWith("content")) {
            try {
                return a(f23087a.getContentResolver(), Uri.parse(str));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int a(String str, int i10) {
        if (str == null) {
            return i10;
        }
        try {
            return str.length() <= 0 ? i10 : Integer.parseInt(str);
        } catch (Exception unused) {
            return i10;
        }
    }

    public static boolean a(int i10) {
        return i10 == 36 || i10 == 46;
    }
}
