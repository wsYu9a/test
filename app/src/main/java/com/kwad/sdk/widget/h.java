package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class h {
    private boolean mClipBackground;

    @NonNull
    private a mCornerConf;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    public float[] radiusArray;

    public static class a {
        private boolean leftTop = true;
        private boolean topRight = true;
        private boolean rightBottom = true;
        private boolean bottomLeft = true;

        public final a bK(boolean z) {
            this.leftTop = z;
            return this;
        }

        public final a bL(boolean z) {
            this.topRight = z;
            return this;
        }

        public final a bM(boolean z) {
            this.rightBottom = z;
            return this;
        }

        public final a bN(boolean z) {
            this.bottomLeft = z;
            return this;
        }

        public final boolean isBottomLeft() {
            return this.bottomLeft;
        }

        public final boolean isLeftTop() {
            return this.leftTop;
        }

        public final boolean isRightBottom() {
            return this.rightBottom;
        }

        public final boolean isTopRight() {
            return this.topRight;
        }

        public final void setAllCorner(boolean z) {
            this.leftTop = z;
            this.topRight = z;
            this.rightBottom = z;
            this.bottomLeft = z;
        }
    }

    public h() {
        this.radiusArray = new float[8];
        this.mCornerConf = new a();
    }

    public h(a aVar) {
        this.radiusArray = new float[8];
        this.mCornerConf = aVar;
    }

    private Path getPath() {
        try {
            this.mPath.reset();
        } catch (Exception unused) {
        }
        this.mPath.addRoundRect(this.mRectF, this.mRadius == 0.0f ? this.radiusArray : getRadius(), Path.Direction.CW);
        return this.mPath;
    }

    private float[] getRadius() {
        this.radiusArray[0] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[1] = this.mCornerConf.isLeftTop() ? this.mRadius : 0.0f;
        this.radiusArray[2] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[3] = this.mCornerConf.isTopRight() ? this.mRadius : 0.0f;
        this.radiusArray[4] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[5] = this.mCornerConf.isRightBottom() ? this.mRadius : 0.0f;
        this.radiusArray[6] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        this.radiusArray[7] = this.mCornerConf.isBottomLeft() ? this.mRadius : 0.0f;
        return this.radiusArray;
    }

    public final void afterDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.drawPath(getPath(), this.mPaint);
        }
        canvas.restore();
    }

    public final void afterDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.drawPath(getPath(), this.mPaint);
            }
            canvas.restore();
        }
    }

    public final void beforeDispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT < 28) {
            canvas.saveLayer(this.mRectF, null, 31);
        } else {
            canvas.save();
            canvas.clipPath(getPath());
        }
    }

    public final void beforeDraw(Canvas canvas) {
        if (this.mClipBackground) {
            if (Build.VERSION.SDK_INT < 28) {
                canvas.saveLayer(this.mRectF, null, 31);
            } else {
                canvas.save();
                canvas.clipPath(getPath());
            }
        }
    }

    @NonNull
    public final a getCornerConf() {
        return this.mCornerConf;
    }

    public final void initAttrs(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i2 = R.attr.ksad_radius;
            int i3 = R.attr.ksad_clipBackground;
            int[] iArr = {i2, i3};
            Arrays.sort(iArr);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(Arrays.binarySearch(iArr, i2), 0);
            this.mClipBackground = obtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i3), true);
            obtainStyledAttributes.recycle();
        }
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void onSizeChanged(int i2, int i3) {
        this.mRectF.set(0.0f, 0.0f, i2, i3);
    }

    public final void setRadius(float f2) {
        this.mRadius = f2;
    }

    public final void setRadius(float[] fArr) {
        this.radiusArray = fArr;
    }
}
