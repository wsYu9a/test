package com.aggmoread.sdk.z.d.a.a.d.b;

import java.util.HashMap;

/* loaded from: classes.dex */
public class h {

    /* renamed from: e */
    public static h f5999e = new b().a();

    /* renamed from: a */
    private int f6000a;

    /* renamed from: b */
    private boolean f6001b;

    /* renamed from: c */
    private String f6002c;

    /* renamed from: d */
    private com.aggmoread.sdk.z.d.a.a.c.j f6003d;

    public static class b {

        /* renamed from: a */
        private int f6004a = -1;

        /* renamed from: b */
        private boolean f6005b;

        /* renamed from: c */
        private String f6006c;

        /* renamed from: d */
        private com.aggmoread.sdk.z.d.a.a.c.j f6007d;

        public b() {
            new HashMap();
        }

        public b a(com.aggmoread.sdk.z.d.a.a.c.j jVar) {
            this.f6007d = jVar;
            return this;
        }

        public h a() {
            h hVar = new h();
            hVar.f6000a = this.f6004a;
            hVar.f6001b = this.f6005b;
            hVar.f6003d = this.f6007d;
            hVar.f6002c = this.f6006c;
            return hVar;
        }
    }

    private h() {
        this.f6000a = -1;
        this.f6001b = false;
        this.f6002c = "";
    }

    public com.aggmoread.sdk.z.d.a.a.c.j b() {
        return this.f6003d;
    }

    public boolean c() {
        return this.f6001b;
    }

    public String toString() {
        return "SDKInitConfig{agreePrivacy='" + this.f6000a + "'useTextureView='" + this.f6001b + "'privacyController='" + this.f6003d + "'oaid='" + this.f6002c + "'}";
    }

    public /* synthetic */ h(a aVar) {
        this();
    }

    public String a() {
        return this.f6002c;
    }
}
