package com.vivo.mobilead.unified.banner;

import android.app.Activity;
import android.text.TextUtils;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class UnifiedVivoBannerAd {
    private static final String TAG = "UnifiedVivoBannerAd";
    private b adWrap;
    private String appPackage;
    private volatile boolean hasLoad = false;
    private String puuid;

    public UnifiedVivoBannerAd(Activity activity, AdParams adParams, UnifiedVivoBannerAdListener unifiedVivoBannerAdListener) {
        UnifiedVivoBannerAdListener unifiedVivoBannerAdListener2 = unifiedVivoBannerAdListener;
        this.puuid = adParams == null ? "" : adParams.getPositionId();
        this.appPackage = activity != null ? activity.getPackageName() : "";
        if (activity != null && adParams != null && unifiedVivoBannerAdListener2 != null && !TextUtils.isEmpty(adParams.getPositionId())) {
            d dVar = new d(unifiedVivoBannerAdListener2);
            if (!com.vivo.mobilead.manager.f.j().e()) {
                com.vivo.mobilead.unified.base.h.a.a(dVar, new VivoAdError(402111, "请先初始化SDK再请求广告"));
                w.a(this.puuid, this.appPackage, "1000004", String.valueOf(1), String.valueOf(1), String.valueOf(3));
                return;
            } else if (w0.d()) {
                this.adWrap = new a(activity, adParams, dVar);
                return;
            } else {
                this.adWrap = new g(activity, adParams, dVar);
                com.vivo.mobilead.manager.f.j().g();
                return;
            }
        }
        VOpenLog.e(TAG, "context or adParams or listener cannot null");
        if (unifiedVivoBannerAdListener2 != null) {
            d dVar2 = new d(unifiedVivoBannerAdListener2);
            dVar2.onAdFailed(new VivoAdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确"));
            unifiedVivoBannerAdListener2 = dVar2;
        }
        if (activity == null) {
            w.a(this.puuid, this.appPackage, "1000000", String.valueOf(1), String.valueOf(1), String.valueOf(3));
        }
        if (adParams == null) {
            w.a(this.puuid, this.appPackage, "1000002", String.valueOf(1), String.valueOf(1), String.valueOf(3));
        }
        if (unifiedVivoBannerAdListener2 == null) {
            w.a(this.puuid, this.appPackage, "1000001", String.valueOf(1), String.valueOf(1), String.valueOf(3));
        }
    }

    public void destroy() {
        b bVar = this.adWrap;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void loadAd() {
        if (this.hasLoad) {
            w.a(this.puuid, this.appPackage, "1000003", String.valueOf(1), String.valueOf(1), String.valueOf(3));
        }
        if (this.hasLoad) {
            return;
        }
        this.hasLoad = true;
        b bVar = this.adWrap;
        if (bVar != null) {
            bVar.l();
        }
    }
}
