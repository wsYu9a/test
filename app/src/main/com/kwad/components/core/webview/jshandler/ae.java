package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ae implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b YR;
    private final boolean Zx = false;
    private com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> jT;

    /* renamed from: com.kwad.components.core.webview.jshandler.ae$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> {
        final /* synthetic */ ImpInfo Du;

        public AnonymousClass1(ImpInfo impInfo) {
            impInfo = impInfo;
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        /* renamed from: ab */
        public AdResultData parseData(String str) {
            JSONObject jSONObject = new JSONObject(str);
            AdResultData adResultData = new AdResultData(impInfo.adScene);
            adResultData.parseJson(jSONObject);
            return adResultData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: nD */
        public com.kwad.components.core.request.a createRequest() {
            return new com.kwad.components.core.request.a(impInfo);
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ae$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData> {
        final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

        /* renamed from: com.kwad.components.core.webview.jshandler.ae$2$1 */
        public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
            final /* synthetic */ AdResultData jX;

            public AnonymousClass1(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                cVar.a(adResultData);
            }
        }

        /* renamed from: com.kwad.components.core.webview.jshandler.ae$2$2 */
        public class C04512 extends com.kwad.sdk.utils.bd {
            final /* synthetic */ AdResultData jX;

            public C04512(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                cVar.a(adResultData);
            }
        }

        public AnonymousClass2(com.kwad.sdk.core.webview.c.c cVar) {
            cVar = cVar;
        }

        private void e(@NonNull AdResultData adResultData) {
            if (!adResultData.isAdResultDataEmpty()) {
                bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ae.2.2
                    final /* synthetic */ AdResultData jX;

                    public C04512(AdResultData adResultData2) {
                        adResultData = adResultData2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        cVar.a(adResultData);
                    }
                });
                return;
            }
            StringBuilder sb2 = new StringBuilder("onError:");
            sb2.append(String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.e.azA.errorCode), TextUtils.isEmpty(adResultData2.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData2.testErrorMsg));
            com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", sb2.toString());
            bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ae.2.1
                final /* synthetic */ AdResultData jX;

                public AnonymousClass1(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    cVar.a(adResultData);
                }
            });
        }

        private void i(int i10, String str) {
            com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i10 + " msg: " + str);
            ae.this.a(cVar);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i10, String str) {
            i(i10, str);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            e((AdResultData) baseResultData);
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ae$3 */
    public class AnonymousClass3 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

        public AnonymousClass3(com.kwad.sdk.core.webview.c.c cVar) {
            cVar = cVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            AdResultData adResultData = new AdResultData();
            adResultData.setAdTemplateList(new ArrayList());
            cVar.a(adResultData);
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        AdResultData mAdResultData;

        public a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    jSONArray.put(adTemplate.toJson());
                } else {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e10) {
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                        jSONArray.put(adTemplate.toJson());
                    }
                }
            }
            com.kwad.sdk.utils.x.putValue(json, "impAdInfo", jSONArray);
            return json;
        }
    }

    public ae(com.kwad.sdk.core.webview.b bVar) {
        this.YR = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.jT;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (!this.Zx) {
            if (this.YR.IC()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            } else {
                cVar.a(new a(this.YR.hF()));
                return;
            }
        }
        AdTemplate adTemplate = this.YR.getAdTemplate();
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        if (adTemplate.mAdScene != null) {
            impInfo.pageScene = r1.getPageScene();
        }
        impInfo.subPageScene = 106L;
        impInfo.adScene.setAdNum(12);
        impInfo.sdkExtraData = com.kwad.sdk.core.response.b.e.ek(adTemplate);
        a(impInfo, cVar);
    }

    private void a(ImpInfo impInfo, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.jT;
        if (lVar != null) {
            lVar.cancel();
        }
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ae.1
            final /* synthetic */ ImpInfo Du;

            public AnonymousClass1(ImpInfo impInfo2) {
                impInfo = impInfo2;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: ab */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: nD */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }
        };
        this.jT = anonymousClass1;
        anonymousClass1.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ae.2
            final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

            /* renamed from: com.kwad.components.core.webview.jshandler.ae$2$1 */
            public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
                final /* synthetic */ AdResultData jX;

                public AnonymousClass1(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    cVar.a(adResultData);
                }
            }

            /* renamed from: com.kwad.components.core.webview.jshandler.ae$2$2 */
            public class C04512 extends com.kwad.sdk.utils.bd {
                final /* synthetic */ AdResultData jX;

                public C04512(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    cVar.a(adResultData);
                }
            }

            public AnonymousClass2(com.kwad.sdk.core.webview.c.c cVar2) {
                cVar = cVar2;
            }

            private void e(@NonNull AdResultData adResultData2) {
                if (!adResultData2.isAdResultDataEmpty()) {
                    bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ae.2.2
                        final /* synthetic */ AdResultData jX;

                        public C04512(AdResultData adResultData22) {
                            adResultData = adResultData22;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            cVar.a(adResultData);
                        }
                    });
                    return;
                }
                StringBuilder sb2 = new StringBuilder("onError:");
                sb2.append(String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.e.azA.errorCode), TextUtils.isEmpty(adResultData22.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData22.testErrorMsg));
                com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", sb2.toString());
                bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ae.2.1
                    final /* synthetic */ AdResultData jX;

                    public AnonymousClass1(AdResultData adResultData22) {
                        adResultData = adResultData22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        cVar.a(adResultData);
                    }
                });
            }

            private void i(int i10, String str) {
                com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i10 + " msg: " + str);
                ae.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i10, String str) {
                i(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                e((AdResultData) baseResultData);
            }
        });
    }

    public void a(com.kwad.sdk.core.webview.c.c cVar) {
        bt.runOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ae.3
            final /* synthetic */ com.kwad.sdk.core.webview.c.c my;

            public AnonymousClass3(com.kwad.sdk.core.webview.c.c cVar2) {
                cVar = cVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                cVar.a(adResultData);
            }
        });
    }
}
