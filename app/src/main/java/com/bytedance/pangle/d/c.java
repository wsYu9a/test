package com.bytedance.pangle.d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.g;
import com.bytedance.pangle.util.i;
import java.io.File;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    private static File f6033a;

    /* renamed from: b */
    private static File f6034b;

    /* renamed from: c */
    private static File f6035c;

    private static String a(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (f6035c == null) {
            f6035c = new File(appApplication.getFilesDir(), ".pangle" + g.f6118a);
        }
        return a(f6035c);
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + g.f6119b);
            if (externalFilesDir != null) {
                return a(externalFilesDir);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void d() {
        if (f6033a == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), "pangle" + g.f6120c);
            f6033a = file;
            a(file);
        }
    }

    public static String e(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String f(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk")).getPath();
    }

    public static String g(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk", "temp")).getPath();
    }

    public static String h(String str, int i2) {
        return i.i() ? a(str, "version-".concat(String.valueOf(i2)), "apk", "temp", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i2)), "dalvik-cache");
    }

    public static String i(String str, int i2) {
        return a(str, "version-".concat(String.valueOf(i2)), "secondary-dexes");
    }

    private static String a(String... strArr) {
        d();
        File file = f6033a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return a(file);
    }

    public static String d(String str, int i2) {
        return a(str, "version-".concat(String.valueOf(i2)), "lib");
    }

    public static String b(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), "apk"), "base-1.apk").getPath();
    }

    public static String c(String str, int i2) {
        return i.i() ? a(str, "version-".concat(String.valueOf(i2)), "apk", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i2)), "dalvik-cache");
    }

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (f6034b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + g.f6119b);
            }
            f6034b = downloadDir;
        }
        return a(f6034b);
    }

    public static String a(String str, int i2) {
        d();
        File file = f6033a;
        String[] strArr = {str, "version-".concat(String.valueOf(i2))};
        for (int i3 = 0; i3 < 2; i3++) {
            String str2 = strArr[i3];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String a(String str) {
        return a(str);
    }
}
