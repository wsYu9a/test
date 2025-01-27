package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class CropTransformation extends th.a {

    /* renamed from: d */
    public static final int f27586d = 1;

    /* renamed from: e */
    public static final String f27587e = "jp.wasabeef.glide.transformations.CropTransformation.1";

    /* renamed from: a */
    public int f27588a;

    /* renamed from: b */
    public int f27589b;

    /* renamed from: c */
    public CropType f27590c;

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f27591a;

        static {
            int[] iArr = new int[CropType.values().length];
            f27591a = iArr;
            try {
                iArr[CropType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27591a[CropType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27591a[CropType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CropTransformation(int width, int height) {
        this(width, height, CropType.CENTER);
    }

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int i10 = this.f27588a;
        if (i10 == 0) {
            i10 = toTransform.getWidth();
        }
        this.f27588a = i10;
        int i11 = this.f27589b;
        if (i11 == 0) {
            i11 = toTransform.getHeight();
        }
        this.f27589b = i11;
        Bitmap bitmap = pool.get(this.f27588a, this.f27589b, toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);
        float max = Math.max(this.f27588a / toTransform.getWidth(), this.f27589b / toTransform.getHeight());
        float width = toTransform.getWidth() * max;
        float height = max * toTransform.getHeight();
        float f10 = (this.f27588a - width) / 2.0f;
        float c10 = c(height);
        RectF rectF = new RectF(f10, c10, width + f10, height + c10);
        a(toTransform, bitmap);
        new Canvas(bitmap).drawBitmap(toTransform, (Rect) null, rectF, (Paint) null);
        return bitmap;
    }

    public final float c(float scaledHeight) {
        int i10 = a.f27591a[this.f27590c.ordinal()];
        if (i10 == 2) {
            return (this.f27589b - scaledHeight) / 2.0f;
        }
        if (i10 != 3) {
            return 0.0f;
        }
        return this.f27589b - scaledHeight;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        if (o10 instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) o10;
            if (cropTransformation.f27588a == this.f27588a && cropTransformation.f27589b == this.f27589b && cropTransformation.f27590c == this.f27590c) {
                return true;
            }
        }
        return false;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-1462327117) + (this.f27588a * 100000) + (this.f27589b * 1000) + (this.f27590c.ordinal() * 10);
    }

    public String toString() {
        return "CropTransformation(width=" + this.f27588a + ", height=" + this.f27589b + ", cropType=" + this.f27590c + ")";
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f27587e + this.f27588a + this.f27589b + this.f27590c).getBytes(Key.CHARSET));
    }

    public CropTransformation(int width, int height, CropType cropType) {
        CropType cropType2 = CropType.CENTER;
        this.f27588a = width;
        this.f27589b = height;
        this.f27590c = cropType;
    }
}
