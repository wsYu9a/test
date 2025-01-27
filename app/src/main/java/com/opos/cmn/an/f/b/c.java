package com.opos.cmn.an.f.b;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public final String f16470a;

    /* renamed from: b */
    public final boolean f16471b;

    public static class a {

        /* renamed from: a */
        private String f16472a;

        /* renamed from: b */
        private boolean f16473b = true;

        public a a(String str) {
            this.f16472a = str;
            return this;
        }

        public a a(boolean z) {
            this.f16473b = z;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private c(a aVar) {
        this.f16470a = aVar.f16472a;
        this.f16471b = aVar.f16473b;
    }

    /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "UploadParams{, businessType=" + this.f16470a + ", onlyWifi=" + this.f16471b + '}';
    }
}
