package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;

/* loaded from: classes.dex */
public interface BitmapDecoder<T> {
    Bitmap decode(T t10, BitmapPool bitmapPool, int i10, int i11, DecodeFormat decodeFormat) throws Exception;

    String getId();
}
