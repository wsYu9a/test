package com.opos.mobad.ad.c;

/* loaded from: classes4.dex */
public class s {

    /* renamed from: a */
    public final int f19482a;

    /* renamed from: b */
    public final int f19483b;

    public static class a {

        /* renamed from: a */
        private int f19484a = 0;

        /* renamed from: b */
        private int f19485b = 0;

        public a a(int i2) {
            this.f19484a = i2;
            return this;
        }

        public s a() {
            return new s(this);
        }

        public a b(int i2) {
            this.f19485b = i2;
            return this;
        }
    }

    public s(a aVar) {
        this.f19482a = aVar.f19484a;
        this.f19483b = aVar.f19485b;
    }

    public String toString() {
        return "NativeAdSize{widthInDp=" + this.f19482a + ", heightInDp=" + this.f19483b + '}';
    }
}
