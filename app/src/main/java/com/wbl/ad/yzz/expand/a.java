package com.wbl.ad.yzz.expand;

import android.graphics.Bitmap;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import f.b.a.d;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends BitmapTransformation {

    /* renamed from: a */
    @d
    public final String f32137a = "com.wbl.ad.yzz.expand.BottomRightAngleRoundedCorners";

    /* renamed from: b */
    @d
    public final byte[] f32138b;

    /* renamed from: c */
    public int f32139c;

    public a(int i2) {
        Charset charset = Key.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "Key.CHARSET");
        byte[] bytes = "com.wbl.ad.yzz.expand.BottomRightAngleRoundedCorners".getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.f32138b = bytes;
        this.f32139c = i2;
    }

    public final Bitmap.Config a(Bitmap bitmap) {
        return (Bitmap.Config) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14064, this, bitmap);
    }

    public final Bitmap a(BitmapPool bitmapPool, Bitmap bitmap) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14063, this, bitmapPool, bitmap);
    }

    public final Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, float f2) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14058, this, bitmapPool, bitmap, Float.valueOf(f2));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14057, this, obj);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14060, this, null);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14059, this, bitmapPool, bitmap, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14054, this, messageDigest);
    }
}
