package com.nostra13.universalimageloader.core.i;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

/* loaded from: classes4.dex */
public class c implements com.nostra13.universalimageloader.core.i.a {

    /* renamed from: a */
    protected final int f16031a;

    /* renamed from: b */
    protected final int f16032b;

    public static class a extends Drawable {

        /* renamed from: a */
        protected final float f16033a;

        /* renamed from: b */
        protected final int f16034b;

        /* renamed from: c */
        protected final RectF f16035c = new RectF();

        /* renamed from: d */
        protected final RectF f16036d;

        /* renamed from: e */
        protected final BitmapShader f16037e;

        /* renamed from: f */
        protected final Paint f16038f;

        public a(Bitmap bitmap, int i2, int i3) {
            this.f16033a = i2;
            this.f16034b = i3;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f16037e = bitmapShader;
            float f2 = i3;
            this.f16036d = new RectF(f2, f2, bitmap.getWidth() - i3, bitmap.getHeight() - i3);
            Paint paint = new Paint();
            this.f16038f = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.f16035c;
            float f2 = this.f16033a;
            canvas.drawRoundRect(rectF, f2, f2, this.f16038f);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.f16035c;
            int i2 = this.f16034b;
            rectF.set(i2, i2, rect.width() - this.f16034b, rect.height() - this.f16034b);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f16036d, this.f16035c, Matrix.ScaleToFit.FILL);
            this.f16037e.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            this.f16038f.setAlpha(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f16038f.setColorFilter(colorFilter);
        }
    }

    public c(int i2) {
        this(i2, 0);
    }

    @Override // com.nostra13.universalimageloader.core.i.a
    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.j.a aVar, LoadedFrom loadedFrom) {
        if (!(aVar instanceof com.nostra13.universalimageloader.core.j.b)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        aVar.setImageDrawable(new a(bitmap, this.f16031a, this.f16032b));
    }

    public c(int i2, int i3) {
        this.f16031a = i2;
        this.f16032b = i3;
    }
}
