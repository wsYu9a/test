package uh;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;

/* loaded from: classes4.dex */
public class c extends th.a {

    /* renamed from: b */
    public static final int f31096b = 1;

    /* renamed from: c */
    public static final String f31097c = "jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation.1";

    /* renamed from: d */
    public static final byte[] f31098d = f31097c.getBytes(Key.CHARSET);

    /* renamed from: a */
    public final GPUImageFilter f31099a;

    public c(GPUImageFilter filter) {
        this.f31099a = filter;
    }

    @Override // th.a
    public Bitmap b(@NonNull Context context, @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        GPUImage gPUImage = new GPUImage(context);
        gPUImage.setImage(toTransform);
        gPUImage.setFilter(this.f31099a);
        return gPUImage.getBitmapWithFilterApplied();
    }

    public <T> T c() {
        return (T) this.f31099a;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof c;
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1751294359;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f31098d);
    }
}
