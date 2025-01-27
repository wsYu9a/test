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
public final class o6 extends i6 {

    /* renamed from: a */
    public ObjectAnimator f3265a;

    /* renamed from: b */
    public ObjectAnimator f3266b;

    /* renamed from: c */
    public AnimatorSet f3267c;

    /* renamed from: d */
    public ImageView f3268d;

    /* renamed from: e */
    public ImageView f3269e;

    /* renamed from: f */
    public View f3270f;

    /* renamed from: g */
    public boolean f3271g;

    public o6(Context context, int i10) {
        super(context);
        this.f3271g = false;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_swipe_up, (ViewGroup) this, true);
            this.f3268d = (ImageView) findViewById(R.id.vlion_img_arrow);
            this.f3269e = (ImageView) findViewById(R.id.vlion_img_hand);
            this.f3270f = findViewById(R.id.vlion_BaseSwipeView);
            this.f3271g = false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            AnimatorSet animatorSet = this.f3267c;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.f3267c.cancel();
                this.f3267c = null;
                this.f3271g = false;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.i6
    public View getBaseSwipeView() {
        View view = this.f3270f;
        if (view != null) {
            view.setVisibility(0);
        }
        return this.f3270f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        try {
            if (this.f3271g) {
                return;
            }
            this.f3268d.getLocationOnScreen(new int[2]);
            int height = this.f3268d.getHeight() / 2;
            LogVlion.e("VlionSwipeGuideLayout:   end == " + height);
            float f10 = (float) (-height);
            float f11 = (float) height;
            this.f3265a = ObjectAnimator.ofFloat(this.f3269e, "translationY", f10, f11).setDuration(1200L);
            this.f3266b = ObjectAnimator.ofFloat(this.f3269e, "translationY", f11, f10).setDuration(1200L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f3267c = animatorSet;
            animatorSet.play(this.f3265a).after(this.f3266b);
            this.f3267c.addListener(new n6(this));
            this.f3271g = true;
            this.f3267c.start();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
