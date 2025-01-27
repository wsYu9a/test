package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: com.kwad.components.ad.adbit.c$1 */
    static class AnonymousClass1 implements com.kwad.sdk.e.c<b> {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.e.c
        /* renamed from: ae */
        public b get() {
            return new b(com.kwad.components.core.n.kwai.a.this);
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$2 */
    static class AnonymousClass2 implements com.kwad.sdk.e.c<com.kwad.components.ad.kwai.a> {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.e.c
        /* renamed from: af */
        public com.kwad.components.ad.kwai.a get() {
            return new com.kwad.components.ad.kwai.a(com.kwad.components.core.n.kwai.a.this);
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ com.kwad.components.core.n.kwai.a bN;
        final /* synthetic */ String bO;

        AnonymousClass3(String str, com.kwad.components.core.n.kwai.a aVar) {
            bidResponse = str;
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                JSONObject jSONObject = new JSONObject(bidResponse);
                AdBitResultData adBitResultData = new AdBitResultData(aVar.JW.Ow);
                adBitResultData.parseJson(jSONObject);
                adBitResultData.setAdTemplateList(c.b(adBitResultData));
                if (adBitResultData.isAdResultDataEmpty()) {
                    com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? f.agn.msg : adBitResultData.testErrorMsg, true);
                    return;
                }
                AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                int adStyle = aVar.JW.Ow.getAdStyle();
                if (adStyle == 10000 || adStyle == d.bV(adTemplate)) {
                    com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData, true);
                    return;
                }
                com.kwad.components.core.n.kwai.a aVar = aVar;
                f fVar = f.agr;
                com.kwad.components.core.n.kwai.a.a(aVar, fVar.errorCode, fVar.msg, true);
            } catch (Exception e2) {
                com.kwad.components.core.n.kwai.a aVar2 = aVar;
                f fVar2 = f.agm;
                com.kwad.components.core.n.kwai.a.a(aVar2, fVar2.errorCode, fVar2.msg, true);
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$4 */
    static class AnonymousClass4 extends m<com.kwad.components.ad.kwai.b, AdBitResultData> {
        final /* synthetic */ AdBitResultData bP;
        final /* synthetic */ List bQ;

        AnonymousClass4(AdBitResultData adBitResultData, List list) {
            adBitResultData = adBitResultData;
            list = list;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: ag */
        public com.kwad.components.ad.kwai.b createRequest() {
            return new com.kwad.components.ad.kwai.b(adBitResultData.adxId, list);
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        /* renamed from: r */
        public AdBitResultData parseData(String str) {
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(com.kwad.components.core.n.kwai.a.this.JW.Ow);
            adBitResultData.parseJson(jSONObject);
            return adBitResultData;
        }
    }

    /* renamed from: com.kwad.components.ad.adbit.c$5 */
    static class AnonymousClass5 extends p<com.kwad.components.ad.kwai.b, AdBitResultData> {
        final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

        AnonymousClass5(com.kwad.components.core.n.kwai.a aVar) {
            aVar = aVar;
        }

        private void b(int i2, String str) {
            com.kwad.components.core.n.kwai.a.a(aVar, i2, str, false);
        }

        private void c(@NonNull AdBitResultData adBitResultData) {
            adBitResultData.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData));
            if (adBitResultData.isAdResultDataEmpty()) {
                com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? f.agn.msg : adBitResultData.testErrorMsg, false);
                return;
            }
            AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
            int i2 = aVar.JW.Ow.adStyle;
            if (i2 == 10000 || i2 == d.bV(adTemplate)) {
                com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData, false);
                return;
            }
            com.kwad.components.core.n.kwai.a aVar = aVar;
            f fVar = f.agr;
            com.kwad.components.core.n.kwai.a.a(aVar, fVar.errorCode, fVar.msg, false);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
            b(i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
            c((AdBitResultData) baseResultData);
        }
    }

    private static <T extends com.kwad.components.core.n.a> T a(com.kwad.sdk.e.c<T> cVar) {
        return cVar.get();
    }

    @Nullable
    private static AdTemplate a(AdBitResultData adBitResultData, long j2) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j2 == d.cl(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }

    public static String a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        b bVar = (b) a(new com.kwad.sdk.e.c<b>() { // from class: com.kwad.components.ad.adbit.c.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.e.c
            /* renamed from: ae */
            public b get() {
                return new b(com.kwad.components.core.n.kwai.a.this);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).ad();
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

    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate a2;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j2 = adBid.creativeId;
                if (j2 > 0 && (a2 = a(adBitResultData2, j2)) != null) {
                    a2.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    private static void a(String str, @NonNull com.kwad.components.core.n.kwai.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.JW.Ow);
            adBitResultData.parseJson(jSONObject);
            List<String> a2 = a(adBitResultData);
            if (a2.isEmpty()) {
                com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? f.agn.msg : adBitResultData.testErrorMsg, false);
            } else {
                a(a2, adBitResultData, aVar);
            }
        } catch (Exception e2) {
            f fVar = f.agm;
            com.kwad.components.core.n.kwai.a.a(aVar, fVar.errorCode, fVar.msg, false);
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private static void a(List<String> list, AdBitResultData adBitResultData, com.kwad.components.core.n.kwai.a aVar) {
        new m<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            final /* synthetic */ AdBitResultData bP;
            final /* synthetic */ List bQ;

            AnonymousClass4(AdBitResultData adBitResultData2, List list2) {
                adBitResultData = adBitResultData2;
                list = list2;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: ag */
            public com.kwad.components.ad.kwai.b createRequest() {
                return new com.kwad.components.ad.kwai.b(adBitResultData.adxId, list);
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            /* renamed from: r */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(com.kwad.components.core.n.kwai.a.this.JW.Ow);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new p<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

            AnonymousClass5(com.kwad.components.core.n.kwai.a aVar2) {
                aVar = aVar2;
            }

            private void b(int i2, String str) {
                com.kwad.components.core.n.kwai.a.a(aVar, i2, str, false);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData2));
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData2.testErrorMsg) ? f.agn.msg : adBitResultData2.testErrorMsg, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i2 = aVar.JW.Ow.adStyle;
                if (i2 == 10000 || i2 == d.bV(adTemplate)) {
                    com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData2, false);
                    return;
                }
                com.kwad.components.core.n.kwai.a aVar2 = aVar;
                f fVar = f.agr;
                com.kwad.components.core.n.kwai.a.a(aVar2, fVar.errorCode, fVar.msg, false);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                b(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }
        });
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate a2;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j2 = adBid.creativeId;
                if (j2 > 0 && (a2 = a(adBitResultData, j2)) != null) {
                    a2.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    public static boolean b(@NonNull com.kwad.components.core.n.kwai.a aVar) {
        String bidResponseV2 = aVar.JW.Ow.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String bidResponse = aVar.JW.Ow.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.ad.adbit.c.3
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;
            final /* synthetic */ String bO;

            AnonymousClass3(String bidResponse2, com.kwad.components.core.n.kwai.a aVar2) {
                bidResponse = bidResponse2;
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(aVar.JW.Ow);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.n.kwai.a.a(aVar, f.agn.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? f.agn.msg : adBitResultData.testErrorMsg, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = aVar.JW.Ow.getAdStyle();
                    if (adStyle == 10000 || adStyle == d.bV(adTemplate)) {
                        com.kwad.components.core.n.kwai.a.a(aVar, adBitResultData, true);
                        return;
                    }
                    com.kwad.components.core.n.kwai.a aVar2 = aVar;
                    f fVar = f.agr;
                    com.kwad.components.core.n.kwai.a.a(aVar2, fVar.errorCode, fVar.msg, true);
                } catch (Exception e2) {
                    com.kwad.components.core.n.kwai.a aVar22 = aVar;
                    f fVar2 = f.agm;
                    com.kwad.components.core.n.kwai.a.a(aVar22, fVar2.errorCode, fVar2.msg, true);
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                }
            }
        });
        return true;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.kwai.a aVar = (com.kwad.components.ad.kwai.a) a(new com.kwad.sdk.e.c<com.kwad.components.ad.kwai.a>() { // from class: com.kwad.components.ad.adbit.c.2
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.e.c
            /* renamed from: af */
            public com.kwad.components.ad.kwai.a get() {
                return new com.kwad.components.ad.kwai.a(com.kwad.components.core.n.kwai.a.this);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).ad();
    }
}
