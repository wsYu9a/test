package b.d.e.c.a;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f4552a = 255;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4553b = false;

    /* renamed from: c, reason: collision with root package name */
    static final String f4554c = System.getProperty("line.separator");

    /* renamed from: d, reason: collision with root package name */
    private static FileWriter f4555d;

    /* renamed from: e, reason: collision with root package name */
    private static StringBuffer f4556e;

    /* renamed from: f, reason: collision with root package name */
    private static SimpleDateFormat f4557f;

    static int a(int i2) {
        return (i2 ^ (-1)) & 255;
    }

    private static String b() {
        if (f4557f == null) {
            f4557f = new SimpleDateFormat(" yyyy-MM-dd hh:mm:ss SSS ");
        }
        return f4557f.format(new Date(System.currentTimeMillis()));
    }

    private static synchronized void c(String str) {
        synchronized (d.class) {
            try {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    f4556e = new StringBuffer();
                    f4556e.append(" TIME:" + b());
                    f4556e.append(str + "\n");
                    String stringBuffer = f4556e.toString();
                    if (f4555d == null) {
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
                        f4555d = new FileWriter(file2, true);
                    }
                    f4555d.write(stringBuffer);
                    f4555d.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void d(String str, String str2) {
        if (l()) {
            Log.d(str, " [AdSdk] " + str2);
            if (f4553b) {
                c(str2);
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (l()) {
            Log.w(str, " [AdSdk] " + str2, th);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (l()) {
            if (objArr != null && objArr.length > 0) {
                try {
                    str2 = String.format(str2, objArr);
                } catch (Exception unused) {
                }
            }
            Log.i(str, " [AdSdk] " + str2);
            if (f4553b) {
                c(str2);
            }
        }
    }

    public static void g(String str, Throwable th) {
        e(str, "", th);
    }

    static void h(String str, boolean z) {
        k(str, "***********************************************");
    }

    public static void i(boolean z) {
        f4552a = z ? a(51) : 255;
    }

    private static int j(int i2) {
        return 1 << ((i2 ^ (-1)) & 15);
    }

    public static void k(String str, String str2) {
        if (l()) {
            Log.i(str, " [AdSdk] " + str2);
            if (f4553b) {
                c(str2);
            }
        }
    }

    static boolean l() {
        return f4552a != 255 && (j(13) ^ q(f4552a)) == m(j(13) + o(8));
    }

    private static int m(int i2) {
        return 136 >> ((i2 ^ (-1)) & 15);
    }

    public static void n(String str, String str2) {
        if (l()) {
            try {
                if (str.startsWith("{")) {
                    str = new JSONObject(str).toString(4);
                } else if (str.startsWith("[")) {
                    str = new JSONArray(str).toString(4);
                }
            } catch (JSONException unused) {
            }
            h("AdSdk", true);
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            String str3 = f4554c;
            sb.append(str3);
            sb.append(str);
            for (String str4 : sb.toString().split(str3)) {
                k("AdSdk", "* " + str4);
            }
            h("AdSdk", false);
        }
    }

    private static int o(int i2) {
        return (i2 ^ (-1)) & 15;
    }

    public static void p(String str, String str2) {
        e(str, str2, null);
    }

    private static int q(int i2) {
        return (i2 >> 4) & 15;
    }
}
