package rx.n;

import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a */
    private static final f f36955a = new f();

    /* renamed from: b */
    private final rx.d f36956b;

    /* renamed from: c */
    private final rx.d f36957c;

    /* renamed from: d */
    private final rx.d f36958d;

    private f() {
        rx.d a2 = rx.m.d.b().e().a();
        if (a2 != null) {
            this.f36956b = a2;
        } else {
            this.f36956b = new rx.internal.schedulers.a();
        }
        rx.d c2 = rx.m.d.b().e().c();
        if (c2 != null) {
            this.f36957c = c2;
        } else {
            this.f36957c = new a();
        }
        rx.d d2 = rx.m.d.b().e().d();
        if (d2 != null) {
            this.f36958d = d2;
        } else {
            this.f36958d = e.c();
        }
    }

    public static rx.d a() {
        return f36955a.f36956b;
    }

    public static rx.d b(Executor executor) {
        return new b(executor);
    }

    public static rx.d c() {
        return d.c();
    }

    public static rx.d d() {
        return f36955a.f36957c;
    }

    public static rx.d e() {
        return f36955a.f36958d;
    }

    public static h f() {
        return new h();
    }

    public static rx.d g() {
        return k.e();
    }
}
