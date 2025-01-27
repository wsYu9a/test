package com.vivo.advv.vaf.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.ImageLoader;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.util.ViewUtils;
import com.vivo.advv.virtualview.common.StringBase;
import java.io.File;

/* loaded from: classes4.dex */
public class NativeImage extends ImageBase {
    private static final String TAG = "NativeImage_TMTEST";
    protected NativeImageImp mNative;

    /* renamed from: com.vivo.advv.vaf.virtualview.view.image.NativeImage$1 */
    class AnonymousClass1 implements ImageLoader.Listener {

        /* renamed from: com.vivo.advv.vaf.virtualview.view.image.NativeImage$1$1 */
        class C05641 extends ImageLoader.DefaultListener {
            C05641() {
            }

            @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
            public void onImageLoadSuccess(Bitmap bitmap) {
                super.onImageLoadSuccess(bitmap);
                NativeImage.this.setBackgroundImage(bitmap);
            }
        }

        /* renamed from: com.vivo.advv.vaf.virtualview.view.image.NativeImage$1$2 */
        class AnonymousClass2 extends ImageLoader.DefaultListener {
            AnonymousClass2() {
            }

            @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
            public void onImageLoadSuccess(Bitmap bitmap) {
                NativeImage.this.setBitmap(bitmap, true);
            }

            @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
            public void onImageLoadSuccess(Drawable drawable) {
                NativeImage.this.setImageDrawable(drawable, true);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadFailed() {
            boolean needCheck = NativeImage.this.needCheck(StringBase.STR_ID_error);
            ImageLoader imageLoader = ((ViewBase) NativeImage.this).mContext.getImageLoader();
            NativeImage nativeImage = NativeImage.this;
            imageLoader.getBitmap(needCheck, nativeImage.mError, nativeImage, nativeImage.getComMeasuredWidth(), NativeImage.this.getComMeasuredHeight(), new ImageLoader.DefaultListener() { // from class: com.vivo.advv.vaf.virtualview.view.image.NativeImage.1.2
                AnonymousClass2() {
                }

                @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadSuccess(Bitmap bitmap) {
                    NativeImage.this.setBitmap(bitmap, true);
                }

                @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadSuccess(Drawable drawable) {
                    NativeImage.this.setImageDrawable(drawable, true);
                }
            });
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(byte[] bArr, File file) {
            NativeImage.this.mNative.decode2Src(bArr, file);
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(Bitmap bitmap) {
            NativeImage.this.setBitmap(bitmap, true);
            NativeImage nativeImage = NativeImage.this;
            if (nativeImage.mBgBlurRadius <= 0 || nativeImage.mBgBlurSampling <= 0.0f) {
                return;
            }
            ImageLoader imageLoader = ((ViewBase) nativeImage).mContext.getImageLoader();
            NativeImage nativeImage2 = NativeImage.this;
            imageLoader.getBlurBitmap(bitmap, nativeImage2, nativeImage2.mBgBlurSampling, nativeImage2.mBgBlurRadius, new ImageLoader.DefaultListener() { // from class: com.vivo.advv.vaf.virtualview.view.image.NativeImage.1.1
                C05641() {
                }

                @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadSuccess(Bitmap bitmap2) {
                    super.onImageLoadSuccess(bitmap2);
                    NativeImage.this.setBackgroundImage(bitmap2);
                }
            });
        }

        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(Drawable drawable) {
            NativeImage.this.setImageDrawable(drawable, true);
        }
    }

    public static class Builder implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new NativeImage(vafContext, viewCache);
        }
    }

