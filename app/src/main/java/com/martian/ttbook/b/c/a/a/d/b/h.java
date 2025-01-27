package com.martian.ttbook.b.c.a.a.d.b;

import java.util.HashMap;

/* loaded from: classes4.dex */
public class h {

    /* renamed from: a */
    public static h f15760a = new b().d();

    /* renamed from: b */
    private int f15761b;

    /* renamed from: c */
    private boolean f15762c;

    /* renamed from: d */
    private String f15763d;

    /* renamed from: e */
    private com.martian.ttbook.b.c.a.a.c.i f15764e;

    public static class b {

        /* renamed from: a */
        private int f15765a = -1;

        /* renamed from: b */
        private boolean f15766b;

        /* renamed from: c */
        private String f15767c;

        /* renamed from: d */
        private com.martian.ttbook.b.c.a.a.c.i f15768d;

        public b() {
            new HashMap();
        }

        public b a(com.martian.ttbook.b.c.a.a.c.i iVar) {
            this.f15768d = iVar;
            return this;
        }

        public b b(String str) {
            this.f15767c = str;
            return this;
        }

        public b c(boolean z) {
            this.f15766b = z;
            return this;
        }

        public h d() {
            h hVar = new h();
            hVar.f15761b = this.f15765a;
            hVar.f15762c = this.f15766b;
            hVar.f15764e = this.f15768d;
            hVar.f15763d = this.f15767c;
            return hVar;
        }
    }

    private h() {
        this.f15761b = -1;
        this.f15762c = false;
        this.f15763d = "";
    }

    /* synthetic */ h(a aVar) {
        this();
    }

    public String c() {
        return this.f15763d;
    }

    public void e(String str) {
        this.f15763d = str;
    }

    public com.martian.ttbook.b.c.a.a.c.i g() {
        return this.f15764e;
    }

    public boolean h() {
        return this.f15762c;
    }

    public String toString() {
        return "SDKInitConfig{agreePrivacy='" + this.f15761b + "'useTextureView='" + this.f15762c + "'privacyController='" + this.f15764e + "'oaid='" + this.f15763d + "'}";
    }
}
