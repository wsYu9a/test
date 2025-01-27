package com.alimm.tanx.ui.image.glide.request.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation;

/* loaded from: classes.dex */
public class DrawableCrossFadeFactory<T extends Drawable> implements GlideAnimationFactory<T> {
    private static final int DEFAULT_DURATION_MS = 300;
    private final ViewAnimationFactory<T> animationFactory;
    private final int duration;
    private DrawableCrossFadeViewAnimation<T> firstResourceAnimation;
    private DrawableCrossFadeViewAnimation<T> secondResourceAnimation;

    public static class DefaultAnimationFactory implements ViewAnimation.AnimationFactory {
        private final int duration;

        public DefaultAnimationFactory(int i10) {
            this.duration = i10;
        }

        @Override // com.alimm.tanx.ui.image.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.duration);
            return alphaAnimation;
        }
    }

    public DrawableCrossFadeFactory() {
        this(300);
    }

    private GlideAnimation<T> getFirstResourceAnimation() {
        if (this.firstResourceAnimation == null) {
            this.firstResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, true), this.duration);
        }
        return this.firstResourceAnimation;
    }

    private GlideAnimation<T> getSecondResourceAnimation() {
        if (this.secondResourceAnimation == null) {
            this.secondResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, false), this.duration);
        }
        return this.secondResourceAnimation;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<T> build(boolean z10, boolean z11) {
        return z10 ? NoAnimation.get() : z11 ? getFirstResourceAnimation() : getSecondResourceAnimation();
    }

    public DrawableCrossFadeFactory(int i10) {
        this.animationFactory = new ViewAnimationFactory<>(new DefaultAnimationFactory(i10));
        this.duration = i10;
    }

    public DrawableCrossFadeFactory(Context context, int i10, int i11) {
        this.animationFactory = new ViewAnimationFactory<>(context, i10);
        this.duration = i11;
    }

    public DrawableCrossFadeFactory(Animation animation, int i10) {
        this.animationFactory = new ViewAnimationFactory<>(animation);
        this.duration = i10;
    }

    public DrawableCrossFadeFactory(ViewAnimationFactory<T> viewAnimationFactory, int i10) {
        this.animationFactory = viewAnimationFactory;
        this.duration = i10;
    }
}
