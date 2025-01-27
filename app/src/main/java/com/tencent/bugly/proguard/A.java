package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class A extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static ArrayList<C0921z> f24920a;

    /* renamed from: b */
    static final /* synthetic */ boolean f24921b = true;

    /* renamed from: c */
    public ArrayList<C0921z> f24922c;

    public A() {
        this.f24922c = null;
    }

    public ArrayList<C0921z> a() {
        return this.f24922c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f24921b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C0910n.a(this.f24922c, ((A) obj).f24922c);
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
        c0908l.a((Collection) this.f24922c, 0);
    }

    public A(ArrayList<C0921z> arrayList) {
        this.f24922c = null;
        this.f24922c = arrayList;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        if (f24920a == null) {
            f24920a = new ArrayList<>();
            f24920a.add(new C0921z());
        }
        this.f24922c = (ArrayList) c0907k.a((C0907k) f24920a, 0, true);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        new C0905i(sb, i2).a((Collection) this.f24922c, com.umeng.analytics.pro.d.ar);
    }
}
