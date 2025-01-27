package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: e */
    public int f9070e;

    /* renamed from: f */
    public int f9071f;

    /* renamed from: g */
    public int f9072g;

    /* renamed from: h */
    public int f9073h;

    /* renamed from: i */
    public int f9074i;

    /* renamed from: j */
    public float f9075j;

    /* renamed from: k */
    public float f9076k;

    /* renamed from: l */
    public int f9077l;

    /* renamed from: m */
    public int f9078m;

    /* renamed from: o */
    public int f9080o;

    /* renamed from: p */
    public int f9081p;

    /* renamed from: q */
    public boolean f9082q;

    /* renamed from: r */
    public boolean f9083r;

    /* renamed from: a */
    public int f9066a = Integer.MAX_VALUE;

    /* renamed from: b */
    public int f9067b = Integer.MAX_VALUE;

    /* renamed from: c */
    public int f9068c = Integer.MIN_VALUE;

    /* renamed from: d */
    public int f9069d = Integer.MIN_VALUE;

    /* renamed from: n */
    public List<Integer> f9079n = new ArrayList();

    public int a() {
        return this.f9072g;
    }

    public int b() {
        return this.f9080o;
    }

    public int c() {
        return this.f9073h;
    }

    public int d() {
        return this.f9073h - this.f9074i;
    }

    public int e() {
        return this.f9070e;
    }

    public float f() {
        return this.f9075j;
    }

    public float g() {
        return this.f9076k;
    }

    public void h(View view, int leftDecoration, int topDecoration, int rightDecoration, int bottomDecoration) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f9066a = Math.min(this.f9066a, (view.getLeft() - flexItem.x()) - leftDecoration);
        this.f9067b = Math.min(this.f9067b, (view.getTop() - flexItem.m()) - topDecoration);
        this.f9068c = Math.max(this.f9068c, view.getRight() + flexItem.y() + rightDecoration);
        this.f9069d = Math.max(this.f9069d, view.getBottom() + flexItem.w() + bottomDecoration);
    }
}
