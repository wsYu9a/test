package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImagePixelationFilter;

/* loaded from: classes4.dex */
public class f extends c {

    /* renamed from: f */
    public static final int f31105f = 1;

    /* renamed from: g */
    public static final String f31106g = "jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation.1";

    /* renamed from: e */
    public final float f31107e;

    public f() {
        this(10.0f);
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof f;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1525023660 + ((int) (this.f31107e * 10.0f));
    }

    @Override // uh.c
    public String toString() {
        return "PixelationFilterTransformation(pixel=" + this.f31107e + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31106g + this.f31107e).getBytes(Key.CHARSET));
    }

    public f(float pixel) {
        super(new GPUImagePixelationFilter());
        this.f31107e = pixel;
        ((GPUImagePixelationFilter) c()).setPixel(pixel);
    }
}
