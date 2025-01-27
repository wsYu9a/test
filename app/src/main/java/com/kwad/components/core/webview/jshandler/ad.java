package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ad implements com.kwad.sdk.core.webview.b.a {
    private final Handler Sw;

    @Nullable
    private final b Tu;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    /* renamed from: com.kwad.components.core.webview.jshandler.ad$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ a Tv;
        final /* synthetic */ AdTemplate Tw;
        final /* synthetic */ com.kwad.components.core.d.b.c Tx;

        /* renamed from: com.kwad.components.core.webview.jshandler.ad$1$1 */
        final class C01911 implements a.b {
            C01911() {
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
            }
        }

        AnonymousClass1(a aVar, AdTemplate adTemplate, com.kwad.components.core.d.b.c cVar) {
            aVar = aVar;
            adTemplate = adTemplate;
            cVar2 = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            y.b bVar = new y.b();
            bVar.Ts = aVar.TD.Ts;
            com.kwad.components.core.d.b.a.a(new a.C0172a(ad.this.mBridgeContext.LD.getContext()).I(adTemplate).b(cVar2).ap(aVar.TC).ao(true).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ad.1.1
                C01911() {
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ad$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public boolean TA;
        public String TB;
        public int TC;
        public com.kwad.sdk.core.webview.c.a.c TD;
    }

    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.d.b.c cVar2;
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.TB));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (com.kwad.sdk.core.response.a.d.bT(adTemplate)) {
            if (this.mBridgeContext.apq != null) {
                cVar2 = (com.kwad.components.core.d.b.c) this.mBridgeContext.apq.eE(com.kwad.sdk.core.response.a.d.cb(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.mBridgeContext.apr) {
                this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ad.1
                    final /* synthetic */ a Tv;
                    final /* synthetic */ AdTemplate Tw;
                    final /* synthetic */ com.kwad.components.core.d.b.c Tx;

                    /* renamed from: com.kwad.components.core.webview.jshandler.ad$1$1 */
                    final class C01911 implements a.b {
                        C01911() {
                        }

                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                        }
                    }

                    AnonymousClass1(a aVar2, AdTemplate adTemplate2, com.kwad.components.core.d.b.c cVar22) {
                        aVar = aVar2;
                        adTemplate = adTemplate2;
                        cVar2 = cVar22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        y.b bVar = new y.b();
                        bVar.Ts = aVar.TD.Ts;
                        com.kwad.components.core.d.b.a.a(new a.C0172a(ad.this.mBridgeContext.LD.getContext()).I(adTemplate).b(cVar2).ap(aVar.TC).ao(true).a(bVar).aq(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.ad.1.1
                            C01911() {
                            }

                            @Override // com.kwad.components.core.d.b.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.Tu != null) {
                this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ad.2
                    AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }
            cVar.a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sw.removeCallbacksAndMessages(null);
    }
}
