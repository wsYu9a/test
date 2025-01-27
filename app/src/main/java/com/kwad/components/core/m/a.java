package com.kwad.components.core.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    private ImpInfo Oy;

    public a(ImpInfo impInfo) {
        this.Oy = impInfo;
    }

    @Override // com.kwad.sdk.core.network.l
    /* renamed from: l */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        m(adResultData);
    }

    private static void m(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo eb2 = e.eb(adTemplate);
            if (com.kwad.sdk.core.response.b.a.bd(eb2)) {
                if (com.kwad.sdk.core.response.b.a.ba(eb2).size() == 0) {
                    com.kwad.components.core.o.a.ri().f(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.b.a.bh(eb2) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(eb2))) {
                com.kwad.components.core.o.a.ri().f(adTemplate, 21006);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.l
    @NonNull
    /* renamed from: ab */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.Oy.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* renamed from: nD */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.Oy);
    }
}
