package cn.vlion.ad.inland.base;

import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import cn.vlion.ad.inland.ad.view.active.VlionShakeGuideLayout;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class h6 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ VlionShakeGuideLayout f2857a;

    public h6(VlionShakeGuideLayout vlionShakeGuideLayout) {
        this.f2857a = vlionShakeGuideLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ImageView imageView = this.f2857a.f2422a;
            if (imageView != null) {
                imageView.clearAnimation();
                this.f2857a.f2424c = new RotateAnimation(-5.0f, 5.0f, 1, 1.0f, 1, 1.0f);
                this.f2857a.f2424c.setRepeatMode(2);
                this.f2857a.f2424c.setRepeatCount(-1);
                this.f2857a.f2424c.setDuration(400L);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(this.f2857a.f2424c);
                this.f2857a.f2422a.startAnimation(animationSet);
                this.f2857a.f2423b = true;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
