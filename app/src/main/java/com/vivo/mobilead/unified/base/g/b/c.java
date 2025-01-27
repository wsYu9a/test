package com.vivo.mobilead.unified.base.g.b;

import android.graphics.Color;
import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.core.NativeViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewBase;
import com.vivo.advv.vaf.virtualview.core.ViewCache;

/* loaded from: classes4.dex */
public class c extends NativeViewBase {

    /* renamed from: a */
    private int f29780a;

    /* renamed from: b */
    private f f29781b;

    public static class a implements ViewBase.IBuilder {
        @Override // com.vivo.advv.vaf.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext, ViewCache viewCache) {
            return new c(vafContext, viewCache);
        }
    }

    public c(VafContext vafContext, ViewCache viewCache) {
        super(vafContext, viewCache);
        this.f29780a = Color.parseColor("#456FFF");
        f fVar = new f(vafContext.forViewConstruction());
        this.f29781b = fVar;
        this.__mNative = fVar;
    }

    public void a(float f2) {
        this.f29781b.a(f2);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void onParseValueFinished(float f2) {
        super.onParseValueFinished(f2);
        this.f29781b.a(this.f29780a);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.NativeViewBase, com.vivo.advv.vaf.virtualview.core.ViewBase
    public void reset() {
        super.reset();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.ViewBase
    protected boolean setAttribute(int i2, int i3) {
        boolean attribute = super.setAttribute(i2, i3);
        if (attribute) {
            return attribute;
        }
        if (i2 != 94842723) {
            return false;
        }
        this.f29780a = i3;
        this.f29781b.a(i3);
        return true;
    }
}
