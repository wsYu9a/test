package th;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class f extends a {

    /* renamed from: c */
    public static final int f30885c = 1;

    /* renamed from: d */
    public static final String f30886d = "jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1";

    /* renamed from: a */
    public final int f30887a;

    /* renamed from: b */
    public final int f30888b;

    public f() {
        this.f30887a = vh.d.a(4);
        this.f30888b = -16777216;
    }

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap circleCrop = TransformationUtils.circleCrop(pool, toTransform, outWidth, outHeight);
        a(toTransform, circleCrop);
        Paint paint = new Paint();
        paint.setColor(this.f30888b);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f30887a);
        paint.setAntiAlias(true);
        new Canvas(circleCrop).drawCircle(outWidth / 2.0f, outHeight / 2.0f, (Math.max(outWidth, outHeight) / 2.0f) - (this.f30887a / 2.0f), paint);
        return circleCrop;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        if (o10 instanceof f) {
            f fVar = (f) o10;
            if (fVar.f30887a == this.f30887a && fVar.f30888b == this.f30888b) {
                return true;
            }
        }
        return false;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 882652245 + (this.f30887a * 100) + this.f30888b + 10;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f30886d + this.f30887a + this.f30888b).getBytes(Key.CHARSET));
    }

    public f(int borderSize, @ColorInt int borderColor) {
        this.f30887a = borderSize;
        this.f30888b = borderColor;
    }
}
