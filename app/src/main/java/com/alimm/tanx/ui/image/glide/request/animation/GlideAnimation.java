package com.alimm.tanx.ui.image.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
public interface GlideAnimation<R> {

    public interface ViewAdapter {
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable drawable);
    }

    boolean animate(R r10, ViewAdapter viewAdapter);
}
