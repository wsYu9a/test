package th;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class g extends a {

    /* renamed from: b */
    public static final int f30889b = 1;

    /* renamed from: c */
    public static final String f30890c = "jp.wasabeef.glide.transformations.CropSquareTransformation.1";

    /* renamed from: a */
    public int f30891a;

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int max = Math.max(outWidth, outHeight);
        this.f30891a = max;
        return TransformationUtils.centerCrop(pool, toTransform, max, max);
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return (o10 instanceof g) && ((g) o10).f30891a == this.f30891a;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-789843280) + (this.f30891a * 10);
    }

    public String toString() {
        return "CropSquareTransformation(size=" + this.f30891a + ")";
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f30890c + this.f30891a).getBytes(Key.CHARSET));
    }
}
