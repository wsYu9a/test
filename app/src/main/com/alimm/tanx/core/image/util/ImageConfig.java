package com.alimm.tanx.core.image.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class ImageConfig implements NotConfused {
    private final Context context;
    private int errorId;
    private Drawable errorPlaceholder;
    private tanxc_do imageConfig;
    private Drawable placeHolderDrawable;
    private int placeholderId;
    private final int resId;
    private String url;

    public static class Builder implements NotConfused {
        private final Context context;
        private int errorId;
        private Drawable errorPlaceholder;
        private Drawable placeHolderDrawable;
        private int placeHolderResId;
        private int radius;
        private int resId;
        private ScaleMode scaleMode = ScaleMode.FIT_CENTER;
        private ShapeMode shapeMode = ShapeMode.RECT;
        private String url;

        public Builder(Context context) {
            this.context = context;
        }

        public ImageConfig build() {
            return new ImageConfig(this);
        }

        public Builder error(int i10) {
            this.errorId = i10;
            return this;
        }

        public Builder placeHolder(int i10) {
            this.placeHolderResId = i10;
            return this;
        }

        public Builder placeHolderDrawable(Drawable drawable) {
            this.placeHolderDrawable = drawable;
            return this;
        }

        public Builder radius(int i10) {
            this.radius = i10;
            return this;
        }

        public Builder res(int i10) {
            this.resId = i10;
            return this;
        }

        public Builder scaleMode(ScaleMode scaleMode) {
            this.scaleMode = scaleMode;
            return this;
        }

        public Builder shapeMode(ShapeMode shapeMode) {
            this.shapeMode = shapeMode;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder error(Drawable drawable) {
            this.errorPlaceholder = drawable;
            return this;
        }
    }

    public interface GifCallback {
        void onFailure(String str);

        void onSuccess();
    }

    public interface ImageBitmapCallback {
        void onFailure(String str);

        void onSuccess(Bitmap bitmap);
    }

    public ImageConfig(Builder builder) {
        this.context = builder.context;
        this.url = builder.url;
        this.resId = builder.resId;
        this.placeholderId = builder.placeHolderResId;
        this.placeHolderDrawable = builder.placeHolderDrawable;
        this.errorId = builder.errorId;
        this.errorPlaceholder = builder.errorPlaceholder;
        this.imageConfig = new tanxc_do(builder.scaleMode, builder.shapeMode, builder.radius);
    }

    public void error(int i10) {
        this.errorId = i10;
    }

    public Context getContext() {
        return this.context;
    }

    public int getErrorId() {
        return this.errorId;
    }

    public Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public tanxc_do getImageConfig() {
        return this.imageConfig;
    }

    public Drawable getPlaceHolderDrawable() {
        return this.placeHolderDrawable;
    }

    public int getPlaceHolderId() {
        return this.placeholderId;
    }

    public int getResId() {
        return this.resId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setImageConfig(tanxc_do tanxc_doVar) {
        this.imageConfig = tanxc_doVar;
    }

    public void setPlaceHolder(int i10) {
        this.placeholderId = i10;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void error(Drawable drawable) {
        this.errorPlaceholder = drawable;
    }

    public void setPlaceHolder(Drawable drawable) {
        this.placeHolderDrawable = drawable;
    }
}
