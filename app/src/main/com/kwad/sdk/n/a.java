package com.kwad.sdk.n;

import android.content.Context;
import java.io.File;

/* loaded from: classes3.dex */
final class a {
    private static File apY;

    private static File aT(Context context) {
        if (apY == null) {
            apY = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return apY;
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.isDirectory();
        }
        return file;
    }

    private static String s(Context context, String str) {
        return i(new File(aT(context), "apk-" + str)).getPath();
    }

    public static String u(Context context, String str) {
        File file = new File(s(context, str), "dynamic.apk");
        return file.exists() ? file.getPath() : new File(s(context, str), "dynamic_apk").getPath();
    }
}
