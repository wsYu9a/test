package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class n0 extends v {

    /* renamed from: a */
    public m0 f18819a;

    /* renamed from: b */
    public e f18820b;

    /* renamed from: c */
    public boolean f18821c;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            n0.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            n0.this.c();
        }
    }

    public n0(Context context) {
        super(context);
        this.f18821c = false;
        View fVar = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(fVar, layoutParams);
        this.f18820b = new e(context);
        this.f18819a = new m0(context);
        this.f18820b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f18820b);
        addView(this.f18819a);
        d();
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.f18821c = false;
        e eVar = this.f18820b;
        if (eVar != null) {
            eVar.a(0.0f);
        }
        m0 m0Var = this.f18819a;
        if (m0Var != null) {
            m0Var.e();
        }
    }

    public final void c() {
        int width = (int) (getWidth() * 0.25f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, (int) (width * 1.62f));
        layoutParams.setMargins(0, (int) (getHeight() * 0.38f), 0, 0);
        layoutParams.addRule(14);
        this.f18819a.setLayoutParams(layoutParams);
    }

    public final void d() {
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f18821c) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        d();
    }

    public n0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18821c = false;
        d();
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.f18821c = true;
        m0 m0Var = this.f18819a;
        if (m0Var != null) {
            m0Var.d();
        }
    }

    public n0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f18821c = false;
        d();
    }

    public void a(float f10) {
        e eVar = this.f18820b;
        if (eVar == null || !this.f18821c) {
            return;
        }
        eVar.a(f10);
    }
}
