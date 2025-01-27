package com.vivo.mobilead.nativead;

import android.app.Activity;
import android.text.TextUtils;
import com.vivo.ad.model.AdError;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class VivoNativeAd {
    private static final String TAG = "VivoNativeAd";
    private String appPackage;
    private volatile boolean hasLoad = false;
    private NativeAdListener mAdListener;
    private a mBaseNativeAdWrap;
    private String puuid;

    public VivoNativeAd(Activity activity, NativeAdParams nativeAdParams, NativeAdListener nativeAdListener) {
        this.puuid = nativeAdParams == null ? "" : nativeAdParams.getPositionId();
        this.appPackage = activity != null ? activity.getPackageName() : "";
        if (activity != null && nativeAdListener != null && nativeAdParams != null && !TextUtils.isEmpty(nativeAdParams.getPositionId())) {
            this.mAdListener = new com.vivo.ad.nativead.e(nativeAdListener);
            if (w0.d()) {
                this.mBaseNativeAdWrap = new l(activity, nativeAdParams, this.mAdListener);
                return;
            } else {
                this.mBaseNativeAdWrap = new k(activity, nativeAdParams, this.mAdListener);
                com.vivo.mobilead.manager.f.j().g();
                return;
            }
        }
        VOpenLog.e(TAG, "context or adParams or listener cannot null");
        if (nativeAdListener != null) {
            com.vivo.ad.nativead.e eVar = new com.vivo.ad.nativead.e(nativeAdListener);
            this.mAdListener = eVar;
            eVar.onNoAD(new AdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确", null, null));
        }
        if (activity == null) {
            w.a(this.puuid, this.appPackage, "1000000", String.valueOf(2), String.valueOf(0), String.valueOf(5));
        }
        if (nativeAdParams == null) {
            w.a(this.puuid, this.appPackage, "1000002", String.valueOf(2), String.valueOf(0), String.valueOf(5));
        }
        if (nativeAdListener == null) {
            w.a(this.puuid, this.appPackage, "1000001", String.valueOf(2), String.valueOf(0), String.valueOf(5));
        }
    }

    public void loadAd() {
        if (this.hasLoad) {
            w.a(this.puuid, this.appPackage, "1000003", String.valueOf(2), String.valueOf(0), String.valueOf(5));
            return;
        }
        if (!com.vivo.mobilead.manager.f.j().e()) {
            NativeAdListener nativeAdListener = this.mAdListener;
            if (nativeAdListener != null) {
                nativeAdListener.onNoAD(new AdError(402111, "请先初始化SDK再请求广告", null, null));
            }
            w.a(this.puuid, this.appPackage, "1000004", String.valueOf(2), String.valueOf(0), String.valueOf(5));
            return;
        }
        this.hasLoad = true;
        a aVar = this.mBaseNativeAdWrap;
        if (aVar != null) {
            aVar.a();
        }
    }
}
