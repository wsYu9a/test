package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes2.dex */
public interface RequestListener<R> {
    boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z10);

    boolean onResourceReady(R r10, Object obj, Target<R> target, DataSource dataSource, boolean z10);
}
