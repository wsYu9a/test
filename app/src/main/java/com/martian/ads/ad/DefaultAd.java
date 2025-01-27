package com.martian.ads.ad;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;

/* loaded from: classes3.dex */
public class DefaultAd extends BaseAd {
    private AppTask appTask;

    public DefaultAd(AdConfig adConfig, @NonNull d8.a aVar, AppTask appTask, Handler handler) {
        super(adConfig, aVar, handler);
        this.appTask = appTask;
        appTask.setGroup(adConfig.getGroup());
    }

    public static boolean isDefaultAd(AppTask appTask) {
        return appTask != null && AdConfig.UnionType.DEFAULT.equalsIgnoreCase(appTask.source);
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Context context) {
        AppTask appTask = this.appTask;
        if (appTask == null) {
            onError(null);
            return;
        }
        appTask.setEcpm(5);
        getAppTaskList().addAppTask(this.appTask);
        onAdReceived();
    }

    public void setAppTask(AppTask appTask) {
        this.appTask = appTask;
    }
}
