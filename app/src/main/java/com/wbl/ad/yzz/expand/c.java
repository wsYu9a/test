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
public final class c extends BitmapTransformation {

    /* renamed from: e */
    public static final int f32147e = 1;

    /* renamed from: f */
    public static final int f32148f = 2;

    /* renamed from: g */
    @d
    public static final a f32149g = new a(null);

    /* renamed from: a */
    @d
    public final String f32150a;

    /* renamed from: b */
    @d
    public final byte[] f32151b;

    /* renamed from: c */
    public final int f32152c;

    /* renamed from: d */
    public final int f32153d;

    public static final class a {
        public a() {
        }

        public final int a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14073, this, null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(int i2, int i3) {
        this.f32153d = i2;
        String str = "com.wbl.ad.yzz.expand.TwoRoundedCorners" + i2;
        this.f32150a = str;
        Charset charset = Key.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "Key.CHARSET");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.f32151b = bytes;
        this.f32152c = i3;
    }

    public final Bitmap.Config a(Bitmap bitmap) {
        return (Bitmap.Config) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14075, this, bitmap);
    }

    public final Bitmap a(BitmapPool bitmapPool, Bitmap bitmap) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14070, this, bitmapPool, bitmap);
    }

    public final Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, float f2) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14069, this, bitmapPool, bitmap, Float.valueOf(f2));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14072, this, obj);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-14071, this, null);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return (Bitmap) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-14066, this, bitmapPool, bitmap, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14065, this, messageDigest);
    }
}
