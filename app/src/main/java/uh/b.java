package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageContrastFilter;

/* loaded from: classes4.dex */
public class b extends c {

    /* renamed from: f */
    public static final int f31093f = 1;

    /* renamed from: g */
    public static final String f31094g = "jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation.1";

    /* renamed from: e */
    public final float f31095e;

    public b() {
        this(1.0f);
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof b;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-306633601) + ((int) (this.f31095e * 10.0f));
    }

    @Override // uh.c
    public String toString() {
        return "ContrastFilterTransformation(contrast=" + this.f31095e + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31094g + this.f31095e).getBytes(Key.CHARSET));
    }

    public b(float contrast) {
        super(new GPUImageContrastFilter());
        this.f31095e = contrast;
        ((GPUImageContrastFilter) c()).setContrast(contrast);
    }
}
