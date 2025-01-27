package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class oa extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static ArrayList<na> f22797a;

    /* renamed from: b */
    public ArrayList<na> f22798b = null;

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a((Collection) this.f22798b, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        if (f22797a == null) {
            f22797a = new ArrayList<>();
            f22797a.add(new na());
        }
        this.f22798b = (ArrayList) c0866k.a((C0866k) f22797a, 0, true);
    }
}
