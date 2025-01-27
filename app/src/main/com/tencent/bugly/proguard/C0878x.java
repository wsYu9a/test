package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: classes4.dex */
public final class C0878x extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static final /* synthetic */ boolean f22888a = true;

    /* renamed from: b */
    public String f22889b;

    /* renamed from: c */
    public String f22890c;

    /* renamed from: d */
    public String f22891d;

    /* renamed from: e */
    public long f22892e;

    /* renamed from: f */
    public String f22893f;

    public C0878x() {
        this.f22889b = "";
        this.f22890c = "";
        this.f22891d = "";
        this.f22892e = 0L;
        this.f22893f = "";
    }

    public String a() {
        return this.f22890c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22888a) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0878x c0878x = (C0878x) obj;
        return C0869n.a(this.f22889b, c0878x.f22889b) && C0869n.a(this.f22890c, c0878x.f22890c) && C0869n.a(this.f22891d, c0878x.f22891d) && C0869n.a(this.f22892e, c0878x.f22892e) && C0869n.a(this.f22893f, c0878x.f22893f);
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
    public void a(C0867l c0867l) {
        c0867l.a(this.f22889b, 0);
        c0867l.a(this.f22890c, 1);
        String str = this.f22891d;
        if (str != null) {
            c0867l.a(str, 2);
        }
        c0867l.a(this.f22892e, 3);
        String str2 = this.f22893f;
        if (str2 != null) {
            c0867l.a(str2, 4);
        }
    }

    public C0878x(String str, String str2, String str3, long j10, String str4) {
        this.f22889b = str;
        this.f22890c = str2;
        this.f22891d = str3;
        this.f22892e = j10;
        this.f22893f = str4;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22889b = c0866k.a(0, true);
        this.f22890c = c0866k.a(1, true);
        this.f22891d = c0866k.a(2, false);
        this.f22892e = c0866k.a(this.f22892e, 3, true);
        this.f22893f = c0866k.a(4, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a(this.f22889b, "apkMd5");
        c0864i.a(this.f22890c, "apkUrl");
        c0864i.a(this.f22891d, "manifestMd5");
        c0864i.a(this.f22892e, "fileSize");
        c0864i.a(this.f22893f, "signatureMd5");
    }
}
