package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSketchFilter;

/* loaded from: classes4.dex */
public class h extends c {

    /* renamed from: e */
    public static final int f31111e = 1;

    /* renamed from: f */
    public static final String f31112f = "jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation.1";

    public h() {
        super(new GPUImageSketchFilter());
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return o10 instanceof h;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return -1790215191;
    }

    @Override // uh.c
    public String toString() {
        return "SketchFilterTransformation()";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f31112f.getBytes(Key.CHARSET));
    }
}
