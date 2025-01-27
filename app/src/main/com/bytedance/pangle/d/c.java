package com.bytedance.pangle.d;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.h;
import com.bytedance.pangle.util.i;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    private static File f7528a;

    /* renamed from: b */
    private static File f7529b;

    /* renamed from: c */
    private static File f7530c;

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
        if (f7530c == null) {
            f7530c = new File(appApplication.getFilesDir(), ".pangle" + h.f7663a);
        }
        return a(f7530c);
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return null;
            }
            File externalFilesDir = appApplication.getExternalFilesDir(".pangle" + h.f7664b);
            if (externalFilesDir != null) {
                return a(externalFilesDir);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static void d() {
        if (f7528a == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + h.f7665c);
            f7528a = file;
            a(file);
        }
    }

    public static String e(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String f(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk")).getPath();
    }

    public static String g(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk", "temp")).getPath();
    }

    public static String h(String str, int i10) {
        return i.i() ? a(str, "version-".concat(String.valueOf(i10)), "apk", "temp", "oat", com.bytedance.pangle.e.b.a()) : a(str, "version-".concat(String.valueOf(i10)), "dalvik-cache");
    }

    public static String i(String str, int i10) {
        return a(str, "version-".concat(String.valueOf(i10)), "secondary-dexes");
    }

    private static String a(String... strArr) {
        d();
        File file = f7528a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return a(file);
    }

    public static String d(String str, int i10) {
        return a(str, "version-".concat(String.valueOf(i10)), "lib");
    }

    public static String b(String str, int i10) {
        return new File(a(str, "version-".concat(String.valueOf(i10)), "apk"), "base-1.apk").getPath();
    }

    public static String c(String str, int i10) {
        if (i.i()) {
            return a(str, "version-".concat(String.valueOf(i10)), "apk", "oat", com.bytedance.pangle.e.b.a());
        }
        return a(str, "version-".concat(String.valueOf(i10)), "dalvik-cache");
    }

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (f7529b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + h.f7664b);
            }
            f7529b = downloadDir;
        }
        return a(f7529b);
    }

    public static String a(String str, int i10) {
        d();
        File file = f7528a;
        String[] strArr = {str, "version-".concat(String.valueOf(i10))};
        for (int i11 = 0; i11 < 2; i11++) {
            String str2 = strArr[i11];
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
