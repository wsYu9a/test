package com.tencent.bugly.proguard;

/* renamed from: com.tencent.bugly.proguard.x */
/* loaded from: classes4.dex */
public final class C0919x extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static final /* synthetic */ boolean f25176a = true;

    /* renamed from: b */
    public String f25177b;

    /* renamed from: c */
    public String f25178c;

    /* renamed from: d */
    public String f25179d;

    /* renamed from: e */
    public long f25180e;

    /* renamed from: f */
    public String f25181f;

    public C0919x() {
        this.f25177b = "";
        this.f25178c = "";
        this.f25179d = "";
        this.f25180e = 0L;
        this.f25181f = "";
    }

    public String a() {
        return this.f25178c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f25176a) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0919x c0919x = (C0919x) obj;
        return C0910n.a(this.f25177b, c0919x.f25177b) && C0910n.a(this.f25178c, c0919x.f25178c) && C0910n.a(this.f25179d, c0919x.f25179d) && C0910n.a(this.f25180e, c0919x.f25180e) && C0910n.a(this.f25181f, c0919x.f25181f);
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
    public void a(C0908l c0908l) {
        c0908l.a(this.f25177b, 0);
        c0908l.a(this.f25178c, 1);
        String str = this.f25179d;
        if (str != null) {
            c0908l.a(str, 2);
        }
        c0908l.a(this.f25180e, 3);
        String str2 = this.f25181f;
        if (str2 != null) {
            c0908l.a(str2, 4);
        }
    }

    public C0919x(String str, String str2, String str3, long j2, String str4) {
        this.f25177b = "";
        this.f25178c = "";
        this.f25179d = "";
        this.f25180e = 0L;
        this.f25181f = "";
        this.f25177b = str;
        this.f25178c = str2;
        this.f25179d = str3;
        this.f25180e = j2;
        this.f25181f = str4;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25177b = c0907k.a(0, true);
        this.f25178c = c0907k.a(1, true);
        this.f25179d = c0907k.a(2, false);
        this.f25180e = c0907k.a(this.f25180e, 3, true);
        this.f25181f = c0907k.a(4, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a(this.f25177b, "apkMd5");
        c0905i.a(this.f25178c, "apkUrl");
        c0905i.a(this.f25179d, "manifestMd5");
        c0905i.a(this.f25180e, "fileSize");
        c0905i.a(this.f25181f, "signatureMd5");
    }
}
