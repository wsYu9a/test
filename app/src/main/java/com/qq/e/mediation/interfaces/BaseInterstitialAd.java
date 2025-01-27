package com.qq.e.mediation.interfaces;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;

/* loaded from: classes4.dex */
public abstract class BaseInterstitialAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseInterstitialAd(Activity activity, String str, String str2, String str3) {
    }

    public abstract void close();

    public abstract void destory();

    public abstract int getAdPatternType();

    public int getAdapterPriority() {
        return -1;
    }

    public abstract String getECPMLevel();

    public abstract int getVideoDuration();

    public abstract boolean isValid();

    public abstract void loadAd();

    public abstract void loadFullScreenAD();

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i2, int i3, String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i2) {
    }

    public abstract void setAdListener(ADListener aDListener);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i2) {
    }

    public abstract void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    public abstract void setMaxVideoDuration(int i2);

    public abstract void setMinVideoDuration(int i2);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVideoOption(VideoOption videoOption);

    public abstract void show();

    public abstract void show(Activity activity);

    public abstract void showAsPopupWindow();

    public abstract void showAsPopupWindow(Activity activity);

    public abstract void showFullScreenAD(Activity activity);
}
