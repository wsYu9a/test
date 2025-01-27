package com.aggmoread.sdk.z.b;

import android.os.Environment;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.downloader.core.download.g;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static int f4374a = 255;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4375b = false;

    /* renamed from: c, reason: collision with root package name */
    static final String f4376c = System.getProperty("line.separator");

    /* renamed from: d, reason: collision with root package name */
    private static FileWriter f4377d;

    /* renamed from: e, reason: collision with root package name */
    private static StringBuffer f4378e;

    /* renamed from: f, reason: collision with root package name */
    private static SimpleDateFormat f4379f;

    public static int a(int i10) {
        return (~i10) & 255;
    }

    private static int b(int i10) {
        return 1 << ((~i10) & 15);
    }

    private static int c(int i10) {
        return TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME >> ((~i10) & 15);
    }

    private static int d(int i10) {
        return (~i10) & 15;
    }

    private static int e(int i10) {
        return (i10 >> 4) & 15;
    }

    private static String a() {
        if (f4379f == null) {
            f4379f = new SimpleDateFormat(" yyyy-MM-dd hh:mm:ss SSS ");
        }
        return f4379f.format(new Date(System.currentTimeMillis()));
    }

    public static void b(String str, String str2) {
        Log.i(str, " [AdSdk] " + str2);
    }

    public static void c(String str, String str2) {
        if (b()) {
            Log.i(str, " [AdSdk] " + str2);
            if (f4375b) {
                a(str2);
            }
        }
    }

    public static void d(String str, String str2) {
        if (b()) {
            try {
                if (str.startsWith("{")) {
                    str = new JSONObject(str).toString(4);
                } else if (str.startsWith("[")) {
                    str = new JSONArray(str).toString(4);
                }
            } catch (JSONException unused) {
            }
            a("AdSdk", true);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            String str3 = f4376c;
            sb2.append(str3);
            sb2.append(str);
            for (String str4 : sb2.toString().split(str3)) {
                c("AdSdk", "* " + str4);
            }
            a("AdSdk", false);
        }
    }

    public static void e(String str, String str2) {
        a(str, str2, (Throwable) null);
    }

    private static synchronized void a(String str) {
        synchronized (d.class) {
            try {
                try {
                    if (Environment.getExternalStorageState().equals("mounted")) {
                        f4378e = new StringBuffer();
                        f4378e.append(" TIME:" + a());
                        f4378e.append(str + "\n");
                        String stringBuffer = f4378e.toString();
                        if (f4377d == null) {
                            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);
                            if (!file.exists()) {
                                file.mkdir();
                            }
                            File file2 = new File(file, "sdk.log");
                            Log.i(k.f18193y, "file path = " + file2.getAbsolutePath());
                            if (!file2.exists()) {
                                file2.createNewFile();
                            }
                            if (file2.length() > g.f19256f) {
                                file2.delete();
                                file2 = new File(file, "sdk.log");
                            }
                            f4377d = new FileWriter(file2, true);
                        }
                        f4377d.write(stringBuffer);
                        f4377d.flush();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean b() {
        return f4374a != 255 && (b(13) ^ e(f4374a)) == c(b(13) + d(8));
    }

    public static void a(String str, String str2) {
        if (b()) {
            Log.d(str, " [AdSdk] " + str2);
            if (f4375b) {
                a(str2);
            }
        }
    }

    public static void a(String str, String str2, Throwable th2) {
        if (b()) {
            Log.w(str, " [AdSdk] " + str2, th2);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        if (b()) {
            if (objArr != null && objArr.length > 0) {
                try {
                    str2 = String.format(str2, objArr);
                } catch (Exception unused) {
                }
            }
            Log.i(str, " [AdSdk] " + str2);
            if (f4375b) {
                a(str2);
            }
        }
    }

    public static void a(String str, Throwable th2) {
        a(str, "", th2);
    }

    public static void a(String str, boolean z10) {
        c(str, "***********************************************");
    }

    public static void a(boolean z10) {
        f4374a = z10 ? a(51) : 255;
    }
}
