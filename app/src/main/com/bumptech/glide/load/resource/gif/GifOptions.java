package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;

/* loaded from: classes2.dex */
public final class GifOptions {
    public static final Option<DecodeFormat> DECODE_FORMAT = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.DecodeFormat", DecodeFormat.DEFAULT);
    public static final Option<Boolean> DISABLE_ANIMATION = Option.memory("com.bumptech.glide.load.resource.gif.GifOptions.DisableAnimation", Boolean.FALSE);

    private GifOptions() {
    }
}
