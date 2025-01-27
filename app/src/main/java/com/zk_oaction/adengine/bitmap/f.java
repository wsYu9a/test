package com.zk_oaction.adengine.bitmap;

import android.graphics.Bitmap;

/* loaded from: classes5.dex */
public class f implements h, com.zk_oaction.adengine.lk_interfaces.b {

    /* renamed from: a */
    String f34748a;

    /* renamed from: b */
    float f34749b;

    /* renamed from: c */
    i f34750c;

    public f(i iVar, String str, float f2) {
        this.f34750c = iVar;
        this.f34748a = str;
        this.f34749b = f2;
        iVar.a(str, f2, 1);
        this.f34750c.e(str, f2, this);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public Bitmap b() {
        return this.f34750c.a(this.f34748a, this.f34749b, 0);
    }

    @Override // com.zk_oaction.adengine.bitmap.h
    public void b(String str, float f2, boolean z) {
        this.f34750c.b(str, f2, z);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int c() {
        return this.f34750c.d(this.f34748a, this.f34749b);
    }

    @Override // com.zk_oaction.adengine.lk_interfaces.b
    public int d() {
        return this.f34750c.c(this.f34748a, this.f34749b);
    }
}
