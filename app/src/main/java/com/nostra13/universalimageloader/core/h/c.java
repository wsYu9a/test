package com.nostra13.universalimageloader.core.h;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private final String f16017a;

    /* renamed from: b */
    private final String f16018b;

    /* renamed from: c */
    private final String f16019c;

    /* renamed from: d */
    private final com.nostra13.universalimageloader.core.assist.c f16020d;

    /* renamed from: e */
    private final ImageScaleType f16021e;

    /* renamed from: f */
    private final ViewScaleType f16022f;

    /* renamed from: g */
    private final ImageDownloader f16023g;

    /* renamed from: h */
    private final Object f16024h;

    /* renamed from: i */
    private final boolean f16025i;

    /* renamed from: j */
    private final BitmapFactory.Options f16026j;

    public c(String str, String str2, String str3, com.nostra13.universalimageloader.core.assist.c cVar, ViewScaleType viewScaleType, ImageDownloader imageDownloader, com.nostra13.universalimageloader.core.c cVar2) {
        this.f16017a = str;
        this.f16018b = str2;
        this.f16019c = str3;
        this.f16020d = cVar;
        this.f16021e = cVar2.C();
        this.f16022f = viewScaleType;
        this.f16023g = imageDownloader;
        this.f16024h = cVar2.x();
        this.f16025i = cVar2.H();
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f16026j = options;
        a(cVar2.u(), options);
    }

    private void a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 10) {
            b(options, options2);
        }
        if (i2 >= 11) {
            c(options, options2);
        }
    }

    @TargetApi(10)
    private void b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public BitmapFactory.Options d() {
        return this.f16026j;
    }

    public ImageDownloader e() {
        return this.f16023g;
    }

    public Object f() {
        return this.f16024h;
    }

    public String g() {
        return this.f16017a;
    }

    public ImageScaleType h() {
        return this.f16021e;
    }

    public String i() {
        return this.f16018b;
    }

    public String j() {
        return this.f16019c;
    }

    public com.nostra13.universalimageloader.core.assist.c k() {
        return this.f16020d;
    }

    public ViewScaleType l() {
        return this.f16022f;
    }

    public boolean m() {
        return this.f16025i;
    }
}
