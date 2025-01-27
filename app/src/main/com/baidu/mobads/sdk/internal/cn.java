package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class cn implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public static String f7064a = "";

    /* renamed from: b */
    private static final String f7065b = "remote";

    /* renamed from: c */
    private static final String f7066c = "proxy";

    /* renamed from: d */
    private static final String f7067d = "third-mtj";

    /* renamed from: e */
    private static final String f7068e = "third-cpu";

    /* renamed from: f */
    private static final String f7069f = "third-cpu-cyber";

    /* renamed from: g */
    private static final String f7070g = "third-novel";

    /* renamed from: h */
    private static final String f7071h = "third-aigc";

    /* renamed from: i */
    private static final String f7072i = "third-aigc-virtual";

    /* renamed from: j */
    private static final String f7073j = "third-aigc-speech";

    /* renamed from: k */
    private static Thread.UncaughtExceptionHandler f7074k = null;

    /* renamed from: l */
    private static volatile cn f7075l = null;

    /* renamed from: o */
    private static final String f7076o = "key_crash_source";

    /* renamed from: p */
    private static final String f7077p = "key_crash_trace";

    /* renamed from: q */
    private static final String f7078q = "key_crash_ad";

    /* renamed from: m */
    private Context f7079m;

    /* renamed from: n */
    private a f7080n;

    public interface a {
        void a(String str);
    }

    private cn(Context context) {
        this.f7079m = context.getApplicationContext();
        f7074k = Thread.getDefaultUncaughtExceptionHandler();
    }

    private List<String> d() {
        IXAdContainerFactory c10;
        ArrayList arrayList = new ArrayList();
        try {
            aa a10 = aa.a();
            if (a10 != null && (c10 = a10.c()) != null) {
                Object remoteParam = c10.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private SharedPreferences e() {
        return this.f7079m.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() {
        return e().edit();
    }

    public void g() {
        SharedPreferences.Editor f10 = f();
        f10.clear();
        f10.apply();
    }

    public void c() {
        this.f7080n = null;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            String a10 = a(th2);
            if (a10 != null) {
                a(a10, Log.getStackTraceString(th2));
                a aVar = this.f7080n;
                if (aVar != null) {
                    aVar.a(a10);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f7074k;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        } catch (Exception e10) {
            bt.a().c(e10);
        }
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cn) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static cn a(Context context) {
        if (f7075l == null) {
            synchronized (cn.class) {
                try {
                    if (f7075l == null) {
                        f7075l = new cn(context);
                    }
                } finally {
                }
            }
        }
        return f7075l;
    }

    public void a() {
        bd.a().a((j) new co(this));
    }

    public void a(a aVar) {
        this.f7080n = aVar;
    }

    private String a(Throwable th2) {
        Throwable cause = th2.getCause();
        if (cause != null) {
            th2 = cause;
        }
        StackTraceElement[] stackTrace = th2.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        List<String> d10 = d();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("junit.framework")) {
                return null;
            }
            if (!className.startsWith(z.as) && !className.startsWith(z.at) && !className.startsWith(z.au)) {
                if (!className.startsWith(z.av) && !className.startsWith(z.aw) && !className.startsWith(z.ax)) {
                    if (className.startsWith(z.ay)) {
                        return f7067d;
                    }
                    if (className.startsWith(z.az)) {
                        return f7068e;
                    }
                    if (className.startsWith(z.aA) || className.startsWith(z.aB)) {
                        return f7069f;
                    }
                    if (className.startsWith(z.aJ)) {
                        return f7073j;
                    }
                    if (!className.startsWith(z.aF) && !className.startsWith(z.aG) && !className.startsWith(z.aH) && !className.startsWith(z.aI)) {
                        if (className.startsWith(z.aE)) {
                            return f7071h;
                        }
                        if (!className.startsWith(z.aC) && !className.startsWith(z.aD)) {
                            if (a(className, d10)) {
                            }
                        } else if (cm.f7061g.booleanValue()) {
                            return f7070g;
                        }
                    } else {
                        return f7072i;
                    }
                } else {
                    return f7066c;
                }
            }
            return f7065b;
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
        SharedPreferences.Editor f10 = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + " ";
        f10.putString(f7076o, str);
        f10.putString(f7077p, str3 + str2);
        f10.putString(f7078q, f7064a);
        f10.commit();
    }

    public String a(String str) {
        return e().getString(str, "");
    }
}
