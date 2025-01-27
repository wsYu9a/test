package com.vivo.mobilead.unified.b;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.manager.f;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.e;
import com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class d extends com.vivo.mobilead.unified.nativead.d {

    /* renamed from: g */
    private com.vivo.mobilead.unified.nativead.a f29684g;

    /* renamed from: h */
    private UnifiedVivoNativeExpressAdListener f29685h;

    class a implements com.vivo.mobilead.g.b {
        a() {
        }

        @Override // com.vivo.mobilead.g.b
        public void a(l0 l0Var) {
            d.this.a(l0Var);
        }
    }

    class b implements UnifiedVivoNativeExpressAdListener {
        b() {
        }

        @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
        public void onAdClick(VivoNativeExpressView vivoNativeExpressView) {
            if (((e) d.this).f29751d != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) d.this).f29751d).onAdClick(vivoNativeExpressView);
            }
        }

        @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
        public void onAdClose(VivoNativeExpressView vivoNativeExpressView) {
            if (((e) d.this).f29751d != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) d.this).f29751d).onAdClose(vivoNativeExpressView);
            }
        }

        @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
        public void onAdFailed(VivoAdError vivoAdError) {
            if (((e) d.this).f29751d != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) d.this).f29751d).onAdFailed(vivoAdError);
            }
        }

        @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
        public void onAdReady(VivoNativeExpressView vivoNativeExpressView) {
            ((com.vivo.mobilead.unified.nativead.d) d.this).f30482f = vivoNativeExpressView;
        }

        @Override // com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener
        public void onAdShow(VivoNativeExpressView vivoNativeExpressView) {
            if (((e) d.this).f29751d != null) {
                ((UnifiedVivoNativeExpressAdListener) ((e) d.this).f29751d).onAdShow(vivoNativeExpressView);
            }
        }
    }

    public d(Context context, AdParams adParams) {
        super(context, adParams);
        this.f29685h = new b();
    }

    @Override // com.vivo.mobilead.unified.base.e
    public void b() {
        AdParams adParams;
        if (!f.j().e() || this.f29749b == null || (adParams = this.f29750c) == null || TextUtils.isEmpty(adParams.getPositionId())) {
            a(new l0().a(c.a.f28912a).b(40218).a("没有广告，建议过一会儿重试").a(false));
            return;
        }
        com.vivo.mobilead.unified.nativead.a aVar = new com.vivo.mobilead.unified.nativead.a(this.f29749b, this.f29750c, this.f29685h);
        this.f29684g = aVar;
        aVar.a(new a());
        this.f29684g.l();
    }
}
