package com.kwad.sdk.crash.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes2.dex */
public final class a {
    private static Context Op;
    private static String arl;

    private static File getDataDir(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i2 >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!dataDir.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return dataDir;
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        Op = context;
        arl = str;
    }

    public static boolean v(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File zI() {
        File file = !TextUtils.isEmpty(arl) ? new File(arl) : new File(getDataDir(Op), "kwad_ex");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File zJ() {
        return new File(zI(), "java_crash/dump");
    }

    public static File zK() {
        return new File(zI(), "anr_log/dump");
    }

    public static File zL() {
        return new File(zI(), "native_crash_log/dump");
    }
}
