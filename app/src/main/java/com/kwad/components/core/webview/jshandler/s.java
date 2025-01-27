package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.internal.api.SceneImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class s implements com.kwad.sdk.core.webview.b.a {
    private boolean SA;
    private Handler Sw;
    private boolean dontShowDialog;

    @Nullable
    private final com.kwad.components.core.d.b.c mApkDownloadHelper;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener;

    /* renamed from: com.kwad.components.core.webview.jshandler.s$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

        /* renamed from: com.kwad.components.core.webview.jshandler.s$1$1 */
        final class C01931 implements a.b {
            C01931() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                if (s.this.mWebCardClickListener != null) {
                    s.this.mWebCardClickListener.onAdClicked(aVar);
                }
            }
        }

        AnonymousClass1(com.kwad.sdk.core.webview.c.a.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (s.this.mBridgeContext.aps || aVar.TA) {
                SceneImpl sceneImpl = s.this.mBridgeContext.getAdTemplate().mAdScene;
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(sceneImpl != null ? KSLoggerReporter.bv(sceneImpl.getAdStyle()) : null, "adClick").b("isWebCard", Boolean.TRUE).report();
                com.kwad.components.core.d.b.a.a(s.this.mBridgeContext.LD.getContext(), s.this.mBridgeContext.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.s.1.1
                    C01931() {
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        if (s.this.mWebCardClickListener != null) {
                            s.this.mWebCardClickListener.onAdClicked(aVar);
                        }
                    }
                }, s.this.mApkDownloadHelper, aVar.TA, s.this.dontShowDialog, s.this.SA);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.s$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

        AnonymousClass2(com.kwad.sdk.core.webview.c.a.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (s.this.mWebCardClickListener != null) {
                s.this.mWebCardClickListener.onAdClicked(aVar);
            }
        }
    }

    public s(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, cVar, aVar, false, false);
    }

    public s(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, boolean z, boolean z2) {
        this.dontShowDialog = false;
        this.SA = false;
        this.dontShowDialog = z;
        this.Sw = new Handler(Looper.getMainLooper());
        this.mBridgeContext = bVar;
        this.mApkDownloadHelper = cVar;
        this.SA = z2;
        if (cVar != null) {
            cVar.as(1);
        }
        this.mWebCardClickListener = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        Handler handler;
        Runnable anonymousClass2;
        if (this.mBridgeContext.yU()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
            aVar.II = true;
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (!this.mBridgeContext.apr) {
            if (this.mWebCardClickListener != null) {
                handler = this.Sw;
                anonymousClass2 = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.s.2
                    final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

                    AnonymousClass2(com.kwad.sdk.core.webview.c.a.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (s.this.mWebCardClickListener != null) {
                            s.this.mWebCardClickListener.onAdClicked(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.Sw;
        anonymousClass2 = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.s.1
            final /* synthetic */ com.kwad.sdk.core.webview.c.a.a St;

            /* renamed from: com.kwad.components.core.webview.jshandler.s$1$1 */
            final class C01931 implements a.b {
                C01931() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (s.this.mWebCardClickListener != null) {
                        s.this.mWebCardClickListener.onAdClicked(aVar);
                    }
                }
            }

            AnonymousClass1(com.kwad.sdk.core.webview.c.a.a aVar2) {
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (s.this.mBridgeContext.aps || aVar.TA) {
                    SceneImpl sceneImpl = s.this.mBridgeContext.getAdTemplate().mAdScene;
                    KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(sceneImpl != null ? KSLoggerReporter.bv(sceneImpl.getAdStyle()) : null, "adClick").b("isWebCard", Boolean.TRUE).report();
                    com.kwad.components.core.d.b.a.a(s.this.mBridgeContext.LD.getContext(), s.this.mBridgeContext.getAdTemplate(), new a.b() { // from class: com.kwad.components.core.webview.jshandler.s.1.1
                        C01931() {
                        }

                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            if (s.this.mWebCardClickListener != null) {
                                s.this.mWebCardClickListener.onAdClicked(aVar);
                            }
                        }
                    }, s.this.mApkDownloadHelper, aVar.TA, s.this.dontShowDialog, s.this.SA);
                }
            }
        };
        handler.post(anonymousClass2);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sw.removeCallbacksAndMessages(null);
        this.mWebCardClickListener = null;
    }
}
