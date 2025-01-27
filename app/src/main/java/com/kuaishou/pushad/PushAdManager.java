package com.kuaishou.pushad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kuaishou.pushad.PushAdView;
import com.kwad.components.core.g.a;
import com.kwad.components.core.g.c;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.util.List;

/* loaded from: classes.dex */
public class PushAdManager implements PushAdView.PushAdListener, Runnable {
    private static final int MSG_WHAT_AD_EXIT = 1000001;
    private static final int MSG_WHAT_PAGE_OUT = 1000002;
    private static final String TAG = "PushAdManager";
    private static Handler mInnerHandler = new Handler(Looper.getMainLooper());
    private static volatile boolean processingPush;
    private AdTemplate mHostAd;
    private AdTemplate mPushAd;

    @Nullable
    private PushAdView mPushAdView;
    private long showPushAdDelayTime;
    private boolean postBuffered = false;
    private boolean hadPostPushAd = false;

    /* renamed from: com.kuaishou.pushad.PushAdManager$1 */
    class AnonymousClass1 implements a.InterfaceC0176a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.g.a.InterfaceC0176a
        public void onError(int i2, String str) {
            b.d(PushAdManager.TAG, "onError: " + str);
            boolean unused = PushAdManager.processingPush = false;
        }

        @Override // com.kwad.components.core.g.a.InterfaceC0176a
        public void onInnerAdLoad(@Nullable List<c> list) {
            b.d(PushAdManager.TAG, "onInnerAdLoad: " + list);
            if (list == null || list.size() <= 0) {
                boolean unused = PushAdManager.processingPush = false;
                return;
            }
            PushAdManager.this.mPushAd = list.get(0).getAdTemplate();
            if (com.kwad.sdk.core.response.a.a.cx(d.cb(PushAdManager.this.mPushAd))) {
                b.d(PushAdManager.TAG, "loadPushTK");
                PushAdManager.this.loadPushTK();
            } else {
                boolean unused2 = PushAdManager.processingPush = false;
                b.d(PushAdManager.TAG, "pushAdInfo templateId invalid");
            }
        }

        @Override // com.kwad.components.core.g.a.InterfaceC0176a
        public void onRequestResult(int i2) {
        }
    }

    /* renamed from: com.kuaishou.pushad.PushAdManager$2 */
    class AnonymousClass2 extends com.kwad.sdk.core.b.d {
        final /* synthetic */ Activity val$currentActivity;

        AnonymousClass2(Activity activity) {
            currentActivity = activity;
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public void onActivityDestroyed(Activity activity) {
            super.onActivityDestroyed(activity);
            if (activity.equals(currentActivity)) {
                PushAdManager.this.mPushAdView.destroy();
            }
        }
    }

    public PushAdManager(@NonNull AdTemplate adTemplate) {
        this.mHostAd = adTemplate;
        this.showPushAdDelayTime = com.kwad.sdk.core.response.a.a.cz(d.cb(adTemplate));
        b.d(TAG, "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + this.showPushAdDelayTime);
    }

    public void loadPushTK() {
        Context context = ServiceProvider.getContext();
        if (context == null) {
            processingPush = false;
            return;
        }
        PushAdView pushAdView = new PushAdView(context);
        this.mPushAdView = pushAdView;
        pushAdView.bindView(this.mPushAd);
        this.mPushAdView.setListener(this);
    }

    @MainThread
    private void performShow() {
        PushAdView pushAdView;
        processingPush = false;
        com.kwad.sdk.core.b.b.vS();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing() || this.hadPostPushAd || (pushAdView = this.mPushAdView) == null || !pushAdView.isTKLoadSuccess()) {
            return;
        }
        this.hadPostPushAd = true;
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kuaishou.pushad.PushAdManager.2
            final /* synthetic */ Activity val$currentActivity;

            AnonymousClass2(Activity currentActivity2) {
                currentActivity = currentActivity2;
            }

            @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
            public void onActivityDestroyed(Activity activity) {
                super.onActivityDestroyed(activity);
                if (activity.equals(currentActivity)) {
                    PushAdManager.this.mPushAdView.destroy();
                }
            }
        });
        PushAdViewHelper.appendPushAd(currentActivity2, this.mPushAdView);
        this.mPushAdView.onShow();
    }

    private static void sendMessageDelay(int i2, Runnable runnable, long j2) {
        Message obtain = Message.obtain(mInnerHandler, runnable);
        obtain.what = i2;
        mInnerHandler.sendMessageDelayed(obtain, j2);
    }

    public void onAdExit(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.mHostAd)) {
            b.d(TAG, "onAdExit not current ad");
            return;
        }
        b.d(TAG, "onAdExit showPushAdDelayTime: " + this.showPushAdDelayTime + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.ao()) {
            sendMessageDelay(MSG_WHAT_AD_EXIT, this, this.showPushAdDelayTime);
        }
    }

    public void onOutSDKPage() {
        b.d(TAG, "onOutSDKPage: ");
        if (mInnerHandler.hasMessages(MSG_WHAT_AD_EXIT)) {
            return;
        }
        b.d(TAG, "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        sendMessageDelay(MSG_WHAT_PAGE_OUT, this, 500L);
    }

    @Override // com.kuaishou.pushad.PushAdView.PushAdListener
    public void onPushAdViewClose() {
        b.d(TAG, "onAdClose: ");
        PushAdViewHelper.removePushAd(null);
        PushAdView pushAdView = this.mPushAdView;
        if (pushAdView != null) {
            pushAdView.destroy();
        }
        KsAdGlobalWatcher.getInstance().removePushAdManager(this);
    }

    @Override // com.kuaishou.pushad.PushAdView.PushAdListener
    public void onPushAdViewShow() {
        y.ag(System.currentTimeMillis());
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean preShowPushCheck = KsAdGlobalWatcher.getInstance().preShowPushCheck();
        b.d(TAG, "run preCheckResult: " + preShowPushCheck);
        if (preShowPushCheck) {
            performShow();
        } else {
            b.d(TAG, "run postBuffered set true");
            this.postBuffered = true;
        }
    }

    public void startRequestPushAd(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate;
        b.w(TAG, "startRequestPushAd processingPush: " + processingPush);
        if (processingPush || (adTemplate = aVar.getAdTemplate()) == null || adTemplate.mAdScene == null) {
            return;
        }
        processingPush = true;
        a.b(adTemplate.mAdScene, new a.InterfaceC0176a() { // from class: com.kuaishou.pushad.PushAdManager.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0176a
            public void onError(int i2, String str) {
                b.d(PushAdManager.TAG, "onError: " + str);
                boolean unused = PushAdManager.processingPush = false;
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0176a
            public void onInnerAdLoad(@Nullable List<c> list) {
                b.d(PushAdManager.TAG, "onInnerAdLoad: " + list);
                if (list == null || list.size() <= 0) {
                    boolean unused = PushAdManager.processingPush = false;
                    return;
                }
                PushAdManager.this.mPushAd = list.get(0).getAdTemplate();
                if (com.kwad.sdk.core.response.a.a.cx(d.cb(PushAdManager.this.mPushAd))) {
                    b.d(PushAdManager.TAG, "loadPushTK");
                    PushAdManager.this.loadPushTK();
                } else {
                    boolean unused2 = PushAdManager.processingPush = false;
                    b.d(PushAdManager.TAG, "pushAdInfo templateId invalid");
                }
            }

            @Override // com.kwad.components.core.g.a.InterfaceC0176a
            public void onRequestResult(int i2) {
            }
        });
    }
}
