package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class la extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static ArrayList<String> f25090a;

    /* renamed from: b */
    public String f25091b = "";

    /* renamed from: c */
    public ArrayList<String> f25092c = null;

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25091b, 0);
        ArrayList<String> arrayList = this.f25092c;
        if (arrayList != null) {
            c0908l.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25091b = c0907k.a(0, true);
        if (f25090a == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f25090a = arrayList;
            arrayList.add("");
        }
        this.f25092c = (ArrayList) c0907k.a((C0907k) f25090a, 1, false);
    }
}
