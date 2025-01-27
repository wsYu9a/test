package com.opos.mobad.ad.e;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public final long f19489a;

    /* renamed from: b */
    public final String f19490b;

    /* renamed from: c */
    public final String f19491c;

    /* renamed from: d */
    public final boolean f19492d;

    /* renamed from: e */
    public final d f19493e;

    /* renamed from: f */
    public final boolean f19494f;

    /* renamed from: g */
    public final e f19495g;

    /* renamed from: h */
    public final boolean f19496h;

    public static class a {

        /* renamed from: a */
        private long f19497a;

        /* renamed from: b */
        private String f19498b;

        /* renamed from: c */
        private String f19499c;

        /* renamed from: d */
        private boolean f19500d;

        /* renamed from: e */
        private d f19501e;

        /* renamed from: f */
        private boolean f19502f;

        /* renamed from: g */
        private Context f19503g;

        /* renamed from: h */
        private boolean f19504h;

        /* renamed from: i */
        private boolean f19505i;

        /* renamed from: j */
        private e f19506j;

        private a() {
            this.f19497a = 5000L;
            this.f19500d = true;
            this.f19501e = null;
            this.f19502f = false;
            this.f19503g = null;
            this.f19504h = true;
            this.f19505i = true;
        }

        public a(Context context) {
            this.f19497a = 5000L;
            this.f19500d = true;
            this.f19501e = null;
            this.f19502f = false;
            this.f19503g = null;
            this.f19504h = true;
            this.f19505i = true;
            if (context != null) {
                this.f19503g = context.getApplicationContext();
            }
        }

        public a a(long j2) {
            if (j2 >= 3000 && j2 <= 5000) {
                this.f19497a = j2;
            }
            return this;
        }

        public a a(d dVar) {
            if (dVar != null) {
                this.f19501e = dVar;
            }
            return this;
        }

        public a a(e eVar) {
            this.f19506j = eVar;
            return this;
        }

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f19498b = str;
            }
            return this;
        }

        public a a(boolean z) {
            this.f19500d = z;
            return this;
        }

        public f a() throws NullPointerException {
            this.f19503g.getClass();
            return new f(this);
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f19499c = str;
            }
            return this;
        }

        public a b(boolean z) {
            this.f19502f = z;
            return this;
        }

        public a c(boolean z) {
            this.f19504h = z;
            return this;
        }

        public a d(boolean z) {
            this.f19505i = z;
            return this;
        }
    }

    public f(a aVar) {
        this.f19489a = aVar.f19497a;
        this.f19490b = aVar.f19498b;
        this.f19491c = aVar.f19499c;
        this.f19492d = aVar.f19500d;
        this.f19493e = aVar.f19501e;
        this.f19494f = aVar.f19502f;
        this.f19496h = aVar.f19504h;
        this.f19495g = aVar.f19506j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplashAdParams{fetchTimeout=");
        sb.append(this.f19489a);
        sb.append(", title='");
        sb.append(this.f19490b);
        sb.append('\'');
        sb.append(", desc='");
        sb.append(this.f19491c);
        sb.append('\'');
        sb.append(", showPreLoadPage=");
        sb.append(this.f19492d);
        sb.append(", bottomArea=");
        Object obj = this.f19493e;
        if (obj == null) {
            obj = "null";
        }
        sb.append(obj);
        sb.append(", isUseSurfaceView='");
        sb.append(this.f19494f);
        sb.append('\'');
        sb.append(", isVertical=");
        sb.append(this.f19496h);
        sb.append('}');
        return sb.toString();
    }
}
