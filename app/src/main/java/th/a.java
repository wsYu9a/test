package th;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public abstract class a implements Transformation<Bitmap> {
    public void a(@NonNull Bitmap toTransform, @NonNull Bitmap canvasBitmap) {
        canvasBitmap.setDensity(toTransform.getDensity());
    }

    public abstract Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight);

    @Override // com.bumptech.glide.load.Key
    public abstract boolean equals(Object o10);

    @Override // com.bumptech.glide.load.Key
    public abstract int hashCode();

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    public final Resource<Bitmap> transform(@NonNull Context context, @NonNull Resource<Bitmap> resource, int outWidth, int outHeight) {
        if (!Util.isValidDimensions(outWidth, outHeight)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + outWidth + " or height: " + outHeight + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        BitmapPool bitmapPool = Glide.get(context).getBitmapPool();
        Bitmap bitmap = resource.get();
        if (outWidth == Integer.MIN_VALUE) {
            outWidth = bitmap.getWidth();
        }
        int i10 = outWidth;
        if (outHeight == Integer.MIN_VALUE) {
            outHeight = bitmap.getHeight();
        }
        Bitmap b10 = b(context.getApplicationContext(), bitmapPool, bitmap, i10, outHeight);
        return bitmap.equals(b10) ? resource : BitmapResource.obtain(b10, bitmapPool);
    }

    @Override // com.bumptech.glide.load.Key
    public abstract void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
