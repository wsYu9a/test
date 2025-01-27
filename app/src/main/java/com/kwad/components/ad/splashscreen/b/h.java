package com.kwad.components.ad.splashscreen.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class h extends e implements com.kwad.sdk.core.g.c {
    private ImageView Cj;
    private ImageView Ck;
    private AdInfo mAdInfo;
    private boolean Ci = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean Cl = false;
    private boolean Cm = false;
    private boolean Cn = false;
    private boolean Co = false;

    /* renamed from: com.kwad.components.ad.splashscreen.b.h$1 */
    final class AnonymousClass1 implements ImageLoadingListener {

        /* renamed from: com.kwad.components.ad.splashscreen.b.h$1$1 */
        final class RunnableC01561 implements Runnable {
            final /* synthetic */ DecodedResult jO;

            /* renamed from: com.kwad.components.ad.splashscreen.b.h$1$1$1 */
            final class RunnableC01571 implements Runnable {
                final /* synthetic */ Bitmap Cr;

                RunnableC01571(Bitmap bitmap) {
                    stackBlur = bitmap;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    h.this.Ck.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                }
            }

            RunnableC01561(DecodedResult decodedResult) {
                decodedResult = decodedResult;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h.this.Ck.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.1.1.1
                    final /* synthetic */ Bitmap Cr;

                    RunnableC01571(Bitmap bitmap) {
                        stackBlur = bitmap;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.Ck.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                    }
                });
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            h.a(h.this, true);
            h.this.kv();
            h.this.Ck.setVisibility(0);
            GlobalThreadPools.xM().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.1.1
                final /* synthetic */ DecodedResult jO;

                /* renamed from: com.kwad.components.ad.splashscreen.b.h$1$1$1 */
                final class RunnableC01571 implements Runnable {
                    final /* synthetic */ Bitmap Cr;

                    RunnableC01571(Bitmap bitmap) {
                        stackBlur = bitmap;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.Ck.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                    }
                }

                RunnableC01561(DecodedResult decodedResult2) {
                    decodedResult = decodedResult2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    h.this.Ck.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.1.1.1
                        final /* synthetic */ Bitmap Cr;

                        RunnableC01571(Bitmap bitmap) {
                            stackBlur = bitmap;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            h.this.Ck.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            if (h.this.Cl) {
                return;
            }
            h.this.Cg.f(0, "load image error");
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.h$2 */
    final class AnonymousClass2 implements ImageLoadingListener {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
            h.a(h.this, true);
            h.this.kv();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            if (h.this.Cl) {
                return;
            }
            h.this.Cg.f(0, "load image error");
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.h$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImageView Ct;
        final /* synthetic */ AdInfo.CutRuleInfo Cu;
        final /* synthetic */ AdInfo rX;

        AnonymousClass3(ImageView imageView, AdInfo adInfo, AdInfo.CutRuleInfo cutRuleInfo) {
            imageView = imageView;
            adInfo = adInfo;
            bP = cutRuleInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int height = imageView.getHeight();
            int width = imageView.getWidth();
            double d2 = com.kwad.sdk.core.response.a.a.aM(adInfo).width;
            AdInfo.CutRuleInfo cutRuleInfo = bP;
            double d3 = cutRuleInfo.picHeight;
            double d4 = cutRuleInfo.viewTopMargin;
            double d5 = cutRuleInfo.safeAreaHeight;
            if (d3 <= 0.0d || d5 <= 0.0d) {
                return;
            }
            double d6 = width;
            Double.isNaN(d6);
            Double.isNaN(d2);
            double d7 = d6 / d2;
            Double.isNaN(d3);
            Double.isNaN(d5);
            Double.isNaN(d4);
            double d8 = d4 / (d3 - d5);
            Double.isNaN(d4);
            double d9 = d4 * d7;
            Double.isNaN(d3);
            double d10 = height;
            Double.isNaN(d10);
            double d11 = (d3 * d7) - d10;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.topMargin = (int) (((d11 / 2.0d) - (d9 - (d9 - (d8 * d11)))) * 2.0d);
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.b.h$4 */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ ImageView Ct;

        AnonymousClass4(ImageView imageView) {
            imageView = imageView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            float width = imageView.getWidth() / 1080.0f;
            float f2 = ((width * 880.0f) * 1152.0f) / 880.0f;
            float f3 = width * 2340.0f;
            float height = imageView.getHeight();
            float f4 = (f3 - height) / 2.0f;
            float f5 = f3 - f2;
            float f6 = (0.44107744f * f5) - f4;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.topMargin = (int) (((((f5 * 0.5589225f) - f4) - f6) / 2.0f) - (height * 0.03f));
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    private void a(ImageView imageView) {
        ((FrameLayout) this.Cg.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.4
            final /* synthetic */ ImageView Ct;

            AnonymousClass4(ImageView imageView2) {
                imageView = imageView2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                float width = imageView.getWidth() / 1080.0f;
                float f2 = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f3 = width * 2340.0f;
                float height = imageView.getHeight();
                float f4 = (f3 - height) / 2.0f;
                float f5 = f3 - f2;
                float f6 = (0.44107744f * f5) - f4;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((((f5 * 0.5589225f) - f4) - f6) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void a(ImageView imageView, AdInfo adInfo) {
        ((FrameLayout) this.Cg.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.3
            final /* synthetic */ ImageView Ct;
            final /* synthetic */ AdInfo.CutRuleInfo Cu;
            final /* synthetic */ AdInfo rX;

            AnonymousClass3(ImageView imageView2, AdInfo adInfo2, AdInfo.CutRuleInfo cutRuleInfo) {
                imageView = imageView2;
                adInfo = adInfo2;
                bP = cutRuleInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d2 = com.kwad.sdk.core.response.a.a.aM(adInfo).width;
                AdInfo.CutRuleInfo cutRuleInfo = bP;
                double d3 = cutRuleInfo.picHeight;
                double d4 = cutRuleInfo.viewTopMargin;
                double d5 = cutRuleInfo.safeAreaHeight;
                if (d3 <= 0.0d || d5 <= 0.0d) {
                    return;
                }
                double d6 = width;
                Double.isNaN(d6);
                Double.isNaN(d2);
                double d7 = d6 / d2;
                Double.isNaN(d3);
                Double.isNaN(d5);
                Double.isNaN(d4);
                double d8 = d4 / (d3 - d5);
                Double.isNaN(d4);
                double d9 = d4 * d7;
                Double.isNaN(d3);
                double d10 = height;
                Double.isNaN(d10);
                double d11 = (d3 * d7) - d10;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((d11 / 2.0d) - (d9 - (d9 - (d8 * d11)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    static /* synthetic */ boolean a(h hVar, boolean z) {
        hVar.Cm = true;
        return true;
    }

    public void kv() {
        if (this.Co && this.Cm && !this.Cn) {
            this.Cn = true;
            this.Cg.kv();
        }
    }

    private void l(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener anonymousClass2;
        if (i2 == 0) {
            this.Cj.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Cj.setVisibility(0);
            imageView = this.Cj;
            adTemplate = this.Cg.mAdTemplate;
            anonymousClass2 = new AnonymousClass1();
        } else {
            this.Ck.setVisibility(0);
            if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.a.a.BS)) {
                a(this.Ck, this.mAdInfo);
            } else {
                a(this.Ck);
            }
            imageView = this.Ck;
            adTemplate = this.Cg.mAdTemplate;
            anonymousClass2 = new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.b.h.2
                AnonymousClass2() {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    h.a(h.this, true);
                    h.this.kv();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    if (h.this.Cl) {
                        return;
                    }
                    h.this.Cg.f(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }
            };
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, anonymousClass2);
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Ck = (ImageView) this.Cg.mRootContainer.findViewById(R.id.ksad_splash_background);
        this.Cj = (ImageView) this.Cg.mRootContainer.findViewById(R.id.ksad_splash_foreground);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.Cg.mAdTemplate);
        this.mAdInfo = cb;
        String str = com.kwad.sdk.core.response.a.a.aM(cb).materialUrl;
        this.Ck.setVisibility(0);
        int i2 = com.kwad.sdk.core.response.a.a.aM(this.mAdInfo).source;
        if (getContext() != null) {
            SplashPreloadManager.rV();
            File aW = SplashPreloadManager.aW(this.mAdInfo.adPreloadInfo.preloadId);
            if (aW != null && aW.exists() && aW.length() > 0) {
                str = Uri.fromFile(aW).toString();
            }
            l(str, i2);
        }
        com.kwad.sdk.core.g.a aVar = this.Cg.BH;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.Cl = true;
        this.Cm = false;
        this.Cn = false;
        this.Co = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageInvisible() {
    }

    @Override // com.kwad.sdk.core.g.c
    public final void onPageVisible() {
        this.Co = true;
        if (!this.Ci) {
            this.Ci = true;
            com.kwad.components.ad.splashscreen.local.c.R(getContext());
            com.kwad.components.core.r.b.pK().a(this.Cg.mAdTemplate, null, null);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "adShowSuccess").report();
        }
        kv();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.g.a aVar = this.Cg.BH;
        if (aVar != null) {
            aVar.b(this);
        }
    }
}
