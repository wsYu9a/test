package com.vivo.mobilead.unified.base.g.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.vivo.ad.model.AdError;
import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.Helper.ImageLoader;
import com.vivo.advv.vaf.virtualview.core.NativeViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.loader.StringLoader;
import com.vivo.advv.virtualview.common.StringBase;
import com.vivo.mobilead.i.m;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class a extends NativeViewBase {

    /* renamed from: a */
    private com.vivo.mobilead.unified.base.g.b.b f29754a;

    /* renamed from: b */
    private int f29755b;

    /* renamed from: c */
    private int f29756c;

    /* renamed from: d */
    private String f29757d;

    /* renamed from: e */
    private int f29758e;

    /* renamed from: f */
    private float f29759f;

    /* renamed from: g */
    private int f29760g;

    /* renamed from: h */
    private String f29761h;

    /* renamed from: i */
    private int f29762i;

    /* renamed from: j */
    private boolean f29763j;

    /* renamed from: com.vivo.mobilead.unified.base.g.b.a$a */
    class C0613a implements m {

        /* renamed from: a */
        final /* synthetic */ String f29764a;

        /* renamed from: com.vivo.mobilead.unified.base.g.b.a$a$a */
        class C0614a implements com.vivo.mobilead.unified.base.callback.c {

            /* renamed from: com.vivo.mobilead.unified.base.g.b.a$a$a$a */
            class C0615a extends com.vivo.mobilead.unified.base.g.a {
                C0615a() {
                }

                @Override // com.vivo.mobilead.unified.base.g.a, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
                public void onImageLoadSuccess(Bitmap bitmap) {
                    super.onImageLoadSuccess(bitmap);
                    a aVar = a.this;
                    if (aVar.a(((ViewBase) aVar).mContext.forViewConstruction()) || bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    a.this.setBackgroundImage(bitmap);
                }
            }

            C0614a() {
            }

            @Override // com.vivo.mobilead.unified.base.callback.c
            public void a(String str, Bitmap bitmap) {
                if (bitmap != null) {
                    a.this.f29754a.setPreviewImage(bitmap);
                    if (a.this.f29760g <= 0 || a.this.f29759f <= 0.0f) {
                        return;
                    }
                    ImageLoader imageLoader = ((ViewBase) a.this).mContext.getImageLoader();
                    a aVar = a.this;
                    imageLoader.getBlurBitmap(bitmap, aVar, aVar.f29759f, a.this.f29760g, new C0615a());
                }
            }
        }

        C0613a(String str) {
            this.f29764a = str;
        }

        @Override // com.vivo.mobilead.i.m
        public void a() {
            com.vivo.mobilead.h.b.a().a(this.f29764a, com.vivo.mobilead.h.b.a().a(this.f29764a, a.this.getComMeasuredWidth(), a.this.getComMeasuredHeight()), new C0614a());
        }

        @Override // com.vivo.mobilead.i.m
        public void a(AdError adError) {
        }
    }

    class b extends com.vivo.mobilead.unified.base.g.a {

        /* renamed from: com.vivo.mobilead.unified.base.g.b.a$b$a */
        class C0616a extends com.vivo.mobilead.unified.base.g.a {
            C0616a() {
            }

            @Override // com.vivo.mobilead.unified.base.g.a, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
            public void onImageLoadSuccess(Bitmap bitmap) {
                super.onImageLoadSuccess(bitmap);
                a aVar = a.this;
                if (aVar.a(((ViewBase) aVar).mContext.forViewConstruction()) || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                a.this.setBackgroundImage(bitmap);
            }
        }

        b() {
        }

        @Override // com.vivo.mobilead.unified.base.g.a, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadFailed() {
        }

        @Override // com.vivo.mobilead.unified.base.g.a, com.vivo.advv.vaf.virtualview.Helper.ImageLoader.Listener
        public void onImageLoadSuccess(Bitmap bitmap) {
            if (((ViewBase) a.this).mDynamicMaterialType == 0) {
                a.this.f29754a.setBitmapSrc(bitmap);
            }
            if (a.this.f29760g <= 0 || a.this.f29759f <= 0.0f) {
                return;
            }
            ImageLoader imageLoader = ((ViewBase) a.this).mContext.getImageLoader();
            a aVar = a.this;
            imageLoader.getBlurBitmap(bitmap, aVar, aVar.f29759f, a.this.f29760g, new C0616a());
        }
    }

    public static class c implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new a(vafContext, viewCache);
        }
    }

    public a(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.f29758e = 1;
        this.f29759f = 1.0f;
        this.f29762i = 1;
        this.f29763j = false;
        com.vivo.mobilead.unified.base.g.b.b bVar = new com.vivo.mobilead.unified.base.g.b.b(vafContext.forViewConstruction());
        this.f29754a = bVar;
        this.__mNative = bVar;
        StringLoader stringLoader = vafContext.getStringLoader();
        this.f29755b = stringLoader.getStringId("preImage", false);
        this.f29756c = stringLoader.getStringId("preImageScaleType", false);
    }

    public void i() {
        this.f29754a.g();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase, com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onComLayout(z, i2, i3, i4, i5);
        if (this.f29763j) {
            return;
        }
        this.f29763j = true;
        if (this.mDynamicMaterialType == 1) {
            String str = this.f29761h;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            y0.a(null, str, 1000L, new C0613a(str));
            return;
        }
        String str2 = this.f29757d;
        boolean needCheck = needCheck(StringBase.STR_ID_src);
        if (com.vivo.advv.TextUtils.isEmpty(str2)) {
            return;
        }
        this.mContext.getImageLoader().getBitmap(needCheck, str2, this, this.mMeasuredWidth, this.mMeasuredHeight, new b());
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        this.f29754a.setBorderTopLeftRadius((int) (this.mBorderTopLeftRadius * this.mScaleFactor));
        this.f29754a.setBorderTopRightRadius((int) (this.mBorderTopRightRadius * this.mScaleFactor));
        this.f29754a.setBorderBottomLeftRadius((int) (this.mBorderBottomLeftRadius * this.mScaleFactor));
        this.f29754a.setBorderBottomRightRadius((int) (this.mBorderBottomRightRadius * this.mScaleFactor));
        this.f29754a.setMediaType(this.mDynamicMaterialType);
        this.f29754a.setPreImageScaleType(this.f29762i);
        this.f29754a.setScaleType(this.f29758e);
        if (this.mDynamicMaterialType == 1) {
            if (com.vivo.advv.TextUtils.isEmpty(this.f29757d)) {
                return;
            }
            this.f29754a.setPlayUrl(this.f29757d);
        } else {
            if (com.vivo.advv.TextUtils.isEmpty(this.f29757d) || !needCheck(StringBase.STR_ID_src)) {
                return;
            }
            this.mContext.getImageLoader().checkExist(this.f29757d, this);
        }
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        if (i2 == 114148) {
            if (Utils.isEL(str)) {
                this.mViewCache.put(this, StringBase.STR_ID_src, str, 2);
            } else {
                this.f29757d = str;
            }
            return true;
        }
        if (i2 == -71928322) {
            if (!Utils.isEL(str)) {
                return attribute;
            }
            this.mViewCache.put(this, StringBase.STR_ID_bgBlurRadius, str, 0);
            return attribute;
        }
        if (i2 == 1603022419) {
            if (!Utils.isEL(str)) {
                return attribute;
            }
            this.mViewCache.put(this, StringBase.STR_ID_bgBlurSampling, str, 1);
            return attribute;
        }
        if (i2 != this.f29755b) {
            return attribute;
        }
        if (Utils.isEL(str)) {
            this.mViewCache.put(this, this.f29755b, str, 2);
            return attribute;
        }
        this.f29761h = str;
        return attribute;
    }

    public void c() {
        this.f29754a.a();
    }

    public void d() {
        this.f29754a.b();
    }

    public void e() {
        this.f29754a.c();
    }

    public void f() {
        this.f29754a.d();
    }

    public void g() {
        this.f29754a.e();
    }

    public void h() {
        this.f29754a.f();
    }

    public int b() {
        return this.f29754a.getDuration();
    }

    public boolean a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing();
        }
        return false;
    }

    public void b(int i2) {
        this.f29754a.setVideoWidth(i2);
    }

    public void b(String str) {
        this.f29754a.setReqId(str);
    }

    public void a(com.vivo.mobilead.d.a aVar) {
        this.f29754a.setMediaCallback(aVar);
    }

    public int a() {
        return this.f29754a.getCurrentPosition();
    }

    public void a(boolean z) {
        this.f29754a.setMute(z);
    }

    public void a(String str) {
        this.f29754a.setPuuid(str);
    }

    public void a(int i2) {
        this.f29754a.setVideoHeight(i2);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == -1877911644) {
            this.f29758e = i3;
        } else if (i2 == -71928322) {
            this.f29760g = i3;
        } else {
            if (i2 != this.f29756c) {
                return attribute;
            }
            this.f29762i = i3;
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute || i2 != 1603022419) {
            return attribute;
        }
        this.f29759f = f2;
        return true;
    }
}
