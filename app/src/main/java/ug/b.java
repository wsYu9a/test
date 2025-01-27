package ug;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.tanx.onlyid.api.IdStorageManager;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: b */
    public static volatile b f31066b = null;

    /* renamed from: c */
    public static volatile boolean f31067c = false;

    /* renamed from: d */
    public static volatile String f31068d;

    /* renamed from: e */
    public static volatile String f31069e;

    /* renamed from: f */
    public static volatile String f31070f;

    /* renamed from: g */
    public static volatile String f31071g;

    /* renamed from: h */
    public static volatile String f31072h;

    /* renamed from: i */
    public static volatile String f31073i;

    /* renamed from: j */
    public static volatile String f31074j;

    /* renamed from: a */
    public Application f31075a;

    public class a implements c {

        /* renamed from: a */
        public final /* synthetic */ c f31076a;

        public a(c cVar) {
            this.f31076a = cVar;
        }

        @Override // ug.c
        public void oaidError(Exception exc) {
            String unused = b.f31070f = "";
            c cVar = this.f31076a;
            if (cVar != null) {
                cVar.oaidError(exc);
            }
        }

        @Override // ug.c
        public void oaidSucc(String str) {
            String unused = b.f31070f = str;
            c cVar = this.f31076a;
            if (cVar != null) {
                cVar.oaidSucc(b.f31070f);
            }
        }
    }

    public static b h() {
        if (f31066b == null) {
            synchronized (b.class) {
                try {
                    if (f31066b == null) {
                        f31066b = new b();
                    }
                } finally {
                }
            }
        }
        return f31066b;
    }

    public String c(Context context) {
        if (f31071g == null) {
            f31071g = IdStorageManager.c(this.f31075a).d(IdStorageManager.f21981g);
            if (TextUtils.isEmpty(f31071g)) {
                f31071g = ug.a.b(context);
                IdStorageManager.c(this.f31075a).e(IdStorageManager.f21981g, f31071g);
            }
        }
        if (f31071g == null) {
            f31071g = "";
        }
        return f31071g;
    }

    public String d() {
        if (TextUtils.isEmpty(f31068d)) {
            f31068d = IdStorageManager.c(this.f31075a).d(IdStorageManager.f21980f);
            if (TextUtils.isEmpty(f31068d)) {
                f31068d = ug.a.d();
                IdStorageManager.c(this.f31075a).e(IdStorageManager.f21980f, f31068d);
            }
        }
        if (f31068d == null) {
            f31068d = "";
        }
        return f31068d;
    }

    public String e(Context context) {
        if (f31074j == null) {
            f31074j = ug.a.f(context);
            if (f31074j == null) {
                f31074j = "";
            }
        }
        return f31074j;
    }

    public String f(Context context) {
        return g(context, false);
    }

    public String g(Context context, boolean z10) {
        if (TextUtils.isEmpty(f31069e)) {
            f31069e = IdStorageManager.c(this.f31075a).d(IdStorageManager.f21979e);
            if (TextUtils.isEmpty(f31069e) && !z10) {
                f31069e = ug.a.m(context);
                IdStorageManager.c(this.f31075a).e(IdStorageManager.f21979e, f31069e);
            }
        }
        if (f31069e == null) {
            f31069e = "";
        }
        return f31069e;
    }

    public String i(Context context) {
        return j(context, false);
    }

    public String j(Context context, boolean z10) {
        return k(context, z10, null);
    }

    public String k(Context context, boolean z10, c cVar) {
        if (TextUtils.isEmpty(f31070f)) {
            f31070f = ug.a.j();
            if (TextUtils.isEmpty(f31070f)) {
                f31070f = IdStorageManager.c(this.f31075a).d(IdStorageManager.f21978d);
            }
            if (TextUtils.isEmpty(f31070f) && !z10) {
                ug.a.k(context, new a(cVar));
            }
        }
        if (f31070f == null) {
            f31070f = "";
        }
        if (cVar != null) {
            cVar.oaidSucc(f31070f);
        }
        return f31070f;
    }

    public String l() {
        if (f31073i == null) {
            f31073i = IdStorageManager.c(this.f31075a).d(IdStorageManager.f21983i);
            if (TextUtils.isEmpty(f31073i)) {
                f31073i = ug.a.l();
                IdStorageManager.c(this.f31075a).e(IdStorageManager.f21983i, f31073i);
            }
        }
        if (f31073i == null) {
            f31073i = "";
        }
        return f31073i;
    }

    public String m() {
        if (f31072h == null) {
            f31072h = IdStorageManager.c(this.f31075a).d(IdStorageManager.f21982h);
            if (TextUtils.isEmpty(f31072h)) {
                f31072h = ug.a.q();
                IdStorageManager.c(this.f31075a).e(IdStorageManager.f21982h, f31072h);
            }
        }
        if (f31072h == null) {
            f31072h = "";
        }
        return f31072h;
    }

    public void n(Application application) {
        o(application, false);
    }

    public void o(Application application, boolean z10) {
        this.f31075a = application;
        if (f31067c) {
            return;
        }
        ug.a.r(application);
        f31067c = true;
        e.a(z10);
    }
}
