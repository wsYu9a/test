package com.martian.ads.ad;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.maritan.libads.R;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.VideoBonusActivity;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.apptask.g.g;
import com.martian.apptask.widget.CountdownNumberTextView;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.n0;
import com.martian.libmars.utils.w0;
import com.martian.libsupport.k;

/* loaded from: classes2.dex */
public class ApiAd extends BaseAd {
    private boolean cancelLoading;

    /* renamed from: com.martian.ads.ad.ApiAd$1 */
    class AnonymousClass1 implements n0.c {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ ImageView val$splash_image;

        AnonymousClass1(final Activity val$splash_image, final ImageView val$activity) {
            activity = val$splash_image;
            imageView = val$activity;
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onError() {
            ApiAd.this.onError(new b.d.c.b.c(-1, "image null"));
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onSuccess(Drawable resource) {
            n0.h(activity, resource, imageView, 0);
            ApiAd.this.onExpose();
        }
    }

    /* renamed from: com.martian.ads.ad.ApiAd$2 */
    class AnonymousClass2 implements com.martian.apptask.e.c {
        AnonymousClass2() {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskActivated(AppTask appTask1) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskClick(AppTask appTask1) {
            if (appTask1 == null || appTask1.downloadDirectly) {
                return;
            }
            ApiAd.this.onDismiss();
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskDownload(AppTask appTask1) {
        }

        @Override // com.martian.apptask.e.c
        public void onAppTaskInstalled(AppTask appTask1) {
        }
    }

    /* renamed from: com.martian.ads.ad.ApiAd$3 */
    class AnonymousClass3 extends com.martian.apptask.f.b {
        AnonymousClass3() {
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            ApiAd.this.onError(errorResult);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        public void onDataReceived(AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.isEmpty()) {
                ApiAd.this.onError(null);
                return;
            }
            for (AppTask appTask : appTaskList.getApps()) {
                appTask.adsPosition = ApiAd.this.adConfig.getAdsPosition();
                appTask.adsType = ApiAd.this.adConfig.getType();
                appTask.source = ApiAd.this.adConfig.getSource();
            }
            ApiAd.this.setAppTaskList(appTaskList);
            ApiAd.this.onAdReceived();
        }
    }

    /* renamed from: com.martian.ads.ad.ApiAd$4 */
    class AnonymousClass4 extends com.martian.apptask.f.c {
        final /* synthetic */ Activity val$activity;

        AnonymousClass4(final Activity val$activity) {
            activity = val$activity;
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            ApiAd.this.onError(null);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }

        @Override // b.d.c.c.b
        public void onDataReceived(AppTask appTask) {
            if (appTask == null || appTask.video == null) {
                ApiAd.this.onError(null);
            } else {
                VideoBonusActivity.r2((j1) activity, appTask);
            }
        }
    }

    public ApiAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        super(config, receiver);
        this.cancelLoading = false;
    }

    public static boolean isApiFlowAd(AppTask appTask) {
        return appTask != null && AdConfig.UnionType.API.equalsIgnoreCase(appTask.source);
    }

    /* renamed from: lambda$setAdData$0 */
    public /* synthetic */ void a(View v) {
        onClose();
    }

    /* renamed from: lambda$setAdData$1 */
    public /* synthetic */ void b(final CountdownNumberTextView splash_close, CountdownNumberTextView textView) {
        splash_close.setText("跳过");
        onClose();
    }

    /* renamed from: lambda$setAdData$2 */
    public /* synthetic */ void c(final Activity activity, final AppTask appTask, View v) {
        onClick();
        g.v((j1) activity, appTask, new com.martian.apptask.e.c() { // from class: com.martian.ads.ad.ApiAd.2
            AnonymousClass2() {
            }

            @Override // com.martian.apptask.e.c
            public void onAppTaskActivated(AppTask appTask1) {
            }

            @Override // com.martian.apptask.e.c
            public void onAppTaskClick(AppTask appTask1) {
                if (appTask1 == null || appTask1.downloadDirectly) {
                    return;
                }
                ApiAd.this.onDismiss();
            }

            @Override // com.martian.apptask.e.c
            public void onAppTaskDownload(AppTask appTask1) {
            }

            @Override // com.martian.apptask.e.c
            public void onAppTaskInstalled(AppTask appTask1) {
            }
        });
    }

    private void loadFlowAds() {
        AnonymousClass3 anonymousClass3 = new com.martian.apptask.f.b() { // from class: com.martian.ads.ad.ApiAd.3
            AnonymousClass3() {
            }

            @Override // b.d.c.c.b
            public void onResultError(b.d.c.b.c errorResult) {
                ApiAd.this.onError(errorResult);
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
            }

            @Override // b.d.c.c.b
            public void onDataReceived(AppTaskList appTaskList) {
                if (appTaskList == null || appTaskList.isEmpty()) {
                    ApiAd.this.onError(null);
                    return;
                }
                for (AppTask appTask : appTaskList.getApps()) {
                    appTask.adsPosition = ApiAd.this.adConfig.getAdsPosition();
                    appTask.adsType = ApiAd.this.adConfig.getType();
                    appTask.source = ApiAd.this.adConfig.getSource();
                }
                ApiAd.this.setAppTaskList(appTaskList);
                ApiAd.this.onAdReceived();
            }
        };
        anonymousClass3.setAdsCount(this.adConfig.getAdsCount());
        anonymousClass3.setUid(this.adConfig.getUid());
        anonymousClass3.setPosition(this.adConfig.getAdsPosition());
        anonymousClass3.executeParallel(this.adConfig.getApiUrl());
    }

    private void loadSplashAds(Activity activity) {
        onError(null);
    }

    private void loadVideoAd(Activity activity) {
        w0.a(activity, "视频加载中");
        AnonymousClass4 anonymousClass4 = new com.martian.apptask.f.c() { // from class: com.martian.ads.ad.ApiAd.4
            final /* synthetic */ Activity val$activity;

            AnonymousClass4(Activity activity2) {
                activity = activity2;
            }

            @Override // b.d.c.c.b
            public void onResultError(b.d.c.b.c errorResult) {
                ApiAd.this.onError(null);
            }

            @Override // b.d.c.c.g
            protected void showLoading(boolean show) {
            }

            @Override // b.d.c.c.b
            public void onDataReceived(AppTask appTask) {
                if (appTask == null || appTask.video == null) {
                    ApiAd.this.onError(null);
                } else {
                    VideoBonusActivity.r2((j1) activity, appTask);
                }
            }
        };
        anonymousClass4.setUid(this.adConfig.getUid());
        anonymousClass4.executeParallel(this.adConfig.getApiUrl());
    }

    private void setAdData(final Activity activity, final View nativeView, final AppTask appTask) {
        final CountdownNumberTextView countdownNumberTextView = (CountdownNumberTextView) nativeView.findViewById(R.id.splash_close);
        ImageView imageView = (ImageView) nativeView.findViewById(R.id.splash_image);
        countdownNumberTextView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.ads.ad.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApiAd.this.a(view);
            }
        });
        countdownNumberTextView.setOnCountDownFinishListener(new CountdownNumberTextView.b() { // from class: com.martian.ads.ad.c
            @Override // com.martian.apptask.widget.CountdownNumberTextView.b
            public final void a(CountdownNumberTextView countdownNumberTextView2) {
                ApiAd.this.b(countdownNumberTextView, countdownNumberTextView2);
            }
        });
        countdownNumberTextView.setPreText("跳过");
        countdownNumberTextView.n(5);
        String str = appTask.splashImageUrl;
        if (k.p(str)) {
            str = appTask.getPosterUrl();
        }
        n0.E(activity, str, new n0.c() { // from class: com.martian.ads.ad.ApiAd.1
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ ImageView val$splash_image;

            AnonymousClass1(final Activity activity2, ImageView imageView2) {
                activity = activity2;
                imageView = imageView2;
            }

            @Override // com.martian.libmars.utils.n0.c
            public void onError() {
                ApiAd.this.onError(new b.d.c.b.c(-1, "image null"));
            }

            @Override // com.martian.libmars.utils.n0.c
            public void onSuccess(Drawable resource) {
                n0.h(activity, resource, imageView, 0);
                ApiAd.this.onExpose();
            }
        });
        imageView2.setClickable(true);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.martian.ads.ad.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApiAd.this.c(activity2, appTask, view);
            }
        });
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
        if ("splash".equalsIgnoreCase(this.adConfig.getType())) {
            loadSplashAds(activity);
        } else if (AdConfig.AdType.REWARD_VIDEO.equalsIgnoreCase(this.adConfig.getType())) {
            loadVideoAd(activity);
        } else {
            loadFlowAds();
        }
    }
}
