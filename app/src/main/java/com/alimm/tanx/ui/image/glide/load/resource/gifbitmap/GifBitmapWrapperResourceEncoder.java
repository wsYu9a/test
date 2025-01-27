package com.alimm.tanx.ui.image.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class GifBitmapWrapperResourceEncoder implements ResourceEncoder<GifBitmapWrapper> {
    private final ResourceEncoder<Bitmap> bitmapEncoder;
    private final ResourceEncoder<GifDrawable> gifEncoder;

    /* renamed from: id */
    private String f6334id;

    public GifBitmapWrapperResourceEncoder(ResourceEncoder<Bitmap> resourceEncoder, ResourceEncoder<GifDrawable> resourceEncoder2) {
        this.bitmapEncoder = resourceEncoder;
        this.gifEncoder = resourceEncoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        if (this.f6334id == null) {
            this.f6334id = this.bitmapEncoder.getId() + this.gifEncoder.getId();
        }
        return this.f6334id;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(Resource<GifBitmapWrapper> resource, OutputStream outputStream) {
        GifBitmapWrapper gifBitmapWrapper = resource.get();
        Resource<Bitmap> bitmapResource = gifBitmapWrapper.getBitmapResource();
        return bitmapResource != null ? this.bitmapEncoder.encode(bitmapResource, outputStream) : this.gifEncoder.encode(gifBitmapWrapper.getGifResource(), outputStream);
    }
}
