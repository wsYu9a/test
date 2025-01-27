package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class u0 extends v {

    /* renamed from: a */
    public s0 f18926a;

    /* renamed from: b */
    public t0 f18927b;

    /* renamed from: c */
    public ObjectAnimator f18928c;

    /* renamed from: d */
    public boolean f18929d;

    public u0(Context context) {
        super(context);
        c();
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.f18929d = true;
        ObjectAnimator objectAnimator = this.f18928c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f18928c.start();
        }
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.f18929d = false;
        ObjectAnimator objectAnimator = this.f18928c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public final void c() {
        addView(new f(getContext()), new FrameLayout.LayoutParams(-1, -1));
        this.f18926a = new s0(getContext());
        this.f18927b = new t0(getContext());
        addView(this.f18926a, new ViewGroup.LayoutParams(-1, -1));
        addView(this.f18927b, new ViewGroup.LayoutParams(-1, -1));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18927b, (Property<t0, Float>) View.ROTATION_Y, -45.0f, 0.0f, 45.0f);
        this.f18928c = ofFloat;
        ofFloat.setDuration(1000L);
        this.f18928c.setRepeatCount(-1);
        this.f18928c.setRepeatMode(2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f18929d) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public u0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public u0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c();
    }
}
