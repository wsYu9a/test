package b.h.a.e;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.opos.acs.st.STManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    public static volatile String f4967a = "";

    /* renamed from: b */
    private static final Object f4968b = new Object();

    /* renamed from: c */
    private static int f4969c = -1;

    /* renamed from: d */
    private static String f4970d = "";

    /* renamed from: e */
    private static Context f4971e;

    /* renamed from: f */
    private static String f4972f;

    public static Context a() {
        return f4971e;
    }

    private static String b(String str, String str2) {
        return (String) j.b(j.a("android.os.SystemProperties"), MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, new Object[]{str, str2});
    }

    public static void c(Context context) {
        if (context != null) {
            f4971e = context.getApplicationContext();
        }
    }

    public static String d(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static boolean e() {
        return !"cn".equalsIgnoreCase(i());
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(f4970d) && context != null) {
            try {
                f4970d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
            }
        }
        return f4970d;
    }

    public static boolean g() {
        return "in".equalsIgnoreCase(i());
    }

    public static int h(Context context) {
        if (-1 == f4969c && context != null) {
            try {
                f4969c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
            }
        }
        return f4969c;
    }

    private static String i() {
        if (f4972f == null) {
            k();
        }
        return f4972f;
    }

    public static String j(Context context) {
        String str;
        if (f4967a != null) {
            return f4967a;
        }
        synchronized (f4968b) {
            if (f4967a != null) {
                str = f4967a;
            } else {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
                Iterator<ActivityManager.RunningAppProcessInfo> it = (runningAppProcesses == null || runningAppProcesses.isEmpty()) ? null : runningAppProcesses.iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next != null && next.pid == Process.myPid()) {
                            str = next.processName;
                            break;
                        }
                    }
                }
                str = null;
                f4967a = str;
            }
        }
        return str;
    }

    private static void k() {
        String b2 = f.b();
        if (!TextUtils.isEmpty(b2) && b2.trim().equalsIgnoreCase(g.f4986g)) {
            String b3 = b("persist.sys.oem.region", STManager.REGION_OF_CN);
            f4972f = b3;
            if ("OverSeas".equalsIgnoreCase(b3)) {
                String country = f4971e.getResources().getConfiguration().locale.getCountry();
                if (STManager.REGION_OF_CN.equalsIgnoreCase(country)) {
                    country = "OC";
                }
                f4972f = country;
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder("persist.sys.");
        String str = g.f4981b;
        sb.append(str);
        sb.append(".region");
        String b4 = b(sb.toString(), STManager.REGION_OF_CN);
        f4972f = b4;
        if ("oc".equalsIgnoreCase(b4)) {
            if (f4971e.getPackageManager().hasSystemFeature(str + ".version.exp")) {
                return;
            }
            f4972f = STManager.REGION_OF_CN;
        }
    }
}
