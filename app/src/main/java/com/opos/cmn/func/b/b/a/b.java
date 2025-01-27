package com.opos.cmn.func.b.b.a;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public final boolean f17094a;

    /* renamed from: b */
    public final long f17095b;

    /* renamed from: c */
    public final a f17096c;

    public enum a {
        CN,
        EU,
        SA,
        SEA
    }

    /* renamed from: com.opos.cmn.func.b.b.a.b$b */
    public static class C0389b {

        /* renamed from: a */
        private boolean f17102a = true;

        /* renamed from: b */
        private long f17103b = 54883;

        /* renamed from: c */
        private a f17104c = null;

        public b a() {
            return new b(this);
        }
    }

    private b(C0389b c0389b) {
        this.f17094a = c0389b.f17102a;
        this.f17095b = c0389b.f17103b;
        this.f17096c = c0389b.f17104c;
    }

    /* synthetic */ b(C0389b c0389b, AnonymousClass1 anonymousClass1) {
        this(c0389b);
    }

    public String toString() {
        return "CloudConfig{enableCloudConfig=" + this.f17094a + ", productId=" + this.f17095b + ", areaCode=" + this.f17096c + '}';
    }
}
