package com.aggmoread.sdk.z.a.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.b.e;
import com.aggmoread.sdk.z.b.s.c;
import com.aggmoread.sdk.z.b.s.d;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b */
    private String f4225b;

    /* renamed from: c */
    private String f4226c;

    /* renamed from: d */
    private String f4227d;

    /* renamed from: e */
    private String f4228e;

    /* renamed from: f */
    private String f4229f;

    /* renamed from: g */
    private String f4230g;

    /* renamed from: h */
    private Context f4231h;

    /* renamed from: i */
    private WeakReference<Activity> f4232i;

    /* renamed from: j */
    private int f4233j;

    /* renamed from: k */
    private WeakReference<ViewGroup> f4234k;

    /* renamed from: l */
    private com.aggmoread.sdk.z.b.i.a f4235l;

    /* renamed from: m */
    private int f4236m;

    /* renamed from: n */
    private View f4237n;

    /* renamed from: o */
    private int f4238o;

    /* renamed from: p */
    private int f4239p;

    /* renamed from: q */
    private int f4240q;

    /* renamed from: r */
    private boolean f4241r;

    /* renamed from: s */
    private boolean f4242s;

    /* renamed from: t */
    private boolean f4243t;

    /* renamed from: u */
    private String f4244u;

    /* renamed from: v */
    private String f4245v;

    public static class b extends e {

        /* renamed from: b */
        private String f4246b;

        /* renamed from: c */
        private String f4247c;

        /* renamed from: d */
        private String f4248d;

        /* renamed from: e */
        private String f4249e;

        /* renamed from: f */
        private Activity f4250f;

        /* renamed from: h */
        private ViewGroup f4252h;

        /* renamed from: i */
        private View f4253i;

        /* renamed from: k */
        private Context f4255k;

        /* renamed from: n */
        private int f4258n;

        /* renamed from: o */
        private int f4259o;

        /* renamed from: p */
        private int f4260p;

        /* renamed from: g */
        private int f4251g = 5000;

        /* renamed from: j */
        private int f4254j = 1;

        /* renamed from: l */
        private boolean f4256l = false;

        /* renamed from: m */
        private boolean f4257m = true;

        /* renamed from: q */
        private String f4261q = "";

        /* renamed from: r */
        private String f4262r = "";

        /* renamed from: s */
        private boolean f4263s = false;

        public b(Context context) {
            if (context instanceof Activity) {
                this.f4250f = (Activity) context;
            }
            this.f4255k = context;
        }

        public b a(View view) {
            this.f4253i = view;
            return this;
        }

        public b b(int i10) {
            this.f4254j = i10;
            return this;
        }

        public b c(int i10) {
            this.f4259o = i10;
            return this;
        }

        public b d(int i10) {
            this.f4251g = i10;
            return this;
        }

        public b e(int i10) {
            this.f4258n = i10;
            return this;
        }

        public b a(String str) {
            this.f4262r = str;
            return this;
        }

        public b b(String str) {
            this.f4246b = str;
            return this;
        }

        public b c(String str) {
            this.f4247c = str;
            return this;
        }

        public b d(String str) {
            this.f4248d = str;
            return this;
        }

        public b e(String str) {
            this.f4261q = str;
            return this;
        }

        public b a(boolean z10) {
            this.f4256l = z10;
            return this;
        }

        public b b(boolean z10) {
            this.f4263s = z10;
            return this;
        }

        public a d() {
            a aVar = new a();
            aVar.f4232i = new WeakReference(this.f4250f);
            aVar.f4226c = this.f4246b;
            aVar.f4233j = this.f4251g;
            aVar.f4234k = new WeakReference(this.f4252h);
            aVar.f4236m = this.f4254j;
            aVar.f4237n = this.f4253i;
            aVar.f4231h = this.f4255k;
            aVar.f4241r = this.f4256l;
            aVar.f4230g = this.f4249e;
            aVar.f4242s = this.f4257m;
            aVar.f4238o = this.f4258n;
            aVar.f4239p = this.f4259o;
            aVar.f4240q = this.f4260p;
            aVar.f4227d = this.f4247c;
            aVar.f4228e = this.f4248d;
            aVar.f4243t = this.f4263s;
            aVar.f4244u = this.f4261q;
            aVar.f4245v = this.f4262r;
            aVar.a(this);
            return aVar;
        }
    }

    private a() {
        this.f4229f = com.umeng.commonsdk.internal.a.f24469e;
        this.f4233j = 5000;
        this.f4235l = com.aggmoread.sdk.z.b.i.a.f4558h;
        this.f4241r = false;
        this.f4242s = true;
        this.f4243t = false;
        this.f4244u = "";
        this.f4245v = "";
        this.f4225b = UUID.randomUUID().toString();
    }

    public View f() {
        return this.f4237n;
    }

    public com.aggmoread.sdk.z.b.i.a g() {
        return this.f4235l;
    }

    public String h() {
        return this.f4245v;
    }

    public int i() {
        return this.f4240q;
    }

    public String j() {
        return this.f4226c;
    }

    public Context k() {
        return this.f4231h;
    }

    public int l() {
        return this.f4239p;
    }

    public String m() {
        return this.f4227d;
    }

    public String n() {
        return this.f4228e;
    }

    public String o() {
        return this.f4244u;
    }

    public int p() {
        return this.f4233j;
    }

    public String q() {
        return this.f4229f;
    }

    public int r() {
        return this.f4238o;
    }

    public boolean s() {
        return this.f4242s;
    }

    public boolean t() {
        return this.f4241r;
    }

    public String toString() {
        return "DspRequest{requestId='" + this.f4225b + "', codeId='" + this.f4226c + "', mediaId='" + this.f4227d + "', mediaToken='" + this.f4228e + "', sdkCodeId='" + this.f4230g + "', activityWeak=" + this.f4232i + ", timeoutMs=" + this.f4233j + ", adContainerWeak=" + this.f4234k + ", adType=" + this.f4235l + ", width=" + this.f4238o + ", height=" + this.f4239p + '}';
    }

    public boolean u() {
        return this.f4243t;
    }

    public /* synthetic */ a(C0055a c0055a) {
        this();
    }

    public Activity d() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f4232i;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return null;
        }
        return activity;
    }

    public ViewGroup e() {
        return this.f4234k.get();
    }

    public void a(com.aggmoread.sdk.z.b.f.a aVar) {
        this.f4235l = com.aggmoread.sdk.z.b.i.a.f4555e;
        if (aVar == null) {
            aVar = com.aggmoread.sdk.z.b.f.a.f4381a;
        }
        com.aggmoread.sdk.z.a.h.a.a(this, aVar);
    }

    public void a(com.aggmoread.sdk.z.b.k.a aVar) {
        this.f4235l = com.aggmoread.sdk.z.b.i.a.f4554d;
        com.aggmoread.sdk.z.a.h.a.a(this, aVar);
    }

    public void a(com.aggmoread.sdk.z.b.l.a aVar) {
        this.f4235l = com.aggmoread.sdk.z.b.i.a.f4553c;
        com.aggmoread.sdk.z.a.h.a.a(this, aVar);
    }

    public void a(c cVar) {
        this.f4235l = com.aggmoread.sdk.z.b.i.a.f4556f;
        if (cVar == null) {
            cVar = c.f4862c;
        }
        com.aggmoread.sdk.z.a.h.a.a(this, cVar);
    }

    public void a(d dVar) {
        this.f4235l = com.aggmoread.sdk.z.b.i.a.f4557g;
        if (dVar == null) {
            dVar = d.f4863d;
        }
        com.aggmoread.sdk.z.a.h.a.a(this, dVar);
    }

    public void a(com.aggmoread.sdk.z.b.s.e eVar) {
        this.f4235l = com.aggmoread.sdk.z.b.i.a.f4552b;
        if (eVar == null) {
            eVar = com.aggmoread.sdk.z.b.s.e.f4864e;
        }
        com.aggmoread.sdk.z.a.h.a.a(this, eVar);
    }
}
