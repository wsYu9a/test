package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class oa extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static ArrayList<na> f25109a;

    /* renamed from: b */
    public ArrayList<na> f25110b = null;

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a((Collection) this.f25110b, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        if (f25109a == null) {
            f25109a = new ArrayList<>();
            f25109a.add(new na());
        }
        this.f25110b = (ArrayList) c0907k.a((C0907k) f25109a, 0, true);
    }
}
