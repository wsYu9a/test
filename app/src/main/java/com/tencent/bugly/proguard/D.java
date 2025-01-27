package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public final class D extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static sa f22580a = null;

    /* renamed from: b */
    static B f22581b = null;

    /* renamed from: c */
    static final /* synthetic */ boolean f22582c = true;

    /* renamed from: d */
    public sa f22583d = null;

    /* renamed from: e */
    public B f22584e = null;

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        sa saVar = this.f22583d;
        if (saVar != null) {
            c0867l.a((AbstractC0868m) saVar, 0);
        }
        B b10 = this.f22584e;
        if (b10 != null) {
            c0867l.a((AbstractC0868m) b10, 1);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22582c) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        D d10 = (D) obj;
        return C0869n.a(this.f22583d, d10.f22583d) && C0869n.a(this.f22584e, d10.f22584e);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        if (f22580a == null) {
            f22580a = new sa();
        }
        this.f22583d = (sa) c0866k.a((AbstractC0868m) f22580a, 0, false);
        if (f22581b == null) {
            f22581b = new B();
        }
        this.f22584e = (B) c0866k.a((AbstractC0868m) f22581b, 1, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a((AbstractC0868m) this.f22583d, "baseStrategy");
        c0864i.a((AbstractC0868m) this.f22584e, "grayStrategy");
    }
}
