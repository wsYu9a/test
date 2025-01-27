package x9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class a implements Transformation<Bitmap> {

    /* renamed from: a */
    public BitmapPool f31914a;

    /* renamed from: b */
    public float f31915b;

    /* renamed from: c */
    public float f31916c;

    /* renamed from: d */
    public float f31917d;

    /* renamed from: e */
    public float f31918e;

    /* renamed from: f */
    public boolean f31919f;

    /* renamed from: g */
    public boolean f31920g;

    /* renamed from: h */
    public boolean f31921h;

    /* renamed from: i */
    public boolean f31922i;

    public a(Context context, float f10, float f11, float f12, float f13) {
        this.f31914a = Glide.get(context).getBitmapPool();
        this.f31915b = f10;
        if (f10 != 0.0f) {
            this.f31919f = true;
        }
        this.f31916c = f11;
        if (f11 != 0.0f) {
            this.f31921h = true;
        }
        this.f31917d = f12;
        if (f12 != 0.0f) {
            this.f31920g = true;
        }
        this.f31918e = f13;
        if (f13 != 0.0f) {
            this.f31922i = true;
        }
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i10, int i11) {
        int height;
        int i12;
        Bitmap bitmap = resource.get();
        if (i10 > i11) {
            float f10 = i11;
            float f11 = i10;
            height = bitmap.getWidth();
            i12 = (int) (bitmap.getWidth() * (f10 / f11));
            if (i12 > bitmap.getHeight()) {
                i12 = bitmap.getHeight();
                height = (int) (bitmap.getHeight() * (f11 / f10));
            }
        } else if (i10 < i11) {
            float f12 = i10;
            float f13 = i11;
            int height2 = bitmap.getHeight();
            int height3 = (int) (bitmap.getHeight() * (f12 / f13));
            if (height3 > bitmap.getWidth()) {
                height = bitmap.getWidth();
                i12 = (int) (bitmap.getWidth() * (f13 / f12));
            } else {
                height = height3;
                i12 = height2;
            }
        } else {
            height = bitmap.getHeight();
            i12 = height;
        }
        float f14 = i12 / i11;
        this.f31915b *= f14;
        this.f31916c *= f14;
        this.f31917d *= f14;
        this.f31918e *= f14;
        BitmapPool bitmapPool = this.f31914a;
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap bitmap2 = bitmapPool.get(height, i12, config);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(height, i12, config);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        int width = (bitmap.getWidth() - height) / 2;
        int height4 = (bitmap.getHeight() - i12) / 2;
        if (width != 0 || height4 != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width, -height4);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        float f15 = this.f31915b;
        float f16 = this.f31917d;
        float f17 = this.f31918e;
        float f18 = this.f31916c;
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{f15, f15, f16, f16, f17, f17, f18, f18}, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return BitmapResource.obtain(bitmap2, this.f31914a);
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }
}
