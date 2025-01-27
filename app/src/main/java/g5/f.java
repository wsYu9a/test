package g5;

import b5.u;
import com.google.common.util.concurrent.p;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@e
/* loaded from: classes2.dex */
public class f {

    /* renamed from: f */
    public static final Logger f26132f = Logger.getLogger(f.class.getName());

    /* renamed from: a */
    public final String f26133a;

    /* renamed from: b */
    public final Executor f26134b;

    /* renamed from: c */
    public final l f26135c;

    /* renamed from: d */
    public final m f26136d;

    /* renamed from: e */
    public final d f26137e;

    public static final class a implements l {

        /* renamed from: a */
        public static final a f26138a = new a();

        public static Logger b(k kVar) {
            String name = f.class.getName();
            String c10 = kVar.b().c();
            StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(c10).length());
            sb2.append(name);
            sb2.append(p1.b.f29697h);
            sb2.append(c10);
            return Logger.getLogger(sb2.toString());
        }

        public static String c(k kVar) {
            Method d10 = kVar.d();
            String name = d10.getName();
            String name2 = d10.getParameterTypes()[0].getName();
            String valueOf = String.valueOf(kVar.c());
            String valueOf2 = String.valueOf(kVar.a());
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 80 + name2.length() + valueOf.length() + valueOf2.length());
            sb2.append("Exception thrown by subscriber method ");
            sb2.append(name);
            sb2.append('(');
            sb2.append(name2);
            sb2.append(')');
            sb2.append(" on subscriber ");
            sb2.append(valueOf);
            sb2.append(" when dispatching event: ");
            sb2.append(valueOf2);
            return sb2.toString();
        }

        @Override // g5.l
        public void a(Throwable th2, k kVar) {
            Logger b10 = b(kVar);
            Level level = Level.SEVERE;
            if (b10.isLoggable(level)) {
                b10.log(level, c(kVar), th2);
            }
        }
    }

    public f() {
        this(DownloadSettingKeys.BugFix.DEFAULT);
    }

    public final Executor a() {
        return this.f26134b;
    }

    public void b(Throwable th2, k kVar) {
        u.E(th2);
        u.E(kVar);
        try {
            this.f26135c.a(th2, kVar);
        } catch (Throwable th3) {
            f26132f.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", th3, th2), th3);
        }
    }

    public final String c() {
        return this.f26133a;
    }

    public void d(Object obj) {
        Iterator<j> f10 = this.f26136d.f(obj);
        if (f10.hasNext()) {
            this.f26137e.a(obj, f10);
        } else {
            if (obj instanceof c) {
                return;
            }
            d(new c(this, obj));
        }
    }

    public void e(Object obj) {
        this.f26136d.h(obj);
    }

    public void f(Object obj) {
        this.f26136d.i(obj);
    }

    public String toString() {
        return com.google.common.base.a.c(this).s(this.f26133a).toString();
    }

    public f(String str) {
        this(str, p.c(), d.d(), a.f26138a);
    }

    public f(l lVar) {
        this(DownloadSettingKeys.BugFix.DEFAULT, p.c(), d.d(), lVar);
    }

    public f(String str, Executor executor, d dVar, l lVar) {
        this.f26136d = new m(this);
        this.f26133a = (String) u.E(str);
        this.f26134b = (Executor) u.E(executor);
        this.f26137e = (d) u.E(dVar);
        this.f26135c = (l) u.E(lVar);
    }
}
