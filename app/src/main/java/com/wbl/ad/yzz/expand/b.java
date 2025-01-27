package com.wbl.ad.yzz.expand;

import android.graphics.Bitmap;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import f.b.a.d;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b extends BitmapTransformation {

    /* renamed from: e */
    public static final int f32140e = 1;

    /* renamed from: f */
    public static final int f32141f = 2;

    /* renamed from: g */
    @d
    public static final a f32142g = new a(null);

    /* renamed from: a */
    @d
    public final String f32143a;

    /* renamed from: b */
    @d
    public final byte[] f32144b;

    /* renamed from: c */
    public final int f32145c;

    /* renamed from: d */
    public final int f32146d;

    public static final class a {
        public a() {
        }

        public final int a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14053, this, null);
        }

        public final int b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14056, this, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(int i2, int i3) {
        this.f32146d = i2;
        String str = "com.wbl.ad.yzz.expand.ThreeRightAngleRoundedCorners" + i2;
        this.f32143a = str;
        Charset charset = Key.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "Key.CHARSET");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.f32144b = bytes;
        this.f32145c = i3;
    }

    public final Bitmap.Config a(Bitmap bitmap) {
        return (Bitmap.Config) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14049, this, bitmap);
    }

    public final Bitmap a(BitmapPool bitmapPool, Bitmap bitmap) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14052, this, bitmapPool, bitmap);
    }

    public final Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, float f2) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14051, this, bitmapPool, bitmap, Float.valueOf(f2));
    }

    public final int c() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14078, this, null);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14077, this, obj);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14080, this, null);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14079, this, bitmapPool, bitmap, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14074, this, messageDigest);
    }
}
