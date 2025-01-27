package com.zk_oaction.adengine.lk_sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.zk_oaction.adengine.lk_view.g;
import com.zk_oaction.adengine.lk_view.m;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a */
    public c f34875a;

    public b(Context context, com.zk_oaction.adengine.lk_interfaces.a aVar) {
        this.f34875a = new c(context, aVar);
    }

    public View a(String str) {
        return this.f34875a.B(str);
    }

    public View b(String str, com.zk_oaction.adengine.lk_interfaces.c cVar) {
        return this.f34875a.e(str, cVar);
    }

    public void c() {
        this.f34875a.S();
    }

    public void d(int i2) {
        this.f34875a.l(i2);
    }

    public void e(View view, String str) {
        if (view == null || !(view instanceof m)) {
            return;
        }
        ((m) view).m(str);
    }

    public void f(View view, String str, Bitmap bitmap) {
        if (view == null || !(view instanceof g)) {
            return;
        }
        ((g) view).U(str, bitmap);
    }

    public void g(com.zk_oaction.adengine.lk_interfaces.b bVar) {
        this.f34875a.o(bVar);
    }

    public void h(String str, String str2) {
        com.zk_oaction.adengine.lk_variable.g gVar = this.f34875a.J;
        if (gVar != null) {
            gVar.f(str, str2);
        }
    }

    public void i(boolean z) {
        this.f34875a.y(z);
    }

    public String j(String str) {
        com.zk_oaction.adengine.lk_variable.g gVar = this.f34875a.J;
        if (gVar != null) {
            return gVar.h(str);
        }
        return null;
    }

    public void k() {
        this.f34875a.W();
    }

    public void l(int i2) {
        this.f34875a.D(i2);
    }

    public void m(String str, String str2) {
        this.f34875a.H(str, str2);
    }

    public void n() {
        this.f34875a.b0();
    }

    public float o() {
        return this.f34875a.P;
    }

    public int p() {
        return this.f34875a.Z;
    }

    public int q() {
        return this.f34875a.a0;
    }
}
