package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ck implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public static String f5730a = "";

    /* renamed from: b */
    private static final String f5731b = "remote";

    /* renamed from: c */
    private static final String f5732c = "proxy";

    /* renamed from: d */
    private static final String f5733d = "third-mtj";

    /* renamed from: e */
    private static final String f5734e = "third-novel";

    /* renamed from: f */
    private static Thread.UncaughtExceptionHandler f5735f = null;

    /* renamed from: g */
    private static volatile ck f5736g = null;

    /* renamed from: j */
    private static final String f5737j = "key_crash_source";
    private static final String k = "key_crash_trace";
    private static final String l = "key_crash_ad";

    /* renamed from: h */
    private Context f5738h;

    /* renamed from: i */
    private a f5739i;

    interface a {
        void a(String str);
    }

    private ck(Context context) {
        this.f5738h = context.getApplicationContext();
        f5735f = Thread.getDefaultUncaughtExceptionHandler();
    }

    private List<String> d() {
        IXAdContainerFactory c2;
        ArrayList arrayList = new ArrayList();
        try {
            z a2 = z.a();
            if (a2 != null && (c2 = a2.c()) != null) {
                Object remoteParam = c2.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.f5738h.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    public void g() {
        SharedPreferences.Editor f2 = f();
        f2.clear();
        f2.apply();
    }

    public void c() {
        this.f5739i = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String a2 = a(th);
            if (a2 != null) {
                a(a2, Log.getStackTraceString(th));
                a aVar = this.f5739i;
                if (aVar != null) {
                    aVar.a(a2);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f5735f;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bq.a().c(e2);
        }
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof ck) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static ck a(Context context) {
        if (f5736g == null) {
            synchronized (ck.class) {
                if (f5736g == null) {
                    f5736g = new ck(context);
                }
            }
        }
        return f5736g;
    }

    public void a() {
        ba.a().a((h) new cl(this));
    }

    public void a(a aVar) {
        this.f5739i = aVar;
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            List<String> d2 = d();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className.startsWith("junit.framework")) {
                    break;
                }
                if (className.startsWith(w.aq) || className.startsWith(w.ar) || className.startsWith(w.as)) {
                    return f5731b;
                }
                if (className.startsWith(w.at) || className.startsWith(w.au) || className.startsWith(w.av)) {
                    return f5732c;
                }
                if (className.startsWith(w.aw)) {
                    return f5733d;
                }
                if (!className.startsWith(w.ax) && !className.startsWith(w.ay)) {
                    if (a(className, d2)) {
                        return f5731b;
                    }
                } else if (cj.f5728g.booleanValue()) {
                    return f5734e;
                }
            }
        }
        return null;
    }

    private boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor f2 = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + " ";
        f2.putString(f5737j, str);
        f2.putString(k, str3 + str2);
        f2.putString(l, f5730a);
        f2.commit();
    }

    public String a(String str) {
        return e().getString(str, "");
    }
}
