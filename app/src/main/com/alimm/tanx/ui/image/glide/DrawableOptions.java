package com.alimm.tanx.ui.image.glide;

import android.view.animation.Animation;

/* loaded from: classes.dex */
interface DrawableOptions {
    GenericRequestBuilder<?, ?, ?, ?> crossFade();

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i10);

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i10, int i11);

    @Deprecated
    GenericRequestBuilder<?, ?, ?, ?> crossFade(Animation animation, int i10);
}
