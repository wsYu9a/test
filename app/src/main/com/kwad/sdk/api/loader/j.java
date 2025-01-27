package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.bugly.beta.tinker.TinkerManager;
import java.io.File;

/* loaded from: classes3.dex */
final class j {
    private static File apY;
    private static final String apZ;

    /* renamed from: com.kwad.sdk.api.loader.j$1 */
    public class AnonymousClass1 extends com.kwad.sdk.api.a.b {
        final /* synthetic */ String aqa;
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // com.kwad.sdk.api.a.b
        public final void doTask() {
            try {
                File[] listFiles = j.t(context, str).getParentFile().listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file : listFiles) {
                    if (i.K(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                        j.h(file);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    static {
        apZ = yR() ? "dynamic_apk" : "dynamic.apk";
    }

    private static File aT(Context context) {
        if (apY == null) {
            apY = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return apY;
    }

    public static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                h(file2);
            }
        }
        file.delete();
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
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!com.kwad.sdk.api.a.ns.booleanValue()) {
            return file;
        }
        throw new RuntimeException("Can not ensureDir:" + file);
    }

    public static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    public static File r(Context context, String str) {
        return new File(aT(context), "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    public static String s(Context context, String str) {
        return i(new File(aT(context), "apk-" + str)).getPath();
    }

    public static File t(Context context, String str) {
        return i(new File(aT(context), "apk-" + str));
    }

    public static String u(Context context, String str) {
        return new File(s(context, str), apZ).getPath();
    }

    public static String v(Context context, String str) {
        return i(new File(s(context, str), TinkerManager.PATCH_DIR)).getPath();
    }

    public static String w(Context context, String str) {
        return i(new File(s(context, str), "libs")).getPath();
    }

    public static void x(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.j.1
            final /* synthetic */ String aqa;
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    File[] listFiles = j.t(context, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (i.K(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            j.h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private static boolean yR() {
        int i10 = Build.VERSION.SDK_INT;
        return i10 == 30 || i10 == 31 || i10 == 32;
    }
}
