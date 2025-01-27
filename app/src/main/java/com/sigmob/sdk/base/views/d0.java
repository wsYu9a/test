package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: classes4.dex */
public class d0 extends RelativeLayout {

    /* renamed from: i */
    public static final int f18514i = 1;

    /* renamed from: j */
    public static final int f18515j = 2;

    /* renamed from: a */
    public ImageView f18516a;

    /* renamed from: b */
    public TextView f18517b;

    /* renamed from: c */
    public TextView f18518c;

    /* renamed from: d */
    public AnimatorSet f18519d;

    /* renamed from: e */
    public ObjectAnimator f18520e;

    /* renamed from: f */
    public ObjectAnimator f18521f;

    /* renamed from: g */
    public View f18522g;

    /* renamed from: h */
    public boolean f18523h;

    public class a implements Animator.AnimatorListener {

        /* renamed from: com.sigmob.sdk.base.views.d0$a$a */
        public class RunnableC0579a implements Runnable {
            public RunnableC0579a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d0.this.f18523h) {
                    return;
                }
                d0.this.f18520e.start();
            }
        }

        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0579a(), 300L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public d0(Context context) {
        super(context);
        b(context);
    }

    public void a() {
        this.f18521f.start();
    }

    public final void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18522g, "translationY", 0.0f, 30.0f, 0.0f, -30.0f, 0.0f);
        this.f18521f = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f18521f.setRepeatCount(2);
        this.f18521f.setDuration(400L);
    }

    public d0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void b() {
        int i10 = this.f18516a.getLayoutParams().height;
        this.f18516a.setPivotX(this.f18516a.getLayoutParams().width);
        this.f18516a.setPivotY(i10 * 0.8f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18516a, "rotation", 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f);
        this.f18520e = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f18520e.addListener(new a());
        this.f18520e.setDuration(qe.a.f30009d);
    }

    public d0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context);
    }

    public final int a(Context context) {
        return ResourceUtil.getLayoutId(context, "sig_shake_view_layout");
    }

    public final void b(Context context) {
        View.inflate(context, a(context), this);
        this.f18516a = (ImageView) findViewById(ResourceUtil.getId(context, "sig_shakeImageView"));
        this.f18517b = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeTitleView"));
        this.f18518c = (TextView) findViewById(ResourceUtil.getId(context, "sig_shakeDescView"));
        this.f18522g = findViewById(ResourceUtil.getId(context, "sig_shake_view"));
        c();
        b();
    }

    public void a(int i10) {
        ObjectAnimator objectAnimator;
        if (i10 != 1) {
            this.f18523h = true;
            this.f18520e.cancel();
            objectAnimator = this.f18521f;
        } else {
            objectAnimator = this.f18520e;
        }
        objectAnimator.start();
    }
}
