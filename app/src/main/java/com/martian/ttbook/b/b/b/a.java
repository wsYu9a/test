package com.martian.ttbook.b.b.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.d.e.c.a.e;
import b.d.e.c.a.l.c;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes4.dex */
public class a extends e {

    /* renamed from: b */
    private String f15186b;

    /* renamed from: c */
    private String f15187c;

    /* renamed from: d */
    private String f15188d;

    /* renamed from: e */
    private Context f15189e;

    /* renamed from: f */
    private WeakReference<Activity> f15190f;

    /* renamed from: g */
    private int f15191g;

    /* renamed from: h */
    private WeakReference<ViewGroup> f15192h;

    /* renamed from: i */
    private b.d.e.c.a.g.a f15193i;

    /* renamed from: j */
    private int f15194j;
    private View k;
    private boolean l;
    private boolean m;

    public static class b extends e {

        /* renamed from: b */
        private String f15195b;

        /* renamed from: c */
        private String f15196c;

        /* renamed from: d */
        private Activity f15197d;

        /* renamed from: f */
        private ViewGroup f15199f;

        /* renamed from: g */
        private View f15200g;

        /* renamed from: i */
        private Context f15202i;

        /* renamed from: e */
        private int f15198e = 5000;

        /* renamed from: h */
        private int f15201h = 1;

        /* renamed from: j */
        private boolean f15203j = false;
        private boolean k = true;

        public b(Context context) {
            this.f15202i = context;
        }

        public b e(int i2) {
            this.f15201h = i2;
            return this;
        }

        public b f(View view) {
            this.f15200g = view;
            return this;
        }

        public b g(String str) {
            this.f15195b = str;
            return this;
        }

        public b h(boolean z) {
            this.f15203j = z;
            return this;
        }

        public b i(int i2) {
            this.f15198e = i2;
            return this;
        }

        public a j() {
            a aVar = new a();
            aVar.f15190f = new WeakReference(this.f15197d);
            aVar.f15187c = this.f15195b;
            aVar.f15191g = this.f15198e;
            aVar.f15192h = new WeakReference(this.f15199f);
            aVar.f15194j = this.f15201h;
            aVar.k = this.f15200g;
            aVar.f15189e = this.f15202i;
            aVar.l = this.f15203j;
            aVar.f15188d = this.f15196c;
            aVar.m = this.k;
            aVar.c(this);
            return aVar;
        }
    }

    private a() {
        this.f15191g = 5000;
        this.f15193i = b.d.e.c.a.g.a.f4621c;
        this.l = false;
        this.m = true;
        this.f15186b = UUID.randomUUID().toString();
    }

    /* synthetic */ a(C0289a c0289a) {
        this();
    }

    public void j(b.d.e.c.a.h.a aVar) {
        this.f15193i = b.d.e.c.a.g.a.f4620b;
        b.d.e.c.c.b.a.c(this, aVar);
    }

    public void k(c cVar) {
        this.f15193i = b.d.e.c.a.g.a.f4619a;
        if (cVar == null) {
            cVar = c.f4681i;
        }
        b.d.e.c.c.b.a.c(this, cVar);
    }

    public Activity n() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f15190f;
        if (weakReference == null || (activity = weakReference.get()) == null) {
            return null;
        }
        return activity;
    }

    public ViewGroup r() {
        return this.f15192h.get();
    }

    public View s() {
        return this.k;
    }

    public b.d.e.c.a.g.a t() {
        return this.f15193i;
    }

    public String toString() {
        return "DspRequest{requestId='" + this.f15186b + "', codeId='" + this.f15187c + "', sdkCodeId='" + this.f15188d + "', activityWeak=" + this.f15190f + ", timeoutMs=" + this.f15191g + ", adContainerWeak=" + this.f15192h + ", adType=" + this.f15193i + '}';
    }

    public String u() {
        return this.f15187c;
    }

    public Context v() {
        return this.f15189e;
    }

    public String w() {
        return this.f15186b;
    }

    public boolean x() {
        return this.m;
    }

    public boolean y() {
        return this.l;
    }
}
