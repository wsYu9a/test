package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.vivo.mobilead.unified.IBidding;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.w;
import com.vivo.mobilead.util.w0;

/* loaded from: classes4.dex */
public class UnifiedVivoRewardVideoAd implements IBidding {
    private static final String TAG = "UnifiedVivoRewardVideoAd";
    private a adWrap;
    private String appPackage;
    private volatile boolean hasLoad = false;
    private volatile boolean hasShow = false;
    private String puuid;
    private UnifiedVivoRewardVideoAdListener rewardVideoAdListener;

    public UnifiedVivoRewardVideoAd(Context context, AdParams adParams, UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        Context context2;
        this.puuid = adParams == null ? "" : adParams.getPositionId();
        if (context == null) {
            context2 = com.vivo.mobilead.manager.f.j().c();
            w.a(this.puuid, this.appPackage, "1000000", String.valueOf(1), String.valueOf(1), String.valueOf(9));
        } else {
            context2 = context;
        }
        this.appPackage = context != null ? context.getPackageName() : "";
        if (context2 == null || adParams == null || unifiedVivoRewardVideoAdListener == null || TextUtils.isEmpty(adParams.getPositionId())) {
            VOpenLog.e(TAG, "context or adParams or listener cannot null");
            if (unifiedVivoRewardVideoAdListener != null) {
                f fVar = new f(unifiedVivoRewardVideoAdListener);
                this.rewardVideoAdListener = fVar;
                fVar.onAdFailed(new VivoAdError(40211, "初始化参数传入有问题，请检查对应参数是否传入正确"));
            }
            if (adParams == null) {
                w.a(this.puuid, this.appPackage, "1000002", String.valueOf(1), String.valueOf(1), String.valueOf(9));
            }
            if (unifiedVivoRewardVideoAdListener == null) {
                w.a(this.puuid, this.appPackage, "1000001", String.valueOf(1), String.valueOf(1), String.valueOf(9));
                return;
            }
            return;
        }
        this.rewardVideoAdListener = new f(unifiedVivoRewardVideoAdListener);
        if (!com.vivo.mobilead.manager.f.j().e()) {
            com.vivo.mobilead.unified.base.h.a.a(this.rewardVideoAdListener, new VivoAdError(402111, "请先初始化SDK再请求广告"));
            w.a(this.puuid, this.appPackage, "1000004", String.valueOf(1), String.valueOf(1), String.valueOf(9));
        } else if (w0.d()) {
            this.adWrap = new e(context2, adParams, this.rewardVideoAdListener);
        } else {
            this.adWrap = new i(context2, adParams, this.rewardVideoAdListener);
            com.vivo.mobilead.manager.f.j().g();
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public int getPrice() {
        a aVar = this.adWrap;
        if (aVar == null) {
            return -3;
        }
        return aVar.i();
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public String getPriceLevel() {
        a aVar = this.adWrap;
        return aVar == null ? "" : aVar.j();
    }

    public void loadAd() {
        if (this.hasLoad) {
            w.a(this.puuid, this.appPackage, "1000003", String.valueOf(1), String.valueOf(1), String.valueOf(9));
            return;
        }
        this.hasLoad = true;
        if (!(System.currentTimeMillis() - d.c().a() >= ((long) (com.vivo.mobilead.manager.b.l().j() * 1000)))) {
            com.vivo.mobilead.unified.base.h.a.a(this.rewardVideoAdListener, new VivoAdError(40217, "广告拉取太频繁，请间隔一定时间请求"));
            w.a(this.puuid, this.appPackage, "1000005", String.valueOf(1), String.valueOf(1), String.valueOf(9));
        } else {
            a aVar = this.adWrap;
            if (aVar != null) {
                aVar.l();
            }
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendLossNotification(int i2, int i3) {
        a aVar = this.adWrap;
        if (aVar != null) {
            aVar.b(i2, i3);
        }
    }

    @Override // com.vivo.mobilead.unified.IBidding
    public void sendWinNotification(int i2) {
        a aVar = this.adWrap;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public void setMediaListener(MediaListener mediaListener) {
        a aVar = this.adWrap;
        if (aVar != null) {
            aVar.a(mediaListener);
        }
    }

    public void showAd(Activity activity) {
        if (this.hasShow) {
            return;
        }
        this.hasShow = true;
        a aVar = this.adWrap;
        if (aVar != null) {
            aVar.a(activity);
        }
    }
}
