package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.vivo.mobilead.unified.IBidding;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class UnifiedVivoInterstitialAd implements IBidding {
    private String appPackage;
    private a institialAdWrap;
    private String puuid;
    private final String TAG = "UnifiedVivoInterstitialAd";
    private volatile boolean hasLoad = false;
    private volatile boolean hasShow = false;

    public UnifiedVivoInterstitialAd(Activity activity, AdParams adParams, UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener) {
        this.puuid = adParams == null ? "" : adParams.getPositionId();
        this.appPackage = activity != null ? activity.getPackageName() : "";
        if (activity == null || adParams == null || unifiedVivoInterstitialAdListener == null || TextUtils.isEmpty(adParams.getPositionId())) {
            VOpenLog.e("UnifiedVivoInterstitialAd", "context or adParams or listener cannot null");
            if (unifiedVivoInterstitialAdListener != null) {
                new e(unifiedVivoInterstitialAdListener).onAdFailed(new VivoAdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确"));
            }
            if (activity == null) {
                w.a(this.puuid, this.appPackage, "1000000", String.valueOf(1), String.valueOf(1), String.valueOf(4));
            }
            if (adParams == null) {
                w.a(this.puuid, this.appPackage, "1000002", String.valueOf(1), String.valueOf(1), String.valueOf(4));
            }
            if (unifiedVivoInterstitialAdListener == null) {
                w.a(this.puuid, this.appPackage, "1000001", String.valueOf(1), String.valueOf(1), String.valueOf(4));
                return;
            }
            return;
        }
        e eVar = new e(unifiedVivoInterstitialAdListener);
        if (!com.vivo.mobilead.manager.f.j().e()) {
            com.vivo.mobilead.unified.base.h.a.a(eVar, new VivoAdError(402111, "请先初始化SDK再请求广告"));
            w.a(this.puuid, this.appPackage, "1000004", String.valueOf(1), String.valueOf(1), String.valueOf(4));
        } else if (w0.d()) {
            this.institialAdWrap = new c(activity, adParams, eVar);
        } else {
            this.institialAdWrap = new j(activity, adParams, eVar);
            com.vivo.mobilead.manager.f.j().g();
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public int getPrice() {
        a aVar = this.institialAdWrap;
        if (aVar == null) {
            return -3;
        }
        return aVar.i();
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public String getPriceLevel() {
        a aVar = this.institialAdWrap;
        return aVar == null ? "" : aVar.j();
    }

    public void loadAd() {
        if (this.hasLoad) {
            w.a(this.puuid, this.appPackage, "1000003", String.valueOf(1), String.valueOf(1), String.valueOf(4));
        }
        if (this.hasLoad || this.institialAdWrap == null) {
            return;
        }
        this.hasLoad = true;
        this.institialAdWrap.l();
    }

    public void loadVideoAd() {
        if (this.hasLoad || this.institialAdWrap == null) {
            return;
        }
        this.hasLoad = true;
        this.institialAdWrap.o();
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendLossNotification(int i2, int i3) {
        a aVar = this.institialAdWrap;
        if (aVar != null) {
            aVar.b(i2, i3);
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendWinNotification(int i2) {
        a aVar = this.institialAdWrap;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public void setMediaListener(MediaListener mediaListener) {
        a aVar = this.institialAdWrap;
        if (aVar != null) {
            aVar.a(mediaListener);
        }
    }

    public void showAd() {
        if (this.hasShow || this.institialAdWrap == null) {
            return;
        }
        this.hasShow = true;
        this.institialAdWrap.q();
    }

    public void showVideoAd(Activity activity) {
        if (this.hasShow || this.institialAdWrap == null) {
            return;
        }
        this.hasShow = true;
        this.institialAdWrap.a(activity);
    }
}
