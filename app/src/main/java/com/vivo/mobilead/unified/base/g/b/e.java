package com.vivo.mobilead.unified.base.g.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.loader.StringLoader;
import com.vivo.advv.vaf.virtualview.view.image.NativeImage;

/* loaded from: classes4.dex */
public class e extends NativeImage {

    /* renamed from: a */
    private Bitmap[] f29791a;

    /* renamed from: b */
    private int[] f29792b;

    /* renamed from: c */
    private int f29793c;

    /* renamed from: d */
    private int f29794d;

    /* renamed from: e */
    private String f29795e;

    /* renamed from: f */
    private String f29796f;

    public static class a implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new e(vafContext, viewCache);
        }
    }

    public e(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        StringLoader stringLoader = vafContext.getStringLoader();
        this.f29793c = stringLoader.getStringId("state1Src", false);
        this.f29794d = stringLoader.getStringId("state2Src", false);
    }

    public String a() {
        return this.f29795e;
    }

    public String b() {
        return this.f29796f;
    }

    public void c() {
        Context forViewConstruction;
        Resources resources;
        Drawable drawable;
        Bitmap[] bitmapArr = this.f29791a;
        if (bitmapArr != null && bitmapArr.length == 2) {
            setAutoDimX(bitmapArr[0].getWidth());
            setAutoDimY(this.f29791a[0].getHeight());
            setBitmap(this.f29791a[0]);
            return;
        }
        int[] iArr = this.f29792b;
        if (iArr == null || iArr.length != 2 || (forViewConstruction = this.mContext.forViewConstruction()) == null || (resources = forViewConstruction.getResources()) == null || (drawable = resources.getDrawable(this.f29792b[0])) == null) {
            return;
        }
        setAutoDimX(drawable.getIntrinsicWidth());
        setAutoDimY(drawable.getIntrinsicHeight());
        setImageDrawable(drawable, false);
    }

    public void d() {
        Context forViewConstruction;
        Resources resources;
        Drawable drawable;
        Bitmap[] bitmapArr = this.f29791a;
        if (bitmapArr != null && bitmapArr.length == 2) {
            setAutoDimX(bitmapArr[1].getWidth());
            setAutoDimY(this.f29791a[1].getHeight());
            setBitmap(this.f29791a[1]);
            return;
        }
        int[] iArr = this.f29792b;
        if (iArr == null || iArr.length != 2 || (forViewConstruction = this.mContext.forViewConstruction()) == null || (resources = forViewConstruction.getResources()) == null || (drawable = resources.getDrawable(this.f29792b[1])) == null) {
            return;
        }
        setAutoDimX(drawable.getIntrinsicWidth());
        setAutoDimY(drawable.getIntrinsicHeight());
        setImageDrawable(drawable, false);
    }

    @Override // com.vivo.advv.vaf.virtualview.view.image.ImageBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        if (i2 == this.f29793c) {
            this.f29795e = str;
        } else {
            if (i2 != this.f29794d) {
                return attribute;
            }
            this.f29796f = str;
        }
        return true;
    }

    public void a(Bitmap[] bitmapArr) {
        if (bitmapArr == null || bitmapArr.length != 2) {
            return;
        }
        this.f29791a = bitmapArr;
    }
}
