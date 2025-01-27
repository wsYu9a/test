package uh;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSwirlFilter;

/* loaded from: classes4.dex */
public class i extends c {

    /* renamed from: h */
    public static final int f31113h = 1;

    /* renamed from: i */
    public static final String f31114i = "jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation.1";

    /* renamed from: e */
    public final float f31115e;

    /* renamed from: f */
    public final float f31116f;

    /* renamed from: g */
    public final PointF f31117g;

    public i() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public boolean equals(Object o10) {
        if (o10 instanceof i) {
            i iVar = (i) o10;
            float f10 = iVar.f31115e;
            float f11 = this.f31115e;
            if (f10 == f11 && iVar.f31116f == f11) {
                PointF pointF = iVar.f31117g;
                PointF pointF2 = this.f31117g;
                if (pointF.equals(pointF2.x, pointF2.y)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public int hashCode() {
        return (-981084566) + ((int) (this.f31115e * 1000.0f)) + ((int) (this.f31116f * 10.0f)) + this.f31117g.hashCode();
    }

    @Override // uh.c
    public String toString() {
        return "SwirlFilterTransformation(radius=" + this.f31115e + ",angle=" + this.f31116f + ",center=" + this.f31117g.toString() + ")";
    }

    @Override // uh.c, th.a, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f31114i + this.f31115e + this.f31116f + this.f31117g.hashCode()).getBytes(Key.CHARSET));
    }

    public i(float radius, float angle, PointF center) {
        super(new GPUImageSwirlFilter());
        this.f31115e = radius;
        this.f31116f = angle;
        this.f31117g = center;
        GPUImageSwirlFilter gPUImageSwirlFilter = (GPUImageSwirlFilter) c();
        gPUImageSwirlFilter.setRadius(radius);
        gPUImageSwirlFilter.setAngle(angle);
        gPUImageSwirlFilter.setCenter(center);
    }
}
