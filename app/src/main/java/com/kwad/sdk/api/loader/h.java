package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.tinker.TinkerManager;
import java.io.File;

/* loaded from: classes2.dex */
final class h {
    private static File ZB;

    /* renamed from: com.kwad.sdk.api.loader.h$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String ZC;
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                File[] listFiles = h.m(context, str).getParentFile().listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file : listFiles) {
                    if (g.q(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                        h.c(file);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static File ar(Context context) {
        if (ZB == null) {
            ZB = d(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return ZB;
    }

    static void c(File file) {
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
                c(file2);
            }
        }
        file.delete();
    }

    private static File d(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if ((file.exists() && file.isDirectory()) || !com.kwad.sdk.api.a.bI.booleanValue()) {
            return file;
        }
        throw new RuntimeException("Can not ensureDir:" + file);
    }

    static void e(File file) {
        try {
            c(file);
        } catch (Exception unused) {
        }
    }

    static File k(Context context, String str) {
        return new File(ar(context), "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    static String l(Context context, String str) {
        return d(new File(ar(context), "apk-" + str)).getPath();
    }

    static File m(Context context, String str) {
        return d(new File(ar(context), "apk-" + str));
    }

    static String n(Context context, String str) {
        return new File(l(context, str), "dynamic.apk").getPath();
    }

    static String o(Context context, String str) {
        return d(new File(l(context, str), TinkerManager.PATCH_DIR)).getPath();
    }

    static String p(Context context, String str) {
        return d(new File(l(context, str), "libs")).getPath();
    }

    static void q(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
            final /* synthetic */ String ZC;
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    File[] listFiles = h.m(context, str).getParentFile().listFiles();
                    if (listFiles == null || listFiles.length <= 0) {
                        return;
                    }
                    for (File file : listFiles) {
                        if (g.q(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            h.c(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
