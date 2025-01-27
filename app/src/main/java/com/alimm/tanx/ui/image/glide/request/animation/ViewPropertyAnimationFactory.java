package com.alimm.tanx.ui.image.glide.request.animation;

import com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation;

/* loaded from: classes.dex */
public class ViewPropertyAnimationFactory<R> implements GlideAnimationFactory<R> {
    private ViewPropertyAnimation<R> animation;
    private final ViewPropertyAnimation.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyAnimation.Animator animator) {
        this.animator = animator;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<R> build(boolean z10, boolean z11) {
        if (z10 || !z11) {
            return NoAnimation.get();
        }
        if (this.animation == null) {
            this.animation = new ViewPropertyAnimation<>(this.animator);
        }
        return this.animation;
    }
}
