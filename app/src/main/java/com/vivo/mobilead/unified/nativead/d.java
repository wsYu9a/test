package com.vivo.mobilead.unified.nativead;

import android.content.Context;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.m;
import org.mozilla.universalchardet.prober.g;

/* loaded from: classes4.dex */
public abstract class d extends com.vivo.mobilead.unified.base.e<UnifiedVivoNativeExpressAdListener> {

    /* renamed from: f */
    protected VivoNativeExpressView f30482f;

    public d(Context context, AdParams adParams) {
        super(context, adParams);
    }

    protected int a(Context context, int i2) {
        int c2 = m.c(context);
        return i2 > 0 ? c2 == 1 ? Math.min(Math.max(i2, g.n), m.c(this.f29749b, m.e(context))) : Math.min(Math.max(i2, g.n), 360) : c2 == 1 ? 0 : 360;
    }

    public void c() {
        VivoNativeExpressView vivoNativeExpressView;
        d();
        T t = this.f29751d;
        if (t == 0 || (vivoNativeExpressView = this.f30482f) == null) {
            return;
        }
        ((UnifiedVivoNativeExpressAdListener) t).onAdReady(vivoNativeExpressView);
    }

    protected void d() {
    }
}
