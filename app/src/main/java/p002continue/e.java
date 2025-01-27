package p002continue;

import bh.b;
import java.util.ArrayList;
import java.util.List;
import p002continue.c;

/* loaded from: classes4.dex */
public abstract class e {

    /* renamed from: a */
    public final List<Class<? extends p002continue.c<?>>> f25205a = new ArrayList();

    public static final class a extends e {
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        public a(Creturn creturn) {
            this.f25205a.add(c.q.class);
            this.f25205a.add(c.j.class);
            this.f25205a.add(c.g.class);
            this.f25205a.add(c.b.class);
        }

        @Override // p002continue.e
        public final String a() {
            return "DownloadState";
        }
    }

    public static final class b extends e {
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        public b(Creturn creturn) {
            this.f25205a.add(c.o.class);
            this.f25205a.add(c.d.class);
            this.f25205a.add(c.C0683c.class);
            this.f25205a.add(c.m.class);
            this.f25205a.add(c.i.class);
            this.f25205a.add(c.a.class);
        }

        @Override // p002continue.e
        public final String a() {
            return "LoadState";
        }
    }

    public static final class c extends e {
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        public c(Creturn creturn) {
            this.f25205a.add(c.e.class);
            this.f25205a.add(p002continue.d.class);
            this.f25205a.add(c.k.class);
            this.f25205a.add(c.f.class);
        }

        @Override // p002continue.e
        public final String a() {
            return "InitState";
        }
    }

    public static final class d extends e {
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        public d(Creturn creturn) {
            this.f25205a.add(c.p.class);
            this.f25205a.add(c.h.class);
            this.f25205a.add(c.n.class);
        }

        @Override // p002continue.e
        public final String a() {
            return "QueryState";
        }
    }

    public abstract String a();

    public final void b(p002continue.c<?> cVar, String str) {
        String str2;
        Throwable th2 = cVar.f25197e;
        try {
            str2 = cVar.c();
        } catch (Exception unused) {
            str2 = "";
        }
        if (th2 == null) {
            b.a.f1608a.i("State", "%s State:%s event:%s toReportValue=%s", str, a(), cVar.f25193a, str2);
        } else {
            b.a.f1608a.n("State", th2, "%s State:%s event:%s toReportValue=%s", str, a(), cVar.f25193a, str2);
        }
    }
}
