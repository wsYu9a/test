package com.aggmoread.sdk.z.e.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.b.e;
import com.aggmoread.sdk.z.b.s.c;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b */
    private String f6187b;

    /* renamed from: c */
    private String f6188c;

    /* renamed from: d */
    private String f6189d;

    /* renamed from: e */
    private String f6190e;

    /* renamed from: f */
    private Context f6191f;

    /* renamed from: g */
    private WeakReference<Activity> f6192g;

    /* renamed from: h */
    private int f6193h;

    /* renamed from: i */
    private WeakReference<ViewGroup> f6194i;

    /* renamed from: j */
    private com.aggmoread.sdk.z.b.i.a f6195j;

    /* renamed from: k */
    private int f6196k;

    /* renamed from: l */
    private View f6197l;

    /* renamed from: m */
    private int f6198m;

    /* renamed from: n */
    private int f6199n;

    /* renamed from: o */
    private int f6200o;

    /* renamed from: p */
    private boolean f6201p;

    /* renamed from: q */
    private boolean f6202q;

    /* renamed from: r */
    private String f6203r;

    /* renamed from: s */
    private String f6204s;

    public static class b extends e {

        /* renamed from: b */
        private String f6205b;

        /* renamed from: c */
        private String f6206c;

        /* renamed from: d */
        private String f6207d;

        /* renamed from: e */
        private Activity f6208e;

        /* renamed from: g */
        private ViewGroup f6210g;

        /* renamed from: h */
        private View f6211h;

        /* renamed from: j */
        private Context f6213j;

        /* renamed from: m */
        private int f6216m;

        /* renamed from: n */
        private int f6217n;

        /* renamed from: o */
        private int f6218o;

        /* renamed from: p */
        private String f6219p;

        /* renamed from: q */
        private String f6220q;

        /* renamed from: f */
        private int f6209f = 5000;

        /* renamed from: i */
        private int f6212i = 1;

        /* renamed from: k */
        private boolean f6214k = false;

        /* renamed from: l */
        private boolean f6215l = true;

        public b(Context context) {
            if (context instanceof Activity) {
                this.f6208e = (Activity) context;
            }
            this.f6213j = context;
        }

        public b a(View view) {
            this.f6211h = view;
            return this;
        }

        public b b(int i10) {
            this.f6212i = i10;
            return this;
        }

        public b c(int i10) {
            this.f6217n = i10;
            return this;
        }

        public b d(int i10) {
            this.f6209f = i10;
            return this;
        }

        public b e(int i10) {
            this.f6216m = i10;
            return this;
        }

        public b a(String str) {
            this.f6220q = str;
            return this;
        }

        public b b(String str) {
            this.f6205b = str;
            return this;
        }

        public b c(String str) {
            this.f6206c = str;
            return this;
        }

        public b d(String str) {
            this.f6219p = str;
            return this;
        }

        public b a(boolean z10) {
            this.f6214k = z10;
            return this;
        }

        public a d() {
            a aVar = new a();
            aVar.f6192g = new WeakReference(this.f6208e);
            aVar.f6188c = this.f6205b;
            aVar.f6193h = this.f6209f;
            aVar.f6194i = new WeakReference(this.f6210g);
            aVar.f6196k = this.f6212i;
            aVar.f6197l = this.f6211h;
            aVar.f6191f = this.f6213j;
            aVar.f6201p = this.f6214k;
            aVar.f6190e = this.f6207d;
            aVar.f6202q = this.f6215l;
            aVar.f6198m = this.f6216m;
            aVar.f6199n = this.f6217n;
            aVar.f6200o = this.f6218o;
            aVar.f6189d = this.f6206c;
            aVar.f6204s = this.f6220q;
            aVar.f6203r = this.f6219p;
            aVar.a(this);
            return aVar;
        }
    }

    private a() {
        this.f6193h = 5000;
        this.f6195j = com.aggmoread.sdk.z.b.i.a.f4558h;
        this.f6201p = false;
        this.f6202q = true;
        this.f6203r = "";
        this.f6204s = "";
        this.f6187b = UUID.randomUUID().toString();
    }

    public View f() {
        return this.f6197l;
    }

    public com.aggmoread.sdk.z.b.i.a g() {
        return this.f6195j;
    }

    public String h() {
        return this.f6204s;
    }

    public int i() {
        return this.f6200o;
    }

    public String j() {
        return this.f6188c;
    }

    public Context k() {
        return this.f6191f;
    }

    public int l() {
        return this.f6199n;
    }

    public String m() {
        return this.f6189d;
    }

    public String n() {
        return this.f6203r;
    }

    public String o() {
        return this.f6187b;
    }

    public int p() {
        return this.f6198m;
    }

    public boolean q() {
        return this.f6202q;
    }

    public boolean r() {
        return this.f6201p;
    }

    public String toString() {
        return "DspRequest{requestId='" + this.f6187b + "', codeId='" + this.f6188c + "', sdkCodeId='" + this.f6190e + "', activityWeak=" + this.f6192g + ", timeoutMs=" + this.f6193h + ", adContainerWeak=" + this.f6194i + ", adType=" + this.f6195j + ", width=" + this.f6198m + ", height=" + this.f6199n + '}';
    }

    public /* synthetic */ a(C0195a c0195a) {
        this();
    }

    public Activity d() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f6192g;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return null;
        }
        return activity;
    }

    public ViewGroup e() {
        return this.f6194i.get();
    }

    public void a(com.aggmoread.sdk.z.b.f.a aVar) {
        this.f6195j = com.aggmoread.sdk.z.b.i.a.f4555e;
        if (aVar == null) {
            aVar = com.aggmoread.sdk.z.b.f.a.f4381a;
        }
        com.aggmoread.sdk.z.e.i.a.a(this, aVar);
    }

    public void a(com.aggmoread.sdk.z.b.k.a aVar) {
        this.f6195j = com.aggmoread.sdk.z.b.i.a.f4554d;
        if (aVar == null) {
            aVar = com.aggmoread.sdk.z.b.k.a.f4652b;
        }
        com.aggmoread.sdk.z.e.i.a.a(this, aVar);
    }

    public void a(com.aggmoread.sdk.z.b.l.a aVar) {
        this.f6195j = com.aggmoread.sdk.z.b.i.a.f4553c;
        com.aggmoread.sdk.z.e.i.a.a(this, aVar);
    }

    public void a(c cVar) {
        this.f6195j = com.aggmoread.sdk.z.b.i.a.f4556f;
        if (cVar == null) {
            cVar = c.f4862c;
        }
        com.aggmoread.sdk.z.e.i.a.a(this, cVar);
    }

    public void a(com.aggmoread.sdk.z.b.s.e eVar) {
        this.f6195j = com.aggmoread.sdk.z.b.i.a.f4552b;
        if (eVar == null) {
            eVar = com.aggmoread.sdk.z.b.s.e.f4864e;
        }
        com.aggmoread.sdk.z.e.i.a.a(this, eVar);
    }
}
