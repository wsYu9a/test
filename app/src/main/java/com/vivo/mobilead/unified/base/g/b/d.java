package com.vivo.mobilead.unified.base.g.b;

import com.vivo.advv.Utils;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.NativeViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;
import com.vivo.advv.vaf.virtualview.loader.StringLoader;

/* loaded from: classes4.dex */
public class d extends NativeViewBase {

    /* renamed from: a */
    private g f29782a;

    /* renamed from: b */
    private int f29783b;

    /* renamed from: c */
    private int f29784c;

    /* renamed from: d */
    private int f29785d;

    /* renamed from: e */
    private int f29786e;

    /* renamed from: f */
    private int f29787f;

    /* renamed from: g */
    private int f29788g;

    /* renamed from: h */
    private int f29789h;

    /* renamed from: i */
    private float f29790i;

    public static class a implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new d(vafContext, viewCache);
        }
    }

    public d(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.f29790i = 4.0f;
        g gVar = new g(vafContext.forViewConstruction());
        this.f29782a = gVar;
        this.__mNative = gVar;
        StringLoader stringLoader = vafContext.getStringLoader();
        this.f29783b = stringLoader.getStringId("ratingWidth", false);
        this.f29784c = stringLoader.getStringId("ratingHeight", false);
        this.f29785d = stringLoader.getStringId("ratingDivider", false);
        this.f29786e = stringLoader.getStringId("selectedRatingCount", false);
    }

    public void a(float f2) {
        this.f29782a.setRating(f2);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        this.f29782a.setRatingWidth((int) (this.f29787f * f2));
        this.f29782a.setRatingHeight((int) (this.f29788g * this.mScaleFactor));
        this.f29782a.setRatingDivider((int) (this.f29789h * this.mScaleFactor));
        this.f29782a.setRating(this.f29790i);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, String str) {
        boolean attribute = super.setAttribute(i2, str);
        if (attribute) {
            return attribute;
        }
        if (i2 == this.f29783b) {
            if (Utils.isEL(str)) {
                this.mViewCache.put(this, this.f29783b, str, 1);
            }
        } else if (i2 == this.f29784c) {
            if (Utils.isEL(str)) {
                this.mViewCache.put(this, this.f29784c, str, 1);
            }
        } else if (i2 == this.f29785d) {
            if (Utils.isEL(str)) {
                this.mViewCache.put(this, this.f29785d, str, 1);
            }
        } else {
            if (i2 != this.f29786e) {
                return attribute;
            }
            if (Utils.isEL(str)) {
                this.mViewCache.put(this, this.f29786e, str, 1);
            }
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    public boolean setRPAttribute(int i2, int i3) {
        boolean rPAttribute = super.setRPAttribute(i2, i3);
        if (rPAttribute) {
            return rPAttribute;
        }
        if (i2 == this.f29783b) {
            this.f29787f = rp2px(i3);
        } else if (i2 == this.f29784c) {
            this.f29788g = rp2px(i3);
        } else {
            if (i2 != this.f29785d) {
                return rPAttribute;
            }
            this.f29789h = rp2px(i3);
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 == this.f29783b) {
            this.f29787f = Utils.dp2px(i3);
        } else if (i2 == this.f29784c) {
            this.f29788g = Utils.dp2px(i3);
        } else {
            if (i2 != this.f29785d) {
                return attribute;
            }
            this.f29789h = Utils.dp2px(i3);
        }
        return true;
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, float f2) {
        boolean attribute = super.setAttribute(i2, f2);
        if (attribute) {
            return attribute;
        }
        if (i2 == this.f29783b) {
            this.f29787f = Utils.dp2px(f2);
        } else if (i2 == this.f29784c) {
            this.f29788g = Utils.dp2px(f2);
        } else if (i2 == this.f29785d) {
            this.f29789h = Utils.dp2px(f2);
        } else {
            if (i2 != this.f29786e) {
                return attribute;
            }
            this.f29790i = f2;
        }
        return true;
    }
}
