package com.martian.ttbook.b.a.g;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.d.e.c.a.e;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes4.dex */
public class c extends e {

    /* renamed from: b */
    public static String f14945b = "";

    /* renamed from: c */
    private String f14946c;

    /* renamed from: d */
    private String f14947d;

    /* renamed from: e */
    private Context f14948e;

    /* renamed from: f */
    private WeakReference<Activity> f14949f;

    /* renamed from: g */
    private int f14950g;

    /* renamed from: h */
    private WeakReference<ViewGroup> f14951h;

    /* renamed from: i */
    private b.d.e.c.a.g.a f14952i;

    /* renamed from: j */
    private int f14953j;
    private View k;
    private boolean l;
    private boolean m;
    private com.martian.ttbook.b.a.p.c n;

    public static class b extends e {

        /* renamed from: b */
        private String f14954b;

        /* renamed from: c */
        private Activity f14955c;

        /* renamed from: d */
        private Context f14956d;

        /* renamed from: f */
        private ViewGroup f14958f;

        /* renamed from: g */
        private View f14959g;

        /* renamed from: e */
        private int f14957e = 5000;

        /* renamed from: h */
        private int f14960h = 1;

        /* renamed from: i */
        private boolean f14961i = false;

        /* renamed from: j */
        private boolean f14962j = true;
        private com.martian.ttbook.b.a.p.c k = com.martian.ttbook.b.a.p.c.f15094a;

        public b(Context context) {
            this.f14956d = context;
        }

        public b e(int i2) {
            this.f14960h = i2;
            return this;
        }

        public b f(View view) {
            this.f14959g = view;
            return this;
        }

        public b g(String str) {
            this.f14954b = str;
            return this;
        }

        public b h(boolean z) {
            this.f14961i = z;
            return this;
        }

        public b i(int i2) {
            this.f14957e = i2;
            return this;
        }

        public c j() {
            c cVar = new c();
            cVar.f14949f = new WeakReference(this.f14955c);
            cVar.f14947d = this.f14954b;
            cVar.f14950g = this.f14957e;
            cVar.k = this.f14959g;
            cVar.f14948e = this.f14956d;
            cVar.f14951h = new WeakReference(this.f14958f);
            cVar.f14953j = this.f14960h;
            cVar.l = this.f14961i;
            cVar.m = this.f14962j;
            cVar.n = this.k;
            cVar.c(this);
            return cVar;
        }
    }

    private c() {
        this.f14950g = 5000;
        this.f14952i = b.d.e.c.a.g.a.f4621c;
        this.l = true;
        this.m = false;
        this.n = com.martian.ttbook.b.a.p.c.f15094a;
        this.f14946c = UUID.randomUUID().toString();
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    private boolean p() {
        return com.martian.ttbook.b.a.g.a.f().h();
    }

    public boolean A() {
        return this.l;
    }

    public void k(b.d.e.c.a.h.a aVar) {
        if (!p()) {
            aVar.b(b.d.e.c.a.f.e.f4609f);
        } else {
            this.f14952i = b.d.e.c.a.g.a.f4620b;
            b.d.e.c.a.l.b.b(this, aVar);
        }
    }

    public void l(b.d.e.c.a.l.c cVar) {
        if (!p()) {
            cVar.b(b.d.e.c.a.f.e.f4609f);
        } else {
            this.f14952i = b.d.e.c.a.g.a.f4619a;
            b.d.e.c.a.l.b.b(this, cVar);
        }
    }

    public Activity r() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f14949f;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return null;
        }
        return activity;
    }

    public ViewGroup s() {
        return this.f14951h.get();
    }

    public View t() {
        return this.k;
    }

    public String toString() {
        return "JuHeApiRequest{requestId='" + this.f14946c + "', codeId='" + this.f14947d + "', activityWeak=" + this.f14949f + ", timeoutMs=" + this.f14950g + ", adContainerWeak=" + this.f14951h + ", adType=" + this.f14952i + '}';
    }

    public b.d.e.c.a.g.a u() {
        return this.f14952i;
    }

    public String v() {
        return this.f14947d;
    }

    public Context w() {
        return this.f14948e;
    }

    public String x() {
        return this.f14946c;
    }

    public com.martian.ttbook.b.a.p.c y() {
        return this.n;
    }

    public boolean z() {
        return this.m;
    }
}
