package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class am implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b YR;
    private final Handler Zm;

    @Nullable
    private final b aah;

    /* renamed from: com.kwad.components.core.webview.jshandler.am$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ AdTemplate aai;
        final /* synthetic */ com.kwad.components.core.e.d.c aaj;
        final /* synthetic */ a aak;

        /* renamed from: com.kwad.components.core.webview.jshandler.am$1$1 */
        public class C04531 implements a.b {
            public C04531() {
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
            }
        }

        public AnonymousClass1(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, a aVar) {
            adTemplate = adTemplate;
            cVar2 = cVar;
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.core.e.d.a.a(new a.C0427a(am.this.YR.QI.getContext()).au(adTemplate).b(cVar2).ao(aVar.aap).ap(true).ai(aVar.aaq.MI).ar(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.am.1.1
                public C04531() {
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                }
            }));
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.am$2 */
    public class AnonymousClass2 extends com.kwad.sdk.utils.bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public boolean aan;
        public String aao;
        public int aap;
        public com.kwad.sdk.core.webview.d.b.d aaq;
    }

    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Zm.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.e.d.c cVar2;
        a aVar = new a();
        AdTemplate adTemplate = new AdTemplate();
        try {
            aVar.parseJson(new JSONObject(str));
            adTemplate.parseJson(new JSONObject(aVar.aao));
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
        if (com.kwad.sdk.core.response.b.e.dT(adTemplate)) {
            if (this.YR.aId != null) {
                cVar2 = (com.kwad.components.core.e.d.c) this.YR.aId.gO(com.kwad.sdk.core.response.b.e.eb(adTemplate).downloadId);
            } else {
                cVar2 = null;
            }
            if (this.YR.aIe) {
                this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.am.1
                    final /* synthetic */ AdTemplate aai;
                    final /* synthetic */ com.kwad.components.core.e.d.c aaj;
                    final /* synthetic */ a aak;

                    /* renamed from: com.kwad.components.core.webview.jshandler.am$1$1 */
                    public class C04531 implements a.b {
                        public C04531() {
                        }

                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                        }
                    }

                    public AnonymousClass1(AdTemplate adTemplate2, com.kwad.components.core.e.d.c cVar22, a aVar2) {
                        adTemplate = adTemplate2;
                        cVar2 = cVar22;
                        aVar = aVar2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.components.core.e.d.a.a(new a.C0427a(am.this.YR.QI.getContext()).au(adTemplate).b(cVar2).ao(aVar.aap).ap(true).ai(aVar.aaq.MI).ar(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.am.1.1
                            public C04531() {
                            }

                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                            }
                        }));
                    }
                });
            } else if (this.aah != null) {
                this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.am.2
                    public AnonymousClass2() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                    }
                });
            }
            cVar.a(null);
        }
    }
}
