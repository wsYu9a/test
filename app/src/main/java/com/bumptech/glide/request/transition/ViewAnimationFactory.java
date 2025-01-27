package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

/* loaded from: classes2.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    private Transition<R> transition;
    private final ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    public static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final Animation animation;

        public ConcreteViewTransitionAnimationFactory(Animation animation) {
            this.animation = animation;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context context) {
            return this.animation;
        }
    }

    public static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        private final int animationId;

        public ResourceViewTransitionAnimationFactory(int i10) {
            this.animationId = i10;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context context) {
            return AnimationUtils.loadAnimation(context, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this(new ConcreteViewTransitionAnimationFactory(animation));
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z10) {
        if (dataSource == DataSource.MEMORY_CACHE || !z10) {
            return NoTransition.get();
        }
        if (this.transition == null) {
            this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
        }
        return this.transition;
    }

    public ViewAnimationFactory(int i10) {
        this(new ResourceViewTransitionAnimationFactory(i10));
    }

    public ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }
}
