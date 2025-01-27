package cf;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public final String f2000a;

    /* renamed from: b */
    public final String f2001b;

    /* renamed from: c */
    public final String f2002c;

    /* renamed from: d */
    public final af.c f2003d;

    /* renamed from: e */
    public final ImageScaleType f2004e;

    /* renamed from: f */
    public final ViewScaleType f2005f;

    /* renamed from: g */
    public final ImageDownloader f2006g;

    /* renamed from: h */
    public final Object f2007h;

    /* renamed from: i */
    public final boolean f2008i;

    /* renamed from: j */
    public final BitmapFactory.Options f2009j;

    public c(String str, String str2, String str3, af.c cVar, ViewScaleType viewScaleType, ImageDownloader imageDownloader, com.nostra13.universalimageloader.core.a aVar) {
        this.f2000a = str;
        this.f2001b = str2;
        this.f2002c = str3;
        this.f2003d = cVar;
        this.f2004e = aVar.C();
        this.f2005f = viewScaleType;
        this.f2006g = imageDownloader;
        this.f2007h = aVar.x();
        this.f2008i = aVar.H();
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f2009j = options;
        a(aVar.u(), options);
    }

    public final void a(BitmapFactory.Options options, BitmapFactory.Options options2) {
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
        b(options, options2);
        c(options, options2);
    }

    @TargetApi(10)
    public final void b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    public final void c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public BitmapFactory.Options d() {
        return this.f2009j;
    }

    public ImageDownloader e() {
        return this.f2006g;
    }

    public Object f() {
        return this.f2007h;
    }

    public String g() {
        return this.f2000a;
    }

    public ImageScaleType h() {
        return this.f2004e;
    }

    public String i() {
        return this.f2001b;
    }

    public String j() {
        return this.f2002c;
    }

    public af.c k() {
        return this.f2003d;
    }

    public ViewScaleType l() {
        return this.f2005f;
    }

    public boolean m() {
        return this.f2008i;
    }
}
