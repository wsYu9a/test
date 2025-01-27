package com.aggmoread.sdk.z.c.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.aggmoread.sdk.z.b.e;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b */
    private String f5110b;

    /* renamed from: c */
    private String f5111c;

    /* renamed from: d */
    private String f5112d;

    /* renamed from: e */
    private Context f5113e;

    /* renamed from: f */
    private WeakReference<Activity> f5114f;

    /* renamed from: g */
    private int f5115g;

    /* renamed from: h */
    private WeakReference<ViewGroup> f5116h;

    /* renamed from: i */
    private com.aggmoread.sdk.z.b.i.a f5117i;

    /* renamed from: j */
    private int f5118j;

    /* renamed from: k */
    private View f5119k;

    /* renamed from: l */
    private boolean f5120l;

    /* renamed from: m */
    private boolean f5121m;

    public static class b extends e {

        /* renamed from: b */
        private String f5122b;

        /* renamed from: c */
        private String f5123c;

        /* renamed from: d */
        private Activity f5124d;

        /* renamed from: f */
        private ViewGroup f5126f;

        /* renamed from: g */
        private View f5127g;

        /* renamed from: i */
        private Context f5129i;

        /* renamed from: e */
        private int f5125e = 5000;

        /* renamed from: h */
        private int f5128h = 1;

        /* renamed from: j */
        private boolean f5130j = false;

        /* renamed from: k */
        private boolean f5131k = true;

        public b(Context context) {
            this.f5129i = context;
        }

        public b a(View view) {
            this.f5127g = view;
            return this;
        }

        public b b(int i10) {
            this.f5128h = i10;
            return this;
        }

        public b c(int i10) {
            this.f5125e = i10;
            return this;
        }

        public a d() {
            a aVar = new a();
            aVar.f5114f = new WeakReference(this.f5124d);
            aVar.f5111c = this.f5122b;
            aVar.f5115g = this.f5125e;
            aVar.f5116h = new WeakReference(this.f5126f);
            aVar.f5118j = this.f5128h;
            aVar.f5119k = this.f5127g;
            aVar.f5113e = this.f5129i;
            aVar.f5120l = this.f5130j;
            aVar.f5112d = this.f5123c;
            aVar.f5121m = this.f5131k;
            aVar.a(this);
            return aVar;
        }

        public b a(String str) {
            this.f5122b = str;
            return this;
        }

        public b a(boolean z10) {
            this.f5130j = z10;
            return this;
        }
    }

    private a() {
        this.f5115g = 5000;
        this.f5117i = com.aggmoread.sdk.z.b.i.a.f4558h;
        this.f5120l = false;
        this.f5121m = true;
        this.f5110b = UUID.randomUUID().toString();
    }

    public Activity d() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f5114f;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return null;
        }
        return activity;
    }

    public ViewGroup e() {
        return this.f5116h.get();
    }

    public View f() {
        return this.f5119k;
    }

    public com.aggmoread.sdk.z.b.i.a g() {
        return this.f5117i;
    }

    public String h() {
        return this.f5111c;
    }

    public Context i() {
        return this.f5113e;
    }

    public String j() {
        return this.f5110b;
    }

    public boolean k() {
        return this.f5121m;
    }

    public boolean l() {
        return this.f5120l;
    }

    public String toString() {
        return "DspRequest{requestId='" + this.f5110b + "', codeId='" + this.f5111c + "', sdkCodeId='" + this.f5112d + "', activityWeak=" + this.f5114f + ", timeoutMs=" + this.f5115g + ", adContainerWeak=" + this.f5116h + ", adType=" + this.f5117i + '}';
    }

    public /* synthetic */ a(C0104a c0104a) {
        this();
    }

    public void a(com.aggmoread.sdk.z.b.l.a aVar) {
        this.f5117i = com.aggmoread.sdk.z.b.i.a.f4553c;
        com.aggmoread.sdk.z.c.c.a.a(this, aVar);
    }

    public void a(com.aggmoread.sdk.z.b.s.e eVar) {
        this.f5117i = com.aggmoread.sdk.z.b.i.a.f4552b;
        if (eVar == null) {
            eVar = com.aggmoread.sdk.z.b.s.e.f4864e;
        }
        com.aggmoread.sdk.z.c.c.a.a(this, eVar);
    }
}
