package com.martian.ads.ad;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;

/* loaded from: classes2.dex */
public class DefaultAd extends BaseAd {
    private AppTask appTask;
    private boolean cancelLoading;

    public DefaultAd(AdConfig config, @NonNull b.d.a.k.a receiver, AppTask appTask) {
        super(config, receiver);
        this.cancelLoading = false;
        this.appTask = appTask;
    }

    public static boolean isDefaultAd(AppTask appTask) {
        return appTask != null && AdConfig.UnionType.DEFAULT.equalsIgnoreCase(appTask.source);
    }

    @Override // com.martian.ads.ad.BaseAd
    protected boolean adCanceled() {
        return this.cancelLoading;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void cancelLoading() {
        this.cancelLoading = true;
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Activity activity) {
        AppTask appTask = this.appTask;
        if (appTask == null) {
            onError(null);
            return;
        }
        appTask.setEcpm(10);
        getAppTaskList().addAppTask(this.appTask);
        onAdReceived();
    }

    public void setAppTask(AppTask appTask) {
        this.appTask = appTask;
    }
}
