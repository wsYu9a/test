package cn.vlion.ad.inland.base;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Path;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.sigmob.sdk.base.common.y;

/* loaded from: classes.dex */
public final class m6 extends i6 {

    /* renamed from: a */
    public ObjectAnimator f3097a;

    /* renamed from: b */
    public ObjectAnimator f3098b;

    /* renamed from: c */
    public AnimatorSet f3099c;

    /* renamed from: d */
    public ImageView f3100d;

    /* renamed from: e */
    public ImageView f3101e;

    /* renamed from: f */
    public boolean f3102f;

    /* renamed from: g */
    public View f3103g;

    public m6(Context context, int i10) {
        super(context);
        this.f3102f = false;
        try {
            LayoutInflater.from(context).inflate(R.layout.vlion_cn_ad_swipe_round_guide, (ViewGroup) this, true);
            this.f3100d = (ImageView) findViewById(R.id.vlion_img_arrow);
            this.f3101e = (ImageView) findViewById(R.id.vlion_img_hand);
            this.f3103g = findViewById(R.id.vlion_BaseSwipeView);
            this.f3102f = false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.d
    public final void destroy() {
        try {
            LogVlion.e("VlionSwipeRoundLayout  destroy");
            AnimatorSet animatorSet = this.f3099c;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.f3099c.cancel();
                this.f3099c = null;
                this.f3102f = false;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // cn.vlion.ad.inland.base.i6
    public View getBaseSwipeView() {
        try {
            View view = this.f3103g;
            if (view != null) {
                view.setVisibility(0);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this.f3103g;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        ImageView imageView;
        super.onLayout(z10, i10, i11, i12, i13);
        LogVlion.e("VlionSwipeRoundLayout  onLayout");
        try {
            LogVlion.e("VlionSwipeRoundLayout  isStart=" + this.f3102f);
            if (!this.f3102f && (imageView = this.f3100d) != null) {
                imageView.getLocationOnScreen(new int[2]);
                this.f3100d.getWidth();
                this.f3100d.getWidth();
                this.f3100d.getHeight();
                int width = this.f3100d.getWidth();
                int height = this.f3100d.getHeight();
                Path path = new Path();
                path.lineTo(0.0f, 0.0f);
                float f10 = width;
                float f11 = height;
                path.lineTo(f10, f11);
                path.lineTo(0.0f, 0.0f);
                Path path2 = new Path();
                path2.lineTo(f10, 0.0f);
                path2.lineTo(0.0f, f11);
                path2.lineTo(f10, 0.0f);
                path2.lineTo(0.0f, 0.0f);
                this.f3097a = ObjectAnimator.ofFloat(this.f3101e, "translationX", "translationY", path2).setDuration(3000L);
                this.f3098b = ObjectAnimator.ofFloat(this.f3101e, "translationX", "translationY", path).setDuration(y.f.f18076n);
                AnimatorSet animatorSet = new AnimatorSet();
                this.f3099c = animatorSet;
                animatorSet.play(this.f3097a).after(this.f3098b);
                this.f3099c.addListener(new l6(this));
                this.f3102f = true;
                this.f3099c.start();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
