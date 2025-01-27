package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.w;
import java.io.File;

/* loaded from: classes3.dex */
public final class a {
    private static Context aDj;
    private static String aKl;

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File Jt() {
        File file;
        if (TextUtils.isEmpty(aKl)) {
            Context context = aDj;
            if (context == null) {
                context = ServiceProvider.MA();
            }
            if (context == null) {
                try {
                    context = w.By();
                } catch (Throwable unused) {
                }
            }
            file = context != null ? new File(getDataDir(context), "kwad_ex") : null;
        } else {
            file = new File(aKl);
        }
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File Ju() {
        return new File(Jt(), "java_crash/dump");
    }

    public static File Jv() {
        return new File(Jt(), "anr_log/dump");
    }

    public static File Jw() {
        return new File(Jt(), "native_crash_log/dump");
    }

    private static File getDataDir(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i10 >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!dataDir.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return dataDir;
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        aDj = context;
        aKl = str;
        aKl = u.O(context, "kwad_ex");
    }
}
