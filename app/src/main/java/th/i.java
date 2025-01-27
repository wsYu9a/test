package th;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class i extends a {

    /* renamed from: b */
    public static final int f30894b = 1;

    /* renamed from: c */
    public static final String f30895c = "jp.wasabeef.glide.transformations.MaskTransformation.1";

    /* renamed from: d */
    public static final Paint f30896d;

    /* renamed from: a */
    public final int f30897a;

    static {
        Paint paint = new Paint();
        f30896d = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public i(int maskId) {
        this.f30897a = maskId;
    }

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap bitmap = pool.get(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setHasAlpha(true);
        Drawable drawable = context.getDrawable(this.f30897a);
        a(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, f30896d);
        return bitmap;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return (o10 instanceof i) && ((i) o10).f30897a == this.f30897a;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-1949385457) + (this.f30897a * 10);
    }

    public String toString() {
        return "MaskTransformation(maskId=" + this.f30897a + ")";
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f30895c + this.f30897a).getBytes(Key.CHARSET));
    }
}
