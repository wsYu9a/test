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
public class a extends uk.co.senab.actionbarpulltorefresh.library.c {
    private Animation o;
    private Animation p;

    /* renamed from: uk.co.senab.actionbarpulltorefresh.extras.actionbarcompat.a$a */
    class AnimationAnimationListenerC0894a implements Animation.AnimationListener {
        AnimationAnimationListenerC0894a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (animation == a.this.p) {
                View o = a.this.o();
                if (o != null) {
                    o.setVisibility(8);
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

    @Override // uk.co.senab.actionbarpulltorefresh.library.c, uk.co.senab.actionbarpulltorefresh.library.e
    public boolean a() {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.a();
        }
        View o = o();
        boolean z = (o == null || o.getVisibility() == 8) ? false : true;
        if (z) {
            Animation animation = this.p;
            if (animation != null) {
                o.startAnimation(animation);
            } else {
                o.setVisibility(8);
                g();
            }
        }
        return z;
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.c, uk.co.senab.actionbarpulltorefresh.library.e
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

    @Override // uk.co.senab.actionbarpulltorefresh.library.c, uk.co.senab.actionbarpulltorefresh.library.e
    public void h(Activity activity, View view) {
        super.h(activity, view);
        this.o = AnimationUtils.loadAnimation(activity, R.anim.fade_in);
        Animation loadAnimation = AnimationUtils.loadAnimation(activity, R.anim.fade_out);
        this.p = loadAnimation;
        if (loadAnimation == null && this.o == null) {
            return;
        }
        AnimationAnimationListenerC0894a animationAnimationListenerC0894a = new AnimationAnimationListenerC0894a();
        Animation animation = this.p;
        if (animation != null) {
            animation.setAnimationListener(animationAnimationListenerC0894a);
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.c, uk.co.senab.actionbarpulltorefresh.library.e
    public boolean i() {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.i();
        }
        View o = o();
        boolean z = (o == null || o.getVisibility() == 0) ? false : true;
        if (z) {
            Animation animation = this.o;
            if (animation != null) {
                o.startAnimation(animation);
            }
            o.setVisibility(0);
        }
        return z;
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.c
    protected Drawable l(Context context) {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.l(context);
        }
        TypedArray q = uk.co.senab.actionbarpulltorefresh.library.c.q(context, R.attr.actionBarStyle, R.styleable.ActionBar);
        try {
            return q.getDrawable(10);
        } finally {
            q.recycle();
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.c
    protected int m(Context context) {
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

    @Override // uk.co.senab.actionbarpulltorefresh.library.c
    protected int n(Context context) {
        if (Build.VERSION.SDK_INT >= super.p()) {
            return super.n(context);
        }
        TypedArray q = uk.co.senab.actionbarpulltorefresh.library.c.q(context, R.attr.actionBarStyle, R.styleable.ActionBar);
        try {
            return q.getResourceId(5, 0);
        } finally {
            q.recycle();
        }
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.c
    protected int p() {
        return 7;
    }
}
