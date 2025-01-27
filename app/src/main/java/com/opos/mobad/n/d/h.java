package com.opos.mobad.n.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class h {
    int A;
    int B;
    int C;
    int E;
    int F;
    String G;
    String H;
    String I;
    String J;
    g K;
    g L;

    /* renamed from: a */
    String f22086a;

    /* renamed from: b */
    String f22087b;

    /* renamed from: g */
    g f22092g;

    /* renamed from: i */
    String f22094i;

    /* renamed from: j */
    g f22095j;
    g k;
    String l;
    String m;
    String n;
    String o;
    int p;
    int q;
    String r;
    com.opos.mobad.n.c t;
    a u;
    long v;
    long w;
    com.opos.mobad.n.d x;
    String y;
    String z;

    /* renamed from: c */
    List<g> f22088c = new ArrayList();

    /* renamed from: d */
    List<g> f22089d = new ArrayList();

    /* renamed from: e */
    List<String> f22090e = new ArrayList();

    /* renamed from: f */
    boolean f22091f = false;

    /* renamed from: h */
    String f22093h = "广告";
    boolean s = false;
    int D = 0;
    int M = 0;

    public d a() {
        List<g> list;
        g gVar = this.f22095j;
        if ((gVar == null || TextUtils.isEmpty(gVar.f22084a)) && ((list = this.f22088c) == null || list.size() <= 0)) {
            return null;
        }
        return new d(this);
    }

    public h a(int i2) {
        this.E = i2;
        return this;
    }

    public h a(long j2, long j3) {
        this.v = j2;
        this.w = j3;
        return this;
    }

    public h a(com.opos.mobad.n.c cVar) {
        this.t = cVar;
        return this;
    }

    public h a(a aVar) {
        this.u = aVar;
        return this;
    }

    public h a(com.opos.mobad.n.d dVar) {
        this.x = dVar;
        return this;
    }

    public h a(String str) {
        this.f22086a = str;
        return this;
    }

    public h a(String str, String str2) {
        this.f22088c.add(TextUtils.isEmpty(str2) ? new g(str) : new g(str, str2));
        return this;
    }

    public h a(String str, String str2, String str3) {
        this.m = str;
        this.n = str2;
        this.o = str3;
        return this;
    }

    public h a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2)) {
            this.L = new g(str);
        } else {
            this.L = new g(str, str2);
        }
        this.n = str3;
        this.o = str4;
        return this;
    }

    public h a(boolean z) {
        this.f22091f = z;
        return this;
    }

    public e b() {
        g gVar = this.k;
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            return null;
        }
        return new e(this);
    }

    public h b(int i2) {
        this.F = i2;
        return this;
    }

    public h b(String str) {
        this.f22087b = str;
        return this;
    }

    public h b(String str, String str2) {
        this.f22089d.add(TextUtils.isEmpty(str2) ? new g(str) : new g(str, str2));
        return this;
    }

    public h b(boolean z) {
        this.s = z;
        return this;
    }

    public c c() {
        if (TextUtils.isEmpty(this.m)) {
            return null;
        }
        return new c(this);
    }

    public h c(int i2) {
        this.D = i2;
        return this;
    }

    public h c(String str) {
        this.f22093h = str;
        return this;
    }

    public h c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.f22092g = new g(str);
        } else {
            this.f22092g = new g(str, str2);
        }
        return this;
    }

    public b d() {
        if (TextUtils.isEmpty(this.G)) {
            return null;
        }
        return new b(this);
    }

    public h d(int i2) {
        this.C = i2;
        return this;
    }

    public h d(String str) {
        this.f22094i = str;
        return this;
    }

    public h d(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                this.f22095j = new g(str);
            } else {
                this.f22095j = new g(str, str2);
            }
        }
        return this;
    }

    public f e() {
        return new f(this);
    }

    public h e(int i2) {
        this.B = i2;
        return this;
    }

    public h e(String str) {
        this.r = str;
        return this;
    }

    public h e(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                this.k = new g(str);
            } else {
                this.k = new g(str, str2);
            }
        }
        return this;
    }

    public h f(int i2) {
        this.p = i2;
        return this;
    }

    public h f(String str) {
        this.l = str;
        return this;
    }

    public h f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.K = new g(str);
        } else {
            this.K = new g(str, str2);
        }
        return this;
    }

    public h g(int i2) {
        this.q = i2;
        return this;
    }

    public h g(String str) {
        this.y = str;
        return this;
    }

    public h h(int i2) {
        this.A = i2;
        return this;
    }

    public h h(String str) {
        this.z = str;
        return this;
    }

    public h i(int i2) {
        this.M = i2;
        return this;
    }

    public h i(String str) {
        this.G = str;
        return this;
    }

    public h j(String str) {
        this.J = str;
        return this;
    }

    public h k(String str) {
        this.I = str;
        return this;
    }

    public h l(String str) {
        this.H = str;
        return this;
    }
}
