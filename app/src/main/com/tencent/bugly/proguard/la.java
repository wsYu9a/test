package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class la extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static ArrayList<String> f22762a;

    /* renamed from: b */
    public String f22763b = "";

    /* renamed from: c */
    public ArrayList<String> f22764c = null;

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22763b, 0);
        ArrayList<String> arrayList = this.f22764c;
        if (arrayList != null) {
            c0867l.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22763b = c0866k.a(0, true);
        if (f22762a == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f22762a = arrayList;
            arrayList.add("");
        }
        this.f22764c = (ArrayList) c0866k.a((C0866k) f22762a, 1, false);
    }
}
