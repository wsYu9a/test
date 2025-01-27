package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public final class av {
    private static String aAn;
    private static File aAo;

    private static boolean Eo() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }

    public static File cA(Context context) {
        File file = aAo;
        if (file != null) {
            return file;
        }
        String str = null;
        if (Eo()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(str + File.separator + "ksadsdk");
        aAo = file2;
        if (!file2.exists()) {
            aAo.mkdirs();
        }
        return aAo;
    }

    public static File cB(Context context) {
        File file = new File(cz(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cC(Context context) {
        File file = new File(cz(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cD(Context context) {
        String str;
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            str = cz(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String cE(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getPath() + File.separator + "ksadsdk";
    }

    public static String cF(Context context) {
        return cA(context).getPath() + "/cookie";
    }

    private static String cz(Context context) {
        if (!TextUtils.isEmpty(aAn)) {
            return aAn;
        }
        String str = null;
        if (Eo()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String str2 = str + File.separator + "ksadsdk";
        aAn = str2;
        return str2;
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String cE = cE(context);
        StringBuilder sb = new StringBuilder();
        sb.append(cE);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ksad/download/js");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return cE(context) + File.separator + "ksad/download/js";
    }
}
