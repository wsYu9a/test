package com.vivo.mobilead.unified.banner;

import android.app.Activity;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class c extends f {
    private UnifiedBannerView Q;
    private int R;

    class a implements UnifiedBannerADListener {
        a() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClicked() {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = c.this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdClick();
            }
            k0.a("2", String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) c.this).f29664d, ((com.vivo.mobilead.unified.a) c.this).f29663c, ((com.vivo.mobilead.unified.a) c.this).f29665e, 1, false);
        }

        public void onADCloseOverlay() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADClosed() {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = c.this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdClose();
            }
            c.this.d();
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADExposure() {
            UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = c.this.t;
            if (unifiedVivoBannerAdListener != null) {
                unifiedVivoBannerAdListener.onAdShow();
            }
            k0.a("2", String.valueOf(c.a.f28914c), ((com.vivo.mobilead.unified.a) c.this).f29664d, ((com.vivo.mobilead.unified.a) c.this).f29663c, ((com.vivo.mobilead.unified.a) c.this).f29665e, 1);
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADLeftApplication() {
        }

        public void onADOpenOverlay() {
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onADReceive() {
            if (c.this.Q != null) {
                c.this.P.removeAllViews();
                c cVar = c.this;
                cVar.P.addView(cVar.Q);
            }
            c.this.a(new l0().a(true).a(c.a.f28914c));
            k0.a(((com.vivo.mobilead.unified.a) c.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) c.this).f29663c, "2", ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 1, 1, -10000, "", c.a.f28914c.intValue());
        }

        @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
        public void onNoAD(AdError adError) {
            String str;
            int i2;
            if (adError != null) {
                String errorMsg = adError.getErrorMsg();
                i2 = com.vivo.mobilead.unified.base.f.a.a(adError.getErrorCode());
                str = errorMsg;
            } else {
                str = "暂无广告，请重试";
                i2 = 402116;
            }
            c.this.a(new l0().a(str).b(i2).a(false).a(c.a.f28914c));
            k0.a(((com.vivo.mobilead.unified.a) c.this).f29662b.getPositionId(), ((com.vivo.mobilead.unified.a) c.this).f29663c, "2", ((com.vivo.mobilead.unified.a) c.this).f29664d, 1, 1, 2, i2, str, c.a.f28914c.intValue());
        }
    }

    public c(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.R = adParams.getRefreshIntervalSeconds();
    }

    @Override // com.vivo.mobilead.unified.banner.b, com.vivo.mobilead.unified.a
    public void d() {
        super.d();
        UnifiedBannerView unifiedBannerView = this.Q;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
        this.P.removeAllViews();
    }

    @Override // com.vivo.mobilead.unified.a
    public void l() {
        UnifiedBannerView unifiedBannerView = new UnifiedBannerView(this.O, this.f29662b.getPositionId(), new a());
        this.Q = unifiedBannerView;
        int i2 = this.R;
        if (i2 <= 0) {
            i2 = com.vivo.mobilead.manager.b.l().b();
        }
        this.R = i2;
        unifiedBannerView.setRefresh(i2);
        k0.a(this.f29662b.getPositionId(), this.f29663c, "2", 1, 1, 1, c.a.f28914c.intValue(), 1);
        this.Q.loadAD();
    }
}
