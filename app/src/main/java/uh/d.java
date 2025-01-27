package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorInvertFilter;

/* loaded from: classes4.dex */
public class d extends c {

    /* renamed from: e */
    public static final int f31100e = 1;

    /* renamed from: f */
    public static final String f31101f = "jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation.1";

    public d() {
        super(new GPUImageColorInvertFilter());
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof d;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 2014901395;
    }

    @Override // uh.c
    public String toString() {
        return "InvertFilterTransformation()";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f31101f.getBytes(Key.CHARSET));
    }
}
