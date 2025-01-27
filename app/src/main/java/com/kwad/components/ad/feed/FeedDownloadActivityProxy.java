package com.kwad.components.ad.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.widget.tailframe.appbar.TailFrameBarAppPortraitVertical;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes2.dex */
public class FeedDownloadActivityProxy extends com.kwad.components.core.proxy.f implements View.OnClickListener {
    private static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    private static final String TAG = "FeedDownloadActivity";
    private static b.a sInnerAdInteractionListener;
    private KsAdContainer mAdContainer;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private TailFrameBarAppPortraitVertical mAppTailFrameView;
    private TextProgressBar mProgressBarTv;

    /* renamed from: com.kwad.components.ad.feed.FeedDownloadActivityProxy$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.download.a.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.cg(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.ac(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i10) {
            FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i10) {
            FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.FeedDownloadActivityProxy$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            try {
                FeedDownloadActivityProxy.this.notifyAdClick();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.cg(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.aE(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.ac(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i10) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.dp(i10), i10);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i10) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.D(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.e(com.kwad.sdk.core.response.b.a.m36do(i10), i10);
            }
        });
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, b.a aVar) {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = aVar;
        context.startActivity(intent);
    }

    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(this.mAdContainer.getTouchCoords()), (JSONObject) null);
        b.a aVar = sInnerAdInteractionListener;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.b.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
        return this.mAdTemplate != null;
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.kH();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_activity_feed_download;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        KsAdContainer ksAdContainer = (KsAdContainer) findViewById(R.id.ksad_container);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_download_container);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.f(this.mAdTemplate);
        this.mAppTailFrameView.D(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(view.getContext()).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(view == this.mProgressBarTv ? 1 : 2).ap(view == this.mProgressBarTv).a(new a.b() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    FeedDownloadActivityProxy.this.notifyAdClick();
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        }));
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }
}
