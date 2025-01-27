package cn.vlion.ad.inland.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.javabean.VlionCustomAdData;
import cn.vlion.ad.inland.ad.javabean.VlionCustomParseAdData;
import cn.vlion.ad.inland.ad.view.active.VlionAdClosedView;
import cn.vlion.ad.inland.ad.view.active.VlionHalfCircleView;
import cn.vlion.ad.inland.base.a2;
import cn.vlion.ad.inland.base.j;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import com.sigmob.sdk.base.common.y;

/* loaded from: classes.dex */
public final class i extends n4 {

    /* renamed from: a */
    public ObjectAnimator f2862a;

    /* renamed from: b */
    public ObjectAnimator f2863b;

    /* renamed from: c */
    public ObjectAnimator f2864c;

    /* renamed from: d */
    public ObjectAnimator f2865d;

    /* renamed from: e */
    public ObjectAnimator f2866e;

    /* renamed from: f */
    public ObjectAnimator f2867f;

    /* renamed from: g */
    public AnimatorSet f2868g;

    /* renamed from: h */
    public AnimatorSet f2869h;

    /* renamed from: i */
    public AnimatorSet f2870i;

    /* renamed from: j */
    public ImageView f2871j;

    /* renamed from: k */
    public ImageView f2872k;

    /* renamed from: l */
    public ImageView f2873l;

    /* renamed from: m */
    public VlionHalfCircleView f2874m;

    /* renamed from: n */
    public ObjectAnimator f2875n;

    /* renamed from: o */
    public ObjectAnimator f2876o;

    /* renamed from: p */
    public VlionAdClosedView f2877p;

    /* renamed from: q */
    public o4 f2878q;

    /* renamed from: r */
    public FrameLayout f2879r;

    /* renamed from: s */
    public LinearLayout f2880s;

    /* renamed from: t */
    public int f2881t;

    /* renamed from: u */
    public TextView f2882u;

    /* renamed from: v */
    public TextView f2883v;

