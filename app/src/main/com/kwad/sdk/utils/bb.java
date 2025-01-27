package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes3.dex */
public final class bb {
    private static String aUp;
    private static File aUq;

    private static boolean Ov() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return false;
        }
    }

    private static String dc(Context context) {
        if (!TextUtils.isEmpty(aUp)) {
            return aUp;
        }
        String str = null;
        if (Ov()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String str2 = str + File.separator + "ksadsdk";
        aUp = str2;
        return str2;
    }

    public static File dd(Context context) {
        File file = aUq;
        if (file != null) {
            return file;
        }
        String str = null;
        if (Ov()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(str + File.separator + "ksadsdk");
        aUq = file2;
        if (!file2.exists()) {
            aUq.mkdirs();
        }
        return aUq;
    }

    public static File de(Context context) {
        File file = new File(dc(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File df(Context context) {
        File file = new File(dc(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dg(Context context) {
        String str;
        if (com.kwad.framework.a.a.ns.booleanValue()) {
            str = dc(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String dh(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getPath() + File.separator + "ksadsdk";
    }

    public static String di(Context context) {
        return dd(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String dh2 = dh(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(dh2);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("ksad/download/js");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return dh(context) + File.separator + "ksad/download/js";
    }
}
