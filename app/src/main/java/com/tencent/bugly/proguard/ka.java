package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public final class ka extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    public String f22755a = "";

    /* renamed from: b */
    public String f22756b = "";

    /* renamed from: c */
    public String f22757c = "";

    /* renamed from: d */
    public String f22758d = "";

    /* renamed from: e */
    public String f22759e = "";

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22755a, 0);
        String str = this.f22756b;
        if (str != null) {
            c0867l.a(str, 1);
        }
        String str2 = this.f22757c;
        if (str2 != null) {
            c0867l.a(str2, 2);
        }
        String str3 = this.f22758d;
        if (str3 != null) {
            c0867l.a(str3, 3);
        }
        String str4 = this.f22759e;
        if (str4 != null) {
            c0867l.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22755a = c0866k.a(0, true);
        this.f22756b = c0866k.a(1, false);
        this.f22757c = c0866k.a(2, false);
        this.f22758d = c0866k.a(3, false);
        this.f22759e = c0866k.a(4, false);
    }
}
