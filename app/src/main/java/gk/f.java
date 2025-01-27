package gk;

import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: d */
    public static final f f26338d = new f();

    /* renamed from: a */
    public final qj.d f26339a;

    /* renamed from: b */
    public final qj.d f26340b;

    /* renamed from: c */
    public final qj.d f26341c;

    public f() {
        qj.d a10 = fk.d.b().e().a();
        if (a10 != null) {
            this.f26339a = a10;
        } else {
            this.f26339a = new zj.a();
        }
        qj.d c10 = fk.d.b().e().c();
        if (c10 != null) {
            this.f26340b = c10;
        } else {
            this.f26340b = new a();
        }
        qj.d d10 = fk.d.b().e().d();
        if (d10 != null) {
            this.f26341c = d10;
        } else {
            this.f26341c = e.c();
        }
    }

    public static qj.d a() {
        return f26338d.f26339a;
    }

    public static qj.d b(Executor executor) {
        return new b(executor);
    }

    public static qj.d c() {
        return d.c();
    }

    public static qj.d d() {
        return f26338d.f26340b;
    }

    public static qj.d e() {
        return f26338d.f26341c;
    }

    public static h f() {
        return new h();
    }

    public static qj.d g() {
        return k.e();
    }
}
