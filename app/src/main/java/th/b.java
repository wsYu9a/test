package th;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: c */
    public static final int f30871c = 1;

    /* renamed from: d */
    public static final String f30872d = "jp.wasabeef.glide.transformations.BlurTransformation.1";

    /* renamed from: e */
    public static final int f30873e = 25;

    /* renamed from: f */
    public static final int f30874f = 1;

    /* renamed from: a */
    public final int f30875a;

    /* renamed from: b */
    public final int f30876b;

    public b() {
        this(25, 1);
    }

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        int i10 = this.f30876b;
        Bitmap bitmap = pool.get(width / i10, height / i10, Bitmap.Config.ARGB_8888);
        a(toTransform, bitmap);
        Canvas canvas = new Canvas(bitmap);
        int i11 = this.f30876b;
        canvas.scale(1.0f / i11, 1.0f / i11);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        try {
            return vh.c.a(context, bitmap, this.f30875a);
        } catch (RSRuntimeException unused) {
            return vh.a.a(bitmap, this.f30875a, true);
        }
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        if (o10 instanceof b) {
            b bVar = (b) o10;
            if (bVar.f30875a == this.f30875a && bVar.f30876b == this.f30876b) {
                return true;
            }
        }
        return false;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 737513610 + (this.f30875a * 1000) + (this.f30876b * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f30875a + ", sampling=" + this.f30876b + ")";
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f30872d + this.f30875a + this.f30876b).getBytes(Key.CHARSET));
    }

    public b(int radius) {
        this(radius, 1);
    }

    public b(int radius, int sampling) {
        this.f30875a = radius;
        this.f30876b = sampling;
    }
}
