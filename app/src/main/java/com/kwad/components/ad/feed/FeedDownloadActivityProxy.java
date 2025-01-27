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
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.KsAdContainer;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import org.json.JSONObject;

@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
/* loaded from: classes.dex */
public class FeedDownloadActivityProxy extends com.kwad.components.core.l.d implements View.OnClickListener {
    private static final boolean DEBUG = false;
    public static final String KEY_AD_DATA = "key_template_json";
    private static final String TAG = "FeedDownloadActivity";
    private static b.a sInnerAdInteractionListener;
    private KsAdContainer mAdContainer;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private TailFrameBarAppPortraitVertical mAppTailFrameView;
    private TextProgressBar mProgressBarTv;

    /* renamed from: com.kwad.components.ad.feed.FeedDownloadActivityProxy$1 */
    final class AnonymousClass1 extends com.kwad.sdk.core.download.kwai.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aw(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aH(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aw(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.T(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i2) {
            FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.bz(i2), i2);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i2) {
            FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
            FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.by(i2), i2);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.FeedDownloadActivityProxy$2 */
    final class AnonymousClass2 implements a.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            FeedDownloadActivityProxy.this.notifyAdClick();
        }
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aw(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aH(FeedDownloadActivityProxy.this.mAdTemplate), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.aw(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.T(FeedDownloadActivityProxy.this.mAdInfo), FeedDownloadActivityProxy.this.mProgressBarTv.getMax());
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i2) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.bz(i2), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                FeedDownloadActivityProxy.this.mAppTailFrameView.x(FeedDownloadActivityProxy.this.mAdInfo);
                FeedDownloadActivityProxy.this.mProgressBarTv.f(com.kwad.sdk.core.response.a.a.by(i2), i2);
            }
        });
    }

    public static void launch(Context context, @NonNull AdTemplate adTemplate, b.a aVar) {
        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
        Intent intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        sInnerAdInteractionListener = aVar;
        context.startActivity(intent);
    }

    public void notifyAdClick() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new i().c(this.mAdContainer.getTouchCoords()), (JSONObject) null);
        b.a aVar = sInnerAdInteractionListener;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.a.a(FeedDownloadActivity.class, FeedDownloadActivityProxy.class);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(@Nullable Intent intent) {
        try {
            String stringExtra = getIntent().getStringExtra("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            adTemplate.parseJson(new JSONObject(stringExtra));
            this.mAdTemplate = adTemplate;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
        return this.mAdTemplate != null;
    }

    public void destroy() {
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = this.mAppTailFrameView;
        if (tailFrameBarAppPortraitVertical != null) {
            tailFrameBarAppPortraitVertical.ki();
            this.mAppTailFrameView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_activity_feed_download;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "FeedDownloadActivityProxy";
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        KsAdContainer ksAdContainer = (KsAdContainer) findViewById(R.id.ksad_container);
        this.mAdContainer = ksAdContainer;
        ksAdContainer.setOnClickListener(this);
        TailFrameBarAppPortraitVertical tailFrameBarAppPortraitVertical = (TailFrameBarAppPortraitVertical) findViewById(R.id.ksad_download_container);
        this.mAppTailFrameView = tailFrameBarAppPortraitVertical;
        tailFrameBarAppPortraitVertical.bindView(this.mAdTemplate);
        this.mAppTailFrameView.x(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate));
        this.mAppTailFrameView.setVisibility(0);
        TextProgressBar textProgressBar = this.mAppTailFrameView.getTextProgressBar();
        this.mProgressBarTv = textProgressBar;
        textProgressBar.setOnClickListener(this);
        bindDownloadListener();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.d.b.a.a(new a.C0172a(view.getContext()).I(this.mAdTemplate).b(this.mApkDownloadHelper).ap(view == this.mProgressBarTv ? 1 : 2).ao(view == this.mProgressBarTv).a(new a.b() { // from class: com.kwad.components.ad.feed.FeedDownloadActivityProxy.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                FeedDownloadActivityProxy.this.notifyAdClick();
            }
        }));
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        super.onDestroy();
        destroy();
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }
}
