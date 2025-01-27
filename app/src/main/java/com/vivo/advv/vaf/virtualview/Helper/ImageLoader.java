package com.vivo.advv.vaf.virtualview.Helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.view.image.ImageBase;
import java.io.File;

/* loaded from: classes4.dex */
public class ImageLoader {
    private static final String TAG = "ImageLoader_TMTEST";
    private Context mContext;
    private IImageLoaderAdapter mImageLoaderAdapter;

    public static class DefaultImageLoaderAdapter implements IImageLoaderAdapter {
        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.IImageLoaderAdapter
        public void bindImage(String str, ImageBase imageBase, int i2, int i3) {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.IImageLoaderAdapter
        public boolean checkExist(String str, ViewBase viewBase) {
            return false;
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.IImageLoaderAdapter
        public void getBitmap(boolean z, String str, ViewBase viewBase, int i2, int i3, Listener listener) {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.IImageLoaderAdapter
        public void getBlurBitmap(Bitmap bitmap, ViewBase viewBase, float f2, int i2, Listener listener) {
        }
    }

    public static class DefaultListener implements Listener {
        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadFailed() {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(Bitmap bitmap) {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(Drawable drawable) {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(byte[] bArr, File file) {
        }
    }

    public interface IImageLoaderAdapter {
        void bindImage(String str, ImageBase imageBase, int i2, int i3);

        boolean checkExist(String str, ViewBase viewBase);

        void getBitmap(boolean z, String str, ViewBase viewBase, int i2, int i3, Listener listener);

        void getBlurBitmap(Bitmap bitmap, ViewBase viewBase, float f2, int i2, Listener listener);
    }

    public interface Listener {
        void onImageLoadFailed();

        void onImageLoadSuccess(Bitmap bitmap);

        void onImageLoadSuccess(Drawable drawable);

        void onImageLoadSuccess(byte[] bArr, File file);
    }

    private ImageLoader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static ImageLoader build(Context context) {
        return new ImageLoader(context);
    }

    public void bindBitmap(String str, ImageBase imageBase, int i2, int i3) {
        IImageLoaderAdapter iImageLoaderAdapter = this.mImageLoaderAdapter;
        if (iImageLoaderAdapter != null) {
            iImageLoaderAdapter.bindImage(str, imageBase, i2, i3);
        }
    }

    public boolean checkExist(String str, ViewBase viewBase) {
        IImageLoaderAdapter iImageLoaderAdapter = this.mImageLoaderAdapter;
        if (iImageLoaderAdapter != null) {
            return iImageLoaderAdapter.checkExist(str, viewBase);
        }
        return false;
    }

    public void getBitmap(boolean z, String str, ViewBase viewBase, int i2, int i3, Listener listener) {
        IImageLoaderAdapter iImageLoaderAdapter = this.mImageLoaderAdapter;
        if (iImageLoaderAdapter != null) {
            iImageLoaderAdapter.getBitmap(z, str, viewBase, i2, i3, listener);
        }
    }

    public void getBlurBitmap(Bitmap bitmap, ViewBase viewBase, float f2, int i2, Listener listener) {
        IImageLoaderAdapter iImageLoaderAdapter = this.mImageLoaderAdapter;
        if (iImageLoaderAdapter != null) {
            iImageLoaderAdapter.getBlurBitmap(bitmap, viewBase, f2, i2, listener);
        }
    }

    public void setImageLoaderAdapter(IImageLoaderAdapter iImageLoaderAdapter) {
        this.mImageLoaderAdapter = iImageLoaderAdapter;
    }
}
