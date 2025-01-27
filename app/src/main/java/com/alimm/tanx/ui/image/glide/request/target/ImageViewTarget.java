package com.alimm.tanx.ui.image.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation;

/* loaded from: classes.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements GlideAnimation.ViewAdapter {
    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadFailed(Exception exc, Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.Target
    public void onResourceReady(Z z10, GlideAnimation<? super Z> glideAnimation) {
        if (glideAnimation == null || !glideAnimation.animate(z10, this)) {
            setResource(z10);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation.ViewAdapter
    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public abstract void setResource(Z z10);
}
