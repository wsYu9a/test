package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public final class D extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static sa f24939a;

    /* renamed from: b */
    static B f24940b;

    /* renamed from: c */
    static final /* synthetic */ boolean f24941c = true;

    /* renamed from: d */
    public sa f24942d = null;

    /* renamed from: e */
    public B f24943e = null;

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        sa saVar = this.f24942d;
        if (saVar != null) {
            c0908l.a((AbstractC0909m) saVar, 0);
        }
        B b2 = this.f24943e;
        if (b2 != null) {
            c0908l.a((AbstractC0909m) b2, 1);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f24941c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        D d2 = (D) obj;
        return C0910n.a(this.f24942d, d2.f24942d) && C0910n.a(this.f24943e, d2.f24943e);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        if (f24939a == null) {
            f24939a = new sa();
        }
        this.f24942d = (sa) c0907k.a((AbstractC0909m) f24939a, 0, false);
        if (f24940b == null) {
            f24940b = new B();
        }
        this.f24943e = (B) c0907k.a((AbstractC0909m) f24940b, 1, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a((AbstractC0909m) this.f24942d, "baseStrategy");
        c0905i.a((AbstractC0909m) this.f24943e, "grayStrategy");
    }
}
