package b.d.e.a.j;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f4533a = 255;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4534b = false;

    /* renamed from: c, reason: collision with root package name */
    private static FileWriter f4535c;

    /* renamed from: d, reason: collision with root package name */
    private static StringBuffer f4536d;

    /* renamed from: e, reason: collision with root package name */
    private static SimpleDateFormat f4537e;

    static {
        System.getProperty("line.separator");
    }

    static int a(int i2) {
        return (i2 ^ (-1)) & 255;
    }

    private static String b() {
        if (f4537e == null) {
            f4537e = new SimpleDateFormat(" yyyy-MM-dd hh:mm:ss SSS ");
        }
        return f4537e.format(new Date(System.currentTimeMillis()));
    }

    private static synchronized void c(String str) {
        synchronized (c.class) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    f4536d = new StringBuffer();
                    f4536d.append(" TIME:" + b());
                    f4536d.append(str + "\n");
                    String stringBuffer = f4536d.toString();
                    if (f4535c == null) {
                        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(file, "sdk.log");
                        Log.i("file", "file path = " + file2.getAbsolutePath());
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        if (file2.length() > 52428800) {
                            file2.delete();
                            file2 = new File(file, "sdk.log");
                        }
                        f4535c = new FileWriter(file2, true);
                    }
                    f4535c.write(stringBuffer);
                    f4535c.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(String str, String str2) {
        Log.i(str, " [AdSdk] " + str2);
    }

    public static void e(String str, String str2, Object... objArr) {
        if (i()) {
            if (objArr != null && objArr.length > 0) {
                try {
                    str2 = String.format(str2, objArr);
                } catch (Exception unused) {
                }
            }
            Log.i(str, " [AdSdk] " + str2);
            if (f4534b) {
                c(str2);
            }
        }
    }

    public static void f(boolean z) {
        f4533a = z ? a(51) : 255;
    }

    private static int g(int i2) {
        return 1 << ((i2 ^ (-1)) & 15);
    }

    public static void h(String str, String str2) {
        if (i()) {
            Log.i(str, " [AdSdk] " + str2);
            if (f4534b) {
                c(str2);
            }
        }
    }

    static boolean i() {
        return f4533a != 255 && (g(13) ^ l(f4533a)) == j(g(13) + k(8));
    }

    private static int j(int i2) {
        return 136 >> ((i2 ^ (-1)) & 15);
    }

    private static int k(int i2) {
        return (i2 ^ (-1)) & 15;
    }

    private static int l(int i2) {
        return (i2 >> 4) & 15;
    }
}
