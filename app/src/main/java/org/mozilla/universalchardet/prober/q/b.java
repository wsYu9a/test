package org.mozilla.universalchardet.prober.q;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    protected m f35503a;

    /* renamed from: b */
    protected int f35504b = 0;

    /* renamed from: c */
    protected int f35505c;

    /* renamed from: d */
    protected int f35506d;

    public b(m mVar) {
        this.f35503a = mVar;
    }

    public String a() {
        return this.f35503a.c();
    }

    public int b() {
        return this.f35505c;
    }

    public int c(byte b2) {
        int b3 = this.f35503a.b(b2);
        if (this.f35504b == 0) {
            this.f35506d = 0;
            this.f35505c = this.f35503a.a(b3);
        }
        int d2 = this.f35503a.d(b3, this.f35504b);
        this.f35504b = d2;
        this.f35506d++;
        return d2;
    }

    public void d() {
        this.f35504b = 0;
    }
}
