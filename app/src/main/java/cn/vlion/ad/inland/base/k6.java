package cn.vlion.ad.inland.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class k6 extends i6 {

    /* renamed from: a */
    public ObjectAnimator f3048a;

    /* renamed from: b */
    public ObjectAnimator f3049b;

    /* renamed from: c */
    public AnimatorSet f3050c;

    /* renamed from: d */
    public ImageView f3051d;

    /* renamed from: e */
    public ImageView f3052e;

    /* renamed from: f */
    public View f3053f;

    /* renamed from: g */
    public boolean f3054g;

    public k6(Context context, int i10) {
        super(context);
        this.f3054g = false;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_swipe_guide, (ViewGroup) this, true);
            this.f3051d = (ImageView) findViewById(R.id.vlion_img_arrow);
            this.f3052e = (ImageView) findViewById(R.id.vlion_img_hand);
            this.f3053f = findViewById(R.id.vlion_BaseSwipeView);
            this.f3054g = false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            AnimatorSet animatorSet = this.f3050c;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.f3050c.cancel();
                this.f3050c = null;
                this.f3054g = false;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.i6
    public View getBaseSwipeView() {
        try {
            View view = this.f3053f;
            if (view != null) {
                view.setVisibility(0);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this.f3053f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        try {
            if (this.f3054g) {
                return;
            }
            this.f3051d.getLocationOnScreen(new int[2]);
            int width = this.f3051d.getWidth() / 2;
            LogVlion.e("VlionSwipeGuideLayout:   end == " + width);
            float f10 = (float) (-width);
            float f11 = (float) width;
            this.f3048a = ObjectAnimator.ofFloat(this.f3052e, "translationX", f10, f11).setDuration(1200L);
            this.f3049b = ObjectAnimator.ofFloat(this.f3052e, "translationX", f11, f10).setDuration(1200L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f3050c = animatorSet;
            animatorSet.play(this.f3048a).after(this.f3049b);
            this.f3050c.addListener(new j6(this));
            this.f3054g = true;
            this.f3050c.start();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
