package com.vivo.advv.vaf.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.ImageView;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.virtualview.common.StringBase;

/* loaded from: classes4.dex */
public abstract class ImageBase extends ViewBase {
    public static SparseArray<ImageView.ScaleType> IMAGE_SCALE_TYPE = null;
    private static final String TAG = "ImageBase_TMTEST";
    public int mBgBlurRadius;
    public float mBgBlurSampling;
    public String mError;
    protected boolean mLoadedSrc;
    public int mScaleType;
    public String mSrc;

    static {
        SparseArray<ImageView.ScaleType> sparseArray = new SparseArray<>();
        IMAGE_SCALE_TYPE = sparseArray;
        sparseArray.put(0, ImageView.ScaleType.MATRIX);
        IMAGE_SCALE_TYPE.put(1, ImageView.ScaleType.FIT_XY);
        IMAGE_SCALE_TYPE.put(2, ImageView.ScaleType.FIT_START);
        IMAGE_SCALE_TYPE.put(3, ImageView.ScaleType.FIT_CENTER);
        IMAGE_SCALE_TYPE.put(4, ImageView.ScaleType.FIT_END);
        IMAGE_SCALE_TYPE.put(5, ImageView.ScaleType.CENTER);
        IMAGE_SCALE_TYPE.put(6, ImageView.ScaleType.CENTER_CROP);
        IMAGE_SCALE_TYPE.put(7, ImageView.ScaleType.CENTER_INSIDE);
    }

    public ImageBase(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.mLoadedSrc = false;
        this.mBgBlurSampling = 1.0f;
        this.mDataTag = "imgUrl";
        this.mScaleType = 1;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void loadImage(String str) {
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mData = null;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        if (i2 != -71928322) {
            if (i2 != 114148) {
                if (i2 != 96784904) {
                    if (i2 != 1603022419) {
                        return false;
                    }
                    if (Utils.isEL(str)) {
                        this.mViewCache.put(this, StringBase.STR_ID_bgBlurSampling, str, 1);
                    }
                } else if (Utils.isEL(str)) {
                    this.mViewCache.put(this, StringBase.STR_ID_error, str, 2);
                } else {
                    this.mError = str;
                }
            } else if (Utils.isEL(str)) {
                this.mViewCache.put(this, StringBase.STR_ID_src, str, 2);
            } else {
                this.mSrc = str;
            }
        } else if (Utils.isEL(str)) {
            this.mViewCache.put(this, StringBase.STR_ID_bgBlurRadius, str, 0);
        }
        return true;
    }

    public void setBitmap(Bitmap bitmap) {
        setBitmap(bitmap, true);
    }

    public abstract void setBitmap(Bitmap bitmap, boolean z);

    public void setImageDrawable(Drawable drawable, boolean z) {
    }

    public void setSrc(String str) {
        if (TextUtils.equals(this.mSrc, str)) {
            return;
        }
        this.mSrc = str;
        loadImage(str);
        refresh();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == -1877911644) {
            this.mScaleType = i3;
            return true;
        }
        if (i2 != -71928322) {
            return false;
        }
        this.mBgBlurRadius = i3;
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 != 1603022419) {
            return false;
        }
        this.mBgBlurSampling = f2;
        return true;
    }
}
