package df;

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

/* loaded from: classes3.dex */
public class c implements df.a {

    /* renamed from: a */
    public final int f25543a;

    /* renamed from: b */
    public final int f25544b;

    public static class a extends Drawable {

        /* renamed from: a */
        public final float f25545a;

        /* renamed from: b */
        public final int f25546b;

        /* renamed from: c */
        public final RectF f25547c = new RectF();

        /* renamed from: d */
        public final RectF f25548d;

        /* renamed from: e */
        public final BitmapShader f25549e;

        /* renamed from: f */
        public final Paint f25550f;

        public a(Bitmap bitmap, int i10, int i11) {
            this.f25545a = i10;
            this.f25546b = i11;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f25549e = bitmapShader;
            float f10 = i11;
            this.f25548d = new RectF(f10, f10, bitmap.getWidth() - i11, bitmap.getHeight() - i11);
            Paint paint = new Paint();
            this.f25550f = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.f25547c;
            float f10 = this.f25545a;
            canvas.drawRoundRect(rectF, f10, f10, this.f25550f);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.f25547c;
            int i10 = this.f25546b;
            rectF.set(i10, i10, rect.width() - this.f25546b, rect.height() - this.f25546b);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f25548d, this.f25547c, Matrix.ScaleToFit.FILL);
            this.f25549e.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            this.f25550f.setAlpha(i10);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f25550f.setColorFilter(colorFilter);
        }
    }

    public c(int i10) {
        this(i10, 0);
    }

    @Override // df.a
    public void a(Bitmap bitmap, ef.a aVar, LoadedFrom loadedFrom) {
        if (!(aVar instanceof ef.b)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        aVar.setImageDrawable(new a(bitmap, this.f25543a, this.f25544b));
    }

    public c(int i10, int i11) {
        this.f25543a = i10;
        this.f25544b = i11;
    }
}
