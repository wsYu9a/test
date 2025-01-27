package b.g.a.b;

import android.content.Context;
import android.os.Environment;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.File;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a */
    private static final String f4921a = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: b */
    private static final String f4922b = "uil-images";

    private f() {
    }

    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File c2 = (z && "mounted".equals(str) && f(context)) ? c(context) : null;
        if (c2 == null) {
            c2 = context.getCacheDir();
        }
        if (c2 != null) {
            return c2;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        d.i("Can't define system cache directory! '%s' will be used.", str2);
        return new File(str2);
    }

    private static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), MiConfigSingleton.t0), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                d.i("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                d.g("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    public static File d(Context context) {
        File a2 = a(context);
        File file = new File(a2, f4922b);
        return (file.exists() || file.mkdir()) ? file : a2;
    }

    public static File e(Context context, String str) {
        File file = ("mounted".equals(Environment.getExternalStorageState()) && f(context)) ? new File(Environment.getExternalStorageDirectory(), str) : null;
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    private static boolean f(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
