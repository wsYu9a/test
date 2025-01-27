package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.w;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.l;
import com.vivo.mobilead.unified.base.view.m;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public abstract class a extends com.vivo.mobilead.unified.a implements l {
    protected String A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int t;
    protected UnifiedVivoSplashAdListener u;
    protected m v;
    private boolean w;
    protected com.vivo.ad.model.b x;
    protected Activity y;
    protected long z;

    public a(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.D = false;
        this.y = activity;
        this.A = adParams.getPositionId();
        int fetchTimeout = adParams.getFetchTimeout();
        this.t = fetchTimeout;
        if (fetchTimeout < 3000) {
            this.t = 3000;
        }
        if (this.t > 5000) {
            this.t = 5000;
        }
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        super.a(adError);
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void b(@NonNull AdError adError) {
        super.b(adError);
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    protected void c() {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(402136, "二价计费广告位，未传入价格或传入值无效"));
        }
    }

    @Override // com.vivo.mobilead.unified.a
    public void d() {
        super.d();
        this.w = false;
        m mVar = this.v;
        if (mVar != null) {
            mVar.e();
        }
    }

    @Override // com.vivo.mobilead.unified.a
    protected int f() {
        return 2;
    }

    @Override // com.vivo.mobilead.unified.a
    protected long g() {
        return this.t - 1500;
    }

    @Override // com.vivo.mobilead.unified.a
    protected String k() {
        return "3";
    }

    protected void o() {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            unifiedVivoSplashAdListener.onAdReady(this.v);
        }
    }

    @Override // com.vivo.mobilead.unified.base.callback.l
    public void onAdShow() {
        com.vivo.ad.model.b bVar = this.x;
        if (bVar != null && bVar.m() == 2 && !a(this.x, this.q) && !this.B && this.u != null) {
            this.B = true;
            c();
        }
        a(this.x, 1, this.q, 0);
        if (this.u == null || this.w) {
            return;
        }
        c(this.x);
        this.u.onAdShow();
    }

    protected void c(com.vivo.ad.model.b bVar) {
        k0.a(this.x, this.f29662b, 2, 2, k(), System.currentTimeMillis() - this.z, c.a.f28912a + "", 1);
        if (this.w) {
            return;
        }
        this.w = true;
        k0.a(bVar, a.EnumC0603a.SHOW, this.f29662b.getSourceAppend());
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void a(@NonNull com.vivo.ad.model.b bVar) {
        this.x = bVar;
        k0.a(k(), bVar, 1);
        k0.a(bVar, a.EnumC0603a.LOADED, this.f29662b.getSourceAppend());
        bVar.a(System.currentTimeMillis());
        if (this.v == null) {
            m mVar = new m(this.y, this.f29662b);
            this.v = mVar;
            mVar.setSplashClickListener(this);
        }
        this.v.a(bVar, this.f29662b.getSourceAppend());
        o();
        this.z = System.currentTimeMillis();
        if (TextUtils.isEmpty(bVar.e())) {
            return;
        }
        y0.b(bVar);
    }

    @Override // com.vivo.mobilead.unified.base.callback.l
    public void b() {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener == null || !this.w) {
            return;
        }
        unifiedVivoSplashAdListener.onAdTimeOver();
        if (!this.D) {
            this.D = true;
            k0.a(this.x, System.currentTimeMillis() - this.z, 2, "3", this.f29662b.getSourceAppend());
        }
        m mVar = this.v;
        if (mVar != null) {
            mVar.a(false);
        }
    }

    @Override // com.vivo.mobilead.unified.base.callback.l
    public void a() {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener == null || !this.w) {
            return;
        }
        unifiedVivoSplashAdListener.onAdSkip();
        if (!this.D) {
            this.D = true;
            k0.a(this.x, System.currentTimeMillis() - this.z, 1, "3", this.f29662b.getSourceAppend());
        }
        m mVar = this.v;
        if (mVar != null) {
            mVar.a(false);
        }
    }

    @Override // com.vivo.mobilead.unified.base.callback.l
    public void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z) {
        a(true, bVar, i2, i3, i4, i5, z, z ? 1 : 0);
    }

    @Override // com.vivo.mobilead.unified.base.callback.l
    public void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        a(true, bVar, i2, i3, i4, i5, z, 0.0d, 0.0d, z2, 0);
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(double d2, double d3) {
        a(false, this.x, -999, -999, -999, -999, true, d2, d3, false, 3);
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(int i2, double d2, View view, int i3, int i4, int i5, int i6) {
        a(false, this.x, i3, i4, i5, i6, true, 2);
    }

    @Override // com.vivo.mobilead.unified.base.callback.l
    public void a(com.vivo.mobilead.model.VivoAdError vivoAdError) {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(vivoAdError.getErrorCode(), vivoAdError.getErrorMsg()));
        }
    }

    protected void a(boolean z, com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z2, int i6) {
        a(z, this.x, i2, i3, i4, i5, z2, 0.0d, 0.0d, false, i6);
    }

    protected void a(boolean z, com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z2, double d2, double d3, boolean z3, int i6) {
        if (this.u == null || !this.w || bVar == null) {
            return;
        }
        if (z2 || com.vivo.mobilead.util.c.a(bVar)) {
            boolean a2 = com.vivo.mobilead.util.e.a(z2, this.x);
            k0.a(bVar, z2, i2, i3, i4, i5, k(), u.a(this.y, bVar, a2, i6 == 1, this.f29662b.getSourceAppend(), "3", this.f29662b.getBackUrlInfo(), 1, this.f29668h), this.f29662b.getSourceAppend(), 1, z3, a2);
            this.u.onAdClick();
            if (!this.C) {
                w wVar = new w(bVar.b());
                wVar.a(d2);
                wVar.b(d3);
                k0.a(bVar, a.EnumC0603a.CLICK, i2, i3, i4, i5, wVar, -999, -999, -999, -999, this.f29662b.getSourceAppend());
                this.C = true;
            }
            m mVar = this.v;
            if (mVar != null) {
                mVar.a(z);
            }
        }
    }
}
