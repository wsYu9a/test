package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import android.text.TextUtils;
import com.vivo.mobilead.unified.IBidding;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.w0;
import com.vivo.mobilead.util.x0;

/* loaded from: classes4.dex */
public class UnifiedVivoSplashAd implements IBidding {
    private static final String TAG = "UnifiedVivoSplashAd";
    private a baseSplashAdWrap;
    private boolean hasLoad;
    private String sourceAppend;

    public UnifiedVivoSplashAd(Activity activity, UnifiedVivoSplashAdListener unifiedVivoSplashAdListener, AdParams adParams) {
        if (adParams != null) {
            this.sourceAppend = adParams.getSourceAppend();
        }
        if (activity == null || unifiedVivoSplashAdListener == null || adParams == null || TextUtils.isEmpty(adParams.getPositionId())) {
            VOpenLog.e(TAG, "context or adParams or listener cannot null");
            if (unifiedVivoSplashAdListener != null) {
                new d(unifiedVivoSplashAdListener).onAdFailed(new VivoAdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确"));
                return;
            }
            return;
        }
        d dVar = new d(unifiedVivoSplashAdListener);
        if (!com.vivo.mobilead.manager.f.j().e()) {
            dVar.onAdFailed(new VivoAdError(402111, "请先初始化SDK再请求广告"));
            return;
        }
        if (activity.getResources().getConfiguration().orientation != adParams.getSplashOrientation()) {
            x0.b(TAG, "splash ad,the screen orientation is  no difference");
            reportSplashOrientationError();
        }
        com.vivo.mobilead.manager.b.l().putInt("splash_orientation_key", adParams.getSplashOrientation());
        if (w0.d()) {
            this.baseSplashAdWrap = new e(activity, adParams, dVar);
        } else {
            this.baseSplashAdWrap = new h(activity, adParams, dVar);
            com.vivo.mobilead.manager.f.j().g();
        }
    }

    private void reportSplashOrientationError() {
        k0.a(this.sourceAppend);
    }

    public void destroy() {
        a aVar = this.baseSplashAdWrap;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public int getPrice() {
        a aVar = this.baseSplashAdWrap;
        if (aVar == null) {
            return -3;
        }
        return aVar.i();
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public String getPriceLevel() {
        a aVar = this.baseSplashAdWrap;
        return aVar == null ? "" : aVar.j();
    }

    public void loadAd() {
        if (this.hasLoad) {
            return;
        }
        this.hasLoad = true;
        a aVar = this.baseSplashAdWrap;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendLossNotification(int i2, int i3) {
        a aVar = this.baseSplashAdWrap;
        if (aVar != null) {
            aVar.b(i2, i3);
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendWinNotification(int i2) {
        a aVar = this.baseSplashAdWrap;
        if (aVar != null) {
            aVar.b(i2);
        }
    }
}
