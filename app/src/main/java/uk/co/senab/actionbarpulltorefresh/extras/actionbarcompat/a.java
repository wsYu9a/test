package uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* loaded from: classes5.dex */
public class a extends uk.co.senab.actionbarpulltorefresh.library.a {

    /* renamed from: o */
    public Animation f31141o;

    /* renamed from: p */
    public Animation f31142p;

    /* renamed from: uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.a$a */
    public class AnimationAnimationListenerC0793a implements Animation.AnimationListener {
        public AnimationAnimationListenerC0793a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (animation == a.this.f31142p) {
                View o10 = a.this.o();
                if (o10 != null) {
                    o10.setVisibility(8);
                }
                a.this.g();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a, uk.d
    public boolean a() {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.a();
        }
        View o10 = o();
        boolean z10 = (o10 == null || o10.getVisibility() == 8) ? false : true;
        if (z10) {
            Animation animation = this.f31142p;
            if (animation != null) {
                o10.startAnimation(animation);
            } else {
                o10.setVisibility(8);
                g();
            }
        }
        return z10;
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a, uk.d
    public void d() {
        if (Build.VERSION.SDK_INT >= super.p()) {
            super.d();
            return;
        }
        View findViewById = o().findViewById(R.id.ptr_content);
        if (findViewById != null) {
            findViewById.startAnimation(AnimationUtils.loadAnimation(findViewById.getContext(), R.anim.fade_out));
            findViewById.setVisibility(4);
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a, uk.d
    public void h(Activity activity, View view) {
        super.h(activity, view);
        this.f31141o = AnimationUtils.loadAnimation(activity, R.anim.fade_in);
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.fade_out);
        this.f31142p = loadAnimation;
        if (loadAnimation == null && this.f31141o == null) {
            return;
        }
        AnimationAnimationListenerC0793a animationAnimationListenerC0793a = new AnimationAnimationListenerC0793a();
        Animation animation = this.f31142p;
        if (animation != null) {
            animation.setAnimationListener(animationAnimationListenerC0793a);
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a, uk.d
    public boolean i() {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.i();
        }
        View o10 = o();
        boolean z10 = (o10 == null || o10.getVisibility() == 0) ? false : true;
        if (z10) {
            Animation animation = this.f31141o;
            if (animation != null) {
                o10.startAnimation(animation);
            }
            o10.setVisibility(0);
        }
        return z10;
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a
    public Drawable l(Context context) {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.l(context);
        }
        TypedArray q10 = uk.co.senab.actionbarpulltorefresh.library.a.q(context, R.attr.actionBarStyle, R.styleable.ActionBar);
        try {
            return q10.getDrawable(10);
        } finally {
            q10.recycle();
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a
    public int m(Context context) {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.m(context);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.actionBarSize});
        try {
            return obtainStyledAttributes.getDimensionPixelSize(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a
    public int n(Context context) {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.n(context);
        }
        TypedArray q10 = uk.co.senab.actionbarpulltorefresh.library.a.q(context, R.attr.actionBarStyle, R.styleable.ActionBar);
        try {
            return q10.getResourceId(5, 0);
        } finally {
            q10.recycle();
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.a
    public int p() {
        return 7;
    }
}
