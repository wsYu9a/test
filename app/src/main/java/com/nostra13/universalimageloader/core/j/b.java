package com.nostra13.universalimageloader.core.j;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class b extends d {
    public b(ImageView imageView) {
        super(imageView);
    }

    private static int c(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue <= 0 || intValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return intValue;
        } catch (Exception e2) {
            b.g.a.b.d.d(e2);
            return 0;
        }
    }

    @Override // com.nostra13.universalimageloader.core.j.d
    protected void a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // com.nostra13.universalimageloader.core.j.d
    protected void b(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    /* renamed from: d */
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        return (height > 0 || (imageView = (ImageView) this.f16044c.get()) == null) ? height : c(imageView, "mMaxHeight");
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.f16044c.get();
        return imageView != null ? ViewScaleType.fromImageView(imageView) : super.getScaleType();
    }

    @Override // com.nostra13.universalimageloader.core.j.d, com.nostra13.universalimageloader.core.j.a
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        return (width > 0 || (imageView = (ImageView) this.f16044c.get()) == null) ? width : c(imageView, "mMaxWidth");
    }

    public b(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
