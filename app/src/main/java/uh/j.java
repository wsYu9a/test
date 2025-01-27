package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageToonFilter;

/* loaded from: classes4.dex */
public class j extends c {

    /* renamed from: g */
    public static final int f31118g = 1;

    /* renamed from: h */
    public static final String f31119h = "jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation.1";

    /* renamed from: e */
    public final float f31120e;

    /* renamed from: f */
    public final float f31121f;

    public j() {
        this(0.2f, 10.0f);
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        if (o10 instanceof j) {
            j jVar = (j) o10;
            if (jVar.f31120e == this.f31120e && jVar.f31121f == this.f31121f) {
                return true;
            }
        }
        return false;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1209810327 + ((int) (this.f31120e * 1000.0f)) + ((int) (this.f31121f * 10.0f));
    }

    @Override // uh.c
    public String toString() {
        return "ToonFilterTransformation(threshold=" + this.f31120e + ",quantizationLevels=" + this.f31121f + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31119h + this.f31120e + this.f31121f).getBytes(Key.CHARSET));
    }

    public j(float threshold, float quantizationLevels) {
        super(new GPUImageToonFilter());
        this.f31120e = threshold;
        this.f31121f = quantizationLevels;
        GPUImageToonFilter gPUImageToonFilter = (GPUImageToonFilter) c();
        gPUImageToonFilter.setThreshold(threshold);
        gPUImageToonFilter.setQuantizationLevels(quantizationLevels);
    }
}
