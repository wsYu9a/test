package com.kwad.sdk.core.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.core.imageloader.core.assist.ViewScaleType;
import com.kwad.sdk.utils.w;

/* loaded from: classes3.dex */
public class ImageViewAware extends ViewAware {
    public ImageViewAware(ImageView imageView) {
        super(imageView);
    }

    private static int getImageViewFieldValue(Object obj, String str) {
        try {
            int intValue = ((Integer) w.getField(obj, str)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        return (height > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? height : getImageViewFieldValue(imageView, "mMaxHeight");
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.viewRef.get();
        return imageView != null ? ViewScaleType.fromImageView(imageView) : super.getScaleType();
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        return (width > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? width : getImageViewFieldValue(imageView, "mMaxWidth");
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware
    public void setImageBitmapInto(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware
    public void setImageDrawableInto(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    public ImageViewAware(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }

    @Override // com.kwad.sdk.core.imageloader.core.imageaware.ViewAware, com.kwad.sdk.core.imageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }
}
