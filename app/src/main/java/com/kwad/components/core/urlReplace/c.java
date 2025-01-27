package com.kwad.components.core.urlReplace;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    private l<b, MarketUrlReplaceData> Vz;

    /* renamed from: com.kwad.components.core.urlReplace.c$1 */
    public class AnonymousClass1 extends l<b, MarketUrlReplaceData> {
        final /* synthetic */ String VA;

        public AnonymousClass1(String str) {
            str = str;
        }

        @NonNull
        private static MarketUrlReplaceData aB(String str) {
            JSONObject jSONObject = new JSONObject(str);
            MarketUrlReplaceData marketUrlReplaceData = new MarketUrlReplaceData();
            marketUrlReplaceData.parseJson(jSONObject);
            return marketUrlReplaceData;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: rZ */
        public b createRequest() {
            return new b(str);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ MarketUrlReplaceData parseData(String str) {
            return aB(str);
        }
    }

    /* renamed from: com.kwad.components.core.urlReplace.c$2 */
    public class AnonymousClass2 extends o<b, MarketUrlReplaceData> {
        final /* synthetic */ a VC;

        public AnonymousClass2(a aVar) {
            aVar = aVar;
        }

        private void a(@NonNull MarketUrlReplaceData marketUrlReplaceData) {
            if (marketUrlReplaceData.isParseSuccess() && marketUrlReplaceData.isReplaceSuccess()) {
                aVar.onSuccess(marketUrlReplaceData.getMiMarketUrl());
            }
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
            a((MarketUrlReplaceData) baseResultData);
        }
    }

    public final void a(String str, a aVar) {
        AnonymousClass1 anonymousClass1 = new l<b, MarketUrlReplaceData>() { // from class: com.kwad.components.core.urlReplace.c.1
            final /* synthetic */ String VA;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @NonNull
            private static MarketUrlReplaceData aB(String str2) {
                JSONObject jSONObject = new JSONObject(str2);
                MarketUrlReplaceData marketUrlReplaceData = new MarketUrlReplaceData();
                marketUrlReplaceData.parseJson(jSONObject);
                return marketUrlReplaceData;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: rZ */
            public b createRequest() {
                return new b(str);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ MarketUrlReplaceData parseData(String str2) {
                return aB(str2);
            }
        };
        this.Vz = anonymousClass1;
        anonymousClass1.request(new o<b, MarketUrlReplaceData>() { // from class: com.kwad.components.core.urlReplace.c.2
            final /* synthetic */ a VC;

            public AnonymousClass2(a aVar2) {
                aVar = aVar2;
            }

            private void a(@NonNull MarketUrlReplaceData marketUrlReplaceData) {
                if (marketUrlReplaceData.isParseSuccess() && marketUrlReplaceData.isReplaceSuccess()) {
                    aVar.onSuccess(marketUrlReplaceData.getMiMarketUrl());
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                a((MarketUrlReplaceData) baseResultData);
            }
        });
    }

    public final void rY() {
        l<b, MarketUrlReplaceData> lVar = this.Vz;
        if (lVar != null) {
            lVar.cancel();
            this.Vz = null;
        }
    }
}
