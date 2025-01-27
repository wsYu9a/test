package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes4.dex */
public final class A extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static ArrayList<C0880z> f22550a = null;

    /* renamed from: b */
    static final /* synthetic */ boolean f22551b = true;

    /* renamed from: c */
    public ArrayList<C0880z> f22552c;

    public A() {
        this.f22552c = null;
    }

    public ArrayList<C0880z> a() {
        return this.f22552c;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22551b) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return C0869n.a(this.f22552c, ((A) obj).f22552c);
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
        c0867l.a((Collection) this.f22552c, 0);
    }

    public A(ArrayList<C0880z> arrayList) {
        this.f22552c = arrayList;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        if (f22550a == null) {
            f22550a = new ArrayList<>();
            f22550a.add(new C0880z());
        }
        this.f22552c = (ArrayList) c0866k.a((C0866k) f22550a, 0, true);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        new C0864i(sb2, i10).a((Collection) this.f22552c, com.umeng.analytics.pro.f.ax);
    }
}
