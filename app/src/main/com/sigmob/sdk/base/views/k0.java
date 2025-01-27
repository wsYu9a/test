package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class k0 extends v {

    /* renamed from: a */
    public j0 f18727a;

    /* renamed from: b */
    public f f18728b;

    /* renamed from: c */
    public boolean f18729c;

    public k0(Context context) {
        super(context);
        this.f18729c = false;
        c();
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.f18729c = true;
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.f18729c = false;
        j0 j0Var = this.f18727a;
        if (j0Var != null) {
            j0Var.a(0.0f);
        }
    }

    public final void c() {
        f fVar = new f(getContext());
        this.f18728b = fVar;
        addView(fVar, new RelativeLayout.LayoutParams(-1, -1));
        this.f18727a = new j0(getContext());
        addView(this.f18727a, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
    }

    public k0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18729c = false;
        c();
    }

    public void a(float f10) {
        j0 j0Var = this.f18727a;
        if (j0Var == null || !this.f18729c) {
            return;
        }
        j0Var.a(f10);
    }

    public k0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18729c = false;
        c();
    }
}