    public NativeImage(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mNative = new NativeImageImp(vafContext.forViewConstruction());
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        super.comLayout(i2, i3, i4, i5);
        this.mNative.comLayout(i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return this.mNative.getComMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return this.mNative.getComMeasuredWidth();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        int i4 = this.mAutoDimDirection;
        if (i4 > 0) {
            if (i4 != 1) {
                if (i4 == 2 && 1073741824 == View.MeasureSpec.getMode(scaleHeightMeasureSpec)) {
                    scaleWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleHeightMeasureSpec) * this.mAutoDimX) / this.mAutoDimY), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(scaleWidthMeasureSpec)) {
                scaleHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleWidthMeasureSpec) * this.mAutoDimY) / this.mAutoDimX), 1073741824);
            }
        }
        this.mNative.measureComponent(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onComLayout(z, i2, i3, i4, i5);
        this.mNative.onComLayout(z, i2, i3, i4, i5);
        if (TextUtils.isEmpty(this.mSrc)) {
            return;
        }
        setSrc(this.mSrc);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        int scaleWidthMeasureSpec = ViewUtils.scaleWidthMeasureSpec(i2, this.mScaleFactor, this.mParams);
        int scaleHeightMeasureSpec = ViewUtils.scaleHeightMeasureSpec(i3, this.mScaleFactor, this.mParams);
        int i4 = this.mAutoDimDirection;
        if (i4 > 0) {
            if (i4 != 1) {
                if (i4 == 2 && 1073741824 == View.MeasureSpec.getMode(scaleHeightMeasureSpec)) {
                    scaleWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleHeightMeasureSpec) * this.mAutoDimX) / this.mAutoDimY), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(scaleWidthMeasureSpec)) {
                scaleHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(scaleWidthMeasureSpec) * this.mAutoDimY) / this.mAutoDimX), 1073741824);
            }
        }
        this.mNative.onComMeasure(scaleWidthMeasureSpec, scaleHeightMeasureSpec);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        this.mNative.setScaleType(ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType));
        this.mNative.setBorderTopLeftRadius((int) (this.mBorderTopLeftRadius * this.mScaleFactor));
        this.mNative.setBorderTopRightRadius((int) (this.mBorderTopRightRadius * this.mScaleFactor));
        this.mNative.setBorderBottomLeftRadius((int) (this.mBorderBottomLeftRadius * this.mScaleFactor));
        this.mNative.setBorderBottomRightRadius((int) (this.mBorderBottomRightRadius * this.mScaleFactor));
        if (TextUtils.isEmpty(this.mSrc) || !needCheck(StringBase.STR_ID_src)) {
            return;
        }
        this.mContext.getImageLoader().checkExist(this.mSrc, this);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mLoadedSrc = false;
        this.mSrc = "";
        this.mContext.getImageLoader().getBitmap(needCheck(StringBase.STR_ID_src), this.mSrc, this, getComMeasuredWidth(), getComMeasuredHeight(), new ImageLoader.DefaultListener());
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void setBackgroundImage(Bitmap bitmap) {
        this.mNative.setBackground(new BitmapDrawable(bitmap));
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase
    public void setBitmap(Bitmap bitmap, boolean z) {
        this.mNative.setImageBitmap(bitmap);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase
    public void setImageDrawable(Drawable drawable, boolean z) {
        this.mNative.setImageDrawable(drawable);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase
    public void setSrc(String str) {
        if (!(TextUtils.equals(this.mSrc, str) && this.mLoadedSrc) && this.mParseValueFinished) {
            this.mSrc = str;
            this.mLoadedSrc = true;
            if (TextUtils.isEmpty(str)) {
                setBitmap(null, true);
            } else {
                this.mContext.getImageLoader().getBitmap(needCheck(StringBase.STR_ID_src), this.mSrc, this, getComMeasuredWidth(), getComMeasuredHeight(), new ImageLoader.Listener() { // from class: com.vivo.advv.vaf.virtualview.view.image.NativeImage.1

                    /* renamed from: com.vivo.advv.vaf.virtualview.view.image.NativeImage$1$1 */
                    class C05641 extends ImageLoader.DefaultListener {
                        C05641() {
                        }

                        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                        public void onImageLoadSuccess(Bitmap bitmap2) {
                            super.onImageLoadSuccess(bitmap2);
                            NativeImage.this.setBackgroundImage(bitmap2);
                        }
                    }

                    /* renamed from: com.vivo.advv.vaf.virtualview.view.image.NativeImage$1$2 */
                    class AnonymousClass2 extends ImageLoader.DefaultListener {
                        AnonymousClass2() {
                        }

                        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                        public void onImageLoadSuccess(Bitmap bitmap) {
                            NativeImage.this.setBitmap(bitmap, true);
                        }

                        @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                        public void onImageLoadSuccess(Drawable drawable) {
                            NativeImage.this.setImageDrawable(drawable, true);
                        }
                    }

                    AnonymousClass1() {
                    }

                    @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                    public void onImageLoadFailed() {
                        boolean needCheck = NativeImage.this.needCheck(StringBase.STR_ID_error);
                        ImageLoader imageLoader = ((ViewBase) NativeImage.this).mContext.getImageLoader();
                        NativeImage nativeImage = NativeImage.this;
                        imageLoader.getBitmap(needCheck, nativeImage.mError, nativeImage, nativeImage.getComMeasuredWidth(), NativeImage.this.getComMeasuredHeight(), new ImageLoader.DefaultListener() { // from class: com.vivo.advv.vaf.virtualview.view.image.NativeImage.1.2
                            AnonymousClass2() {
                            }

                            @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                            public void onImageLoadSuccess(Bitmap bitmap) {
                                NativeImage.this.setBitmap(bitmap, true);
                            }

                            @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                            public void onImageLoadSuccess(Drawable drawable) {
                                NativeImage.this.setImageDrawable(drawable, true);
                            }
                        });
                    }

                    @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                    public void onImageLoadSuccess(byte[] bArr, File file) {
                        NativeImage.this.mNative.decode2Src(bArr, file);
                    }

                    @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                    public void onImageLoadSuccess(Bitmap bitmap) {
                        NativeImage.this.setBitmap(bitmap, true);
                        NativeImage nativeImage = NativeImage.this;
                        if (nativeImage.mBgBlurRadius <= 0 || nativeImage.mBgBlurSampling <= 0.0f) {
                            return;
                        }
                        ImageLoader imageLoader = ((ViewBase) nativeImage).mContext.getImageLoader();
                        NativeImage nativeImage2 = NativeImage.this;
                        imageLoader.getBlurBitmap(bitmap, nativeImage2, nativeImage2.mBgBlurSampling, nativeImage2.mBgBlurRadius, new ImageLoader.DefaultListener() { // from class: com.vivo.advv.vaf.virtualview.view.image.NativeImage.1.1
                            C05641() {
                            }

                            @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.DefaultListener, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                            public void onImageLoadSuccess(Bitmap bitmap2) {
                                super.onImageLoadSuccess(bitmap2);
                                NativeImage.this.setBackgroundImage(bitmap2);
                            }
                        });
                    }

                    @Override // com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                    public void onImageLoadSuccess(Drawable drawable) {
                        NativeImage.this.setImageDrawable(drawable, true);
                    }
                });
            }
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected void setBackgroundImage(byte[] bArr, File file) {
        super.setBackgroundImage(bArr, file);
        this.mNative.decode2Bg(bArr, file);
    }
}
