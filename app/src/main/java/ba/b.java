package ba;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.annotation.RequiresApi;
import java.io.File;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAppDirectoryManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppDirectoryManager.kt\ncom/martian/libsupport/AppDirectoryManager\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,232:1\n13309#2,2:233\n*S KotlinDebug\n*F\n+ 1 AppDirectoryManager.kt\ncom/martian/libsupport/AppDirectoryManager\n*L\n163#1:233,2\n*E\n"})
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    @xi.k
    public static final b f1453a = new b();

    /* renamed from: b */
    public static Context f1454b;

    /* renamed from: c */
    @xi.k
    public static final String f1455c;

    /* renamed from: d */
    @xi.k
    public static final String f1456d;

    /* renamed from: e */
    @xi.k
    public static final String f1457e;

    /* renamed from: f */
    @xi.k
    public static final String f1458f;

    /* renamed from: g */
    @xi.k
    public static final String f1459g;

    /* renamed from: h */
    @xi.k
    public static final String f1460h;

    static {
        String str = File.separator;
        f1455c = "martian" + str + h3.e.f26408m;
        f1456d = "martian" + str + "fonts";
        f1457e = "martian" + str + "themes";
        f1458f = "martian" + str + "images";
        f1459g = "martian" + str + "databases";
        f1460h = "martian" + str + "store";
    }

    @JvmStatic
    public static final void a() {
        File i10 = i();
        if (i10 == null || !i10.isDirectory()) {
            return;
        }
        f1453a.c(i10);
    }

    @JvmStatic
    public static final void b() {
        Context context = f1454b;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, f1455c);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(externalFilesDir, f1456d);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        Context context3 = f1454b;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        } else {
            context2 = context3;
        }
        File externalCacheDir = context2.getExternalCacheDir();
        if (externalCacheDir != null) {
            File file3 = new File(externalCacheDir, f1458f);
            if (file3.exists()) {
                return;
            }
            file3.mkdirs();
        }
    }

    @JvmStatic
    @xi.k
    public static final String d() {
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            return separator;
        }
        return new File(externalCacheDir, f1458f).getPath() + File.separator;
    }

    @JvmStatic
    @xi.k
    public static final String e() {
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(f1459g);
        return (externalFilesDir != null ? externalFilesDir.getPath() : null) + File.separator;
    }

    @JvmStatic
    @xi.k
    public static final String f() {
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(f1455c);
        return (externalFilesDir != null ? externalFilesDir.getPath() : null) + File.separator;
    }

    @JvmStatic
    @xi.k
    public static final String g() {
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        return (externalFilesDir != null ? externalFilesDir.getPath() : null) + File.separator;
    }

    @JvmStatic
    @xi.k
    public static final String h(@xi.k String childDir) {
        Intrinsics.checkNotNullParameter(childDir, "childDir");
        File i10 = i();
        String path = i10 != null ? i10.getPath() : null;
        String str = File.separator;
        return path + str + childDir + str;
    }

    @JvmStatic
    @xi.l
    public static final File i() {
        Context context = null;
        if (!p()) {
            return null;
        }
        Context context2 = f1454b;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        } else {
            context = context2;
        }
        return context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    }

    @JvmStatic
    @xi.k
    public static final String j() {
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(f1456d);
        return (externalFilesDir != null ? externalFilesDir.getPath() : null) + File.separator;
    }

    @JvmStatic
    @xi.k
    public static final String k() {
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(f1460h);
        return (externalFilesDir != null ? externalFilesDir.getPath() : null) + File.separator;
    }

    @JvmStatic
    @xi.k
    public static final String l() {
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        File externalFilesDir = context.getExternalFilesDir(f1457e);
        return (externalFilesDir != null ? externalFilesDir.getPath() : null) + File.separator;
    }

    @JvmStatic
    @xi.k
    public static final String m() {
        String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        String str = File.separator;
        return file + str + "martian" + str + h3.e.f26408m + str;
    }

    @JvmStatic
    @xi.k
    public static final String n() {
        String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        String str = File.separator;
        return file + str + "martian" + str;
    }

    @JvmStatic
    public static final void o(@xi.k Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        f1454b = applicationContext;
        b();
    }

    @JvmStatic
    public static final boolean p() {
        String externalStorageState = Environment.getExternalStorageState();
        return Intrinsics.areEqual("mounted", externalStorageState) || Intrinsics.areEqual("mounted_ro", externalStorageState);
    }

    @JvmStatic
    public static final boolean q(@xi.k String directoryPath, @xi.k String fileName) {
        Intrinsics.checkNotNullParameter(directoryPath, "directoryPath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (Build.VERSION.SDK_INT < 30) {
            File file = new File(directoryPath, fileName);
            return file.exists() && file.canRead();
        }
        Context context = f1454b;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            context = null;
        }
        return r(context, fileName);
    }

    @JvmStatic
    @RequiresApi(29)
    public static final boolean r(@xi.k Context context, @xi.k String fileName) {
        Uri EXTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        EXTERNAL_CONTENT_URI = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
        Cursor query = contentResolver.query(EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name"}, "_display_name = ?", new String[]{fileName}, null);
        if (query == null) {
            return false;
        }
        Cursor cursor = query;
        try {
            boolean moveToFirst = cursor.moveToFirst();
            CloseableKt.closeFinally(cursor, null);
            return moveToFirst;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(cursor, th2);
                throw th3;
            }
        }
    }

    public final void c(File file) {
        File[] listFiles;
        if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    b bVar = f1453a;
                    Intrinsics.checkNotNull(file2);
                    bVar.c(file2);
                }
            }
            file.delete();
        }
    }
}
