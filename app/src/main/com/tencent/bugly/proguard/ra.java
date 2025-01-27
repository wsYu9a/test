package com.tencent.bugly.proguard;

/* loaded from: classes4.dex */
public final class ra extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    public String f22847a = "";

    /* renamed from: b */
    public String f22848b = "";

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22847a, 0);
        c0867l.a(this.f22848b, 1);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22847a = c0866k.a(0, true);
        this.f22848b = c0866k.a(1, true);
    }
}
