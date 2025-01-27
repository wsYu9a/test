package th;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

@Deprecated
/* loaded from: classes4.dex */
public class e extends a {

    /* renamed from: a */
    public static final int f30883a = 1;

    /* renamed from: b */
    public static final String f30884b = "jp.wasabeef.glide.transformations.CropCircleTransformation.1";

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return TransformationUtils.circleCrop(pool, toTransform, outWidth, outHeight);
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof e;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1288474723;
    }

    public String toString() {
        return "CropCircleTransformation()";
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f30884b.getBytes(Key.CHARSET));
    }
}
