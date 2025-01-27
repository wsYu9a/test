package com.aggmoread.sdk.z.b.h;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.b.e;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: o */
    public static String f4527o = "";

    /* renamed from: b */
    private String f4528b;

    /* renamed from: c */
    private String f4529c;

    /* renamed from: d */
    private Context f4530d;

    /* renamed from: e */
    private WeakReference<Activity> f4531e;

    /* renamed from: f */
    private int f4532f;

    /* renamed from: g */
    private WeakReference<ViewGroup> f4533g;

    /* renamed from: h */
    private com.aggmoread.sdk.z.b.i.a f4534h;

    /* renamed from: i */
    private int f4535i;

    /* renamed from: j */
    private View f4536j;

    /* renamed from: k */
    private boolean f4537k;

    /* renamed from: l */
    private boolean f4538l;

    /* renamed from: m */
    private boolean f4539m;

    /* renamed from: n */
    private com.aggmoread.sdk.z.b.t.e f4540n;

    public static class b extends e {

        /* renamed from: b */
        private String f4541b;

        /* renamed from: c */
        private Activity f4542c;

        /* renamed from: d */
        private Context f4543d;

        /* renamed from: f */
        private ViewGroup f4545f;

        /* renamed from: g */
        private View f4546g;

        /* renamed from: e */
        private int f4544e = 5000;

        /* renamed from: h */
        private int f4547h = 1;

        /* renamed from: i */
        private boolean f4548i = false;

        /* renamed from: j */
        private boolean f4549j = true;

        /* renamed from: k */
        private boolean f4550k = false;

        /* renamed from: l */
        private com.aggmoread.sdk.z.b.t.e f4551l = com.aggmoread.sdk.z.b.t.e.f4958k;

        public b(Context context) {
            if (context instanceof Activity) {
                this.f4542c = (Activity) context;
            }
            this.f4543d = context;
        }

        public b a(View view) {
            this.f4546g = view;
            return this;
        }

        public b b(int i10) {
            this.f4547h = i10;
            return this;
        }

        public b c(int i10) {
            this.f4544e = i10;
            return this;
        }

        public c d() {
            c cVar = new c();
            cVar.f4531e = new WeakReference(this.f4542c);
            cVar.f4529c = this.f4541b;
            cVar.f4532f = this.f4544e;
            cVar.f4536j = this.f4546g;
            cVar.f4530d = this.f4543d;
            cVar.f4533g = new WeakReference(this.f4545f);
            cVar.f4535i = this.f4547h;
            cVar.f4537k = this.f4548i;
            cVar.f4538l = this.f4549j;
            cVar.f4540n = this.f4551l;
            cVar.f4539m = this.f4550k;
            cVar.a(this);
            return cVar;
        }

        public b a(String str) {
            this.f4541b = str;
            return this;
        }

        public b b(boolean z10) {
            this.f4550k = z10;
            return this;
        }

        public b a(boolean z10) {
            this.f4548i = z10;
            return this;
        }
    }

    private c() {
        this.f4532f = 5000;
        this.f4534h = com.aggmoread.sdk.z.b.i.a.f4558h;
        this.f4537k = true;
        this.f4538l = false;
        this.f4539m = false;
        this.f4540n = com.aggmoread.sdk.z.b.t.e.f4958k;
        this.f4528b = UUID.randomUUID().toString();
    }

    private boolean d() {
        return com.aggmoread.sdk.z.b.h.a.d().f();
    }

    public Activity e() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f4531e;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return null;
        }
        return activity;
    }

    public ViewGroup f() {
        return this.f4533g.get();
    }

    public View g() {
        return this.f4536j;
    }

    public com.aggmoread.sdk.z.b.i.a h() {
        return this.f4534h;
    }

    public String i() {
        return this.f4529c;
    }

    public Context j() {
        return this.f4530d;
    }

    public String k() {
        return this.f4528b;
    }

    public com.aggmoread.sdk.z.b.t.e l() {
        return this.f4540n;
    }

    public boolean m() {
        return this.f4538l;
    }

    public boolean n() {
        return this.f4537k;
    }

    public boolean o() {
        return this.f4539m;
    }

    public String toString() {
        return "JuHeApiRequest{requestId='" + this.f4528b + "', codeId='" + this.f4529c + "', activityWeak=" + this.f4531e + ", timeoutMs=" + this.f4532f + ", adContainerWeak=" + this.f4533g + ", adType=" + this.f4534h + '}';
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public void a(com.aggmoread.sdk.z.b.f.a aVar) {
        if (!d()) {
            aVar.a(com.aggmoread.sdk.z.b.g.e.f4498h);
        } else {
            this.f4534h = com.aggmoread.sdk.z.b.i.a.f4555e;
            com.aggmoread.sdk.z.b.s.b.a(this, aVar);
        }
    }

    public void a(com.aggmoread.sdk.z.b.k.a aVar) {
        if (!d()) {
            aVar.a(com.aggmoread.sdk.z.b.g.e.f4498h);
        } else {
            this.f4534h = com.aggmoread.sdk.z.b.i.a.f4554d;
            com.aggmoread.sdk.z.b.s.b.a(this, aVar);
        }
    }

    public void a(com.aggmoread.sdk.z.b.l.a aVar) {
        if (!d()) {
            aVar.a(com.aggmoread.sdk.z.b.g.e.f4498h);
        } else {
            this.f4534h = com.aggmoread.sdk.z.b.i.a.f4553c;
            com.aggmoread.sdk.z.b.s.b.a(this, aVar);
        }
    }

    public void a(com.aggmoread.sdk.z.b.s.c cVar) {
        if (!d()) {
            cVar.a(com.aggmoread.sdk.z.b.g.e.f4498h);
        } else {
            this.f4534h = com.aggmoread.sdk.z.b.i.a.f4556f;
            com.aggmoread.sdk.z.b.s.b.a(this, cVar);
        }
    }

    public void a(com.aggmoread.sdk.z.b.s.e eVar) {
        if (!d()) {
            eVar.a(com.aggmoread.sdk.z.b.g.e.f4498h);
        } else {
            this.f4534h = com.aggmoread.sdk.z.b.i.a.f4552b;
            com.aggmoread.sdk.z.b.s.b.a(this, eVar);
        }
    }
}
