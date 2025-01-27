package th;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class d extends a {

    /* renamed from: b */
    public static final int f30880b = 1;

    /* renamed from: c */
    public static final String f30881c = "jp.wasabeef.glide.transformations.ColorFilterTransformation.1";

    /* renamed from: a */
    public final int f30882a;

    public d(int color) {
        this.f30882a = color;
    }

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap bitmap = pool.get(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        a(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.f30882a, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return bitmap;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return (o10 instanceof d) && ((d) o10).f30882a == this.f30882a;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 705373712 + (this.f30882a * 10);
    }

    public String toString() {
        return "ColorFilterTransformation(color=" + this.f30882a + ")";
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f30881c + this.f30882a).getBytes(Key.CHARSET));
    }
}
