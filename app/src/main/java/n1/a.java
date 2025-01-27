package n1;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final String f28719a = "NTeRQWvye18AkPd6G";

    /* renamed from: b */
    public static final String f28720b = "wmHzgD4lOj5o4241";

    /* renamed from: c */
    public static volatile a f28721c = null;

    /* renamed from: d */
    public static volatile boolean f28722d = false;

    /* renamed from: e */
    public static ILogger f28723e;

    @Deprecated
    public static void b() {
        b.g();
    }

    @Deprecated
    public static boolean f() {
        return b.k();
    }

    public static boolean g() {
        return b.l();
    }

    @Deprecated
    public static synchronized void i() {
        synchronized (a.class) {
            b.n();
        }
    }

    public static a j() {
        if (!f28722d) {
            throw new InitException("ARouter::Init::Invoke init(context) first!");
        }
        if (f28721c == null) {
            synchronized (a.class) {
                try {
                    if (f28721c == null) {
                        f28721c = new a();
                    }
                } finally {
                }
            }
        }
        return f28721c;
    }

    public static void k(Application application) {
        if (f28722d) {
            return;
        }
        ILogger iLogger = b.f28724a;
        f28723e = iLogger;
        iLogger.info("ARouter::", "ARouter init start.");
        f28722d = b.q(application);
        if (f28722d) {
            b.f();
        }
        b.f28724a.info("ARouter::", "ARouter init over.");
    }

    public static boolean m() {
        return b.s();
    }

    public static synchronized void n() {
        synchronized (a.class) {
            b.t();
        }
    }

    public static synchronized void q() {
        synchronized (a.class) {
            b.w();
        }
    }

    public static synchronized void r() {
        synchronized (a.class) {
            b.x();
        }
    }

    public static synchronized void s() {
        synchronized (a.class) {
            b.y();
        }
    }

    public static synchronized void t(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (a.class) {
            b.A(threadPoolExecutor);
        }
    }

    public static void u(ILogger iLogger) {
        b.B(iLogger);
    }

    public boolean a(IRouteGroup iRouteGroup) {
        return b.p().e(iRouteGroup);
    }

    public Postcard c(Uri uri) {
        return b.p().h(uri);
    }

    public Postcard d(String str) {
        return b.p().i(str);
    }

    @Deprecated
    public Postcard e(String str, String str2) {
        return b.p().j(str, str2, Boolean.FALSE);
    }

    public synchronized void h() {
        b.m();
        f28722d = false;
    }

    public void l(Object obj) {
        b.r(obj);
    }

    public Object o(Context context, Postcard postcard, int i10, NavigationCallback navigationCallback) {
        return b.p().u(context, postcard, i10, navigationCallback);
    }

    public <T> T p(Class<? extends T> cls) {
        return (T) b.p().v(cls);
    }
}
