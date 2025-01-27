package com.opos.mobad.ad.c;

/* loaded from: classes4.dex */
public class r {

    /* renamed from: a */
    public final long f19480a;

    public static class a {

        /* renamed from: a */
        private long f19481a = 30000;

        public a a(long j2) {
            if (j2 >= 500 && j2 <= 30000) {
                this.f19481a = j2;
            }
            return this;
        }

        public r a() {
            return new r(this);
        }
    }

    public r(a aVar) {
        this.f19480a = aVar.f19481a;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.f19480a + '}';
    }
}
