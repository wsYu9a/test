package com.opos.cmn.an.f.a.b;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public final String f16423a;

    /* renamed from: b */
    public final Object f16424b;

    /* renamed from: c */
    public final Throwable f16425c;

    /* renamed from: d */
    public final int f16426d;

    /* renamed from: e */
    public final long f16427e;

    /* renamed from: f */
    public final String f16428f;

    /* renamed from: g */
    public final long f16429g;

    /* renamed from: h */
    public final int f16430h;

    public static class a {

        /* renamed from: a */
        private String f16431a;

        /* renamed from: b */
        private Object f16432b;

        /* renamed from: c */
        private Throwable f16433c;

        /* renamed from: d */
        private int f16434d;

        /* renamed from: e */
        private long f16435e = 0;

        /* renamed from: f */
        private String f16436f = "";

        /* renamed from: g */
        private long f16437g = 0;

        /* renamed from: h */
        private int f16438h = 1;

        public a a(int i2) {
            this.f16434d = i2;
            return this;
        }

        public a a(long j2) {
            this.f16435e = j2;
            return this;
        }

        public a a(Object obj) {
            this.f16432b = obj;
            return this;
        }

        public a a(String str) {
            this.f16431a = str;
            return this;
        }

        public a a(Throwable th) {
            this.f16433c = th;
            return this;
        }

        public d a() {
            return new d(this);
        }

        public a b(int i2) {
            this.f16438h = i2;
            return this;
        }

        public a b(long j2) {
            this.f16437g = j2;
            return this;
        }

        public a b(String str) {
            this.f16436f = str;
            return this;
        }
    }

    private d(a aVar) {
        this.f16423a = aVar.f16431a;
        this.f16424b = aVar.f16432b;
        this.f16425c = aVar.f16433c;
        this.f16426d = aVar.f16434d;
        this.f16427e = aVar.f16435e;
        this.f16428f = aVar.f16436f;
        this.f16429g = aVar.f16437g;
        this.f16430h = aVar.f16438h;
    }

    /* synthetic */ d(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }
}
