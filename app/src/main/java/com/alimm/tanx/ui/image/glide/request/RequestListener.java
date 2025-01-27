package com.alimm.tanx.ui.image.glide.request;

import com.alimm.tanx.ui.image.glide.request.target.Target;

/* loaded from: classes.dex */
public interface RequestListener<T, R> {
    boolean onException(Exception exc, T t10, Target<R> target, boolean z10);

    boolean onResourceReady(R r10, T t10, Target<R> target, boolean z10, boolean z11);
}
