package com.sigmob.sdk.mraid;

import android.content.Context;
import android.graphics.Rect;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: a */
    public final Context f19599a;

    /* renamed from: b */
    public final Rect f19600b = new Rect();

    /* renamed from: c */
    public final Rect f19601c = new Rect();

    /* renamed from: d */
    public final Rect f19602d = new Rect();

    /* renamed from: e */
    public final Rect f19603e = new Rect();

    /* renamed from: f */
    public final Rect f19604f = new Rect();

    /* renamed from: g */
    public final Rect f19605g = new Rect();

    /* renamed from: h */
    public final Rect f19606h = new Rect();

    /* renamed from: i */
    public final Rect f19607i = new Rect();

    /* renamed from: j */
    public final float f19608j;

    public l(Context context, float f10) {
        this.f19599a = context.getApplicationContext();
        this.f19608j = f10;
    }

    public final void a(Rect rect, Rect rect2) {
        rect2.set(Dips.pixelsToIntDips(rect.left, this.f19599a), Dips.pixelsToIntDips(rect.top, this.f19599a), Dips.pixelsToIntDips(rect.right, this.f19599a), Dips.pixelsToIntDips(rect.bottom, this.f19599a));
    }

    public Rect b() {
        return this.f19605g;
    }

    public Rect c() {
        return this.f19606h;
    }

    public Rect d() {
        return this.f19607i;
    }

    public float e() {
        return this.f19608j;
    }

    public Rect f() {
        return this.f19602d;
    }

    public Rect g() {
        return this.f19603e;
    }

    public Rect h() {
        return this.f19600b;
    }

    public Rect i() {
        return this.f19601c;
    }

    public Rect a() {
        return this.f19604f;
    }

    public void b(int i10, int i11, int i12, int i13) {
        this.f19606h.set(i10, i11, i12 + i10, i13 + i11);
        a(this.f19606h, this.f19607i);
    }

    public void c(int i10, int i11, int i12, int i13) {
        this.f19602d.set(i10, i11, i12 + i10, i13 + i11);
        a(this.f19602d, this.f19603e);
    }

    public void a(int i10, int i11, int i12, int i13) {
        this.f19604f.set(i10, i11, i12 + i10, i13 + i11);
        a(this.f19604f, this.f19605g);
    }

    public void a(int i10, int i11) {
        this.f19600b.set(0, 0, i10, i11);
        a(this.f19600b, this.f19601c);
    }
}
