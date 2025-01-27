package uh;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter;

/* loaded from: classes4.dex */
public class k extends c {

    /* renamed from: i */
    public static final int f31122i = 1;

    /* renamed from: j */
    public static final String f31123j = "jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1";

    /* renamed from: e */
    public final PointF f31124e;

    /* renamed from: f */
    public final float[] f31125f;

    /* renamed from: g */
    public final float f31126g;

    /* renamed from: h */
    public final float f31127h;

    public k() {
        this(new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 0.75f);
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        if (o10 instanceof k) {
            k kVar = (k) o10;
            PointF pointF = kVar.f31124e;
            PointF pointF2 = this.f31124e;
            if (pointF.equals(pointF2.x, pointF2.y) && Arrays.equals(kVar.f31125f, this.f31125f) && kVar.f31126g == this.f31126g && kVar.f31127h == this.f31127h) {
                return true;
            }
        }
        return false;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return 1874002103 + this.f31124e.hashCode() + Arrays.hashCode(this.f31125f) + ((int) (this.f31126g * 100.0f)) + ((int) (this.f31127h * 10.0f));
    }

    @Override // uh.c
    public String toString() {
        return "VignetteFilterTransformation(center=" + this.f31124e.toString() + ",color=" + Arrays.toString(this.f31125f) + ",start=" + this.f31126g + ",end=" + this.f31127h + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31123j + this.f31124e + Arrays.hashCode(this.f31125f) + this.f31126g + this.f31127h).getBytes(Key.CHARSET));
    }

    public k(PointF center, float[] color, float start, float end) {
        super(new GPUImageVignetteFilter());
        this.f31124e = center;
        this.f31125f = color;
        this.f31126g = start;
        this.f31127h = end;
        GPUImageVignetteFilter gPUImageVignetteFilter = (GPUImageVignetteFilter) c();
        gPUImageVignetteFilter.setVignetteCenter(center);
        gPUImageVignetteFilter.setVignetteColor(color);
        gPUImageVignetteFilter.setVignetteStart(start);
        gPUImageVignetteFilter.setVignetteEnd(end);
    }
}
