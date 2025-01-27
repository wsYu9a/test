package com.vivo.mobilead.unified.nativead;

import android.app.Activity;
import android.text.TextUtils;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.w;

/* loaded from: classes4.dex */
public class UnifiedVivoNativeExpressAd {
    private static final String TAG = "UnifiedVivoNativeExpressAd";
    private String appPackage;
    private volatile boolean hasLoad = false;
    private a nativeExpressAdWrap;
    private String puuid;

    public UnifiedVivoNativeExpressAd(Activity activity, AdParams adParams, UnifiedVivoNativeExpressAdListener unifiedVivoNativeExpressAdListener) {
        this.puuid = adParams == null ? "" : adParams.getPositionId();
        this.appPackage = activity != null ? activity.getPackageName() : "";
        if (activity != null && adParams != null && unifiedVivoNativeExpressAdListener != null && !TextUtils.isEmpty(adParams.getPositionId())) {
            c cVar = new c(unifiedVivoNativeExpressAdListener);
            if (com.vivo.mobilead.manager.f.j().e()) {
                this.nativeExpressAdWrap = new e(activity, adParams, cVar);
                com.vivo.mobilead.manager.f.j().g();
                return;
            } else {
                com.vivo.mobilead.unified.base.h.a.a(cVar, new VivoAdError(402111, "请先初始化SDK再请求广告"));
                w.a(this.puuid, this.appPackage, "1000004", String.valueOf(1), String.valueOf(0), String.valueOf(5));
                return;
            }
        }
        VOpenLog.e(TAG, "context or adParams or listener cannot null");
        if (unifiedVivoNativeExpressAdListener != null) {
            com.vivo.mobilead.unified.base.h.a.a(new c(unifiedVivoNativeExpressAdListener), new VivoAdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确"));
        }
        if (activity == null) {
            w.a(this.puuid, this.appPackage, "1000000", String.valueOf(1), String.valueOf(0), String.valueOf(5));
        }
        if (adParams == null) {
            w.a(this.puuid, this.appPackage, "1000002", String.valueOf(1), String.valueOf(0), String.valueOf(5));
        }
        if (unifiedVivoNativeExpressAdListener == null) {
            w.a(this.puuid, this.appPackage, "1000001", String.valueOf(1), String.valueOf(0), String.valueOf(5));
        }
    }

    public void loadAd() {
        if (this.hasLoad) {
            w.a(this.puuid, this.appPackage, "1000003", String.valueOf(1), String.valueOf(0), String.valueOf(5));
        }
        if (this.hasLoad || this.nativeExpressAdWrap == null) {
            return;
        }
        this.hasLoad = true;
        this.nativeExpressAdWrap.l();
    }
}
