package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageKuwaharaFilter;

/* loaded from: classes4.dex */
public class e extends c {

    /* renamed from: f */
    public static final int f31102f = 1;

    /* renamed from: g */
    public static final String f31103g = "jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation.1";

    /* renamed from: e */
    public final int f31104e;

    public e() {
        this(25);
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof e;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-1859800423) + (this.f31104e * 10);
    }

    @Override // uh.c
    public String toString() {
        return "KuwaharaFilterTransformation(radius=" + this.f31104e + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31103g + this.f31104e).getBytes(Key.CHARSET));
    }

    public e(int radius) {
        super(new GPUImageKuwaharaFilter());
        this.f31104e = radius;
        ((GPUImageKuwaharaFilter) c()).setRadius(radius);
    }
}
