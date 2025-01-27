package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.VideoBonusActivity;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.common.ConfigSingleton;
import l9.t0;
import x8.c;

/* loaded from: classes3.dex */
public class ApiAd extends BaseAd {

    /* renamed from: com.martian.ads.ad.ApiAd$1 */
    public class AnonymousClass1 extends h8.b {
        public AnonymousClass1() {
        }

        @Override // y8.a
        public void onResultError(c cVar) {
            ApiAd.this.onError(cVar);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        public void onDataReceived(AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.isEmpty()) {
                ApiAd.this.onError(null);
                return;
            }
            for (AppTask appTask : appTaskList.getApps()) {
                appTask.pid = ApiAd.this.adConfig.getPid();
                appTask.adsType = ApiAd.this.adConfig.getType();
                appTask.source = ApiAd.this.adConfig.getSource();
            }
            ApiAd.this.setAppTaskList(appTaskList);
            ApiAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.ApiAd$2 */
    public class AnonymousClass2 extends h8.c {
        final /* synthetic */ Context val$context;

        public AnonymousClass2(Context context) {
            context = context;
        }

        @Override // y8.a
        public void onResultError(c cVar) {
            ApiAd.this.onError(null);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }

        @Override // y8.a
        public void onDataReceived(AppTask appTask) {
            if (appTask == null || appTask.video == null) {
                ApiAd.this.onError(null);
            } else {
                VideoBonusActivity.J2((Activity) context, appTask);
            }
        }
    }

    public ApiAd(AdConfig adConfig, @NonNull d8.a aVar, Handler handler) {
        super(adConfig, aVar, handler);
    }

    public static boolean isApiFlowAd(AppTask appTask) {
        return appTask != null && AdConfig.UnionType.API.equalsIgnoreCase(appTask.source);
    }

    private void loadFlowAds() {
        AnonymousClass1 anonymousClass1 = new h8.b() { // from class: com.martian.ads.ad.ApiAd.1
            public AnonymousClass1() {
            }

            @Override // y8.a
            public void onResultError(c cVar) {
                ApiAd.this.onError(cVar);
            }

            @Override // y8.f
            public void showLoading(boolean z10) {
            }

            @Override // y8.a
            public void onDataReceived(AppTaskList appTaskList) {
                if (appTaskList == null || appTaskList.isEmpty()) {
                    ApiAd.this.onError(null);
                    return;
                }
                for (AppTask appTask : appTaskList.getApps()) {
                    appTask.pid = ApiAd.this.adConfig.getPid();
                    appTask.adsType = ApiAd.this.adConfig.getType();
                    appTask.source = ApiAd.this.adConfig.getSource();
                }
                ApiAd.this.setAppTaskList(appTaskList);
                ApiAd.this.onAdReceived();
            }
        };
        anonymousClass1.setAdsCount(this.adConfig.getAdsCount());
        anonymousClass1.setUid(ConfigSingleton.D().y());
        anonymousClass1.setPosition(this.adConfig.getPid());
        anonymousClass1.executeParallel(this.adConfig.getApiUrl());
    }

    private void loadSplashAds(Context context) {
        onError(null);
    }

    private void loadVideoAd(Context context) {
        t0.b(context, "视频加载中");
        AnonymousClass2 anonymousClass2 = new h8.c() { // from class: com.martian.ads.ad.ApiAd.2
            final /* synthetic */ Context val$context;

            public AnonymousClass2(Context context2) {
                context = context2;
            }

            @Override // y8.a
            public void onResultError(c cVar) {
                ApiAd.this.onError(null);
            }

            @Override // y8.f
            public void showLoading(boolean z10) {
            }

            @Override // y8.a
            public void onDataReceived(AppTask appTask) {
                if (appTask == null || appTask.video == null) {
                    ApiAd.this.onError(null);
                } else {
                    VideoBonusActivity.J2((Activity) context, appTask);
                }
            }
        };
        anonymousClass2.setUid(ConfigSingleton.D().y());
        anonymousClass2.executeParallel(this.adConfig.getApiUrl());
    }

    @Override // com.martian.ads.ad.BaseAd
    public void loadAds(Context context) {
        onAdRequest();
        if ("splash".equalsIgnoreCase(this.adConfig.getType())) {
            loadSplashAds(context);
        } else if (AdConfig.AdType.REWARD_VIDEO.equalsIgnoreCase(this.adConfig.getType())) {
            loadVideoAd(context);
        } else {
            loadFlowAds();
        }
    }
}
