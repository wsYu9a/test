package com.kwad.components.ad.splashscreen.presenter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.presenter.playcard.SplashPlayDefaultInfoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class h extends e {
    private ImageView EL;
    private ImageView EM;
    private View EP;
    private ViewGroup EQ;
    private SplashPlayDefaultInfoView ER;
    private AdInfo mAdInfo;
    private boolean EN = false;
    private boolean EO = false;
    Runnable ES = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.5
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.ai(h.this.EJ.mAdTemplate);
            h.this.ly();
        }
    };

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$1 */
    public class AnonymousClass1 implements ImageLoadingListener {

        /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$1$1 */
        public class RunnableC04091 implements Runnable {
            final /* synthetic */ DecodedResult lt;

            /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$1$1$1 */
            public class C04101 extends bd {
                final /* synthetic */ Bitmap EV;

                public C04101(Bitmap bitmap) {
                    stackBlur = bitmap;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    h.this.EM.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                }
            }

            public RunnableC04091(DecodedResult decodedResult) {
                decodedResult = decodedResult;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h.this.EM.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1.1
                    final /* synthetic */ Bitmap EV;

                    public C04101(Bitmap bitmap) {
                        stackBlur = bitmap;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        h.this.EM.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                    }
                });
            }
        }

        public AnonymousClass1() {
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
            h.this.lz();
            h.this.EM.setVisibility(0);
            GlobalThreadPools.Hk().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1
                final /* synthetic */ DecodedResult lt;

                /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$1$1$1 */
                public class C04101 extends bd {
                    final /* synthetic */ Bitmap EV;

                    public C04101(Bitmap bitmap) {
                        stackBlur = bitmap;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        h.this.EM.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                    }
                }

                public RunnableC04091(DecodedResult decodedResult2) {
                    decodedResult = decodedResult2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    h.this.EM.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1.1
                        final /* synthetic */ Bitmap EV;

                        public C04101(Bitmap bitmap) {
                            stackBlur = bitmap;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            h.this.EM.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), stackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            h.this.ly();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$2 */
    public class AnonymousClass2 implements ImageLoadingListener {
        public AnonymousClass2() {
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
            h.this.lz();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            h.this.ly();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ ImageView EX;
        final /* synthetic */ AdInfo.CutRuleInfo EY;
        final /* synthetic */ AdInfo tK;

        public AnonymousClass3(ImageView imageView, AdInfo adInfo, AdInfo.CutRuleInfo cutRuleInfo) {
            imageView = imageView;
            adInfo = adInfo;
            cr = cutRuleInfo;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            int height = imageView.getHeight();
            int width = imageView.getWidth();
            double d10 = com.kwad.sdk.core.response.b.a.aU(adInfo).width;
            AdInfo.CutRuleInfo cutRuleInfo = cr;
            double d11 = cutRuleInfo.picHeight;
            double d12 = cutRuleInfo.viewTopMargin;
            double d13 = cutRuleInfo.safeAreaHeight;
            if (d11 <= l5.c.f27899e || d13 <= l5.c.f27899e) {
                return;
            }
            double d14 = width / d10;
            double d15 = d12 / (d11 - d13);
            double d16 = d12 * d14;
            double d17 = (d11 * d14) - height;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.topMargin = (int) (((d17 / 2.0d) - (d16 - (d16 - (d15 * d17)))) * 2.0d);
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$4 */
    public class AnonymousClass4 extends bd {
        final /* synthetic */ ImageView EX;

        public AnonymousClass4(ImageView imageView) {
            imageView = imageView;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            float width = imageView.getWidth() / 1080.0f;
            float f10 = ((width * 880.0f) * 1152.0f) / 880.0f;
            float f11 = width * 2340.0f;
            float height = imageView.getHeight();
            float f12 = (f11 - height) / 2.0f;
            float f13 = f11 - f10;
            float f14 = (0.44107744f * f13) - f12;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
            marginLayoutParams.topMargin = (int) (((((f13 * 0.5589225f) - f12) - f14) / 2.0f) - (height * 0.03f));
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.ai(h.this.EJ.mAdTemplate);
            h.this.ly();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.presenter.h$6 */
    public class AnonymousClass6 implements Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.this.EQ.setVisibility(0);
            h.this.ER.a(h.this.EJ.mAdTemplate, com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.EP.getHeight()) / 414.0f);
        }
    }

    private void l(String str, int i10) {
        if (i10 == 0) {
            this.EL.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.EL.setVisibility(0);
            KSImageLoader.loadImage(this.EL, str, this.EJ.mAdTemplate, new AnonymousClass1());
        } else {
            this.EM.setVisibility(0);
            if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Es)) {
                a(this.EM, this.mAdInfo);
            } else {
                a(this.EM);
            }
            KSImageLoader.loadImage(this.EM, str, this.EJ.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.h.2
                public AnonymousClass2() {
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
                    h.this.lz();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    h.this.ly();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }
            });
        }
    }

    private void lx() {
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Et)) {
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.ag(this.EJ.mAdTemplate);
            bt.runOnUiThreadDelay(this.ES, com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Eu));
        }
    }

    public void ly() {
        if (this.EN) {
            return;
        }
        this.EN = true;
        this.EP.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.6
            public AnonymousClass6() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                h.this.EQ.setVisibility(0);
                h.this.ER.a(h.this.EJ.mAdTemplate, com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.EP.getHeight()) / 414.0f);
            }
        });
        this.EL.setVisibility(8);
        this.EM.setVisibility(8);
    }

    public void lz() {
        if (this.EO) {
            return;
        }
        this.EO = true;
        if (com.kwad.sdk.core.config.d.a(com.kwad.components.ad.splashscreen.b.a.Et)) {
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.ah(this.EJ.mAdTemplate);
            bt.c(this.ES);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.EP = findViewById(R.id.ksad_splash_root_container);
        this.EM = (ImageView) findViewById(R.id.ksad_splash_background);
        this.EL = (ImageView) findViewById(R.id.ksad_splash_foreground);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.EJ.mAdTemplate);
        this.EQ = (ViewGroup) findViewById(R.id.ksad_splash_default_image_view_container);
        this.ER = (SplashPlayDefaultInfoView) findViewById(R.id.ksad_splash_default_image_view);
        String str = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl;
        this.EM.setVisibility(0);
        int i10 = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).source;
        lx();
        if (getContext() != null) {
            SplashPreloadManager.kQ();
            File W = SplashPreloadManager.W(this.mAdInfo.adPreloadInfo.preloadId);
            if (W != null && W.exists() && W.length() > 0) {
                str = Uri.fromFile(W).toString();
            }
            l(str, i10);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        lz();
    }

    private void a(ImageView imageView, AdInfo adInfo) {
        ((FrameLayout) this.EJ.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.h.3
            final /* synthetic */ ImageView EX;
            final /* synthetic */ AdInfo.CutRuleInfo EY;
            final /* synthetic */ AdInfo tK;

            public AnonymousClass3(ImageView imageView2, AdInfo adInfo2, AdInfo.CutRuleInfo cutRuleInfo) {
                imageView = imageView2;
                adInfo = adInfo2;
                cr = cutRuleInfo;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d10 = com.kwad.sdk.core.response.b.a.aU(adInfo).width;
                AdInfo.CutRuleInfo cutRuleInfo = cr;
                double d11 = cutRuleInfo.picHeight;
                double d12 = cutRuleInfo.viewTopMargin;
                double d13 = cutRuleInfo.safeAreaHeight;
                if (d11 <= l5.c.f27899e || d13 <= l5.c.f27899e) {
                    return;
                }
                double d14 = width / d10;
                double d15 = d12 / (d11 - d13);
                double d16 = d12 * d14;
                double d17 = (d11 * d14) - height;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((d17 / 2.0d) - (d16 - (d16 - (d15 * d17)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void a(ImageView imageView) {
        ((FrameLayout) this.EJ.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new bd() { // from class: com.kwad.components.ad.splashscreen.presenter.h.4
            final /* synthetic */ ImageView EX;

            public AnonymousClass4(ImageView imageView2) {
                imageView = imageView2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                float width = imageView.getWidth() / 1080.0f;
                float f10 = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f11 = width * 2340.0f;
                float height = imageView.getHeight();
                float f12 = (f11 - height) / 2.0f;
                float f13 = f11 - f10;
                float f14 = (0.44107744f * f13) - f12;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((((f13 * 0.5589225f) - f12) - f14) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }
}