    /* renamed from: w */
    public VlionCustomParseAdData f2884w;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            try {
                AnimatorSet animatorSet = i.this.f2870i;
                if (animatorSet != null) {
                    animatorSet.start();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            try {
                AnimatorSet animatorSet = i.this.f2868g;
                if (animatorSet != null) {
                    animatorSet.start();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            try {
                AnimatorSet animatorSet = i.this.f2869h;
                if (animatorSet != null) {
                    animatorSet.start();
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    public i(Context context, int i10) {
        super(context);
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_splash_canvasview, (ViewGroup) this, true);
            this.f2880s = (LinearLayout) findViewById(R.id.vlion_cn_ad_img_container);
            this.f2877p = (VlionAdClosedView) findViewById(R.id.vlion_ad_closed);
            this.f2872k = (ImageView) findViewById(R.id.vlion_img_arrow1);
            this.f2873l = (ImageView) findViewById(R.id.vlion_img_arrow2);
            this.f2879r = (FrameLayout) findViewById(R.id.vlion_fl_phone_icon);
            this.f2871j = (ImageView) findViewById(R.id.vlion_img_phone_icon);
            this.f2874m = (VlionHalfCircleView) findViewById(R.id.vlion_halfCircleView);
            this.f2882u = (TextView) findViewById(R.id.vlion_ad_splash_tips);
            this.f2883v = (TextView) findViewById(R.id.vlion_ad_splash_action);
            i0 i0Var = new i0();
            this.f2874m.setOnTouchDataUtils(i0Var);
            this.f2874m.setListener(new f(this, i0Var));
            this.f2879r.setOnClickListener(new g(this, new i0(this.f2879r)));
            ImageView imageView = this.f2872k;
            if (imageView != null) {
                this.f2862a = ObjectAnimator.ofFloat(imageView, "alpha", 0.0f, 1.0f).setDuration(100L);
                this.f2864c = ObjectAnimator.ofFloat(this.f2872k, "alpha", 1.0f, 0.0f).setDuration(400L);
                this.f2866e = ObjectAnimator.ofFloat(this.f2872k, "translationY", 50.0f, -45.0f).setDuration(800L);
                this.f2868g = new AnimatorSet();
            }
            ImageView imageView2 = this.f2873l;
            if (imageView2 != null) {
                this.f2863b = ObjectAnimator.ofFloat(imageView2, "alpha", 0.0f, 1.0f).setDuration(100L);
                this.f2865d = ObjectAnimator.ofFloat(this.f2873l, "alpha", 1.0f, 0.0f).setDuration(400L);
                this.f2867f = ObjectAnimator.ofFloat(this.f2873l, "translationY", 65.0f, -55.0f).setDuration(800L);
                this.f2869h = new AnimatorSet();
            }
            this.f2875n = ObjectAnimator.ofFloat(this.f2871j, "rotation", 0.0f, -45.0f, -35.0f, -5.0f, 35.0f, 45.0f, 35.0f, 0.0f).setDuration(y.f.f18076n);
            this.f2876o = ObjectAnimator.ofFloat(this.f2871j, "rotationY", 5.0f, -55.0f, -15.0f, 15.0f, 55.0f, 0.0f).setDuration(y.f.f18076n);
            this.f2870i = new AnimatorSet();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a() {
        try {
            AnimatorSet animatorSet = this.f2870i;
            if (animatorSet != null) {
                animatorSet.playSequentially(this.f2875n, this.f2876o);
                this.f2870i.addListener(new a());
                this.f2870i.start();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b() {
        try {
            AnimatorSet animatorSet = this.f2868g;
            if (animatorSet != null) {
                animatorSet.play(this.f2866e).after(this.f2862a).before(this.f2864c);
                this.f2868g.addListener(new b());
                this.f2868g.start();
            }
            AnimatorSet animatorSet2 = this.f2869h;
            if (animatorSet2 != null) {
                animatorSet2.play(this.f2867f).after(this.f2863b).before(this.f2865d);
                this.f2869h.addListener(new c());
                this.f2869h.start();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            ObjectAnimator objectAnimator = this.f2862a;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f2862a.removeAllListeners();
                this.f2862a = null;
            }
            ObjectAnimator objectAnimator2 = this.f2864c;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
                this.f2864c.removeAllListeners();
                this.f2864c = null;
            }
            ObjectAnimator objectAnimator3 = this.f2866e;
            if (objectAnimator3 != null) {
                objectAnimator3.cancel();
                this.f2866e.removeAllListeners();
                this.f2866e = null;
            }
            AnimatorSet animatorSet = this.f2868g;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f2868g.removeAllListeners();
                this.f2868g = null;
            }
            ObjectAnimator objectAnimator4 = this.f2863b;
            if (objectAnimator4 != null) {
                objectAnimator4.cancel();
                this.f2863b.removeAllListeners();
                this.f2863b = null;
            }
            ObjectAnimator objectAnimator5 = this.f2865d;
            if (objectAnimator5 != null) {
                objectAnimator5.cancel();
                this.f2865d.removeAllListeners();
                this.f2865d = null;
            }
            ObjectAnimator objectAnimator6 = this.f2867f;
            if (objectAnimator6 != null) {
                objectAnimator6.cancel();
                this.f2867f.removeAllListeners();
                this.f2867f = null;
            }
            AnimatorSet animatorSet2 = this.f2869h;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
                this.f2869h.removeAllListeners();
                this.f2869h = null;
            }
            AnimatorSet animatorSet3 = this.f2870i;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
                this.f2870i.removeAllListeners();
                this.f2870i = null;
            }
            ObjectAnimator objectAnimator7 = this.f2875n;
            if (objectAnimator7 != null) {
                objectAnimator7.cancel();
                this.f2875n.removeAllListeners();
                this.f2875n = null;
            }
            ImageView imageView = this.f2872k;
            if (imageView != null) {
                imageView.clearAnimation();
                this.f2872k = null;
            }
            ImageView imageView2 = this.f2873l;
            if (imageView2 != null) {
                imageView2.clearAnimation();
                this.f2873l = null;
            }
            ImageView imageView3 = this.f2871j;
            if (imageView3 != null) {
                imageView3.clearAnimation();
                this.f2871j = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // cn.vlion.ad.inland.base.n4
    public void setAppinfo(VlionCustomAdData.SeatbidBean.BidBean.AppInfoBean appInfoBean) {
        if (appInfoBean != null) {
            try {
                if (getContext() != null) {
                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.vlion_ad_down_info);
                    TextView textView = (TextView) findViewById(R.id.vlion_down_bottom_tv_name);
                    TextView textView2 = (TextView) findViewById(R.id.vlion_down_bottom_tv_company);
                    TextView textView3 = (TextView) findViewById(R.id.vlion_down_bottom_tv_version);
                    TextView textView4 = (TextView) findViewById(R.id.vlion_down_bottom_tv_privacy);
                    TextView textView5 = (TextView) findViewById(R.id.vlion_down_bottom_tv_permission);
                    TextView textView6 = (TextView) findViewById(R.id.vlion_down_bottom_tv_intro);
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    Context context = getContext();
                    if (context == null) {
                        return;
                    }
                    try {
                        textView.setText(String.valueOf(appInfoBean.getApp_name()));
                        textView2.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_developer) + appInfoBean.getDeveloper_name());
                        textView3.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_code) + appInfoBean.getVersion_code());
                        textView4.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_privacy));
                        textView5.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_permission));
                        textView6.setText(context.getResources().getString(R.string.vlion_custom_ad_splash_text_intro));
                        textView4.setOnClickListener(new a2.a(context, appInfoBean));
                        textView5.setOnClickListener(new a2.b(context, appInfoBean));
                        textView6.setOnClickListener(new a2.c(context, appInfoBean));
                    } catch (Throwable th2) {
                        try {
                            VlionSDkManager.getInstance().upLoadCatchException(th2);
                        } catch (Throwable th3) {
                            VlionSDkManager.getInstance().upLoadCatchException(th3);
                            return;
                        }
                    }
                    try {
                        textView4.getPaint().setFlags(8);
                        textView4.getPaint().setAntiAlias(true);
                    } catch (Throwable th4) {
                        VlionSDkManager.getInstance().upLoadCatchException(th4);
                    }
                    try {
                        textView5.getPaint().setFlags(8);
                        textView5.getPaint().setAntiAlias(true);
                    } catch (Throwable th5) {
                        VlionSDkManager.getInstance().upLoadCatchException(th5);
                    }
                    try {
                        textView6.getPaint().setFlags(8);
                        textView6.getPaint().setAntiAlias(true);
                    } catch (Throwable th6) {
                        VlionSDkManager.getInstance().upLoadCatchException(th6);
                    }
                }
            } catch (Throwable th7) {
                VlionSDkManager.getInstance().upLoadCatchException(th7);
            }
        }
    }

    @Override // cn.vlion.ad.inland.base.n4
    public void settingVlionViewTouch(g7 g7Var) {
        try {
            VlionHalfCircleView vlionHalfCircleView = this.f2874m;
            if (vlionHalfCircleView != null) {
                vlionHalfCircleView.settingVlionViewTouch(g7Var);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(View view) {
        try {
            this.f2880s.removeAllViews();
            if (view != null) {
                j0.a(view);
                this.f2880s.addView(view, -1, -1);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(VlionAdapterADConfig vlionAdapterADConfig, boolean z10, boolean z11, j.c cVar, VlionCustomParseAdData vlionCustomParseAdData) {
        if (vlionAdapterADConfig == null) {
            return;
        }
        try {
            this.f2884w = vlionCustomParseAdData;
            this.f2878q = cVar;
            if (z10) {
                this.f2879r.setVisibility(0);
                a();
            } else {
                this.f2879r.setVisibility(8);
            }
            if (z11) {
                this.f2872k.setVisibility(0);
                this.f2873l.setVisibility(0);
                b();
            } else {
                this.f2872k.setVisibility(8);
                this.f2873l.setVisibility(8);
            }
            this.f2877p.a("跳过", true, new h(this, cVar));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                this.f2882u.setVisibility(8);
            }
            this.f2882u.setText(str);
            this.f2883v.setText(str2);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
