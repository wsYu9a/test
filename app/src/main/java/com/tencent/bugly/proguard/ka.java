package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public final class ka extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    public String f25083a = "";

    /* renamed from: b */
    public String f25084b = "";

    /* renamed from: c */
    public String f25085c = "";

    /* renamed from: d */
    public String f25086d = "";

    /* renamed from: e */
    public String f25087e = "";

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25083a, 0);
        String str = this.f25084b;
        if (str != null) {
            c0908l.a(str, 1);
        }
        String str2 = this.f25085c;
        if (str2 != null) {
            c0908l.a(str2, 2);
        }
        String str3 = this.f25086d;
        if (str3 != null) {
            c0908l.a(str3, 3);
        }
        String str4 = this.f25087e;
        if (str4 != null) {
            c0908l.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25083a = c0907k.a(0, true);
        this.f25084b = c0907k.a(1, false);
        this.f25085c = c0907k.a(2, false);
        this.f25086d = c0907k.a(3, false);
        this.f25087e = c0907k.a(4, false);
    }
}
