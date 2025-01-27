package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;

/* loaded from: classes.dex */
public class GifBitmapWrapperResource implements Resource<GifBitmapWrapper> {
    private final GifBitmapWrapper data;

    public GifBitmapWrapperResource(GifBitmapWrapper gifBitmapWrapper) {
        if (gifBitmapWrapper == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.data = gifBitmapWrapper;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public int getSize() {
        return this.data.getSize();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
        Resource<Bitmap> bitmapResource = this.data.getBitmapResource();
        if (bitmapResource != null) {
            bitmapResource.recycle();
        }
        Resource<GifDrawable> gifResource = this.data.getGifResource();
        if (gifResource != null) {
            gifResource.recycle();
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public GifBitmapWrapper get() {
        return this.data;
    }
}
