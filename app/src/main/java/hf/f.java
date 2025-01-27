package hf;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a */
    public static final String f26696a = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: b */
    public static final String f26697b = "uil-images";

    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z10) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File c10 = (z10 && "mounted".equals(str) && f(context)) ? c(context) : null;
        if (c10 == null) {
            c10 = context.getCacheDir();
        }
        if (c10 != null) {
            return c10;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        d.i("Can't define system cache directory! '%s' will be used.", str2);
        return new File(str2);
    }

    public static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), h3.e.f26408m), context.getPackageName()), "cache");
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
        File a10 = a(context);
        File file = new File(a10, f26697b);
        return (file.exists() || file.mkdir()) ? file : a10;
    }

    public static File e(Context context, String str) {
        File file = ("mounted".equals(Environment.getExternalStorageState()) && f(context)) ? new File(Environment.getExternalStorageDirectory(), str) : null;
        return (file == null || !(file.exists() || file.mkdirs())) ? context.getCacheDir() : file;
    }

    public static boolean f(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
