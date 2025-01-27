package com.opos.cmn.biz.web.c.b;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public final String f16907a;

    /* renamed from: b */
    public final boolean f16908b;

    /* renamed from: c */
    public final String f16909c;

    public static class a {

        /* renamed from: b */
        private String f16911b;

        /* renamed from: a */
        private boolean f16910a = true;

        /* renamed from: c */
        private String f16912c = "";

        public a a(String str) {
            this.f16911b = str;
            return this;
        }

        public a a(boolean z) {
            this.f16910a = z;
            return this;
        }

        public c a() {
            if (this.f16912c == null) {
                this.f16912c = "";
            }
            return new c(this);
        }

        public a b(String str) {
            this.f16912c = str;
            return this;
        }
    }

    private c(a aVar) {
        this.f16908b = aVar.f16910a;
        this.f16909c = aVar.f16911b;
        this.f16907a = aVar.f16912c;
    }

    /* synthetic */ c(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "JsCommonInitParams{, businessType=" + this.f16907a + "forceJsInit=" + this.f16908b + ", jsSign=" + this.f16909c + '}';
    }
}
