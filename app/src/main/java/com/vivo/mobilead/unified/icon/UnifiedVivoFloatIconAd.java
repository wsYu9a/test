package com.vivo.mobilead.unified.icon;

import android.app.Activity;
import android.text.TextUtils;
import com.vivo.mobilead.manager.f;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.w;

/* loaded from: classes4.dex */
public class UnifiedVivoFloatIconAd {
    private static final String TAG = "UnifiedVivoFloatIconAd";
    private String appPackage;
    private a floaticonAdWrap;
    private volatile boolean hasLoad = false;
    private volatile boolean hasShow = false;
    private String puuid;

    public UnifiedVivoFloatIconAd(Activity activity, AdParams adParams, UnifiedVivoFloatIconAdListener unifiedVivoFloatIconAdListener) {
        this.puuid = adParams == null ? "" : adParams.getPositionId();
        this.appPackage = activity != null ? activity.getPackageName() : "";
        if (activity != null && adParams != null && unifiedVivoFloatIconAdListener != null && !TextUtils.isEmpty(adParams.getPositionId())) {
            b bVar = new b(unifiedVivoFloatIconAdListener);
            if (f.j().e()) {
                this.floaticonAdWrap = new a(activity, adParams, bVar);
                f.j().g();
                return;
            } else {
                w.a(this.puuid, this.appPackage, "1000004", String.valueOf(3), String.valueOf(0), String.valueOf(5));
                com.vivo.mobilead.unified.base.h.a.a(bVar, new VivoAdError(402111, "请先初始化SDK再请求广告"));
                return;
            }
        }
        VOpenLog.e(TAG, "context or adParams or listener cannot null");
        if (unifiedVivoFloatIconAdListener != null) {
            com.vivo.mobilead.unified.base.h.a.a(new b(unifiedVivoFloatIconAdListener), new VivoAdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确"));
        }
        if (activity == null) {
            w.a(this.puuid, this.appPackage, "1000000", String.valueOf(3), String.valueOf(0), String.valueOf(5));
        }
        if (adParams == null) {
            w.a(this.puuid, this.appPackage, "1000002", String.valueOf(3), String.valueOf(0), String.valueOf(5));
        }
        if (unifiedVivoFloatIconAdListener == null) {
            w.a(this.puuid, this.appPackage, "1000001", String.valueOf(3), String.valueOf(0), String.valueOf(5));
        }
    }

    public void destroy() {
        a aVar = this.floaticonAdWrap;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void loadAd() {
        if (this.hasLoad) {
            w.a(this.puuid, this.appPackage, "1000003", String.valueOf(3), String.valueOf(0), String.valueOf(5));
        }
        if (this.hasLoad || this.floaticonAdWrap == null) {
            return;
        }
        this.hasLoad = true;
        this.floaticonAdWrap.l();
    }

    public void showAd(Activity activity) {
        if (this.hasShow || this.floaticonAdWrap == null) {
            return;
        }
        this.hasShow = true;
        this.floaticonAdWrap.a(activity);
    }

    public void showAd(Activity activity, int i2, int i3) {
        if (this.hasShow || this.floaticonAdWrap == null) {
            return;
        }
        this.hasShow = true;
        this.floaticonAdWrap.a(activity, i2, i3);
    }
}
