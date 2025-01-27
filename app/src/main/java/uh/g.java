package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSepiaToneFilter;

/* loaded from: classes4.dex */
public class g extends c {

    /* renamed from: f */
    public static final int f31108f = 1;

    /* renamed from: g */
    public static final String f31109g = "jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation.1";

    /* renamed from: e */
    public final float f31110e;

    public g() {
        this(1.0f);
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof g;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 895516065 + ((int) (this.f31110e * 10.0f));
    }

    @Override // uh.c
    public String toString() {
        return "SepiaFilterTransformation(intensity=" + this.f31110e + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31109g + this.f31110e).getBytes(Key.CHARSET));
    }

    public g(float intensity) {
        super(new GPUImageSepiaToneFilter());
        this.f31110e = intensity;
        ((GPUImageSepiaToneFilter) c()).setIntensity(intensity);
    }
}
