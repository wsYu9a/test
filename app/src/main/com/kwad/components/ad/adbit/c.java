package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: com.kwad.components.ad.adbit.c$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.c<b> {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.f.c
        /* renamed from: O */
        public b get() {
            return new b(com.kwad.components.core.request.model.a.this);
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.c<com.kwad.components.ad.a.a> {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.f.c
        /* renamed from: P */
        public com.kwad.components.ad.a.a get() {
            return new com.kwad.components.ad.a.a(com.kwad.components.core.request.model.a.this);
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ String bD;

        public AnonymousClass3(String str) {
            bidResponse = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            try {
                com.kwad.components.core.request.model.a.this.az("server_bid_one");
                com.kwad.components.core.request.model.a aVar = com.kwad.components.core.request.model.a.this;
                d.b(aVar.Oy.adScene, aVar.rz());
                JSONObject jSONObject = new JSONObject(bidResponse);
                AdBitResultData adBitResultData = new AdBitResultData(com.kwad.components.core.request.model.a.this.Oy.adScene);
                adBitResultData.parseJson(jSONObject);
                adBitResultData.setAdTemplateList(c.b(adBitResultData));
                adBitResultData.setAdSource("server_bid_one");
                if (adBitResultData.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                    return;
                }
                AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                int adStyle = com.kwad.components.core.request.model.a.this.Oy.adScene.getAdStyle();
                if (adStyle == 10000 || adStyle == e.dV(adTemplate)) {
                    com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                    return;
                }
                com.kwad.components.core.request.model.a aVar2 = com.kwad.components.core.request.model.a.this;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azE;
                com.kwad.components.core.request.model.a.a(aVar2, eVar.errorCode, eVar.msg, true);
            } catch (Exception e10) {
                com.kwad.components.core.request.model.a aVar3 = com.kwad.components.core.request.model.a.this;
                com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azz;
                com.kwad.components.core.request.model.a.a(aVar3, eVar2.errorCode, eVar2.msg, true);
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$4 */
    public class AnonymousClass4 extends l<com.kwad.components.ad.a.b, AdBitResultData> {
        final /* synthetic */ AdBitResultData bE;
        final /* synthetic */ List bF;

        public AnonymousClass4(AdBitResultData adBitResultData, List list) {
            adBitResultData = adBitResultData;
            list = list;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: Q */
        public com.kwad.components.ad.a.b createRequest() {
            return new com.kwad.components.ad.a.b(adBitResultData.adxId, list);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        /* renamed from: n */
        public AdBitResultData parseData(String str) {
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(com.kwad.components.core.request.model.a.this.Oy.adScene);
            adBitResultData.parseJson(jSONObject);
            return adBitResultData;
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$5 */
    public class AnonymousClass5 extends o<com.kwad.components.ad.a.b, AdBitResultData> {
        final /* synthetic */ com.kwad.components.core.request.model.a bC;

        public AnonymousClass5(com.kwad.components.core.request.model.a aVar) {
            aVar = aVar;
        }

        private void b(int i10, String str) {
            com.kwad.components.core.request.model.a.a(aVar, i10, str, false);
        }

        private void c(@NonNull AdBitResultData adBitResultData) {
            adBitResultData.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData));
            adBitResultData.setAdSource("server_bid_two");
            if (adBitResultData.isAdResultDataEmpty()) {
                com.kwad.components.core.request.model.a.a(aVar, adBitResultData, false);
                return;
            }
            AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
            int i10 = aVar.Oy.adScene.adStyle;
            if (i10 == 10000 || i10 == e.dV(adTemplate)) {
                com.kwad.components.core.request.model.a.a(aVar, adBitResultData, false);
                return;
            }
            com.kwad.components.core.request.model.a aVar = aVar;
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azE;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, false);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
            b(i10, str);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
            c((AdBitResultData) baseResultData);
        }
    }

    private static <T extends com.kwad.components.core.request.a> T a(com.kwad.sdk.f.c<T> cVar) {
        return cVar.get();
    }

    public static boolean c(@NonNull com.kwad.components.core.request.model.a aVar) {
        String bidResponseV2 = aVar.Oy.adScene.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        String bidResponse = aVar.Oy.adScene.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.Hp().submit(new bd() { // from class: com.kwad.components.ad.adbit.c.3
            final /* synthetic */ String bD;

            public AnonymousClass3(String bidResponse2) {
                bidResponse = bidResponse2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    com.kwad.components.core.request.model.a.this.az("server_bid_one");
                    com.kwad.components.core.request.model.a aVar2 = com.kwad.components.core.request.model.a.this;
                    d.b(aVar2.Oy.adScene, aVar2.rz());
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(com.kwad.components.core.request.model.a.this.Oy.adScene);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    adBitResultData.setAdSource("server_bid_one");
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = com.kwad.components.core.request.model.a.this.Oy.adScene.getAdStyle();
                    if (adStyle == 10000 || adStyle == e.dV(adTemplate)) {
                        com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                        return;
                    }
                    com.kwad.components.core.request.model.a aVar22 = com.kwad.components.core.request.model.a.this;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azE;
                    com.kwad.components.core.request.model.a.a(aVar22, eVar.errorCode, eVar.msg, true);
                } catch (Exception e10) {
                    com.kwad.components.core.request.model.a aVar3 = com.kwad.components.core.request.model.a.this;
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.azz;
                    com.kwad.components.core.request.model.a.a(aVar3, eVar2.errorCode, eVar2.msg, true);
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                }
            }
        });
        return true;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) a(new com.kwad.sdk.f.c<com.kwad.components.ad.a.a>() { // from class: com.kwad.components.ad.adbit.c.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.f.c
            /* renamed from: P */
            public com.kwad.components.ad.a.a get() {
                return new com.kwad.components.ad.a.a(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).N();
    }

    public static String a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        b bVar = (b) a(new com.kwad.sdk.f.c<b>() { // from class: com.kwad.components.ad.adbit.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.f.c
            /* renamed from: O */
            public b get() {
                return new b(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).N();
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate a10;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j10 = adBid.creativeId;
                if (j10 > 0 && (a10 = a(adBitResultData, j10)) != null) {
                    a10.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a10);
                }
            }
        }
        return arrayList;
    }

    private static void a(String str, @NonNull com.kwad.components.core.request.model.a aVar) {
        try {
            aVar.az("server_bid_two");
            d.b(aVar.Oy.adScene, aVar.rz());
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.Oy.adScene);
            adBitResultData.parseJson(jSONObject);
            List<String> a10 = a(adBitResultData);
            if (a10.isEmpty()) {
                com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adBitResultData.testErrorMsg, false);
            } else {
                a(a10, adBitResultData, aVar);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azz;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, false);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    private static void a(List<String> list, AdBitResultData adBitResultData, com.kwad.components.core.request.model.a aVar) {
        new l<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            final /* synthetic */ AdBitResultData bE;
            final /* synthetic */ List bF;

            public AnonymousClass4(AdBitResultData adBitResultData2, List list2) {
                adBitResultData = adBitResultData2;
                list = list2;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: Q */
            public com.kwad.components.ad.a.b createRequest() {
                return new com.kwad.components.ad.a.b(adBitResultData.adxId, list);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: n */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(com.kwad.components.core.request.model.a.this.Oy.adScene);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new o<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            final /* synthetic */ com.kwad.components.core.request.model.a bC;

            public AnonymousClass5(com.kwad.components.core.request.model.a aVar2) {
                aVar = aVar2;
            }

            private void b(int i10, String str) {
                com.kwad.components.core.request.model.a.a(aVar, i10, str, false);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData2));
                adBitResultData2.setAdSource("server_bid_two");
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i10 = aVar.Oy.adScene.adStyle;
                if (i10 == 10000 || i10 == e.dV(adTemplate)) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                com.kwad.components.core.request.model.a aVar2 = aVar;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.azE;
                com.kwad.components.core.request.model.a.a(aVar2, eVar.errorCode, eVar.msg, false);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
                b(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }
        });
    }

    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate a10;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j10 = adBid.creativeId;
                if (j10 > 0 && (a10 = a(adBitResultData2, j10)) != null) {
                    a10.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a10);
                }
            }
        }
        return arrayList;
    }

    private static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    @Nullable
    private static AdTemplate a(AdBitResultData adBitResultData, long j10) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j10 == e.el(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }
}
