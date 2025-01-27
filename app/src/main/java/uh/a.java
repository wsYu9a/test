package uh;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter;

/* loaded from: classes4.dex */
public class a extends c {

    /* renamed from: f */
    public static final int f31090f = 1;

    /* renamed from: g */
    public static final String f31091g = "jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation.1";

    /* renamed from: e */
    public final float f31092e;

    public a() {
        this(0.0f);
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        return (o10 instanceof a) && ((a) o10).f31092e == this.f31092e;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-1311211954) + ((int) ((this.f31092e + 1.0f) * 10.0f));
    }

    @Override // uh.c
    public String toString() {
        return "BrightnessFilterTransformation(brightness=" + this.f31092e + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31091g + this.f31092e).getBytes(Key.CHARSET));
    }

    public a(float brightness) {
        super(new GPUImageBrightnessFilter());
        this.f31092e = brightness;
        ((GPUImageBrightnessFilter) c()).setBrightness(brightness);
    }
}
